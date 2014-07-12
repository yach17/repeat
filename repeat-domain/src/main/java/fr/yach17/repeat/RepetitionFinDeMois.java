package fr.yach17.repeat;

import java.time.LocalDate;
import java.time.Period;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public class RepetitionFinDeMois extends RepetitionAbstract {

    LocalDate innerStartDate;

    private Period nbJoursAvantFinMois;

    public RepetitionFinDeMois(int nbJoursAvantFinMois) {
        this("Repetition " + nbJoursAvantFinMois + " avant la fin du mois", nbJoursAvantFinMois);
    }

    public RepetitionFinDeMois(String description, int nbJoursAvantFinMois) {
        super(description);
        this.nbJoursAvantFinMois = Period.ofDays(nbJoursAvantFinMois);
    }

    @Override
    public void setStartDate(LocalDate startDate) {
        super.setStartDate(startDate);
        innerStartDate = startDate.with(lastDayOfMonth()).minus(nbJoursAvantFinMois);
        if (innerStartDate.isAfter(startDate)) {
            innerStartDate = innerStartDate.with(firstDayOfMonth()).minus(nbJoursAvantFinMois.plusDays(1));

        }
    }

    @Override
    public LocalDate getNextDate(){
        return getNextDate(innerStartDate);
    }

    protected LocalDate getNextDate(LocalDate from) {
        return from.plusMonths(1).with(lastDayOfMonth()).minus(nbJoursAvantFinMois);
    }


}
