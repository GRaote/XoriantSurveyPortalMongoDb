package com.xoriant.dao.supp;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoConnectionFactory {
	@SuppressWarnings("resource")
	public static MongoDatabase getConnection() {
		MongoClient mongoClient;

		mongoClient = new MongoClient(new MongoClientURI(
				"mongodb://localhost:27017"));

		MongoDatabase database = mongoClient.getDatabase("XoriantSurveyPortal");
		return database;
	}
}
