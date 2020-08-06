/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import com.bitlab.dao.UserDao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrea
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserDao udao = new UserDao();
        try {
            System.out.println(udao.find(1).toString());            
        } catch (Exception e) {
            Logger.getLogger(prueba.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
}
