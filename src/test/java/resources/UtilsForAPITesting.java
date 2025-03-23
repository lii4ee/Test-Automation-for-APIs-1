package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class UtilsForAPITesting {
	
	RequestSpecification req;
	
	public RequestSpecification requestSpecificationUtility(String somewhereelse)
	{
		req = new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();
		return req;
	}
}
