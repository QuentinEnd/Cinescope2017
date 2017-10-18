package daos;

//import connexion.Connexion;
import connexion.Connexion;
import entities.Genre;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author quent
 */
public class GenreDAOTests {

    public static void main(String[] args) {
        Connection cnx = Connexion.getConnexionMySQL("127.0.0.1", "cinescope2017", "3306", "root", "");
        
//        //********************** ORDRE INSERT ******************************************
//        System.out.println("******** INSERT ********");
//        Genre objet = new Genre("H", "Historique", "M");
//        GenreDAO dao = new GenreDAO(cnx);
//        int r = dao.insert(objet);
//        System.out.println(r);
////******************************************************************************

////********************** ORDRE DELETE ******************************************
//        System.out.println("******** DELETE ********");
//        Genre objet2 = new Genre(4, "H", "Histoire", "M");
//        GenreDAO dao2 = new GenreDAO(cnx);
//        int r1 = dao2.delete(objet2);
//        System.out.println(r1);
////****************************************************************************** 
//
////********************** ORDRE SELECTONE ***************************************
//        System.out.println("******** SELECT ONE ********");
//        GenreDAO dao3 = new GenreDAO(cnx);
//        System.out.println(dao3.selectOne(4));
////******************************************************************************
//
////********************** ORDRE SELECTALL ***************************************
//        System.out.println("******** SELECT ALL ********");
//        GenreDAO dao4 = new GenreDAO(cnx);
//        List<Genre> listeGenre = dao4.selectAll();
//        for (int i = 0; i < listeGenre.size(); i++) {
//            System.out.println(listeGenre.get(i));
//        }
////******************************************************************************
//
////********************** ORDRE UPDATE ******************************************
//        System.out.println("******** UPDATE ********");
//        Genre objet3 = new Genre(4, "H", "Histoire", "M");
//        GenreDAO dao5 = new GenreDAO(cnx);
//        int r2 = dao5.update(objet3);
//        System.out.println(r2);
////******************************************************************************
    }

}
