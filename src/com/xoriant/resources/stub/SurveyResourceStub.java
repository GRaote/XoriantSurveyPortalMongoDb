package com.xoriant.resources.stub;

import java.util.HashMap;
import java.util.Map;

import com.xoriant.model.Survey;
import com.xoriant.stubinterface.ISurvey;

/**
 * 
 * @author raote_g
 * 
 */
public class SurveyResourceStub implements ISurvey {
	/**
	 * 
	 */
	@Override
	public void addSurvey(Survey survey) {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 */
	@Override
	public Survey getSurvey(String surveyId) {
		Survey survey = new Survey("001");
		return survey;
	}

	/**
	 * 
	 */
	@Override
	public Map<String, Survey> getAllSurvey() {
		Map<String, Survey> surveys = new HashMap<String, Survey>();
		surveys.put("001", new Survey("001"));
		surveys.put("050", new Survey("050"));
		return surveys;
	}

}
