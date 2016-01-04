package com.xoriant.resources.stub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xoriant.model.EmployeeSurvey;
import com.xoriant.model.Survey;
import com.xoriant.stubinterface.IEmployeeSurvey;

/**
 * 
 * @author raote_g
 * 
 */
public class EmployeeSurveyResourceStub implements IEmployeeSurvey {
	/**
	 * 
	 */
	@Override
	public void addEmployeeSurvey(EmployeeSurvey empSurvey) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	@Override
	public Map<String, EmployeeSurvey> getAllSurveyConduced() {
		Map<String, EmployeeSurvey> empSurvey = new HashMap<String, EmployeeSurvey>();
		empSurvey.put("e01001", new EmployeeSurvey("e01001"));
		empSurvey.put("e01050", new EmployeeSurvey("e01050"));
		return empSurvey;
	}

	/**
	 * 
	 */
	@Override
	public List<Survey> getAllSurveyConducedByEmpId(String empId) {
		List<Survey> surveys = new ArrayList<Survey>();
		surveys.add(new Survey("001"));
		surveys.add(new Survey("050"));
		return surveys;
	}

}
