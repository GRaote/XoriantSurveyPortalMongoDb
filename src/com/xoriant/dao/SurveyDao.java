package com.xoriant.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.xoriant.dao.supp.MongoConnectionFactory;
import com.xoriant.model.Survey;

/**
 * 
 * @author raote_g
 * 
 */
public enum SurveyDao {
	instance;

	/**
	 * Adds survey
	 * 
	 * @param survey
	 * @throws SQLException
	 */
	public void addSurvey(Survey survey)  {
		MongoDatabase database = MongoConnectionFactory.getConnection();
		MongoCollection<Document> collection = database
				.getCollection("surveys");
		Document sur = new Document("surveyId", survey.getSurveyId())
				.append("title", survey.getTitle())
				.append("choice1", survey.getChoice1())
				.append("choice2", survey.getChoice2())
				.append("status", survey.getStatus());
		collection.insertOne(sur);

	}

	/**
	 * Gets the list of Surveys
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Survey> getAllSurvey()  {
		ObjectMapper mapper = new ObjectMapper();
		MongoDatabase database = MongoConnectionFactory.getConnection();
		MongoCollection<Document> collection = database
				.getCollection("surveys");
		MongoCursor<Document> cursor = collection.find().iterator();
		Map<String, Survey> surveyList = new HashMap<String, Survey>();
		try {
			while (cursor.hasNext()) {
				Document cur = cursor.next();
				cur.remove("_id");
				Survey survey;
				try {
					survey = mapper.readValue(cur.toJson(), Survey.class);
					surveyList.put((String) cur.get("surveyId"), survey);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} finally {
			cursor.close();
		}
		return surveyList;
	}
}
