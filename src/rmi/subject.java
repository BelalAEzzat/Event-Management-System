/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author Laptop World
 */
public interface subject {

    public void registerObserver(Observer o);

    public void notifyAllObservers(Observer o);

}
