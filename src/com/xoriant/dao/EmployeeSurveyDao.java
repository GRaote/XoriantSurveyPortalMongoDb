package com.xoriant.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.xoriant.dao.supp.MongoConnectionFactory;
import com.xoriant.model.EmployeeSurvey;
import com.xoriant.model.Survey;

public enum EmployeeSurveyDao {
	instance;

	/**
	 * Adds details of survey taken by a employee.
	 * 
	 * @param empSurvey
	 * @throws SQLException
	 */
	public void addEmployeeSurvey(EmployeeSurvey empSurvey) throws SQLException {
		MongoDatabase database = MongoConnectionFactory.getConnection();
		MongoCollection<Document> collection = database
				.getCollection("employeesurvey");
		Document empSur = new Document("empSurveyId",
				empSurvey.getEmpSurveyId())
				.append("empId", empSurvey.getEmpId())
				.append("surveyId", empSurvey.getSurveyId())
				.append("title", empSurvey.getTitle())
				.append("finalChoice", empSurvey.getFinalChoice());
		collection.insertOne(empSur);

	}

	/**
	 * Gets details of all the surveys taken by all employees.
	 * 
	 * @return
	 */
	public Map<String, EmployeeSurvey> getAllSurveyConduced() {
		ObjectMapper mapper = new ObjectMapper();
		MongoDatabase database = MongoConnectionFactory.getConnection();
		MongoCollection<Document> collection = database
				.getCollection("employeesurvey");
		MongoCursor<Document> cursor = collection.find().iterator();
		Map<String, EmployeeSurvey> employeeSurveyList = new HashMap<String, EmployeeSurvey>();
		try {
			while (cursor.hasNext()) {
				Document cur = cursor.next();
				cur.remove("_id");
				EmployeeSurvey empSurvey;
				;
				try {
					empSurvey = mapper.readValue(cur.toJson(),
							EmployeeSurvey.class);
					employeeSurveyList.put((String) cur.get("empSurveyId"),
							empSurvey);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} finally {
			cursor.close();
		}
		return employeeSurveyList;
	}

	/**
	 * Gets all the surveys taken by a particular employee
	 * 
	 * @param empId
	 * @return
	 */
	public List<Survey> getAllSurveyConducedByEmpId(String empId) {

		Map<String, EmployeeSurvey> employeeSurveyList = EmployeeSurveyDao.instance
				.getAllSurveyConduced();
		List<EmployeeSurvey> employeeSurvey = new ArrayList<>(
				employeeSurveyList.values());
		List<Survey> surveys = new ArrayList<Survey>();
		for (EmployeeSurvey emp : employeeSurvey) {
			if (emp.getEmpId().equals(empId)) {
				surveys.add(new Survey(emp.getSurveyId(), emp.getTitle(), emp
						.getFinalChoice()));
			}
		}

		return surveys;
	}
}
