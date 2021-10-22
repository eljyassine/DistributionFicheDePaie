package org.acme.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.model.FichierRequestModel;
import org.acme.service.RouleauExtractionByChaine;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Path("/upload")
public class UploadFileResource {

  /*  @POST
    @Path("/one")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Uni<Boolean> uploadOne(@MultipartForm SingleRequest upload) throws Exception {
        return Uni.createFrom().item(true);
    }*/

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response uploadFile(@MultipartForm FichierRequestModel form) {

        String fileName = "F:\\quarks\\fichiertest\\fichier";

        try {
            writeFile(form.getData(), fileName);

        } catch (IOException e) {

            e.printStackTrace();
        }

        System.out.println("Done");

        return Response.status(200)
                .entity("uploadFile is called, Uploaded file name : " + fileName).build();

    }

    // save to somewhere
    private void writeFile(byte[] content, String filename) throws IOException {

        File file = new File(filename);

        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fop = new FileOutputStream(file);

        fop.write(content);
        fop.flush();
        fop.close();

    }
}
