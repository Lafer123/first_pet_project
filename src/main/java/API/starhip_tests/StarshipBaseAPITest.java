package API.starhip_tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import API.response.OptionsResponse;
import API.response.StarshipResponse;

import static API.Constants.Constants.*;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class StarshipBaseAPITest {

    @BeforeClass(description = "Verify API status using HEAD")
    public void verifyAPIWorksByHead() {
           Response response =  given()
                .contentType(ContentType.JSON)
                .when()
                .head(BASE_URL)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        LOGGER.info("The status code from response : " + response.getStatusCode());
    }

    @BeforeClass(description = "Verify API status using Options", dependsOnMethods = "verifyAPIWorksByHead")
    public void verifyAPIWorksByOptions() {
        OptionsResponse response = given()
                .contentType(ContentType.JSON)
                .when()
                .options(BASE_URL)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(OptionsResponse.class);

        LOGGER.info("The name from response : " + response.getName());
        assertEquals(response.getName(), STARSHIP_TITLE);
    }

    @Test(description = "Verify the GET request will return 200 status code")
    public void verifyCorrectNameField() {
        StarshipResponse response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(StarshipResponse.class);

        LOGGER.info("The name from response : " + response.getName());
        assertEquals(STARSHIP_NAME, response.getName());
    }
}
