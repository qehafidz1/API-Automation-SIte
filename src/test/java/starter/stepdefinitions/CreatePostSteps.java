package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.post.CreatePost;

public class CreatePostSteps {

    @Steps
    CreatePost createPost;

    @Given("I set API endpoint for create a new post")
    public void setApiEndpoint() {
        createPost.setApiEndpoint();
    }

    @When("I send request to create a new post")
    public void sendCreatePostRequest() {
        createPost.sendCreateNewPostRequest();
    }

    @Then("I receive status code 201")
    public void receiveStatusCode201() {
        createPost.receiveStatusCode201();
    }

    @And("I receive valid data for created post")
    public void receiveValidCreatedPostData() {
        createPost.receiveValidCreatedPostData();
    }

    @When("I send request to create a new post with invalid inputs")
    public void sendCreatePostRequestInvalidInputs() {
        createPost.sendCreatePostInvalidInputs();
    }

    @Then("I receive status code 400")
    public void receiveStatusCode400() {
        createPost.receiveStatusCode400();
    }
}
