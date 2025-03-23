package stepDefinition;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.UtilsForAPITesting;
import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.Assert;


public class StepDefinition extends UtilsForAPITesting {
	
	RequestSpecification req;
	Response responseAfterHTTPMethod;
	
	@Given("I have the API endpoint {string}")
	public void i_have_the_api_endpoint(String endPoint) {
		System.out.println("1");
		req = requestSpecificationUtility(endPoint);
	}

	@When("I send a GET request to the endpoint {string}")
	public void i_send_a_get_request_to_the_endpoint(String endPoint) {
		System.out.println("2");
		responseAfterHTTPMethod = given().header("Content-Type", "application/json").spec(req).when().get(endPoint);
	}

	@Then("the response code should be {int}")
	public void the_response_code_should_be(Integer statusCode) {
		System.out.println("3");
		String responseString = responseAfterHTTPMethod.then().extract().asString();
		JsonPath js = new JsonPath(responseString);
		Assert.assertEquals(js.getInt(responseString), statusCode);
	}

	@Then("the response JSON should contain all brands list")
	public void the_response_json_should_contain_all_brands_list() {
		System.out.println("4");
		String responseString = responseAfterHTTPMethod.then().extract().asString();
		JsonPath js = new JsonPath(responseString);
		List <Object> arr = js.getList("products");
		Assert.assertTrue(arr.size() > 0);
		System.out.println("Should make a better assert");
	}

	@When("I send a PUT request to the endpoint {string}")
	public void i_send_a_put_request_to_the_endpoint(String string) {
		

		
	}

	@Then("the response message should be {string}")
	public void the_response_message_should_be(String string) {

		
	}

}
