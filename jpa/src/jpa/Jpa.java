/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import com.bitlab.dao.UserDao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nativi
 */
public class Jpa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UserDao r= new UserDao();
            
            System.out.println(r.find(1).toString());
        } catch (Exception ex) {
            Logger.getLogger(Jpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
