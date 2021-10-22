package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.Fichier;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class FichierRepository implements PanacheRepository<Fichier> {

    public long findByCNSS(String Date, String typeIdent, String Ident) {
        return find("user_idUsers", Ident).count();
    }


    public long findByMatricule(String Matricule) {
        return find("matricule", Matricule).count();
    }

    /*public List<Fichier> findByIdentByDate(String typeIdent, String ident, String Date) {
        if (typeIdent == "CNSS") {
            return (List<Fichier>) stream("user.CNSS = ?1 and fichier.date = ?2", ident, Date);
        } else {
             return (List<Fichier>) stream("user.matricule = ?1 and fichier.date = ?2", ident, Date);
        }
    }*/

        public Optional<Fichier> findByIden(String Date, String typeIdent, String Ident) {
        String idUser= String.valueOf(find("SELECT u.idUsers FROM User u  WHERE u."+ typeIdent +"=?1", Ident).stream().findAny().get());
            find("SELECT f FROM Fichier f  WHERE f.date= ?1 AND user_idUsers=?2", Date, idUser).stream().findAny().get();
        String idUserr= String.valueOf(find("SELECT u.idUsers FROM User u  WHERE u."+ typeIdent +"=?1", Ident).stream().findFirst());
        return find("SELECT f FROM Fichier f  WHERE f.date= ?1 AND user_idUsers=?2", Date, idUser).stream().findFirst();
    }




}



