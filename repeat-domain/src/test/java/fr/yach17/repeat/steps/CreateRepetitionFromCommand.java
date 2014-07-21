package fr.yach17.repeat.steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.inject.Singleton;

/**
 * Created by SaYaQuenGa on 21/07/2014.
 */
@Singleton
public class CreateRepetitionFromCommand {
    @When("^I issue a command to create a repetition with the following configuration :$")
    public void issueCreateRepetitionCommand(DataTable config) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^I have a periodic repetition \"([^\"]*)\" with a period of (\\d+) months$")
    public void checkPeriodicRepetition(int months) throws Throwable {
        

    }

}
