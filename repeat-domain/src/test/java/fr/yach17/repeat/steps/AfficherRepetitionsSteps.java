package fr.yach17.repeat.steps;

import cucumber.api.DataTable;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Lorsque;
import fr.yach17.repeat.Repetition;
import fr.yach17.repeat.RepetitionFinDeMois;
import fr.yach17.repeat.RepetitionPeriodique;
import fr.yach17.repeat.Utilisateur;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import static fr.yach17.repeat.steps.StepsHelper.parse;
import static java.lang.Integer.parseInt;

/**
 * Created by SaYaQuenGa on 26/06/2014.
 */
public class AfficherRepetitionsSteps {
    private LocalDate dateDuJour;
    private Utilisateur utilisateur;
    private List<Repetition> repetitionsParDate;

    @Etantdonné("^que je suis un utilisateur$")
    public void que_je_suis_un_utilisateur() throws Throwable {
        utilisateur = new Utilisateur();
    }

    @Et("^que je créé les répétitions périodiques suivantes :$")
    public void que_je_créé_les_répétitions_périodiques_suivantes(DataTable tableRepetitions) throws Throwable {
        for (Map<String, String> ligneRepetition : tableRepetitions.asMaps(String.class, String.class)) {
            Repetition repetition = new RepetitionPeriodique(ligneRepetition.get("description"), Period.ofDays(parseInt(ligneRepetition.get("periode de répétition"))));
            repetition.setStartDate(parse(ligneRepetition.get("date de début")));
            utilisateur.addToRepetitions(repetition);
        }

    }

    @Et("^que je créé les répétitions de fin de mois suivantes$")
    public void que_je_créé_les_répétitions_de_fin_de_mois_suivantes(DataTable tableRepetitions) throws Throwable {
        for (Map<String, String> ligneRepetition : tableRepetitions.asMaps(String.class, String.class)) {
            RepetitionFinDeMois repetition = new RepetitionFinDeMois(ligneRepetition.get("description"), parseInt(ligneRepetition.get("nombre de jours avant la fin du mois")));
            repetition.setStartDate(LocalDate.now());
            utilisateur.addToRepetitions(repetition);
        }
    }

    @Et("^que nous sommes le \"([^\"]*)\"$")
    public void que_nous_sommes_le(String dateDuJourString) throws Throwable {
        dateDuJour = parse(dateDuJourString);
    }

    @Lorsque("^je liste mes répétitions par ordre de prochaine date$")
    public void je_liste_mes_répétitions_par_ordre_de_prochaine_date() throws Throwable {
        repetitionsParDate = utilisateur.listerRepetitionsParDate(dateDuJour);
    }


    @Alors("^j'obtiens les répétitions suivantes :$")
    public void j_obtiens_les_répétitions_suivantes(DataTable repetitionsAttendues) throws Throwable {
        repetitionsAttendues.diff(repetitionsParDate);
    }
}
