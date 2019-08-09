package testApiframework;

import java.net.URI;

import org.junit.Before;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TestBase {
	
	public ResponseSpecBuilder respbuilder;
	public ResponseSpecification respoSpec;
	
	public RequestSpecification reqSpec;
	public RequestSpecBuilder reqSpebuilder;
	
	{
		
		 RestAssured.baseURI="https://reqres.in";
	}
	
	@BeforeClass public void setupResponseSpecBuilder() {
		
		
		respbuilder = new ResponseSpecBuilder();
		respbuilder.expectStatusCode(200);
		
		respoSpec=respbuilder.build();
		
		
	}
	
	@BeforeTest public void SetupPreRequisite(){
		
//		reqSpebuilder.
		reqSpec = reqSpebuilder.build();
		
	}

	
	
}
