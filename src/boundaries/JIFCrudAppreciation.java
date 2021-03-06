package boundaries;

import daos.AppreciationDAO;
import daos.Globale;
import entities.Appreciation;
import java.awt.Component;
import java.awt.Rectangle;
import java.sql.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author quent
 */
public class JIFCrudAppreciation extends javax.swing.JInternalFrame {

    private Connection cnx;
    private AppreciationDAO dao;
    private DefaultTableModel ldtm;
    private Object[] tLigne;
    private Appreciation ap;
    private String motifEtoile = "^(\\*){1,5}$";
    private String motifAppreciation = "^[\\D]{5,50}$";
    private Boolean lbOk;

    /**
     * Creates new form JIFCrudAppreciation
     */
    public JIFCrudAppreciation() {
        initComponents();
        setVisible(true);
        jButtonValider.setVisible(false);
        jButtonAnnuler.setVisible(false);

        try {
            cnx = Globale.getCnx();
            System.out.println(cnx);

            ldtm = (DefaultTableModel) jTableAppreciation.getModel();

        } catch (Exception ex) {
            jLabelMessage.setText(ex.getMessage());
        }

        remplirjTableAppreciation();
    }

    private void remplirjTableAppreciation() {
        // Boucle permettant de mettre à jour la table genre
        for (int i = ldtm.getRowCount() - 1; i >= 0; i--) {
            ldtm.removeRow(i);
        }

        /*
         * Bloc TRY and CATCH pour l'affichage des données de la table Appreciation
         * dans la jTableAppreciation
         */
        try {
            // Création et Instanciation d'un Objet DAO avec une connexion à la DB
            dao = new AppreciationDAO(cnx);
            // Exécution de la procédure stockée définie dans le DAO
            List<Appreciation> listeAppreciation = dao.selectAll();
            for (int i = 0; i < listeAppreciation.size(); i++) {
                ap = listeAppreciation.get(i);
                tLigne = new Object[3];
                tLigne[0] = ap.getIdAppreciation();
                tLigne[1] = ap.getEtoile();
                tLigne[2] = ap.getLibelleAppreciation();;
                ldtm.addRow(tLigne);
            }
        } catch (Exception ex) {
            jLabelMessage.setText(ex.getMessage());
        }
    }// Fin remplirjTableAppreciation

    private void cls() {

        try {
            // Déclaration d'un tableau de composants
            Component[] tComposants = getContentPane().getComponents();
            // Boucle pour récupérer le nombre de composants sur le panel
            for (int i = 0; i < tComposants.length; i++) {
                Object objet = tComposants[i];
                /*
                 * Si un des composants présent sur le panel est identique à la 
                 * classe java correspondant aux JTextField, alors il faut le remplacer
                 * par une chaîne vide
                 */
                if (objet.getClass().toString().equals("class javax.swing.JTextField")) {
                    JTextField composant = (JTextField) objet;
                    composant.setText("");
                }
            }
        } catch (Exception ex) {
            jLabelMessage.setText(ex.getMessage());
        }
    }// Fin cls
    
    private String majPremier(String caract){
        StringBuilder result = new StringBuilder(caract);
        String lsResult = result.substring(0, 1).toUpperCase() + result.substring(1).toLowerCase();
        
        return lsResult;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAppreciation = new javax.swing.JTable();
        jLabelId = new javax.swing.JLabel();
        jLabelEtoile = new javax.swing.JLabel();
        jLabelAppreciation = new javax.swing.JLabel();
        jLabelMessage = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldEtoile = new javax.swing.JTextField();
        jTextFieldAppreciation = new javax.swing.JTextField();
        jButtonAjouter = new javax.swing.JButton();
        jButtonModifier = new javax.swing.JButton();
        jButtonSupprimer = new javax.swing.JButton();
        jButtonCLS = new javax.swing.JButton();
        jButtonAnnuler = new javax.swing.JButton();
        jButtonValider = new javax.swing.JButton();
        jLabelMessageErreurEtoile = new javax.swing.JLabel();
        jLabelMessageErreurAppreciation = new javax.swing.JLabel();
        jLabelMessage2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CRUD Appréciation");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jTableAppreciation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_appreciation", "ETOILE", "LIBELLE_appreciation"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAppreciation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAppreciationMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAppreciation);

        jLabelId.setText("ID");

        jLabelEtoile.setText("Etoile");

        jLabelAppreciation.setText("Appréciation");

        jLabelMessage.setText("Message");

        jTextFieldId.setEditable(false);
        jTextFieldId.setBackground(new java.awt.Color(255, 51, 51));
        jTextFieldId.setBorder(null);

        jButtonAjouter.setText("Ajouter");
        jButtonAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjouterActionPerformed(evt);
            }
        });

        jButtonModifier.setText("Modifier");
        jButtonModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifierActionPerformed(evt);
            }
        });

        jButtonSupprimer.setText("Supprimer");
        jButtonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupprimerActionPerformed(evt);
            }
        });

        jButtonCLS.setText("CLS");
        jButtonCLS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCLSActionPerformed(evt);
            }
        });

        jButtonAnnuler.setText("Annuler");

        jButtonValider.setText("Valider");

        jLabelMessageErreurEtoile.setForeground(new java.awt.Color(255, 0, 0));

        jLabelMessageErreurAppreciation.setForeground(new java.awt.Color(255, 0, 0));

        jLabelMessage2.setText("Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButtonAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonValider, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonCLS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)
                                        .addComponent(jButtonAjouter, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addComponent(jButtonModifier, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                                        .addComponent(jButtonSupprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelId)
                                            .addComponent(jLabelEtoile)
                                            .addComponent(jLabelAppreciation))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextFieldEtoile, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldAppreciation, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelMessageErreurEtoile, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jLabelMessageErreurAppreciation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMessage2)
                                    .addComponent(jLabelMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEtoile)
                    .addComponent(jTextFieldEtoile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMessageErreurEtoile, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAppreciation)
                    .addComponent(jTextFieldAppreciation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMessageErreurAppreciation))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCLS)
                    .addComponent(jButtonAjouter)
                    .addComponent(jButtonModifier)
                    .addComponent(jButtonSupprimer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonValider)
                    .addComponent(jButtonAnnuler))
                .addGap(30, 30, 30)
                .addComponent(jLabelMessage)
                .addGap(18, 18, 18)
                .addComponent(jLabelMessage2)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjouterActionPerformed
        int liAffecte;
        lbOk = true;

        /*
         * Si le premier champs rempli ne correspond pas au motif de l'expression
         * régulière, on affiche le premier message d'erreur.
         */
        if (!jTextFieldEtoile.getText().matches(motifEtoile)) {
            jLabelMessageErreurEtoile.setText("La note doit comprendre 1 à 5 étoiles (*).");
            lbOk = false;
        }
        /*
         * Si le deuxième champs rempli ne correspond pas au motif de l'expression
         * régulière, on affiche le second message d'erreur.
         */
        if (!jTextFieldAppreciation.getText().matches(motifAppreciation)) {
            jLabelMessageErreurAppreciation.setText("5 caractères min et 50 caractères max.");
            lbOk = false;
        }
        // Si les champs sont correctement remplis, début du Bloc TRY and CATCH
        if (lbOk) {
            // Bloc TRY and CATCH pour l'Insert d'une appréciation
            try {
                // Création et Instanciation d'un Objet DAO avec une connexion à la DB
                dao = new AppreciationDAO(cnx);

                // Création et Instanciation d'un Objet DTO en utilisant un constructeur
                ap = new Appreciation(jTextFieldEtoile.getText(), majPremier(jTextFieldAppreciation.getText()));
                // Utilisation de la méthode INSERT du DAO pour l'ajout de notre DTO dans la base
                liAffecte = dao.insert(ap);
                // Condition. Si l'ordre SQL rempli les conditions
                if (liAffecte == 1) {
                    // Validation de la transaction
                    cnx.commit();

                    // Mise à jour de la jTable
                    remplirjTableAppreciation();
                    int liMax = jTableAppreciation.getRowCount() - 1;
                    jTableAppreciation.getSelectionModel().setSelectionInterval(liMax, liMax);
                    // Scroll dans la jTable pour arriver directement sur le nouvel enregistrement
                    jTableAppreciation.scrollRectToVisible(new Rectangle(jTableAppreciation.getCellRect(liMax, 0, true)));
                }
                jLabelMessage.setText("Apréciation ajoutée : + " + Integer.toString(liAffecte));

                // Remise à zéro des jTextField
                cls();

            } catch (SQLException ex) {
                jLabelMessage2.setText(ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonAjouterActionPerformed

    private void jTableAppreciationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAppreciationMouseClicked
        int selectedRow = this.jTableAppreciation.getSelectedRow();

        if (selectedRow >= 0) {
            jTextFieldId.setText(jTableAppreciation.getValueAt(selectedRow, 0).toString());
            jTextFieldEtoile.setText(jTableAppreciation.getValueAt(selectedRow, 1).toString());
            jTextFieldAppreciation.setText(jTableAppreciation.getValueAt(selectedRow, 2).toString());
            jLabelMessageErreurEtoile.setText("");
            jLabelMessageErreurAppreciation.setText("");
       } else {
            jLabelMessage.setText("Erreur");
        }
    }//GEN-LAST:event_jTableAppreciationMouseClicked

    private void jButtonModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifierActionPerformed
        int liAffecte = 0;
        lbOk = true;
        
        /*
         * Si le premier champs rempli ne correspond pas au motif de l'expression
         * régulière, on affiche le premier message d'erreur.
         */
        if (!jTextFieldEtoile.getText().matches(motifEtoile)) {
            jLabelMessageErreurEtoile.setText("La note doit comprendre 1 à 5 *.");
            lbOk = false;
        }
        /*
         * Si le deuxième champs rempli ne correspond pas au motif de l'expression
         * régulière, on affiche le second message d'erreur.
         */
        if (!jTextFieldAppreciation.getText().matches(motifAppreciation)) {
            jLabelMessageErreurAppreciation.setText("5 caractères min et 50 caractères max.");
            lbOk = false;
        }
        if (lbOk) {

            try {
                // Création et Instanciation d'un Objet DAO avec une connexion à la DB
                dao = new AppreciationDAO(cnx);

                // Création et Instanciation d'un Objet DTO en utilisant un constructeur
                ap = new Appreciation(Integer.valueOf(jTextFieldId.getText()), jTextFieldEtoile.getText(), majPremier(jTextFieldAppreciation.getText()));
                // Utilisation de la méthode UPDATE du DAO pour l'ajout de notre DTO dans la base                
                liAffecte = dao.update(ap);
                // Condition. Si l'ordre SQL rempli les conditions
                if (liAffecte == 1) {
                    // Validation de la transaction
                    cnx.commit();

                    // Mise à jour de la jTable
                    remplirjTableAppreciation();
                }
                jLabelMessage.setText("Appréciation modifiée : " + Integer.toString(liAffecte));

                // Remise à zéro des jTextField
                cls();

            } catch (SQLException e) {
                jLabelMessage2.setText(e.getMessage());
            }
        }

    }//GEN-LAST:event_jButtonModifierActionPerformed

    private void jButtonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupprimerActionPerformed
        // Condition, si le jTextField de l'ID est vide, message "d'erreur"
        if (jTextFieldId.getText().equals("")) {
            jLabelMessage.setText("Veuillez sélectionner une ligne !");
        } else {
            int liAffecte = 0;

            try {
                // Création et Instanciation d'un Objet DAO avec une connexion à la DB
                dao = new AppreciationDAO(cnx);

                // Création et Instanciation d'un Objet DTO en utilisant un constructeur
                ap = new Appreciation(Integer.valueOf(jTextFieldId.getText()), jTextFieldEtoile.getText(), jTextFieldAppreciation.getText());
                // Utilisation de la méthode DELETE du DAO pour l'ajout de notre DTO dans la base  
                liAffecte = dao.delete(ap);
                // Condition. Si l'ordre SQL rempli les conditions
                if (liAffecte == 1) {
                    // Validation de la transaction
                    cnx.commit();

                    // Mise à jour de la jTable
                    remplirjTableAppreciation();
                }
                jLabelMessage.setText("Appréciation Supprimée : " + Integer.toString(liAffecte));

                // Remise à zéro des jTextField
                cls();

            } catch (SQLException e) {
                jLabelMessage2.setText(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonSupprimerActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // DECONNEXION DE LA BD
//        try {
//            icn.close();
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButtonCLSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCLSActionPerformed
        // Lors du clic sur le bouton CLS, remise à zéro de tout les champs
        jLabelMessage.setText("");
        jTextFieldId.setText("");
        jTextFieldEtoile.setText("");
        jLabelMessageErreurEtoile.setText("");
        jTextFieldAppreciation.setText("");
        jLabelMessageErreurAppreciation.setText("");
    }//GEN-LAST:event_jButtonCLSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAjouter;
    private javax.swing.JButton jButtonAnnuler;
    private javax.swing.JButton jButtonCLS;
    private javax.swing.JButton jButtonModifier;
    private javax.swing.JButton jButtonSupprimer;
    private javax.swing.JButton jButtonValider;
    private javax.swing.JLabel jLabelAppreciation;
    private javax.swing.JLabel jLabelEtoile;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelMessage2;
    private javax.swing.JLabel jLabelMessageErreurAppreciation;
    private javax.swing.JLabel jLabelMessageErreurEtoile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAppreciation;
    private javax.swing.JTextField jTextFieldAppreciation;
    private javax.swing.JTextField jTextFieldEtoile;
    private javax.swing.JTextField jTextFieldId;
    // End of variables declaration//GEN-END:variables
}
