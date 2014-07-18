package fr.yach17.repeat.domain;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public class PeriodicRepetition extends RepetitionAbstract {
    private final Period period;
    public PeriodicRepetition(Period period) {
        this("Periodic repetition :" + period.toString(), period);
    }

    public PeriodicRepetition(String description, Period period) {
        super(description);
        this.period = period;

    }

    @Override
    protected LocalDate getNextDate(LocalDate from) {
        return from.plus(period);
    }

    @Override
    public LocalDate getNextDate() {
        return getNextDate(startDate);
    }

}
