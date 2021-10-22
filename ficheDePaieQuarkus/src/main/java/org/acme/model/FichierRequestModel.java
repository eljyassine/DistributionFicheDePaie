package org.acme.model;


import static javax.ws.rs.core.MediaType.APPLICATION_OCTET_STREAM;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import java.io.File;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FichierRequestModel {

    @FormParam("file")
    @PartType(APPLICATION_OCTET_STREAM)
    public byte[] data;

    public byte[] getData() {
        return data;
    }
    @FormParam("filename")
    @PartType(TEXT_PLAIN)
    public String fileName;
}
