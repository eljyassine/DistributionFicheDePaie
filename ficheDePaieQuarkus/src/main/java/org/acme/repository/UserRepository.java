package org.acme.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.entity.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
    public long findByCNSS(String cnss){
        return find("CNSS", cnss).count();
    }


    public long findByMatricule(String Matricule){
        return find("matricule", Matricule).count();
    }
}
