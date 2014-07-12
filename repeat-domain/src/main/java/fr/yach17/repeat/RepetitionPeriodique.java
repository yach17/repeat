package fr.yach17.repeat;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public class RepetitionPeriodique extends RepetitionAbstract {
    private final Period periodicite;
    public RepetitionPeriodique(Period periodicite) {
        this("Répétition périodique :" + periodicite.toString(), periodicite);
    }

    public RepetitionPeriodique(String description, Period periodicite) {
        super(description);
        this.periodicite = periodicite;

    }

    @Override
    protected LocalDate getNextDate(LocalDate from) {
        return from.plus(periodicite);
    }

    @Override
    public LocalDate getNextDate() {
        return getNextDate(startDate);
    }

}
