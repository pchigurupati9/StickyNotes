package com.edwardjones.codefest.service;

import java.util.Iterator;

import org.bson.Document;
import org.springframework.stereotype.Service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

/**
 * implements the logic for survivor needs goal input service endpoints
 */
@Service
public class StickyNotesService {

    /**
     * get the Sticky Note
     * 
     * @return StickyNote
     */
    public String getStickyNote() {

    	MongoClient mongoClient = MongoClients.create("mongodb+srv://CodeFest:Fest1%212%403%234%24@codefest.mg69s.mongodb.net/");
    	MongoIterable<String> databaseNames = mongoClient.listDatabaseNames();
    	
    	Iterator<String> databaseNamesIterator = databaseNames.iterator();
    	System.out.println("************ start listing the database names **************");
    	while (databaseNamesIterator.hasNext()) {
    		String databaseName = databaseNamesIterator.next();
    		System.out.println("databaseName: " + databaseName);
//    		databaseName: CodeFest_DB
//    		databaseName: admin
//    		databaseName: local
    	}
    	System.out.println("************ end listing the database names **************");
    	
    	MongoDatabase database = mongoClient.getDatabase("CodeFest_DB");
    	MongoIterable<String> collectionNames = database.listCollectionNames();
    	
    	Iterator<String> collectionNamesIterator = collectionNames.iterator();
    	System.out.println("************ start listing the collection names in CodeFest_DB **************");
    	while (collectionNamesIterator.hasNext()) {
    		String collectionName = collectionNamesIterator.next();
    		System.out.println("collectionName: " + collectionName);
//    		collectionName: reminder_staging
//    		collectionName: sticky_notes
    	}
    	System.out.println("************ end listing the collection names in CodeFest_DB **************");
    	
    	MongoCollection<Document> stickyNotesCollection = database.getCollection("sticky_notes");
    	// all of the documents for testing
    	FindIterable<Document> stickyNotesDocuments = stickyNotesCollection.find();

    	Iterator<Document> stickyNotesDocumentsIterator = stickyNotesDocuments.iterator();
    	System.out.println("************ start listing the documents in sticky_notes collection **************");
    	while (stickyNotesDocumentsIterator.hasNext()) {
    		Document stickyNotesDocument = stickyNotesDocumentsIterator.next();
    		System.out.println("stickyNotesDocument: " + stickyNotesDocument);
    	}
    	System.out.println("************ end listing the documents in sticky_notes collection **************");

    	MongoCollection<Document> reminderStagingCollection = database.getCollection("reminder_staging");
    	// all of the documents for testing
    	FindIterable<Document> reminderStagingDocuments = reminderStagingCollection.find();

    	Iterator<Document> reminderStagingDocumentsIterator = reminderStagingDocuments.iterator();
    	System.out.println("************ start listing the documents in reminder_staging collection **************");
    	while (reminderStagingDocumentsIterator.hasNext()) {
    		Document reminderStagingDocument = reminderStagingDocumentsIterator.next();
    		System.out.println("reminderStagingDocument: " + reminderStagingDocument);
    	}
    	System.out.println("************ end listing the documents in reminder_staging collection **************");
        
    	String stickyNote = "Hello World";

        return stickyNote;
    }

}
