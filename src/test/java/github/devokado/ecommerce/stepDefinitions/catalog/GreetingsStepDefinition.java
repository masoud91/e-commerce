package github.devokado.ecommerce.stepDefinitions.catalog;

import github.devokado.ecommerce.stepDefinitions.BaseStepDefinition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpMethod;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingsStepDefinition extends BaseStepDefinition {

    @Given("I am a guest user")
    public void iAmAGuestUser() {

    }

    @When("I ask for greetings")
    public void iAskForGreetings() {
        sendRequest(HttpMethod.GET, "/greetings", null, null, DataTable.emptyDataTable());
    }

    @Then("I receive a warm welcome")
    public void iReceiveAWarmWelcome() {
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hi!");
    }
}
