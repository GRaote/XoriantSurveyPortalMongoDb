package com.xoriant.resourcestest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.xoriant.dao.EmployeeSurveyDao;
import com.xoriant.model.EmployeeSurvey;
import com.xoriant.model.Survey;
import com.xoriant.resources.stub.EmployeeSurveyResourceStub;
import com.xoriant.stubinterface.IEmployeeSurvey;

public class EmployeeSurveyResourceTest {

	private List<Survey> surList = null;
	private IEmployeeSurvey iEmployeeSurvey = null;
	private Map<String, EmployeeSurvey> empSurveys = new HashMap<String, EmployeeSurvey>();

	/**
	 * 
	 */
	@Before
	public void setup() {
		iEmployeeSurvey = new EmployeeSurveyResourceStub();
		empSurveys = iEmployeeSurvey.getAllSurveyConduced();
		surList = iEmployeeSurvey.getAllSurveyConducedByEmpId("e01");
	}

	@Test
	public void testGetAllSurveys() {
		boolean gotException = true;

		try {
			EmployeeSurveyDao.instance.getAllSurveyConduced();
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
	public void getAllEmployeeSurveysSuccessTest() {

		Map<String, EmployeeSurvey> empSurvey = null;
		empSurvey = EmployeeSurveyDao.instance.getAllSurveyConduced();
		EmployeeSurvey empSur = empSurvey.get("e01001");
		EmployeeSurvey empSur1 = empSurveys.get("e01001");
		assertEquals(empSur, empSur1);
	}

	/**
	 * 
	 * 
	 */
	@Test
	public void getAllSurveysFailTest() {

		Map<String, EmployeeSurvey> empSurvey = null;
		empSurvey = EmployeeSurveyDao.instance.getAllSurveyConduced();
		EmployeeSurvey empSur = empSurvey.get("e01001");
		EmployeeSurvey empSur1 = empSurveys.get("e01050");
		boolean flag = empSur.equals(empSur1);
		assertFalse(flag);
	}

	/**
	 * 
	 * 
	 */
	@Test
	public void getSurveyByIdSuccessTest() {

		List<Survey> surveyList = new ArrayList<Survey>();
		surveyList = EmployeeSurveyDao.instance
				.getAllSurveyConducedByEmpId("e01");
		assertEquals(surveyList.get(0), surList.get(0));
	}

	/**
	 * 
	 * 
	 */
	@Test
	public void getSurveyByIdFailTest() {

		List<Survey> surveyList = new ArrayList<Survey>();
		surveyList = EmployeeSurveyDao.instance
				.getAllSurveyConducedByEmpId("e01");
		boolean flag = surveyList.get(0).equals(surList.get(1));
		assertFalse(flag);
	}

}
