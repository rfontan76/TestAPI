package Console;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

public class GET_Generate_DeepLinks extends Console_BaseClass {

    @Test
    public void GET_Generate_Deeplinks() {

        given()
                .when()
                .get("console/console-test/path?nodeId=5a65dbff2283004474e8df2c&shareType=history&seoString=This is a message from Walter White Blue C10H15N Breaking Bad&elementItemId=5a5618898b45cb7abcd1cc05&extraParams=p1=12,p2=19")
                .then()
                .statusCode(200)
                .log()
                .all();
    }

}