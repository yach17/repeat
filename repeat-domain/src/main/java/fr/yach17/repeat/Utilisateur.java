package fr.yach17.repeat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by SaYaQuenGa on 27/06/2014.
 */
public class Utilisateur {
    String nom;
    String prenom;
    List<Repetition> repetitions;

    public List<Repetition> getRepetitions() {
        return Collections.unmodifiableList(repetitions);
    }

    public void setRepetitions(List<Repetition> repetitions) {
        this.repetitions = new ArrayList<>(repetitions);
    }

    public void addToRepetitions(Repetition repetition) {
        Objects.requireNonNull(repetition);
        if( repetitions == null ) {
            repetitions = new ArrayList<>();
        }
        repetitions.add(repetition);

    }

    public List<Repetition> listerRepetitionsParDate(LocalDate dateDuJour) {
        Objects.requireNonNull(dateDuJour);
        ArrayList<Repetition> repetitionsParDate = new ArrayList<>(repetitions);
        repetitionsParDate.sort((r1, r2) -> r1.getDateFollowing(dateDuJour).compareTo(r2.getDateFollowing(dateDuJour)));
        return repetitionsParDate;
    }
}
