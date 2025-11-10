import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTest {
    public static class Posts {
        public int id;
        public int userId;
        public String title;
        public String body;
        public Posts() {}
        public Posts(int id, int userId, String title, String body) {
            this.id = id;
            this.userId = userId;
            this.title = title;
            this.body = body;
        }
    }
    public static void main(String[] args) {
        Posts post = new Posts(1, 239, "The Man", "The story of a man");
//        Response response = RestAssured
//                .given()
//                .relaxedHTTPSValidation() // checks if SSL certificate is valid (not expired, hostname matches the one in cert, signed by CA)
//                .baseUri("https://jsonplaceholder.typicode.com")
//                .header("Content-Type", "application/json")
//                .body(post)
//                .when()
//                .post("/posts")
//                .then()
//                .assertThat()
//                .statusCode(201)
//                .extract()
//                .response();
//
//        List<Posts> list = response.jsonPath().getList("$", Posts.class);
//        Posts post = response.as(Posts.class);
//        System.out.println(response.getStatusCode());
//        Posts res = response.as(Posts.class);
//        System.out.println(res.body);
//        System.out.println(response.jsonPath().getString("body"));
//        Response response = RestAssured
//                .given()
//                .relaxedHTTPSValidation()
//                .baseUri("https://jsonplaceholder.typicode.com/")
//                .header("Content-Type","application/json")
//                .body(post)
//                .when()
//                .pathParam("id", 1)
//                .put("/posts/{id}")
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .extract()
//                .response();
        Response response = RestAssured
                .given()
                .relaxedHTTPSValidation()
                .baseUri("https://jsonplaceholder.typicode.com/")
                .header("Content-Type","application/json")
                .body("{ \"title\": \"The Son\"}")
                .when()
                .pathParam("id", 1)
                .queryParam("name", "don")
                .patch("/posts/{id}")
                .then()
                .log().body()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo("The Son"))
                .extract()
                .response();
//        Posts res = response.as(Posts.class);
//        System.out.println(res.title + " " + res.body);
    }
}
