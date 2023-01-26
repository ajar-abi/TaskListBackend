package com.build.curd.SpringBootDemo.db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class TaskListDB {
	public ArrayList viewList() {
		
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
		ArrayList<Object> iterDoc = new ArrayList<>();
		try {
			MongoDatabase db = mongoClient.getDatabase("TaskList");
			MongoCollection<Document> collection = db.getCollection("TaskCollection");
			//Retrieving the documents
		    iterDoc = collection.find().into(new ArrayList<>());
		} catch (Error e) {
			System.out.println("error " + e);
		} finally {
			mongoClient.close();
		}
		return iterDoc;
		
	}
	public String addList(String taskid, String taskName) {
		
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
		try {
		MongoDatabase db = mongoClient.getDatabase("TaskList");
		MongoCollection<Document> collection = db.getCollection("TaskCollection");
		
		Document document = new Document();
	    document.append("taskid", taskid);
	    document.append("taskName", taskName);
	    document.append("status", "CREATED");
	    collection.insertOne(document);
		} catch (Error e) {
			System.out.println("error " + e);
		} finally {
	    mongoClient.close();
		}
		return "Success !!";
	}
	
	public String deletetask(String taskid) {
		
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 ); 
		
		List<TaskModal> taskmodal = new ArrayList<TaskListDB.TaskModal>();
		try {
		MongoDatabase db = mongoClient.getDatabase("TaskList");
		MongoCollection<Document> collection = db.getCollection("TaskCollection");
		collection.deleteOne(Filters.eq("taskid", taskid));
		} catch (Error e) {
			System.out.println("error " + e);
		} finally {
		mongoClient.close();
		}
		return "Deleted !!";
	}
	
	
	public class TaskModal {
		public String taskid;
		public String taskName;
		public String id;
	}
}

