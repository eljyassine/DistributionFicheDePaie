package org.acme.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.FormParam;
import java.io.Serializable;

import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Entity
public class ExtractionInfoModel  implements Serializable {

    @Id
    @GeneratedValue
    private  int idU;
    private boolean isRouleau ;
    private  String typeIdent ;
    private  String typeSearch ;
    private  String chaineApres ;
    private  int largeur ;
    private  int ligne   ;
    private  int colonne   ;
    private  String lienFichier="F:/quarks/fichiertest/fichier";
    private  String date ;
    private String destination="F:/quarks/fichiertest/nouveau";

  /*  @FormParam("file")
    @PartType(APPLICATION_OCTET_STREAM)
    public byte[] data;

    public byte[] getData() {
        return data;
    }
    @FormParam("filename")
    @PartType(TEXT_PLAIN)
    public String fileName;

    @FormParam("uploadedFile")
    @PartType("application/octet-stream")
    public void setData(byte[] data) {
        this.data = data;
    }
*/


    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public ExtractionInfoModel(){ }


    public ExtractionInfoModel(int idU, boolean isRouleau, String typeIdent, String typeSearch, String chaineApres, int largeur, int ligne, int colonne, String lienFichier, String date, String destination) {
        this.idU = idU;
        this.isRouleau = isRouleau;
        this.typeIdent = typeIdent;
        this.typeSearch = typeSearch;
        this.chaineApres = chaineApres;
        this.largeur = largeur;
        this.ligne = ligne;
        this.colonne = colonne;
        this.lienFichier = lienFichier;
        this.date = date;
        this.destination = destination;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public void setIsRouleau(boolean isRouleau) {
        this.isRouleau = isRouleau;
    }

    public int getIdU() {
        return idU;
    }

    public void setTypeIdent(String typeIdent) {
        this.typeIdent = typeIdent;
    }

    public void setTypeSearch(String typeSearch) {
        this.typeSearch = typeSearch;
    }

    public void setChaineApres(String chaineApres) {
        this.chaineApres = chaineApres;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setLienFichier(String lienFichier) {
        this.lienFichier = lienFichier;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean  getIsRouleau() {
        return this.isRouleau;
    }

    public String getTypeIdent() {
        return typeIdent;
    }

    public String getTypeSearch() {
        return typeSearch;
    }

    public String getChaineApres() {
        return chaineApres;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLigne() {
        return ligne;
    }

    public String getLienFichier() {
        return lienFichier;
    }

    public String getDate() {
        return date;
    }




   /* private Long idUsers;
    private String typeIdent ;
    private String valeurIdent ;
    private boolean formFichier ;
    private String  date ;
    private String largeur ;
    private String langeur ;
    private String source  ;
    private String destination  ;
    private String chainePrecede;
    private String typeSearch;



    public String getChainePrecede() {
        return chainePrecede;
    }

    public void setChainePrecede(String chainePrecede) {
        this.chainePrecede = chainePrecede;
    }

    public void setTypeSearch(String typeSearch) {
        this.typeSearch = typeSearch;
    }

    public String getTypeSearch() {
        return typeSearch;
    }


    public Long getIdUsers() {
        return idUsers;
    }

    public String getTypeIdent() {
        return typeIdent;
    }

    public String getValeurIdent() {
        return valeurIdent;
    }

    public boolean isFormFichier() {
        return formFichier;
    }

    public String getDate() {
        return date;
    }

    public String getLargeur() {
        return largeur;
    }

    public String getLangeur() {
        return langeur;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public void setIdUsers(Long idUsers) {
        this.idUsers = idUsers;
    }

    public void setTypeIdent(String typeIdent) {
        this.typeIdent = typeIdent;
    }

    public void setValeurIdent(String valeurIdent) {
        this.valeurIdent = valeurIdent;
    }

    public void setFormFichier(boolean formFichier) {
        this.formFichier = formFichier;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLargeur(String largeur) {
        this.largeur = largeur;
    }

    public void setLangeur(String langeur) {
        this.langeur = langeur;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }*/
}
