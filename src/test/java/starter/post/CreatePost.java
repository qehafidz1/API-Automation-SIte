package starter.post;

import com.github.javafaker.Faker;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.utils.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class CreatePost {
    private static String url = "https://jsonplaceholder.typicode.com/posts";

    @Step("I set API endpoint for create a new post")
    public String setApiEndpoint() {
        return url;
    }

    @Step("I send request to create a new post")
    public void sendCreateNewPostRequest() {
        JSONObject requestBody = new JSONObject();

        Faker faker = new Faker();

        String title = faker.book().title();
        String body = faker.lorem().paragraph(3);

        requestBody.put("title", title);
        requestBody.put("body", body);
        requestBody.put("userId", 1);

        SerenityRest.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive status code 201")
    public void receiveStatusCode201() {
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I receive valid data for created post")
    public void receiveValidCreatedPostData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_POST_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

        restAssuredThat(response -> response.body("'id'", notNullValue()));
        restAssuredThat(response -> response.body("'title'", notNullValue()));
        restAssuredThat(response -> response.body("'body'", notNullValue()));
        restAssuredThat(response -> response.body("'userId'", notNullValue()));
    }

    @Step("I send request to create a new post with invalid inputs")
    public void sendCreatePostInvalidInputs() {
        JSONObject requestBody = new JSONObject();

        Faker faker = new Faker();

        String title = faker.book().title();
        String body = faker.lorem().paragraph(3);

        requestBody.put("title", title);
        requestBody.put("body", body);
        requestBody.put("userId", 1);

        SerenityRest.given()
                .header("Content-Type", "text/plain")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive status code 400")
    public void receiveStatusCode400() {
        restAssuredThat(response -> response.statusCode(400));
    }

}
