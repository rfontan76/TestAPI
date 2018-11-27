package restMC;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class POST_RestMC_Entries extends RestMC_BaseClass {

    @Test
    //Verify Request returns 200
    public void POST_RestMC_Entries_200() {

        given()
                .when()
                .body("{\n" +
                        "  \"id\": \"577eb481f1e3a60703d2d595\",\n" +
                        "  \"event\": \"sh_img\",\n" +
                        "  \"tags\": [\n" +
                        "    \"a_tag_0\",\n" +
                        "    \"a_tag_1\",\n" +
                        "    \"...\",\n" +
                        "    \"a_tag_n\"\n" +
                        "  ],\n" +
                        "  \"room\": \"clients|other\",\n" +
                        "  \"data\": {\n" +
                        "    \"base\": {\n" +
                        "      \"ext\": \"jpeg\",\n" +
                        "      \"filename\": \"56141eb2c01c5bdb459117b2\",\n" +
                        "      \"basePath\": \"http://static.iamat.com/media/\",\n" +
                        "      \"formats\": [\n" +
                        "        \"small\",\n" +
                        "        \"medium\",\n" +
                        "        \"bigscreen\"\n" +
                        "      ]\n" +
                        "    },\n" +
                        "    \"img_id\": \"577eb481f1e3a60703d2d595\",\n" +
                        "    \"text\": \"Hello, world!\",\n" +
                        "    \"title\": \"Hello, world!\"\n" +
                        "  }\n" +
                        "}")
                .post("/atcodes/yog18-qa/history")
                .then()
                .statusCode(200)
                .log()
                .all();
    }


    @Test
    //Verify Request Schema is valid
    public void POST_RestMC_Entries_Schema() {

        given()
                .when()
                .body("{\n" +
                        "  \"id\": \"577eb481f1e3a60703d2d595\",\n" +
                        "  \"event\": \"sh_img\",\n" +
                        "  \"tags\": [\n" +
                        "    \"a_tag_0\",\n" +
                        "    \"a_tag_1\",\n" +
                        "    \"...\",\n" +
                        "    \"a_tag_n\"\n" +
                        "  ],\n" +
                        "  \"room\": \"clients|other\",\n" +
                        "  \"data\": {\n" +
                        "    \"base\": {\n" +
                        "      \"ext\": \"jpeg\",\n" +
                        "      \"filename\": \"56141eb2c01c5bdb459117b2\",\n" +
                        "      \"basePath\": \"http://static.iamat.com/media/\",\n" +
                        "      \"formats\": [\n" +
                        "        \"small\",\n" +
                        "        \"medium\",\n" +
                        "        \"bigscreen\"\n" +
                        "      ]\n" +
                        "    },\n" +
                        "    \"img_id\": \"577eb481f1e3a60703d2d595\",\n" +
                        "    \"text\": \"Hello, world!\",\n" +
                        "    \"title\": \"Hello, world!\"\n" +
                        "  }\n" +
                        "}")
                .post("/atcodes/yog18-qa/history")
                .then()
                .assertThat().body(matchesJsonSchemaInClasspath("restMCPostSchema"))
                .statusCode(200)
                .log()
                .all();
    }





}