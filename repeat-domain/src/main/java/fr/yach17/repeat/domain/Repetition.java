package fr.yach17.repeat.domain;

import java.time.LocalDate;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public interface Repetition {
    LocalDate getNextDate();

    LocalDate getDateFollowing(LocalDate baseDate);

    void setStartDate(LocalDate now);

     String getDescription();
}
