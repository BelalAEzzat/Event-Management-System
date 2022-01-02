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
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

/**
 *
 * @author pc
 */
public class DB {

    private static DB instance;
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Document> admin;

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

        thirdPartycompany = database.getCollection("thirdPartycompany");
        bank = database.getCollection("bank");
        Employee = database.getCollection("Employee");
        Event = database.getCollection("Event");
        reservee = database.getCollection("reservee");
        Visitor = database.getCollection("Visitor");
        PaymentMethod = database.getCollection("PaymentMethod");

    }

    public static DB getinstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;

    }

    public void insertAdmin(Admin s) throws RemoteException {
        ArrayList<Document> docs = admin.find().into(new ArrayList<Document>());
        if ((docs.size() > 0)) {
            admin.deleteOne(Filters.eq("Email_Address", s.getEmail_Address()));
            admin.insertOne(Document.parse(gson.toJson(s)));
            System.out.println("Admin inserted.");
        } else {
            admin.insertOne(Document.parse(gson.toJson(s)));
            System.out.println("Admin inserted.");
        }

    }

    public boolean insertthirdPartycompany(ThirdPartyCompany s) {
        ArrayList<Venue> result = new ArrayList();
        ArrayList<Document> docs = thirdPartycompany.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            if ((gson.fromJson(jsonResult, ThirdPartyCompany.class).getName().equals(s.getName()))) {
                return false;
            }
        }
        thirdPartycompany.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("ThirdPartyCompany inserted.");
        return true;
    }

    public boolean insertbank(Bank s) {
        ArrayList<Venue> result = new ArrayList();
        ArrayList<Document> docs = bank.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            if ((gson.fromJson(jsonResult, Bank.class).getName().equals(s.getName()))) {
                return false;
            }
        }
        bank.insertOne(Document.parse(gson.toJson(s)));

        System.out.println("bank inserted.");
        return true;
    }

    public boolean insertEmployee(Employee s) {
        ArrayList<Venue> result = new ArrayList();
        ArrayList<Document> docs = Employee.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            if ((gson.fromJson(jsonResult, Employee.class).getEmail_Address().equals(s.getEmail_Address()))) {
                return false;
            }
        }
        Employee.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Employee inserted.");
        return true;
    }

    public boolean insertEvent(Event s) {
        ArrayList<Venue> result = new ArrayList();
        ArrayList<Document> docs = Event.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            if ((gson.fromJson(jsonResult, Event.class).getEventID() == s.getEventID())) {
                return false;
            }
        }
        Event.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Event inserted.");
        return true;
    }

    public boolean insertreservee(Reservee s) {
        ArrayList<Venue> result = new ArrayList();
        ArrayList<Document> docs = reservee.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            if ((gson.fromJson(jsonResult, Reservee.class).getEmail_Address().equals(s.getEmail_Address()))) {
                return false;
            }
        }
        reservee.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("reservee inserted.");
        return true;
    }

    public boolean insertVisitor(Visitor s) {
        ArrayList<Venue> result = new ArrayList();
        ArrayList<Document> docs = Visitor.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            if ((gson.fromJson(jsonResult, Visitor.class).getEmail_Address().equals(s.getEmail_Address()))) {
                return false;
            }
        }
        Visitor.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Visitor inserted.");
        return true;
    }

    public boolean insertPaymentMethod(PaymentMethod s) {
        ArrayList<Venue> result = new ArrayList();
        ArrayList<Document> docs = PaymentMethod.find().into(new ArrayList<Document>());
        for (int i = 0; i < docs.size(); i++) {
            String jsonResult = docs.get(i).toJson();
            if ((gson.fromJson(jsonResult, PaymentMethod.class).getCardNumber() == s.getCardNumber())) {
                return false;
            }
        }
        PaymentMethod.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("PaymentMethod inserted.");
        return true;
    }

    public Admin loginAdmin(String Email, String Password) {
        ArrayList<Document> docs = admin.find(Filters.eq("Email_Address", Email)).into(new ArrayList<Document>());
        if (docs.size() > 0) {
            String jsonResult = docs.get(0).toJson();
            Admin a = gson.fromJson(jsonResult, Admin.class);
            if (a.getPassword().equals(Password)) {
                return a;
            }
        }
        return null;

    }



    public ThirdPartyCompany FindThirdPartybyName(String Name) {
        ArrayList<Document> docs = thirdPartycompany.find(Filters.eq("name", Name)).into(new ArrayList<Document>());
        String jsonResult = docs.get(0).toJson();
        ThirdPartyCompany a = gson.fromJson(jsonResult, ThirdPartyCompany.class);
        return a;
    }

    public Bank FindBankBYname(String Name) {
        ArrayList<Document> docs = bank.find(Filters.eq("Name", Name)).into(new ArrayList<Document>());
        String jsonResult = docs.get(0).toJson();
        Bank a = gson.fromJson(jsonResult, Bank.class);
        return a;
    }

    public Employee loginemEmployee(String Email, String Password) {
        ArrayList<Document> docs = Employee.find(Filters.eq("Email_Address", Email)).into(new ArrayList<Document>());

        String jsonResult = docs.get(0).toJson();
        Employee a = gson.fromJson(jsonResult, Employee.class);
        System.out.println(a.getPassword());
        System.out.println(Password);
        if (a.getPassword().equals(Password)) {
            return a;
        }
        return null;
    }

    public Event findEventByID(int ID) {
        ArrayList<Document> docs = Event.find(Filters.eq("eventID", ID)).into(new ArrayList<Document>());
        String jsonResult = docs.get(0).toJson();
        Event a = gson.fromJson(jsonResult, Event.class);
        return a;
    }

    public Reservee LoginReservee(String Email, String Password) {
        ArrayList<Document> docs = reservee.find(Filters.eq("Email_Address", Email)).into(new ArrayList<Document>());

        String jsonResult = docs.get(0).toJson();
        Reservee a = gson.fromJson(jsonResult, Reservee.class);
        System.out.println(a.getPassword());
        System.out.println(Password);
        if (a.getPassword().equals(Password)) {
            return a;
        }
        return null;

    }

    public Visitor loginVisitor(String Email, String Password) {
        ArrayList<Document> docs = Visitor.find(Filters.eq("Email_Address", Email)).into(new ArrayList<Document>());

        String jsonResult = docs.get(0).toJson();
        Visitor a = gson.fromJson(jsonResult, Visitor.class);
        System.out.println(a.getPassword());
        System.out.println(Password);
        if (a.getPassword().equals(Password)) {
            return a;
        }
        return null;

    }

    /**
     *
     */
    public void UpdateAdmin()  {
        Admin s = Admin.getInstance();
        ArrayList<Document> docs = admin.find().into(new ArrayList<Document>());
        if ((docs.size() > 0)) {
            admin.deleteOne(Filters.eq("Email_Address", s.getEmail_Address()));
            admin.insertOne(Document.parse(gson.toJson(s)));
            System.out.println("Admin inserted.");
        } else {
            admin.insertOne(Document.parse(gson.toJson(s)));
            System.out.println("Admin inserted.");
        }
    }

    public void UpdatethirdPartycompany(ThirdPartyCompany s) {
        ArrayList<Document> docs = thirdPartycompany.find(Filters.eq("name", s.getName())).into(new ArrayList<Document>());

        thirdPartycompany.deleteOne(Filters.eq("name", s.getName()));
        thirdPartycompany.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("ThirdPartyCompany inserted.");

    }

    public void UpdateBank(Bank s) {
        ArrayList<Document> docs = bank.find(Filters.eq("Name", s.getName())).into(new ArrayList<Document>());

        bank.deleteOne(Filters.eq("Name", s.getName()));
        bank.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Bank inserted.");

    }

    public void UpdateEmployee(Employee s) {
        ArrayList<Document> docs = Employee.find(Filters.eq("Email_Address", s.getEmail_Address())).into(new ArrayList<Document>());
        Employee.deleteOne(Filters.eq("Email_Address", s.getEmail_Address()));
        Employee.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Employee inserted.");

    }

    public void UpdateEvent(Event s) {
        ArrayList<Document> docs = Event.find(Filters.eq("eventID", s.getEventID())).into(new ArrayList<Document>());
        Event.deleteOne(Filters.eq("eventID", s.getEventID()));
        Event.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Employee inserted.");
    }

    public void UpdateEvent(Reservee s) {
        ArrayList<Document> docs = reservee.find(Filters.eq("Email_Address", s.getEmail_Address())).into(new ArrayList<Document>());
        reservee.deleteOne(Filters.eq("Email_Address", s.getEmail_Address()));
        reservee.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Employee inserted.");
    }
      public void UpdateVisitor(Visitor s) {
        ArrayList<Document> docs = Visitor.find(Filters.eq("Email_Address", s.getEmail_Address())).into(new ArrayList<Document>());
        Visitor.deleteOne(Filters.eq("Email_Address", s.getEmail_Address()));
        Visitor.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Visitor inserted.");
    }
        public void UpdatePaymentMethod(PaymentMethod s) {
        ArrayList<Document> docs = PaymentMethod.find(Filters.eq("CardNumber", s.getCardNumber())).into(new ArrayList<Document>());
        PaymentMethod.deleteOne(Filters.eq("CardNumber", s.getCardNumber()));
        PaymentMethod.insertOne(Document.parse(gson.toJson(s)));
        System.out.println("Employee inserted.");
    }



}
