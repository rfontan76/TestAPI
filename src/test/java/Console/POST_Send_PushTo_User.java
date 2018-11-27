package Console;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class POST_Send_PushTo_User extends Console_BaseClass {



   @Test
    public void POST_Send_PushTo_User_200() {

        given()

                .when()
                .body("{\n" +
                        "  \"text\": \"Body message\",\n" +
                        "  \"title\": \"Title\",\n" +
                        "  \"path\": \"Deeplink path\"\n" +
                        "}")
                .post("/atcodes/yog18-qa/push/user/5bb5029103b2a70938ce90fe")
                .then()
                .statusCode(200)
                .log()
                .all();
    }


}
