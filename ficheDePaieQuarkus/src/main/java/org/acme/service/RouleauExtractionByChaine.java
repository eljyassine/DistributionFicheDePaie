package org.acme.service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import io.smallrye.mutiny.Multi;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.acme.entity.Fichier;
import org.acme.model.ExtractionInfoModel;
import org.acme.repository.FichierRepository;
import org.acme.resource.FichierResource;
import org.apache.fontbox.type1.DamagedFontException;
import org.apache.pdfbox.multipdf.PageExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RequestScoped
public class RouleauExtractionByChaine {

    @Inject
    FichierRepository fichierRepository;

    public void validInfo(ExtractionInfoModel extraction) throws IOException, DocumentException {


        if (extraction.getIsRouleau()) {

       /* if (extraction.getTypeSearch().equals("chaineApres")) {//najmo n7oto function searchByChaine
                rouleauExtraction.setChaineapres(extraction.getChaineApres());
           }else if (extraction.getTypeSearch().equals("langeurChaine")){
            rouleauExtraction.setChaineapres(extraction.getChaineApres());*/
            savePdfAfterSearch(extraction.getLienFichier(), extraction.getDestination(), extraction.getLigne(), extraction.getColonne(), extraction.getTypeIdent(), extraction.getDate());
        } else {

            try {
               unzipfonctionc(extraction.getLienFichier(),extraction.getDestination(),extraction.getDate(),extraction.getTypeIdent());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


    private void savePdfAfterSearch(String pdfPath, String destination, int ligne, int colonne, String typeIdent, String date) throws DocumentException, IOException {


        PdfReader reader2 = new PdfReader(pdfPath);
        int nbrOfPage = reader2.getNumberOfPages();
        reader2.close();



        for (int j = 1; j <= nbrOfPage-1; j++) {//lezem nel9alha hal hedi mta3 el -1 puisque mech bech youslelha el(ERA


           String wordsearch=wordExtraction(colonne,ligne,pdfPath,j);
           String wordSearch2=wordExtraction(colonne,ligne,pdfPath,j+1);


           PdfReader reader = new PdfReader(pdfPath);
         if (wordsearch.equals(wordSearch2)){
                reader.selectPages(List.of(j,j+1));
                j++;
            }
           else{
                reader.selectPages(List.of(j));
            }

         try {
             fichierRepository.findByIden(date, typeIdent, wordsearch);

             new File(destination + '/' + wordsearch).mkdir();
               String path = String.format(destination + "/%s/%s.pdf", wordsearch, wordsearch);
               PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(path));
               stamper.close();
               reader.close();
            } catch (Exception ex) {
                continue;
            }


/*
            new File(destination + '/' + wordsearch).mkdir();
            String path = String.format(destination + "/%s/%s.pdf", wordsearch, wordsearch);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(path));
            stamper.close();
            reader.close();
*/
        }
    }


    private String wordExtraction(int colonne,int ligne,String pdfPath,int selctedPage) throws IOException {

        PdfReader reader = new PdfReader(pdfPath);
        String line = PdfTextExtractor.getTextFromPage(reader, selctedPage);
        String[] arrstr = line.split("\n");
        String wordsearch = arrstr[ligne - 1].substring(colonne, colonne + 5);
        reader.close();//+largeur

        return wordsearch;

    }

    public void unzipfonctionc( String source, String destination,String date,String typeIdent )throws IOException , ZipException {
        String nameFilee="";
        String Ident="";
        ZipFile zipFile = new ZipFile(source);
        List<FileHeader> fileHeaderList = zipFile.getFileHeaders();

        for (int i = 0; i < fileHeaderList.size(); i++) {

             nameFilee=fileHeaderList.get(i).toString();
             Ident= nameFilee.replace(".pdf",  "");

            try {
                fichierRepository.findByIden(date, typeIdent, Ident);
                try {
                    zipFile.extractFile( nameFilee , destination+'/'+Ident);
                } catch (ZipException e) {
                    e.printStackTrace();
                }
            } catch (Exception ex) {
                    continue;
            }



        }

    }

}









