package fr.yach17.repeat.steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by SaYaQuenGa on 26/06/2014.
 */
public class StepsHelper {
    private StepsHelper(){}

    public static LocalDate parse(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
