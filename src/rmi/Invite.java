
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author pc
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class Invite {
    private Event event;
    private Reservee from;
    private Visitor to;

    public Invite(Event event, Reservee from, Visitor to) {
        this.event = event;
        this.from = from;
        this.to = to;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setFrom(Reservee from) {
        this.from = from;
    }

    public void setTo(Visitor to) {
        this.to = to;
    }

    public Event getEvent() {
        return event;
    }

    public Reservee getFrom() {
        return from;
    }

    public Visitor getTo() {
        return to;
    }
    
    
    
}