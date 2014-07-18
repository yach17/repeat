package fr.yach17.repeat.steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import fr.yach17.repeat.domain.EndOfMonthRepetition;
import fr.yach17.repeat.domain.PeriodicRepetition;
import fr.yach17.repeat.domain.Repetition;
import fr.yach17.repeat.domain.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;

import static fr.yach17.repeat.steps.StepsHelper.parse;
import static java.lang.Integer.parseInt;

/**
 * Created by SaYaQuenGa on 26/06/2014.
 */
public class DisplayRepetitionSteps {
    private LocalDate today;
    private User user;
    private List<Repetition> repetitionsSortedByDate;

    @Given("^I am a user$")
    public void createUser() throws Throwable {
        user = new User();
    }

    @And("^I create the following periodic repetitions$")
    public void createRepetitions(DataTable tableRepetitions) throws Throwable {
        for (Map<String, String> ligneRepetition : tableRepetitions.asMaps(String.class, String.class)) {
            Repetition repetition = new PeriodicRepetition(ligneRepetition.get("description"), Period.ofDays(parseInt(ligneRepetition.get("period"))));
            repetition.setStartDate(parse(ligneRepetition.get("start date")));
            user.addToRepetitions(repetition);
        }

    }

    @And("^I create the following end of month repetitions$")
    public void createEndOfMonthRepetitions(DataTable tableRepetitions) throws Throwable {
        for (Map<String, String> ligneRepetition : tableRepetitions.asMaps(String.class, String.class)) {
            EndOfMonthRepetition repetition = new EndOfMonthRepetition(ligneRepetition.get("description"), parseInt(ligneRepetition.get("number of days before the end of the month")));
            repetition.setStartDate(LocalDate.now());
            user.addToRepetitions(repetition);
        }
    }

    @And("^today is the  \"([^\"]*)\"$")
    public void setToday(String dateDuJourString) throws Throwable {
        today = parse(dateDuJourString);
    }

    @When("^I list my repetitions ordered by next date$")
    public void displayRepetitionsByDate() throws Throwable {
        repetitionsSortedByDate = user.getRepetitionsByDate(today);
    }


    @Then("^I get the following list of repetitions :$")
    public void checkRepetitionsList(DataTable expectedRepetitions) throws Throwable {
        expectedRepetitions.diff(repetitionsSortedByDate);
    }
}
