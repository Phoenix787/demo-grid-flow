package com.example.demogridflow;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Locale;

import static org.junit.Assert.*;

public class PriceConverterTest {

    @Test
    public void convertToModel() throws ParseException {
        Locale.setDefault(new Locale("ru", "RU"));
        DecimalFormat df = new DecimalFormat("#0.00");
        df.setGroupingUsed(false);
        String value = "23,3";
        assertEquals(23.30, df.parse(value).doubleValue(),0.1);
    }

    @Test
    public void convertToPresentation() {
    }
}