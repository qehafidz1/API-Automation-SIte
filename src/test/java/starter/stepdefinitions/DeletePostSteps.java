package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.post.DeletePost;

public class DeletePostSteps {

    @Steps
    DeletePost deletePost;

    @Given("I set API endpoint for delete a post")
    public void setApiEndpoint() {
        deletePost.setApiEndpoint();
    }

    @When("I send request to delete a post")
    public void sendDeletePostRequest() {
        deletePost.sendDeletePostRequest();
    }
}
