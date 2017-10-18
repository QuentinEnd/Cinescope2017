/*
 * DTO Département
 * 
 * CONSTRUCTEURS:
 * 4 constructeurs
 *  - un vide;
 *  - un plein;
 *  - un avec les colonnes obligatoires;
 *  - un avec les colonnes obligatoires sans la PK;
 * 
 * GETTERS AND SETTERS:
 *  - tous saus si certains attributs sont en RO ie dérivé ou Frozen
 */
package entities;

/**
 *
 * @author quent
 */
public class Departement {

    /*
     * ATTRIBUTS
     */
    private int idDepartement;
    private String codeDepartement;
    private String nomDepartement;

    /*
     * CONSTRUCTEURS
     */
    public Departement() {
    }

    public Departement(int idDepartement, String codeDepartement, String nomDepartement) {
        this.idDepartement = idDepartement;
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
    }

    public Departement(String codeDepartement, String nomDepartement) {
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
    }

    /*
     * GETTERS AND SETTERS
     */
    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    /*
     * AUTRES
     */
    @Override
    public String toString() {
        return "Departement{" + "idDepartement=" + idDepartement + ", codeDepartement=" + codeDepartement + ", nomDepartement=" + nomDepartement + '}';
    }

}// Fin class
