package entities;

/**
 *
 * @author quent
 */
public class Genre {

    private int idGenre;
    private String codeGenre;
    private String libelleGenre;
    private String genreGrammatical;

    //************ CONSTRUCTEUR ********\\
    // Constructeur Vide
    public Genre() {

    }// Fin Constructeur Vide

    // Constructeur Plein
    public Genre(int idGenre, String codeGenre, String libelleGenre, String genreGrammatical) {
        this.idGenre = idGenre;
        this.codeGenre = codeGenre;
        this.libelleGenre = libelleGenre;
        this.genreGrammatical = genreGrammatical;
    }// Fin Constructeur Plein

    // Constructeur Moitié Plein
    public Genre(String codeGenre, String libelleGenre, String genreGrammatical) {
        this.codeGenre = codeGenre;
        this.libelleGenre = libelleGenre;
        this.genreGrammatical = genreGrammatical;
    }// Fin Constructeur Moitié Plein

    //******** Fin CONSTRUCTEUR ********\\
    
    
    // GETTERS and SETTERS
    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getCodeGenre() {
        return codeGenre;
    }

    public void setCodeGenre(String codeGenre) {
        this.codeGenre = codeGenre;
    }

    public String getLibelleGenre() {
        return libelleGenre;
    }

    public void setLibelleGenre(String libelleGenre) {
        this.libelleGenre = libelleGenre;
    }

    public String getGenreGrammatical() {
        return genreGrammatical;
    }

    public void setGenreGrammatical(String genreGrammatical) {
        this.genreGrammatical = genreGrammatical;
    }

    @Override
    public String toString() {
        return "Genre{" + "idGenre=" + idGenre + ", codeGenre=" + codeGenre + ", libelleGenre=" + libelleGenre + ", genreGrammatical=" + genreGrammatical + '}';
    }
    
    

}// Fin class Genre
