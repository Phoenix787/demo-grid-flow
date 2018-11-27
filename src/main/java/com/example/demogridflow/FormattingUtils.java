package com.example.demogridflow;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormattingUtils {
    public static final Locale APP_LOCALE = new Locale("ru", "RU");
    public static final String DECIMAL_ZERO = "0.00";

    public static DecimalFormat getUiPriceFormatter() {
        DecimalFormat formatter = new DecimalFormat("#" + DECIMAL_ZERO,
                DecimalFormatSymbols.getInstance(APP_LOCALE));
        formatter.setGroupingUsed(false);
        return formatter;
    }

}
