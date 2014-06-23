package fr.yach17.repeat;

import java.time.LocalDate;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public abstract class RepetitionAbstract implements Repetition {

    protected LocalDate startDate;

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;

    }
}
