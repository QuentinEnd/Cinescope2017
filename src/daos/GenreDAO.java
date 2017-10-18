package daos;

import entities.Genre;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author quent
 */
public class GenreDAO implements IDAO<Genre> {

    private Connection cnx;

    /**
     *
     * @param cnx
     */
    public GenreDAO(Connection cnx) {
        this.cnx = cnx;
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int insert(Genre objet) {

        // Déclaration des attributs
        int liAffecte = 0;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL genreInsert(?,?,?)");

            // Valorisation des paramètres
            lpst.setString(1, objet.getCodeGenre());
            lpst.setString(2, objet.getLibelleGenre());
            lpst.setString(3, objet.getGenreGrammatical());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            System.out.println(e.getMessage());
            liAffecte = -1;
        }

        return liAffecte;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Genre> selectAll() {
        // Déclaration des attributs
        List<Genre> listeGenre = new ArrayList();

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL genreSelectAll()");
            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle sur la table 
            while (lrs.next()) {
                Genre g = new Genre();
                g.setIdGenre(lrs.getInt(1));
                g.setCodeGenre(lrs.getString(2));
                g.setLibelleGenre(lrs.getString(3));
                g.setGenreGrammatical(lrs.getString(4));
                // Enregistrement et ajout des datas dans la liste
                listeGenre.add(g);
            }
            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            System.out.println(e.getMessage());
        }

        return listeGenre;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Genre selectOne(int id) {
        // Déclaration des attributs
        Genre g = new Genre();

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL genreSelectOne(?)");

            // Valorisation des paramètres
            lpst.setInt(1, id);

            // Exécution de l'ordre SQL
            ResultSet lrs = lpst.executeQuery();

            // Boucle pour la récupération des informations d'un genre
            // Si le département est bon
            if (lrs.next()) {
                g.setIdGenre(id);
                g.setCodeGenre(lrs.getString("CODE_genre"));
                g.setLibelleGenre(lrs.getString("LIBELLE_genre"));
                g.setGenreGrammatical(lrs.getString("genre_GRAMMATICAL"));
                // Si le genre n'existe pas
            } else {
                g.setIdGenre(0);
                g.setCodeGenre("INTROUVABLE");
                g.setLibelleGenre("INTROUVABLE");
                g.setGenreGrammatical("INTROUVABLE");
            }

            // Fermeture des curseurs
            lrs.close();
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            g.setIdGenre(-1);
            g.setCodeGenre(e.getMessage());
            g.setLibelleGenre(e.getMessage());
            g.setGenreGrammatical(e.getMessage());
        }

        return g;
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int delete(Genre objet) {
        // Déclaration des attributs
        int liAffecte;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL genreDelete(?)");

            // Valorisation des paramètres
            lpst.setInt(1, objet.getIdGenre());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            liAffecte = -1;
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int update(Genre objet) {
        // Déclaration des attributs
        int liAffecte;

        try {
            // Préparation de la procédure stockée
            PreparedStatement lpst = cnx.prepareStatement("CALL genreUpdate(?,?,?,?)");

            // Valorisation des paramètres
            lpst.setString(1, objet.getCodeGenre());
            lpst.setString(2, objet.getLibelleGenre());
            lpst.setString(3, objet.getGenreGrammatical());
            lpst.setInt(4, objet.getIdGenre());

            // Exécution de l'ordre SQL
            liAffecte = lpst.executeUpdate();

            // Fermeture des curseurs
            lpst.close();

        } catch (SQLException e) { // Si une exception est levée
            liAffecte = -1;
        }

        return liAffecte;
    }

}// Fin class GenreDAO implements IDAO<Genre>
