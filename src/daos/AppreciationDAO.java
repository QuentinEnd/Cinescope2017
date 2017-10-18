package daos;

import entities.Appreciation;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quent
 */
public class AppreciationDAO implements IDAO<Appreciation> {

    private Connection cnx;

    /**
     * 
     * @param cnx 
     */
    public AppreciationDAO(Connection cnx) {
        this.cnx = cnx;
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int insert(Appreciation objet) {
        // Déclaration des attributs
        int liAffecte = 0;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL appreciationInsert(?,?)");

            // Valorisation des paramètres
            lpst.setString(1, objet.getEtoile());
            lpst.setString(2, objet.getLibelleAppreciation());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture du curseurs
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée
            System.out.println(ex.getMessage());
            liAffecte = -1;
        }

        return liAffecte;
    }// Fin Insert

    /**
     *
     * @return
     */
    @Override
    public List<Appreciation> selectAll() {
        // Déclaration des attributs
        List<Appreciation> listeAppreciation = new ArrayList();

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL appreciationSelectAll()");
            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle sur la table
            while (lrs.next()) {
                Appreciation ap = new Appreciation();
                ap.setIdAppreciation(lrs.getInt(1));
                ap.setEtoile(lrs.getString(2));
                ap.setLibelleAppreciation(lrs.getString(3));
                // Enregistrement et ajout des datas dans la liste
                listeAppreciation.add(ap);
            }

            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée pendant le processus
            System.out.println(ex.getMessage());
        }

        return listeAppreciation;
    }// Fin selectAll

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Appreciation selectOne(int id) {
        // Déclaration des attributs;
        Appreciation ap = new Appreciation();

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL appreciationSelectOne(?)");

            // Valorisation des paramètres
            lpst.setInt(1, id);

            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle pour la récupération des informations d'un arrondissement
            // Si l'arrondissement est bon
            if (lrs.next()) {
                ap.setIdAppreciation(id);
                ap.setEtoile(lrs.getString("ETOILE"));
                ap.setLibelleAppreciation(lrs.getString("LIBELLE_appreciation"));
            } else {
                ap.setIdAppreciation(0);
                ap.setEtoile("INTROUVABLE");
                ap.setLibelleAppreciation("INTROUVABLE");
            }

            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée durant le processus
            ap.setIdAppreciation(-1);
            ap.setEtoile(ex.getMessage());
            ap.setLibelleAppreciation(ex.getMessage());
        }

        return ap;
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int delete(Appreciation objet) {
        // Déclaration des attributs
        int liAffecte;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL appreciationDelete(?)");

            // Valorisation des paramètres
            lpst.setInt(1, objet.getIdAppreciation());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture du curseurs
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée durant le processus
            liAffecte = -1;
            System.out.println(ex.getMessage());
        }

        return liAffecte;
    }// Fin delete

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int update(Appreciation objet) {
        // Déclaration des attributs
        int liAffecte;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL appreciationUpdate(?,?,?)");

            // Valorisation des paramètres
            lpst.setString(1, objet.getEtoile());
            lpst.setString(2, objet.getLibelleAppreciation());
            lpst.setInt(3, objet.getIdAppreciation());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture du curseurs
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée durant le processus
            liAffecte = -1;
            System.out.println(ex.getMessage());
        }

        return liAffecte;
    }// Fin update

}// Fin class AppreciationDAO implements IDAO<Appreciation>
