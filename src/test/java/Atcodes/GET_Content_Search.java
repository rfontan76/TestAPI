package Atcodes;

import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;


public class GET_Content_Search extends Atcodes_BaseClass {

    @Test
    //Verify GET Content search http 200
    public void GET_Content_Search_200() {

        given()
                .when()
                .header("Content-Type", "application/json")
                .get("/atcodes/yog18-qa/search/content?tags=new,deportes&page=1&page_entries=10")
                .then()
                .statusCode(200)
                .log()
                .all();
    }


    @Test
    //Verify Test Content Search 404
    public void GET_Content_Search_404() {

        given()
                .when()
                .header("Content-Type", "application/json")
                .get("/atcodes/yog18-qa/search/contents?tags=new,deportes&page=1&page_entries=10")
                .then()
                .statusCode(404)
                .log()
                .all();
    }

    @Test
    //Verify Test Content Search without Atcode returns 404
    public void GET_Content_Search_Atcode_Required() {

        given()
                .when()
                .header("Content-Type", "application/json")
                .get("/atcodes/search/contents?tags=new,deportes&page=1&page_entries=10")
                .then()
                .statusCode(404)
                .log()
                .all();
    }

    @Test
    //Verify Test Content Search without Atcode returns 404
    public void GET_Content_Search_PageEntries_Required() {

        given()
                .when()
                .get("/atcodes/search/contents?tags=new,deportes&page=1")
                .then()
                .statusCode(404)
                .log()
                .all();
    }

    @Test
    //Verify Test Content Search Schema Validation
    public void GET_Content_Search_Schema() {

        given()
                .when()
                .get("/atcodes/yog18-qa/search/content?tags=new,deportes&page=1&page_entries=1")
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("AtcodesGetSchema"))
                .statusCode(200)
                .log()
                .all();
    }


    @Test
    //Verify Test Content Search Schema Validation
    public void GET_Content_Search_EntryCount() {

        given()
                .when()
                .get("/atcodes/yog18-qa/search/content?tags=new,deportes&page=1&page_entries=1")
                .then()
                .assertThat().body("media", equalTo(1))
                .statusCode(200)
                .log()
                .all();
    }

}