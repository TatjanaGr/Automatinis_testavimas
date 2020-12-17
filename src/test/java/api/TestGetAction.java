package api;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class TestGetAction {

	@Test
	public void testGetUser_ExpectedMaleInactive() {
		given().

				pathParam("userId", "101"). // pavadinimas "userId" sugalvojam patys
				log().all().when().

				get("https://gorest.co.in/public-api/users/{userId}"). // cia {}nurodom sugalvota pavadinima

				then().

				assertThat().

				statusCode(200).body("code", is(200)).body("data.gender", equalTo("Male"))
				.body("data.status", equalTo("Inactive")).log().all();

	}
	
	@Test
	public void testGetUsers_Expected20() {
		given().

				queryParam("page","5"). // pavadinimas "userId" sugalvojam patys
				log().all().when().

				get("https://gorest.co.in/public-api/users"). // cia {}nurodom sugalvota pavadinima

				then().

				assertThat().

				body("data", hasSize(20)).
				log().all();

	}
}
