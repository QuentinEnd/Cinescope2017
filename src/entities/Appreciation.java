package entities;

/**
 *
 * @author quent
 */
public class Appreciation {
    
    private int idAppreciation;
    private String etoile;
    private String LibelleAppreciation;

    //************ CONSTRUCTEUR ********\\
    // Constructeur Vide
    /**
     *
     */
    public Appreciation() {
    }

    // Constructeur Moitié Plein
    /**
     * 
     * @param etoile
     * @param LibelleAppreciation 
     */
    public Appreciation(String etoile, String LibelleAppreciation) {
        this.etoile = etoile;
        this.LibelleAppreciation = LibelleAppreciation;
    }

    // Constructeur Plein
    /**
     * 
     * @param idAppreciation
     * @param etoile
     * @param LibelleAppreciation 
     */
    public Appreciation(int idAppreciation, String etoile, String LibelleAppreciation) {
        this.idAppreciation = idAppreciation;
        this.etoile = etoile;
        this.LibelleAppreciation = LibelleAppreciation;
    }

    //******** Fin CONSTRUCTEUR ********\\
    
    //******** GETTERS and SETTERS ********\\
    /**
     * 
     * @return 
     */
    public int getIdAppreciation() {
        return idAppreciation;
    }

    /**
     * 
     * @param idAppreciation 
     */
    public void setIdAppreciation(int idAppreciation) {
        this.idAppreciation = idAppreciation;
    }

    /**
     * 
     * @return 
     */
    public String getEtoile() {
        return etoile;
    }

    /**
     * 
     * @param etoile 
     */
    public void setEtoile(String etoile) {
        this.etoile = etoile;
    }

    /**
     * 
     * @return 
     */
    public String getLibelleAppreciation() {
        return LibelleAppreciation;
    }

    /**
     * 
     * @param LibelleAppreciation 
     */
    public void setLibelleAppreciation(String LibelleAppreciation) {
        this.LibelleAppreciation = LibelleAppreciation;
    }
    //******** Fin GETTERS and SETTERS ********\\
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Appreciation{" + "idAppreciation=" + idAppreciation + ", etoile=" + etoile + ", LibelleAppreciation=" + LibelleAppreciation + '}';
    }
    
    
    
    
    
    
    
}
