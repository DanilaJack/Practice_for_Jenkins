package gitlab_tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class API_Tests {

    @Test
    public void checkAllUsersTest(){

        List<User> users = given()
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then().statusCode(200).log().body()
                .extract().body().jsonPath().getList("", User.class);

        List<String> names = users.stream().map(User::getName).toList();
        Assertions.assertTrue(names.size()>5);

    }
}
