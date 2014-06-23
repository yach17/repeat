package fr.yach17.repeat;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public class RepetitionPeriodique extends RepetitionAbstract {
    private final Period periodicite;
    public RepetitionPeriodique(Period periodicite) {
        this.periodicite = periodicite;
    }

    @Override
    public LocalDate getNextDate() {
        return startDate.plus(periodicite);
    }
}
