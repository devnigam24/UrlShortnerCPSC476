package com.fullerton.edu.cpsc.cpsc476.DAO;

import org.bson.Document;

import com.fullerton.edu.cpsc.cpsc476.Util.ErrorAndMessages;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class MongoDAO {
	private static MongoClient ourMongoClient;
	private static MongoDatabase urlshortnerDB;
	
	public MongoDAO(){
		try{
			MongoDAO.ourMongoClient = new MongoClient("localhost", 27017);
			if(ourMongoClient != null){
				MongoDAO.urlshortnerDB = ourMongoClient.getDatabase("urlshortnerDB");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}		
	}
	
	public String storeThisDocumentOnThisCollection(Document newUserDocument, String username) {
		try{
			MongoIterable<String> allCollectionsLsit = urlshortnerDB.listCollectionNames();
			for(String oneCollection : allCollectionsLsit){
				if(oneCollection.equals(username)){
					return ErrorAndMessages.collectionExists;
				}
			}
			urlshortnerDB.createCollection(username);
			urlshortnerDB.getCollection(username).insertOne(newUserDocument);
			return null;
		}catch(Exception e){
			return ErrorAndMessages.serverDown;
		}finally{
			if(ourMongoClient != null){
				ourMongoClient.close();
			}
		}
	}
	
	public Boolean loginValidation(String username,String password){
		return true;
	}
}
