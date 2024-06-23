package br.com.desafio.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Datas {

    public String format(LocalDate value) {
        try {
            return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(value);
        } catch (Exception e) {
            return null;
        }
    }
}
