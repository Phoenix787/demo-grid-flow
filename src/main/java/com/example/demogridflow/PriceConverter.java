package com.example.demogridflow;

import com.vaadin.flow.data.binder.Result;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.converter.Converter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.Supplier;

public class PriceConverter implements Converter<String, Integer> {
    private final DecimalFormat df = FormattingUtils.getUiPriceFormatter();
    public PriceConverter() {
        Locale.setDefault(new Locale("ru", "RU"));
    }

    @Override
    public Result<Integer> convertToModel(String value, ValueContext context) {
        Integer tmp;
        Double dbl;
        if (value.isEmpty()) {
            value = "0,0";
        }

        try {
            dbl = df.parse(value).doubleValue();
            dbl = dbl *100;
            tmp = (int) (dbl * 100);
            return Result.ok(tmp);
        } catch (ParseException e) {
            return Result.error("Invalid number");
        }
    }

    @Override
    public String convertToPresentation(Integer value, ValueContext context) {
        Locale.setDefault(new Locale("ru", "RU"));

        return convertIfNotNull(value, i -> df.format(BigDecimal.valueOf(i, 2)), () -> "");
    }

    public static <S, T> T convertIfNotNull(S source, Function<S, T> converter) {
        return convertIfNotNull(source, converter, () -> null);
    }

    public static <S, T> T convertIfNotNull(S source, Function<S, T> converter, Supplier<T> nullValueSupplier) {
        return source != null ? converter.apply(source) : nullValueSupplier.get();
    }

}
