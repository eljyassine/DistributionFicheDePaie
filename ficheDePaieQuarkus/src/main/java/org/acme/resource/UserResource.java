package org.acme.resource;

import org.acme.entity.Fichier;
import org.acme.entity.User;
import org.acme.repository.FichierRepository;
import org.acme.repository.UserRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Users")
public class UserResource {


    @Inject
    UserRepository userRepository;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response Users() {
        List<User> listuser = userRepository.findAll().list();
        return Response.status(Response.Status.OK).entity(listuser).build();
    }



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response SaveUser(User user) {

        userRepository.persist(user);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }


}



