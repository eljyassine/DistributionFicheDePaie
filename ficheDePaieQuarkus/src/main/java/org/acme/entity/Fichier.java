 package org.acme.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.inject.Inject;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Fichier   {

   @Id
    @GeneratedValue
    private Long idFichier;
    private String date;
    private String path;

public Fichier(){} ;

    @ManyToOne( fetch = FetchType.LAZY,cascade=CascadeType.ALL)
      public User user;


    public Long getIdFichier() {
        return idFichier;
    }

    public String getDate() {
        return date;
    }



    public String getPath() {
        return path;
    }

    public User getUser() {
        return user;
    }

    public void setIdFichier(Long idFichier) {
        this.idFichier = idFichier;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public void setPath(String path) {
        this.path = path;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Fichier(Long idFichier, String date,  String path, User user) {
        this.idFichier = idFichier;
        this.date = date;
        this.path = path;
        this.user = user;

}


}


