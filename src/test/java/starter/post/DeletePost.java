package starter.post;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class DeletePost {
    private static String url = "https://jsonplaceholder.typicode.com/posts/1";

    @Step("I set API endpoint for delete a post")
    public String setApiEndpoint() {
        return url;
    }

    @Step("I send request to delete a post")
    public void sendDeletePostRequest() {
        SerenityRest.given().delete(setApiEndpoint());
    }
}
