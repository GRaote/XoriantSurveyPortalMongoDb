package com.xoriant.test;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

public class MongoTest {
	public static void main(String args[]) throws JsonMappingException,
			JsonParseException {
		// MongoDatabase database = MongoConnectionFactory.getConnection();
		// // database.createCollection("employee");
		// MongoCollection<Document> collection = database
		// .getCollection("employee");
		//
		// Document employee1 = new Document("empId", "e01").append("ename",
		// "Gaurang");
		// Document employee2 = new Document("empId", "e02").append("ename",
		// "Adarsh");
		// collection.insertOne(employee1);
		// collection.insertOne(employee2);
		//
		//
		// ObjectMapper mapper = new ObjectMapper();
		// MongoCursor<Document> cursor = collection.find().iterator();
		// ArrayList<Employee> employees = new ArrayList<>();
		// try {
		// while (cursor.hasNext()) {
		// Document cur = cursor.next();
		// cur.remove("_id");
		// Employee employee;
		// try {
		// employee = mapper.readValue(cur.toJson(), Employee.class);
		// employees.add(employee);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// } finally {
		// cursor.close();
		// }
		//
		// System.out.println(employees);
		// Survey survey=new Survey("001","Who are you?","A","B","Open");
		// MongoDatabase database = MongoConnectionFactory.getConnection();
		// database.createCollection("surveys");
		// MongoCollection<Document> collection = database
		// .getCollection("surveys");
		// Document sur = new Document("surveyId", survey.getSurveyId())
		// .append("title", survey.getTitle())
		// .append("choice1", survey.getChoice1())
		// .append("choice2", survey.getChoice2())
		// .append("status", survey.getStatus());
		// collection.insertOne(sur);

		// ObjectMapper mapper = new ObjectMapper();
		// MongoDatabase database = MongoConnectionFactory.getConnection();
		// MongoCollection<Document> collection = database
		// .getCollection("surveys");
		// MongoCursor<Document> cursor = collection.find().iterator();
		// Map<String, Survey> surveyList = new HashMap<String, Survey>();
		// try {
		// while (cursor.hasNext()) {
		// Document cur = cursor.next();
		// cur.remove("_id");
		// Survey survey;
		// try {
		// survey = mapper.readValue(cur.toJson(), Survey.class);
		// surveyList.put((String) cur.get("surveyId"), survey);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// } finally {
		// cursor.close();
		// }
		// MongoDatabase database = MongoConnectionFactory.getConnection();
		// database.createCollection("employeesurvey");
		// MongoCollection<Document> collection = database
		// .getCollection("employeesurvey");
		// EmployeeSurvey empSurvey=new EmployeeSurvey("e01001", "e01", "001",
		// "Who are you?", "A");
		//
		// Document empSur = new Document("empSurveyId",
		// empSurvey.getEmpSurveyId())
		// .append("empId", empSurvey.getEmpId())
		// .append("surveyId", empSurvey.getSurveyId())
		// .append("title", empSurvey.getTitle())
		// .append("finalChoice", empSurvey.getFinalChoice());
		// collection.insertOne(empSur);
		// ObjectMapper mapper = new ObjectMapper();
		// MongoDatabase database = MongoConnectionFactory.getConnection();
		// MongoCollection<Document> collection = database
		// .getCollection("employeesurvey");
		// MongoCursor<Document> cursor = collection.find().iterator();
		// Map<String, EmployeeSurvey> employeeSurveyList = new HashMap<String,
		// EmployeeSurvey>();
		// try {
		// while (cursor.hasNext()) {
		// Document cur = cursor.next();
		// cur.remove("_id");
		// EmployeeSurvey empSurvey;
		// ;
		// try {
		// empSurvey = mapper.readValue(cur.toJson(),
		// EmployeeSurvey.class);
		// employeeSurveyList.put((String) cur.get("empSurveyId"),
		// empSurvey);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// }
		// } finally {
		// cursor.close();
		// }

	}

}
