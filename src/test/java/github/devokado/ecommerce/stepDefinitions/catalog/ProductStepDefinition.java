package github.devokado.ecommerce.stepDefinitions.catalog;

import github.devokado.ecommerce.stepDefinitions.BaseStepDefinition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpMethod;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductStepDefinition extends BaseStepDefinition {

    @Given("I am an admin")
    public void iAmAnAdmin() {
    }

    @When("I add a product with following details")
    public void iAddAProductWithFollowingDetails(DataTable table) {
        sendRequest(HttpMethod.POST, "/v1/products/add", table);
    }

    @Then("I have the added product available")
    public void iHaveTheAddedProductAvailable() {
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
