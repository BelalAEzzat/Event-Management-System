/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
/**
 *
 * @author pc
 */
public class DB {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> admin;
    private MongoCollection<Document> venues;
    private MongoCollection<Document> thirdPartycompany;
    private MongoCollection<Document> bank; 
    private MongoCollection<Document> Employee;
    private MongoCollection<Document> Event;
    private MongoCollection<Document> reservee;
    private MongoCollection<Document> Visitor;
    private MongoCollection<Document> PaymentMethod;

    
    private Gson gson = new Gson();
       
    public DB() {
      Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.SEVERE);

        // Initialize
        client = new MongoClient();
        database = client.getDatabase("Company"); // Database name
        admin = database.getCollection("admin"); // Collection name
        venues = database.getCollection("venues");        
        thirdPartycompany = database.getCollection("thirdPartycompany");    
        bank = database.getCollection("bank");  
        Employee = database.getCollection("Employee");  
        Event = database.getCollection("Event");    
        reservee = database.getCollection("reservee");  
        Visitor = database.getCollection("Visitor");  
        PaymentMethod = database.getCollection("PaymentMethod");  
          
    }
       public void insertAdmin(Admin s) {
        admin.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Admin inserted.");
    }
     public void insertvenues(Venue s) {
        venues.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("venues inserted.");
    }
      public void insertthirdPartycompany(ThirdPartyCompany s) {
        thirdPartycompany.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("ThirdPartyCompany inserted.");
    }
       public void insertbank(Bank s) {
        bank.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("bank inserted.");
    }
        public void insertEmployee(Employee s) {
        Employee.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Employee inserted.");
    } public void insertEvent(Event s) {
        Event.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Event inserted.");
    }
       
        public void insertreservee(Reservee s) {
        reservee.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("reservee inserted.");
    }
      
      public void insertVisitor(Visitor s) {
        Visitor.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Visitor inserted.");
    }
        public void insertPaymentMethod(PaymentMethod s) {
        PaymentMethod.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("PaymentMethod inserted.");
    }
       
    public void SaveAll(){
        
    }
       public void loadAll(){
       
       
       }

     
          
    
}
