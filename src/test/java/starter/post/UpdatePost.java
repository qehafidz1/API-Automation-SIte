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

public class UpdatePost {

    private static String url = "https://jsonplaceholder.typicode.com/posts/1";

    @Step("I set API endpoint for update a post")
    public String setApiEndpoint() {
        return url;
    }

    @Step("I send request to update a post")
    public void sendUpdatePostRequest() {
        JSONObject requestBody = new JSONObject();

        Faker faker = new Faker();

        String title = faker.book().title();
        String body = faker.lorem().paragraph(4);

        requestBody.put("id", 1);
        requestBody.put("title", title);
        requestBody.put("body", body);
        requestBody.put("userId", 1);

        SerenityRest.given()
                .header("Content-Type", "application/json; charset=UTF-8")
                .body(requestBody.toString())
                .put(setApiEndpoint());
    }

    @Step("I receive valid data for updated post")
    public void receiveValidUpdatedPostData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.UPDATE_POST_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

        restAssuredThat(response -> response.body("'id'", notNullValue()));
        restAssuredThat(response -> response.body("'title'", notNullValue()));
        restAssuredThat(response -> response.body("'body'", notNullValue()));
        restAssuredThat(response -> response.body("'userId'", notNullValue()));
    }

}
