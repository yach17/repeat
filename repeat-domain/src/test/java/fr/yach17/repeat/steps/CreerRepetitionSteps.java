package fr.yach17.repeat.steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fr.yach17.repeat.EndOfMonthRepetition;
import fr.yach17.repeat.PeriodicRepetition;
import fr.yach17.repeat.Repetition;

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

    @Given("^I have a yearly repetition$")
    public void que_j_ai_une_répétition_annuelle() throws Throwable {
        repetition = new PeriodicRepetition(Period.ofYears(1));
    }

    @When("^I set the start date to today$")
    public void je_définis_sa_date_de_début_à_aujourd_hui() throws Throwable {
        repetition.setStartDate(LocalDate.now());
    }

    @Then("^the next date is next year$")
    public void la_date_suivante_est_l_an_prochain() throws Throwable {
        assertThat(repetition.getNextDate()).isEqualTo(LocalDate.now().plusYears(1));

    }

    @Given("^I have a monthly repetition$")
    public void que_j_ai_une_répétition_mensuelle() throws Throwable {
        repetition = new PeriodicRepetition(Period.ofMonths(1));
    }

    @Then("^the next date is next month$")
    public void la_date_suivante_est_le_mois_prochain() throws Throwable {
        assertThat(repetition.getNextDate()).isEqualTo(LocalDate.now().plusMonths(1));
    }

    @Given("^I have a repetition with a period of (\\d+) days$")
    public void que_j_ai_une_répétition_de_période_days(int nbJours) throws Throwable {
        repetition = new PeriodicRepetition(Period.ofDays(nbJours));
    }


    @When("^I set the start date to \"([^\"]*)\"$")
    public void je_définis_sa_date_de_début_au(String dateString) throws Throwable {
        repetition.setStartDate(StepsHelper.parse(dateString));
    }

    @Then("^the next date is \"([^\"]*)\"$")
    public void la_date_suivante_est_le(String dateExpected) throws Throwable {
        assertThat(repetition.getNextDate()).isEqualTo(StepsHelper.parse(dateExpected));
    }

    @Given("^I have an end of month repetition (\\d+) days before the end of the month$")
    public void que_j_ai_une_répétition_de_fin_de_mois_jours_avant_la_fin_du_mois(int nbJoursAvantFinDuMois) throws Throwable {
        repetition = new EndOfMonthRepetition(nbJoursAvantFinDuMois);
    }

}