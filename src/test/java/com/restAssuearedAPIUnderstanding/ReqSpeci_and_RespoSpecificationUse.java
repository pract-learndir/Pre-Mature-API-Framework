package com.restAssuearedAPIUnderstanding;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestLogSpecification;
import testApiframework.TestBase;



public class ReqSpeci_and_RespoSpecificationUse extends TestBase {


/*	Ineffective 
 * 
 * 
 * @Override
	@BeforeTest
	public void Setup1PreRequisite() {
		// TODO Auto-generated method stub
		super.Setup1PreRequisite();
	}*/


	@Test(priority=1)
	void understandReqSpeAbstrctMethodUse(){


		System.out.println("Test --> 1 ");
		/*
		 * specifing request builder data under request specification refernce 
		 * 
		 * */

		reqSpec.queryParam("page", 2);
		reqSpec.basePath("api/users");
		//		reqSpec.accept(ContentType.JSON);
		//		reqSpec.header("Content-Type","application/json");
		RequestLogSpecification logVal = reqSpec.log();
		logVal.everything();
		//		reqSpec.given().get("?page=2").thenReturn().getBody();
		//		System.out.println("-->>>--->>>>>------->>>------");


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
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<-----------------------------------------");
	}


	@Test(priority=2)
	private void useOfresponseBulderObjOnResponsInterface() {

		System.out.println("Test --> 2");

		
		Response respo = given().basePath("/api/users").spec(reqSpec).when().get();
		System.out.println("------>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<-----");
		respo.toString();
		System.out.println("------>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<-----");
		respo.body().prettyPrint();
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<-----------------------------------------");

	}

	@Test(priority=3)
	private void understandResponseValidateer() {
		System.out.println("Test --> 3");
		ValidatableResponse valRespo = given().basePath("/api/users").param("page", "2").spec(reqSpec).when().log().everything().get().then().log().everything();
		valRespo.extract().body().asString();
		valRespo.assertThat().contentType(ContentType.JSON);
		valRespo.statusCode(200);
		valRespo.spec(respoSpec);
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<-----------------------------------------");

	}

	@Test(priority=4)
	private void deptinRespoVal_withoutNOStaticSpc_and_loggingSncReq() {
		System.out.println("Test-------->4");
//		Response respoval1 = given().basePath("api/users").pathParam("page", "2").when().log().everything().get();
		Response respoval1 = given().basePath("api/users").when().log().everything().get(); //Specification should mention and it cant taken a default till mentioned as static or class level member
		respoval1.body().prettyPrint();
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<");
		respoval1.body().asString();	//Both boby().asString and getBody().asString() cannt work for std out on cli  
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<");
		respoval1.getBody().asString();
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<");
		respoval1.body().jsonPath().get("per_page").equals("3");
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<-----------------------------------------");
	}

	@Test(priority=5)
	private void inDepthRespVal_pathparam_and_loggingAftrRespo() {
		System.out.println("Test--->5");
		ValidatableResponse valRespoVal2 = given().basePath("api/users").pathParam("page", "2").when().get("{page}").then().log().everything();
		valRespoVal2.extract().body().asString();
		valRespoVal2.assertThat().contentType(ContentType.JSON);
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<-----------------------------------------");
	}
	
	
	@Test(priority=6)
	private void deptinRespoVal_withoutNOStaticSpc_and_loggingSncReq_and_pathPrm() {
		System.out.println("Test-------->6");
		Response respoval1 = given().basePath("api/users").pathParam("page", "2").when().log().everything().get("{page}");
		
		respoval1.body().prettyPrint();
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<");
		respoval1.body().asString();	//Both boby().asString and getBody().asString() cannt work for std out on cli  
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<");
		respoval1.getBody().asString();
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<");
		respoval1.body().jsonPath().get("data.id").equals("3");
		respoval1.body().jsonPath().get("per_page").equals("3");
		System.out.println("----------------------->>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<-----------------------------------------");
	}
}
