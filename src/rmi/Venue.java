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

    public Venue(String venuelocation, String venueName, int venueMAxCapacity) {
        this.venuelocation = venuelocation;
        this.venueName = venueName;
        this.venueMAxCapacity = venueMAxCapacity;
        this.venueStatus = true;
    }


    private ArrayList<Event> Timeline = new ArrayList();
    private ArrayList<Service> ThirdPartyCompany = new ArrayList();

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

    public void setTimeline(ArrayList<Event> Timeline) {
        this.Timeline = Timeline;
    }

    public void setThirdPartyCompany(ArrayList<Service> ThirdPartyCompany) {
        this.ThirdPartyCompany = ThirdPartyCompany;
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

    public ArrayList<Event> getTimeline() {
        return Timeline;
    }

    public ArrayList<Service> getThirdPartyCompany() {
        return ThirdPartyCompany;
    }
    
    public void manageServices(){
        boolean run=true;
        
        while(run==true){
            System.out.println("please choose the service you wantt to manage");
            System.out.println("1:DecorationCompany\n2:MediaProduction\n3: invite Restaurant\n");
            Scanner myObj = new Scanner(System.in);
            int input1 = Integer.parseInt(myObj.nextLine()); 
            if(input1 == 1){
                int input2 = Integer.parseInt(myObj.nextLine());  
                System.out.println("1:add\n2:remove\n");
            if(input2==1){
                System.out.println("enter Name OF service");
                String serviceName = myObj.nextLine();

                for(int i = 0; i < Admin.AvailableDecorationCompany.size();i++){
                    int number = 0;
                    System.out.println(number+":"+Admin.AvailableDecorationCompany.getName);
                    }

                int input3 = Integer.parseInt(myObj.nextLine());  
                AvailableDecorationCompany.add(1);
                }
            }
        }
    }
}
