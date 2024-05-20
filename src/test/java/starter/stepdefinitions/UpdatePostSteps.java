package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.post.UpdatePost;

public class UpdatePostSteps {

    @Steps
    UpdatePost updatePost;

    @Given("I set API endpoint for update a post")
    public void setApiEndpoint() {
        updatePost.setApiEndpoint();
    }

    @When("I send request to update a post")
    public void sendUpdatePostRequest() {
        updatePost.sendUpdatePostRequest();
    }

    @And("I receive valid data for updated post")
    public void receiveValidUpdatedPostData() {
        updatePost.receiveValidUpdatedPostData();
    }

}
