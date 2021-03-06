package fr.yach17.repeat.domain;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public abstract class RepetitionAbstract implements Repetition{

    private UUID identifier;


    private String description;
    protected LocalDate startDate;

    public RepetitionAbstract(){

    }

    public RepetitionAbstract(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;

    }

    protected abstract LocalDate getNextDate(LocalDate from);

    @Override
    public LocalDate getDateFollowing(LocalDate baseDate) {
        Objects.requireNonNull(baseDate);
        LocalDate occurrence = getNextDate();
        while(baseDate.isAfter(occurrence)) {
            occurrence = getNextDate(occurrence);
        }
        return occurrence;
    }

    public UUID getIdentifier() {
        return identifier;
    }
}
