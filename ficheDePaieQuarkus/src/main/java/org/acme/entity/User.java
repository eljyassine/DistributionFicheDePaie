package org.acme.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class User {
    @Id
    @GeneratedValue
    private Long idUsers;
    private String CNSS;
    private String matricule;


 /*   @OneToMany(mappedBy = "user")
    public List<Fichier> fichies = new ArrayList<>();

    public void setFichies(List<Fichier> fichies) {
        this.fichies = fichies;
    }

    public List<Fichier> getFichies() {
        return fichies;
    }
*/
    public Long getId() {
        return idUsers;
    }

    public String getCNSS() {
        return CNSS;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setId(Long id) {
        this.idUsers = id;
    }

    public void setCNSS(String CNSS) {
        this.CNSS = CNSS;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public User() {
    }

    public User(Long id, String CNSS, String matricule) {
        this.idUsers = id;
        this.CNSS = CNSS;
        this.matricule = matricule;
    }
}
