package org.acme.resource;

import com.itextpdf.text.DocumentException;
import org.acme.model.ExtractionInfoModel;
import org.acme.repository.ExtractionInfoRepository;
import org.acme.service.RouleauExtractionByChaine;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;



@Path("/ExtractionInfo")
public class ExtractionInfoResource {

    @Inject
    ExtractionInfoRepository dataRepository;
    @Inject
    RouleauExtractionByChaine rouleauExtractionByChaine;
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response SaveData(ExtractionInfoModel data) throws IOException {
        try {
            rouleauExtractionByChaine.validInfo(data);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        dataRepository.persist(data);
        return Response.status(Response.Status.CREATED).entity(data).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getData() {
        List<ExtractionInfoModel> listExtraction=dataRepository.findAll().list();

        return  Response.status(Response.Status.OK).entity(listExtraction).build();
    }



}
