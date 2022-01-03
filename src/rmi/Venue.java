/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Venue {
    private String venuelocation;
    private String venueName;
    private int venueMAxCapacity;
    private Boolean venueStatus;
    private ArrayList<ThirdPartyCompany> companies;
    
    
    public Venue(String venueName,String venuelocation, int venueMAxCapacity) {
        this.venuelocation = venuelocation;
        this.venueName = venueName;
        this.venueMAxCapacity = venueMAxCapacity;
        this.venueStatus = true;
        this.companies = new ArrayList<ThirdPartyCompany>();
    }

    public ArrayList<ThirdPartyCompany> getCompanies() {
        return companies;
    }


    

    public void setVenuelocation(String venuelocation) {
        this.venuelocation = venuelocation;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setVenueMAxCapacity(int venueMAxCapacity) {
        this.venueMAxCapacity = venueMAxCapacity;
    }

    public void setVenueStatus(Boolean venueStatus) {
        this.venueStatus = venueStatus;
    }


    public String getVenuelocation() {
        return venuelocation;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getVenueMAxCapacity() {
        return venueMAxCapacity;
    }

    public boolean getVenueStatus() {
        return venueStatus;
    }

    public void addCompany(ThirdPartyCompany c){
        companies.add(c);
    }
    
//    public void manageServices(){
//        boolean run=true;
//        
//        while(run==true){
//            System.out.println("please choose the service you wantt to manage");
//            System.out.println("1:DecorationCompany\n2:MediaProduction\n3: invite Restaurant\n");
//            Scanner myObj = new Scanner(System.in);
//            int input1 = Integer.parseInt(myObj.nextLine()); 
//            if(input1 == 1){
//                int input2 = Integer.parseInt(myObj.nextLine());  
//                System.out.println("1:add\n2:remove\n");
//            if(input2==1){
//                System.out.println("enter Name OF service");
//                String serviceName = myObj.nextLine();
//
//                for(int i = 0; i < Admin.AvailableDecorationCompany.size();i++){
//                    int number = 0;
//                    System.out.println(number+":"+Admin.AvailableDecorationCompany.getName);
//                    }
//
//                int input3 = Integer.parseInt(myObj.nextLine());  
//                AvailableDecorationCompany.add(1);
//                }
//            }
//        }
//    }

    void get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

