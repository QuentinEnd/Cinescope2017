package daos;

import connexion.Connexion;
import entities.Departement;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author quent
 */
public class DepartementDAOTests {

    public static void main(String[] args) {
        Connection lcnx = Connexion.getConnexionMySQL("127.0.0.1", "cinescope2017", "3306", "root", "");

//********************** ORDRE INSERT ******************************************
        System.out.println("******** INSERT ********");
        Departement d = new Departement("99", "Neuf");
        DepartementDAO dao = new DepartementDAO(lcnx);
        int r = dao.insert(d);
        System.out.println(r);
//******************************************************************************
 
 
//********************** ORDRE DELETE ******************************************
        System.out.println("******** DELETE ********");
        Departement d2 = new Departement(4, "99", "Neuf");
        DepartementDAO dao1 = new DepartementDAO(lcnx);
        int r1 = dao1.delete(d2);
        System.out.println(r1);
//****************************************************************************** 


//********************** ORDRE SELECTONE ***************************************
        System.out.println("******** SELECT ONE ********");
        DepartementDAO dao2 = new DepartementDAO(lcnx);
        System.out.println(dao2.selectOne(7));
//******************************************************************************


//********************** ORDRE SELECTALL ***************************************
        System.out.println("******** SELECT ALL ********");
        DepartementDAO dao3 = new DepartementDAO(lcnx);
        List<Departement> listeDepartement = dao3.selectAll();
        for (int i = 0; i < listeDepartement.size(); i++) {
            System.out.println(listeDepartement.get(i));
        }
//******************************************************************************


//********************** ORDRE UPDATE ******************************************
        System.out.println("******** UPDATE ********");
        Departement d3 = new Departement(7, "99", "Neufffff");
        DepartementDAO dao4 = new DepartementDAO(lcnx);
        int r2 = dao4.update(d3);
        System.out.println(r2);
//******************************************************************************

    }

}
