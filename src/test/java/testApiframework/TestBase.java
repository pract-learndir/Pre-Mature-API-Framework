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

		 RestAssured.baseURI = "https://reqres.in";
	}

	@BeforeClass
	public void setup0ResponseSpecBuilder() {

		respbuilder = new ResponseSpecBuilder();
		respbuilder.expectStatusCode(200);

		respoSpec = respbuilder.build();
		System.out.println("Before class exe..");

	}



	@BeforeTest
	public void Setup1PreRequisite() {

		try {
			reqSpebuilder =  new RequestSpecBuilder();
			reqSpec = reqSpebuilder.build();

		} catch (Exception e) {
			// System.out.println(e.getStackTrace());
			System.out.println("exception nullpoutiner catched..");
			e.getMessage();

		}

		System.out.println("Before Test...exe...");

	}

}
