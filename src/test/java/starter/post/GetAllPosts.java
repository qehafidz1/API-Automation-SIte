package starter.post;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllPosts {
    private static String url = "https://jsonplaceholder.typicode.com/posts";

    @Step("I set API endpoint for get all posts")
    public String setApiEndpoint() {
        return url;
    }

    @Step("I send request to get all posts")
    public void sendGetAllPostsRequest() {
        SerenityRest.given().get(setApiEndpoint());
    }

    @Step("I receive status code 200")
    public void receiveValidStatusCode200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid posts data")
    public void receiveValidPostsData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_POSTS_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
