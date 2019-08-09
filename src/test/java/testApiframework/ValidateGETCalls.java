package testApiframework;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given ;


//import static 

public class ValidateGETCalls extends TestBase {

	@Test protected void validateUserList() {
		
		reqSpec.and().queryParam("page", 2);
//		given().spec(reqSpec).when().get().then().body("page", ham)

	}
	
	
}
