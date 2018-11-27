package com.example.demogridflow;

import com.example.demogridflow.entity.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToDoubleConverter;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Route("")
public class MainView extends VerticalLayout {

    private final PriceRepository priceRepository;

    private final PersonRepository personRepository;

    private ComboBox<PriceItem> priceComboBox;
    private Binder<Person> binder = new Binder<>(Person.class);
    private Person person;
    private Grid<Person> grid;
    private final ComboBox<Service> serviceComboBox;
    private final TextField numberField;
    private final TextField prField;
    private final TextField name;
    private final Button add;

    public MainView(PriceRepository priceRepository, PersonRepository personRepository) {
        this.priceRepository = priceRepository;
        this.personRepository = personRepository;
        List<PriceItem> priceItems = this.priceRepository.findById(1L).get().getPriceItems();
        grid = new Grid<>();
        person = new Person("");
        binder.setBean(person);

        add = new Button("Add");
        add.addClickListener(e->{
            save();
        });
        name = new TextField("Name");
        binder.bind(name, "name");


        grid.setWidth("600px");
        grid.addColumn(Person::getId).setWidth("100px");
        grid.addColumn(Person::getName).setWidth("150px");
        grid.addColumn(Person::getAmount).setWidth("100px");
        grid.addColumn(Person::getPr).setWidth("70px");
        update();

        numberField = new TextField();
        binder.forField(numberField)
                .withConverter(new StringToDoubleConverter(0.0,"Must be a number"))
                .bind(Person::getAmount, Person::setAmount);
        prField = new TextField("PrField");

        binder.forField(prField)
                .withConverter(new PriceConverter())
                .bind("pr");

        prField.setPattern("\\d+(\\,\\d?\\d?)?$");
        prField.setPreventInvalidInput(true);

        String currencySymbol = Currency.getInstance(new Locale("ru", "RU")).getSymbol();
        prField.setPrefixComponent(new Span(currencySymbol));


    serviceComboBox = new ComboBox<>();
        serviceComboBox.setItems(Service.values());
        serviceComboBox.addValueChangeListener(e->{
            List<PriceItem> items = priceItems.stream().filter(item -> item.getService().equals(e.getValue())).collect(Collectors.toList());
            priceComboBox.setItems(items);
        });

        priceComboBox = new ComboBox<>();

        priceComboBox.setDataProvider(DataProvider.ofCollection(priceItems));
        priceComboBox.setItemLabelGenerator(PriceItem::getName);
//        priceComboBox.addValueChangeListener(e->{
//            serviceComboBox.setValue(e.getValue().getService());
//        });
        binder.bind(priceComboBox, "price");

        VerticalLayout form = new VerticalLayout(name, numberField, prField, serviceComboBox, priceComboBox, add);
        HorizontalLayout layout = new HorizontalLayout(grid, form);

        add(layout);
    }

    private void save() {
        personRepository.save(person);
        update();
    }

    private void update() {
        grid.setItems(personRepository.findAll());
    }
}
