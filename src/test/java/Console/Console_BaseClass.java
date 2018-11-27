package Console;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;

public class Console_BaseClass {

    //Executes before each class
    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }


        //String basePath = System.getProperty("server.base");
        //if (basePath == null) {
           // basePath = "/atcode/yog18-qa/";
        //}
        //RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "https://api.stg-iamat.com";
        }
        RestAssured.baseURI = baseHost;


    }

}
