package daos;

import java.sql.*;

/**
 *
 * @author quent
 */
public class Globale {
    
    // Connection est un attribut de la classe Globale
    private static Connection cnx;

    public static Connection getCnx() {
        return cnx;
    }

    public static void setCnx(Connection cnx) {
        Globale.cnx = cnx;
    }
       
}
