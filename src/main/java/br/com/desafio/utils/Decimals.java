package br.com.desafio.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Decimals {

    public String format(BigDecimal value) {
        try {
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            return decimalFormat.format(value);
        } catch (Exception e) {
            return null;
        }
    }
}
