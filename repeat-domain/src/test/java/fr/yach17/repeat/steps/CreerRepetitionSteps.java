package fr.yach17.repeat.steps;

import cucumber.api.java.Before;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Etantdonné;
import cucumber.api.java.fr.Lorsque;
import fr.yach17.repeat.Repetition;
import fr.yach17.repeat.RepetitionFinDeMois;
import fr.yach17.repeat.RepetitionPeriodique;

import java.time.LocalDate;
import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by SaYaQuenGa on 17/06/2014.
 */
public class CreerRepetitionSteps {
    private Repetition repetition;

    @Before
    public void reset(){
        repetition = null;
    }

    @Etantdonné("^que j'ai une répétition annuelle$")
    public void que_j_ai_une_répétition_annuelle() throws Throwable {
        repetition = new RepetitionPeriodique(Period.ofYears(1));
    }

    @Lorsque("^je définis sa date de début à aujourd'hui$")
    public void je_définis_sa_date_de_début_à_aujourd_hui() throws Throwable {
        repetition.setStartDate(LocalDate.now());
    }

    @Alors("^la date suivante est l'an prochain$")
    public void la_date_suivante_est_l_an_prochain() throws Throwable {
        assertThat(repetition.getNextDate()).isEqualTo(LocalDate.now().plusYears(1));

    }

    @Etantdonné("^que j'ai une répétition mensuelle$")
    public void que_j_ai_une_répétition_mensuelle() throws Throwable {
        repetition = new RepetitionPeriodique(Period.ofMonths(1));
    }

    @Alors("^la date suivante est le mois prochain$")
    public void la_date_suivante_est_le_mois_prochain() throws Throwable {
        assertThat(repetition.getNextDate()).isEqualTo(LocalDate.now().plusMonths(1));
    }

    @Etantdonné("^que j'ai une répétition de période (\\d+) jours$")
    public void que_j_ai_une_répétition_de_période_jours(int nbJours) throws Throwable {
        repetition = new RepetitionPeriodique(Period.ofDays(nbJours));
    }


    @Lorsque("^je définis sa date de début au \"([^\"]*)\"$")
    public void je_définis_sa_date_de_début_au(String dateString) throws Throwable {
        repetition.setStartDate(StepsHelper.parse(dateString));
    }

    @Alors("^la date suivante est le \"([^\"]*)\"$")
    public void la_date_suivante_est_le(String dateExpected) throws Throwable {
        assertThat(repetition.getNextDate()).isEqualTo(StepsHelper.parse(dateExpected));
    }

    @Etantdonné("^que j'ai une répétition de fin de mois (\\d+) jours avant la fin du mois$")
    public void que_j_ai_une_répétition_de_fin_de_mois_jours_avant_la_fin_du_mois(int nbJoursAvantFinDuMois) throws Throwable {
        repetition = new RepetitionFinDeMois(nbJoursAvantFinDuMois);
    }

}