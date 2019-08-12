package testApiframework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestLogSpecification;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given ;
import static org.hamcrest.Matchers.*;



//import static 

public class ValidateGETCalls extends TestBase {
	

	

	@Test protected void validateUserList() {
		
		
		reqSpec.queryParam("page", 2);
		reqSpec.basePath("api/users");
//		reqSpec.accept(ContentType.JSON);
//		reqSpec.header("Content-Type","application/json");
		RequestLogSpecification logVal = reqSpec.log();
		logVal.everything();
//		reqSpec.given().get("?page=2").thenReturn().getBody();
//		System.out.println("-->>>--->>>>>------->>>------");
//		Response respo = given().basePath("/api/users").pathParam("page", "2").spec(reqSpec).when().get();
		
//		respo.body().prettyPrint();
		
		System.out.println("-->>>--->>>>>------->>>------");
		given().spec(reqSpec).when().get().body().prettyPrint();	//here; reqSpec can use 
		System.out.println("-->>>--->>>>>------->>>------");
		given().when().get().body().prettyPrint();
//		System.out.println("-->>>--->>>>>------->>>------");
//		given().when().get().then().body("page", equalTo("2"));
//		
//		System.out.println("-->>>--->>>>>------->>>------");
//		reqSpec.given().get("?page=2").thenReturn().getBody();
//		System.out.println("-->>>--->>>>>------->>>------");

	}
	
	
}
