package org.acme.resource;

import org.acme.entity.Fichier;
import org.acme.repository.FichierRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;


@Path("/Fichiers")
public class FichierResource {

    @Inject
    FichierRepository fichierRepository;
/*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response Fichiers() {
        List<Fichier> listfichier = fichierRepository.findAll().list();
        return Response.status(Response.Status.OK).entity(listfichier).build();
    }
*/
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response SaveFichier(Fichier fichier) {
        fichierRepository.persist(fichier);
        return Response.status(Response.Status.CREATED).entity(fichier).build();
    }


    @GET
    public Optional<Fichier> TestUserExist (){//String date, String typeIdent, String Ident){
    Optional<Fichier> isUserExiste=fichierRepository.findByIden("2020-01","CNSS","00170");
         return isUserExiste;
    }







}
