/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import com.bitlab.dao.RolDao;
import com.bitlab.dao.UserDao;
import com.bitlab.entities.Rol;
import com.bitlab.entities.User;
import com.bitlab.utils.Sha;
import java.util.Date;
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
            RolDao rd= new RolDao();
            UserDao r = new UserDao();
            User input = new User(0, "karla", Sha.encrypt("12345"), "yo", new Date(), "yo", new Date(), rd.find(1));
            System.out.println(r.login(input));
        } catch (Exception ex) {
            Logger.getLogger(Jpa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
