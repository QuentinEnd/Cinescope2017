package daos;

import entities.Arrondissement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quent
 */
public class ArrondissementDAO implements IDAO<Arrondissement> {

    private Connection cnx;

    /**
     *
     * @param cnx
     */
    public ArrondissementDAO(Connection cnx) {
        this.cnx = cnx;
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int insert(Arrondissement objet) {

        // Déclaration des attributs
        int liAffecte = 0;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL arrondissementInsert(?,?)");

            // Valorisation des paramètres
            lpst.setString(1, objet.getCodeArrondissement());
            lpst.setString(2, objet.getNomArrondissement());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée
            System.out.println(ex.getMessage());
            liAffecte = -1;
        }

        return liAffecte;
    }// Fin insert

    /**
     *
     * @return
     */
    @Override
    public List<Arrondissement> selectAll() {
        // Déclaration des attributs
        List<Arrondissement> listeArrondissement = new ArrayList();

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL arrondissementSelectAll()");
            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle sur la table
            while (lrs.next()) {
                Arrondissement a = new Arrondissement();
                a.setIdArrondissement(lrs.getInt(1));
                a.setCodeArrondissement(lrs.getString(2));
                a.setNomArrondissement(lrs.getString(3));
                // Enregistrement et ajotu des datas dans la liste
                listeArrondissement.add(a);
            }

            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée pendant le processus
            System.out.println(ex.getMessage());
        }

        return listeArrondissement;
    }// Fin selectAll

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Arrondissement selectOne(int id) {
        // Déclaration des attributs;
        Arrondissement a = new Arrondissement();

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL arrondissementSelectOne(?)");

            // Valorisation des paramètres
            lpst.setInt(1, id);

            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle pour la récupération des informations d'un arrondissement
            // Si l'arrondissement est bon
            if (lrs.next()) {
                a.setIdArrondissement(id);
                a.setCodeArrondissement(lrs.getString("CODE_arrondissement"));
                a.setNomArrondissement(lrs.getString("NOM_arrondissement"));
            } else {
                a.setIdArrondissement(0);
                a.setCodeArrondissement("INTROUVABLE");
                a.setNomArrondissement("INTROUVABLE");
            }

            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée durant le processus
            a.setIdArrondissement(-1);
            a.setCodeArrondissement(ex.getMessage());
            a.setNomArrondissement(ex.getMessage());
        }

        return a;
    }// Fin selectOne

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int delete(Arrondissement objet) {
        // Déclaration des attributs
        int liAffecte;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL arrondissementDelete(?)");

            // Valorisation des paramètres
            lpst.setInt(1, objet.getIdArrondissement());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée durant le processus
            liAffecte = -1;
            System.out.println(ex.getMessage());
        }

        return liAffecte;
    }// fin delete

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int update(Arrondissement objet) {
        // Déclaration des attributs
        int liAffecte;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL arrondissementUpdate(?,?,?)");

            // Valorisation des paramètres
            lpst.setString(1, objet.getCodeArrondissement());
            lpst.setString(2, objet.getNomArrondissement());
            lpst.setInt(3, objet.getIdArrondissement());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException ex) { // Si une exception est levée durant le processus
            liAffecte = -1;
            System.out.println(ex.getMessage());
        }

        return liAffecte;
    }// Fin update

}// Fin class ArrondissementDAO implements IDAO<Arrondissement>
