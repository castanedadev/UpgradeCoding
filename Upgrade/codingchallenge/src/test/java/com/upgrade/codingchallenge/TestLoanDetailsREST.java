package com.upgrade.codingchallenge;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.mashape.unirest.http.JsonNode;
import com.upgrade.codingchallenge.utils.Utils;
import com.upgrade.codingchallenge.utils.Utils.ServiceOperation;

public class TestLoanDetailsREST {

	private String baseAPIEndpoint = "https://credapi.credify.tech/api/loanapp/v1/states";
	private static final Logger LOGGER = Logger.getLogger(TestLoanDetailsREST.class.getName());
	
	@Test
	public void eligibleStatesServiceTest() {
		LOGGER.log(Level.INFO, "About to start eligibleStatesServiceTest()");
		JsonNode response = Utils.callServiceOperation(baseAPIEndpoint, ServiceOperation.GET);
		JSONArray array = response.getObject().getJSONArray("states");
		int expectedMinAgeStates = 0, expectedMinLoanStates = 0;
		StringBuffer minAgeStateName = null, minLoanStateName = null;

		// Iterate over states to check minAge and minLoanAmmount
		for (Object state : array) {
			JSONObject jsonState = (JSONObject) state;

			if (Integer.valueOf(jsonState.get("minAge").toString()) == 19) {
				minAgeStateName = new StringBuffer();
				minAgeStateName.append(jsonState.get("label").toString());
				expectedMinAgeStates++;
			}

			if (Double.valueOf(jsonState.get("minLoanAmount").toString()) == 3005) {
				minLoanStateName = new StringBuffer();
				minLoanStateName.append(jsonState.get("label").toString());
				expectedMinLoanStates++;
			}
		}

		AssertJUnit.assertEquals("Only one state has a min age of 19!", 1, expectedMinAgeStates);
		LOGGER.info(minAgeStateName.toString() + " is the only state with min age requirement of 19 years!");
		AssertJUnit.assertEquals("Only one state has min loan amount requirement of $3005!", 1, expectedMinLoanStates);
		LOGGER.info(minLoanStateName + " is the only state with min loan amount requirement of $3005");
		AssertJUnit.assertEquals("Total state count must be 47!", 47, array.length());
	}
}
