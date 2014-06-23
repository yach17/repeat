package fr.yach17.repeat;

import java.time.LocalDate;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public interface Repetition {
    LocalDate getNextDate();

    void setStartDate(LocalDate now);
}
