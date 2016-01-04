package com.xoriant.dao;

import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;
import org.codehaus.jackson.map.ObjectMapper;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.xoriant.dao.supp.MongoConnectionFactory;
import com.xoriant.model.Employee;

/**
 * 
 * @author raote_g
 * 
 */
public enum EmployeeDao {
	instance;

	/**
	 * Adds employee
	 * 
	 * @param employee
	 */
	public void addEmployee(Employee employee) {

		MongoDatabase database = MongoConnectionFactory.getConnection();
		MongoCollection<Document> collection = database
				.getCollection("employee");
		Document emp = new Document("empId", employee.getEmpId()).append(
				"ename", employee.getEname());
		collection.insertOne(emp);

	}

	/**
	 * Gets the list of all employees
	 * 
	 * @return
	 */
	public ArrayList<Employee> getAllEmployees() {

		ObjectMapper mapper = new ObjectMapper();
		MongoDatabase database = MongoConnectionFactory.getConnection();
		MongoCollection<Document> collection = database
				.getCollection("employee");
		MongoCursor<Document> cursor = collection.find().iterator();
		ArrayList<Employee> employees = new ArrayList<>();
		try {
			while (cursor.hasNext()) {
				Document cur = cursor.next();
				cur.remove("_id");
				Employee employee;
				try {
					employee = mapper.readValue(cur.toJson(), Employee.class);
					employees.add(employee);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} finally {
			cursor.close();
		}
		return employees;
	}
}
