package com.xoriant.resourcestest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.xoriant.dao.SurveyDao;
import com.xoriant.model.Survey;
import com.xoriant.resources.stub.SurveyResourceStub;
import com.xoriant.stubinterface.ISurvey;

public class SurveyResourcesTest {

	private Survey survey = null;
	private ISurvey iSurvey = null;
	private Map<String, Survey> surveys = new HashMap<String, Survey>();

	/**
	 * 
	 */
	@Before
	public void setup() {
		iSurvey = new SurveyResourceStub();
		surveys = iSurvey.getAllSurvey();
		survey = iSurvey.getSurvey("001");

	}

	/**
	 * 
	 */
	@Test
	public void testGetAllSurveys() {
		boolean gotException = true;

		try {
			SurveyDao.instance.getAllSurvey();
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception");
			gotException = false;
		}

		if (!gotException) {
			fail("Returned null");
		}
	}

	/**
	 * 
	 * 
	 */
	@Test
	public void getAllSurveysSuccessTest() {

		Map<String, Survey> surveyMap = null;
		surveyMap = SurveyDao.instance.getAllSurvey();
		Survey sur = surveyMap.get("001");
		Survey sur1 = surveys.get("001");
		assertEquals(sur, sur1);
	}

	/**
	 * 
	 * 
	 */
	@Test
	public void getAllSurveysFailTest() {

		Map<String, Survey> surveyMap = null;
		surveyMap = SurveyDao.instance.getAllSurvey();
		Survey sur = surveyMap.get("001");
		Survey sur1 = surveys.get("050");
		boolean flag = sur.equals(sur1);
		assertFalse(flag);
	}

}
