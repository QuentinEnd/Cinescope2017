package essaies;

import connexion.Connexion;
import java.sql.*;

/**
 *
 * @author quent
 */
public class ConnexionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Connection cn = Connexion.getConnexionMySQL("127.0.0.1", "cinescope2017", "3306", "root", "");
        System.out.println(cn);
        
        Connexion.seDeconnecter(cn);
        System.out.println(cn);
    }
    
}
