package fr.yach17.repeat.domain;

import java.time.LocalDate;
import java.time.Period;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public class EndOfMonthRepetition extends RepetitionAbstract {

    LocalDate innerStartDate;

    private Period daysBeforeEndOfMonth;

    public EndOfMonthRepetition(int daysBeforeEndOfMonth) {
        this("Repetition " + daysBeforeEndOfMonth + " before the end of the month", daysBeforeEndOfMonth);
    }

    public EndOfMonthRepetition(String description, int daysBeforeEndOfMonth) {
        super(description);
        this.daysBeforeEndOfMonth = Period.ofDays(daysBeforeEndOfMonth);
    }

    @Override
    public void setStartDate(LocalDate startDate) {
        super.setStartDate(startDate);
        innerStartDate = startDate.with(lastDayOfMonth()).minus(daysBeforeEndOfMonth);
        if (innerStartDate.isAfter(startDate)) {
            innerStartDate = innerStartDate.with(firstDayOfMonth()).minus(daysBeforeEndOfMonth.plusDays(1));

        }
    }

    @Override
    public LocalDate getNextDate(){
        return getNextDate(innerStartDate);
    }

    protected LocalDate getNextDate(LocalDate from) {
        return from.plusMonths(1).with(lastDayOfMonth()).minus(daysBeforeEndOfMonth);
    }


}
