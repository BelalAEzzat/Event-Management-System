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
public class ThirdPartyCompany {
    private String name;

    public ThirdPartyCompany(String name, String Type) {
        this.name = name;
        this.Type = Type;
    }
    private String Type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
    
    
}
