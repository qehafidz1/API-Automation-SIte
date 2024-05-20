package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.post.GetAllPosts;

public class GetAllPostsSteps {

    @Steps
    GetAllPosts getAllPosts;

    @Given("I set API endpoint for get all posts")
    public void setApiEndpoint() {
        getAllPosts.setApiEndpoint();
    }

    @When("I send request to get all posts")
    public void sendGetAllPostsRequest() {
        getAllPosts.sendGetAllPostsRequest();
    }

    @Then("I receive status code 200")
    public void receiveValidStatusCode200() {
        getAllPosts.receiveValidStatusCode200();
    }

    @And("I receive valid posts data")
    public void receiveValidPostsData() {
        getAllPosts.receiveValidPostsData();
    }
}
