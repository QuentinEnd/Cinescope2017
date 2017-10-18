package daos;

import entities.Departement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quent
 */
public class DepartementDAO {

    private Connection icnx;

    public DepartementDAO(Connection icnx) {
        this.icnx = icnx;
    }// Fin constructeur

    /**
     *
     * @param d
     * @return
     */
    public int insert(Departement d) {
        // Déclaration des attributs
        int liAffecte = 0;

        try {
            // Préparation de l'ordre SQL
            PreparedStatement lpst = icnx.prepareStatement("CALL departementInsert(?,?)");

            // Valorisation des paramètres
            lpst.setString(1, d.getCodeDepartement());
            lpst.setString(2, d.getNomDepartement());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            liAffecte = -1;
        }

        return liAffecte;
    }// Fin INSERT
    
    /**
     *
     * @param id
     * @return
     */
    public Departement selectOne(int id) {
        // Déclaration des attributs
        Departement d = new Departement();

        try {
            // Préparation de l'ordre SQL
            PreparedStatement lpst = icnx.prepareStatement("CALL departementSelectOne(?)");

            // Valorisation des paramètres
            lpst.setInt(1, id);

            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle pour la récupération des informations d'un département
            // Si le département est bon
            if (lrs.next()) {
                d.setIdDepartement(id);
                d.setCodeDepartement(lrs.getString("CODE_departement"));
                d.setNomDepartement(lrs.getString("NOM_departement"));
            // Si le département n'existe pas
            } else {
                d.setIdDepartement(0);
                d.setCodeDepartement("INTROUVABLE");
                d.setNomDepartement("INTROUVABLE");
            }

            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            d.setIdDepartement(-1);
            d.setCodeDepartement(e.getMessage());
            d.setNomDepartement(e.getMessage());
        }

        return d;
    }// Fin selectOne
    
    /**
     *
     * @return
     */
    public List<Departement> selectAll() {
        // Déclaration des attributs
        List<Departement> listeDepartement = new ArrayList();

        try {
            // Préparation de l'ordre SQL
            PreparedStatement lpst = icnx.prepareStatement("CALL departementSelectAll()");
            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle sur la table 
            while (lrs.next()) {
                Departement d = new Departement();
                d.setIdDepartement(lrs.getInt(1));
                d.setCodeDepartement(lrs.getString(2));
                d.setNomDepartement(lrs.getString(3));
                // Enregistrement et ajout des datas dans la liste
                listeDepartement.add(d);
            }
            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            System.out.println(e.getMessage());
        }

        return listeDepartement;
    }// Fin selectAll
    
    /**
     *
     * @param d
     * @return
     */
    public int update(Departement d) {
        // Déclaration des attributs
        int liAffecte;

        try {
            // Préparation de l'ordre SQL
            PreparedStatement lpst = icnx.prepareStatement("CALL departementUpdate(?,?,?)");

            // Valorisation des paramètres
            lpst.setString(1, d.getCodeDepartement());
            lpst.setString(2, d.getNomDepartement());
            lpst.setInt(3, d.getIdDepartement());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            liAffecte = -1;
        }

        return liAffecte;
    }// Fin update

    /**
     *
     * @param d
     * @return
     */
    public int delete(Departement d) {
        // Déclaration des attributs
        int liAffecte;

        try {
            // Préparation de l'ordre SQL
            PreparedStatement lpst = icnx.prepareStatement("CALL departementDelete(?)");

            // Valorisation des paramètres
            lpst.setInt(1, d.getIdDepartement());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            liAffecte = -1;
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }// Fin DELETE 
    
}// Fin class
