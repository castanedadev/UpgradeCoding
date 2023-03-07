package com.upgrade.codingchallenge.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class Utils {

	public final static String US_STATE = "HI";
	public final static String US_CITY = "Hanamaulu";
	public final static String US_STREET = "443 Rockaway Drive";
	public final static int US_ZIP_CODE = 96715;
	private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

	public enum ServiceOperation {
		GET, POST, PUT, DELETE
	}

	public static String generateRandomString() {
		return RandomStringUtils.randomAlphabetic(10);
	}

	public static String generateEmail() {
		return "candidate+" + RandomStringUtils.randomNumeric(10) + "@upgrade-challenge.com";
	}

	public static String generateValidDOB(int lowerBound, int upperBound) {
		GregorianCalendar gc = new GregorianCalendar();

		int year = randomBetween(lowerBound, upperBound);
		gc.set(Calendar.YEAR, year);
		int dayOfYear = randomBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

		String month = (gc.get(Calendar.MONTH) + 1) < 10 ? "0" + (gc.get(Calendar.MONTH) + 1)
				: gc.get(Calendar.MONTH) + 1 + "";
		String day = (gc.get(Calendar.DAY_OF_MONTH) + 1) < 10 ? "0" + (gc.get(Calendar.DAY_OF_MONTH) + 1)
				: gc.get(Calendar.DAY_OF_MONTH) + 1 + "";
		

		LOGGER.log(Level.INFO, "Generated date: " + (month + day + gc.get(Calendar.YEAR)));
		return (month + day + gc.get(Calendar.YEAR));
	}

	private static int randomBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static String generatePassword() {
		String pass = RandomStringUtils.randomAlphabetic(1).toUpperCase()
				+ RandomStringUtils.randomAlphabetic(1).toLowerCase() + RandomStringUtils.randomNumeric(1)
				+ RandomStringUtils.randomAlphanumeric(5);

		Pattern emailRegex = Pattern.compile("((?=.*[a-z])(?=.*[0-9])(?=.*[A-Z]).{8})", Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailRegex.matcher(pass);
		
		LOGGER.log(Level.INFO, "Generating password: " + pass);
		LOGGER.log(Level.INFO, "Is generate password valid? " + matcher.find());
		return pass;
	}

	public static JsonNode callServiceOperation(String endpoint, ServiceOperation operation) {

		JsonNode body = null;
		switch (operation) {

		case GET:
			LOGGER.info("Making GET Request to API: " + endpoint);
			try {
				body = Unirest.get(endpoint).asJson().getBody();				
			} catch (Exception ex) {

			}
			break;

		case POST:
			LOGGER.warning("This operation has not been implemented yet.");
			break;

		case PUT:
			LOGGER.warning("This operation has not been implemented yet.");
			break;

		case DELETE:
			LOGGER.warning("This operation has not been implemented yet.");
			break;
		}

		return body;
	}
}
