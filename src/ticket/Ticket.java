/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticket;

/**
 *
 * @author szeman
 */
public class Ticket {
    public String id;
    public String company;
    public String catwCode;
    public String comment;
    
    public float time;

    public Ticket(String id) {
        this.id = id;
    }

    public Ticket(String id, String company, String catwCode, String comment) {
        this.id = id;
        this.company = company;
        this.catwCode = catwCode;
        this.comment = comment;
    }
    

    @Override
    public String toString() {
        return id; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
