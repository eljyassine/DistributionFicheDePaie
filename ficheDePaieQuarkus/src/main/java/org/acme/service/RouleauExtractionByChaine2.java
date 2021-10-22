package org.acme.service;

import org.apache.pdfbox.multipdf.PageExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;

public class RouleauExtractionByChaine2 {

    private String pdfPath;
    private String destination;
    private String fileNameExtracté;


    public RouleauExtractionByChaine2(String pdfPath, String destination, String fileNameExtracté) {
        this.pdfPath = pdfPath;
        this.destination = destination;
        this.fileNameExtracté = fileNameExtracté;
    }

    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFileNameExtracté(String fileNameExtracté) {
        this.fileNameExtracté = fileNameExtracté;
    }

    public String getPdfPath() {
        return pdfPath;
    }

    public String getDestination() {
        return destination;
    }

    public String getFileNameExtracté() {
        return fileNameExtracté;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "1414" + ".pdf";
        String destination = "F:/quarks/fichiertest/rouleau";

        String source = "F:/quarks/fichiertest/rouleau" + "/" + "2020-01" + ".pdf";
        RouleauExtractionByChaine2 ex = new RouleauExtractionByChaine2(source, destination, fileName);
        ex.savePdfAfterSearch("2020##00090##HOARAU##Claudine##39331864700046");//position fel start


        System.out.println(ex.readParaFromPDF(31));

        String[] arrstr =(ex.readParaFromPDF(31)).split(System.lineSeparator());
        String wordsearch=arrstr[28-1].substring(0,0+5);//index de final=4=debut+langeur
        System.out.println (wordsearch) ;











    }

    public void savePdfAfterSearch(String chaine) {
        PDDocument document = null;
        try {
            document = PDDocument.load(new File(this.pdfPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int nbrOfPage = document.getNumberOfPages();

        int i = 0;
        int start = 0;
        int end = 0;
        while (i != nbrOfPage) {
            System.out.println("iiiiiiii" + i);
            i++;
            if (searchWord(i, chaine) != -1) {
                start = i;
                end = i;
                System.out.println("(((((yjjjjjjjjjjjj((((((((((((((((" + searchWord(i, chaine));
                System.out.println("/**************************" + i);
                i++;
                while (searchWord(i, chaine) != -1) {
                    end = i;
                    i++;
                }
                System.out.println(end + "edd" + start + "nbrOfPag" + nbrOfPage);
                break;

            }
            //exception if n a pas de valeur cherché


        }
        try {
            savePdf(start, end);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int searchWord(int pageNo, String chaine) {

        int index = readParaFromPDF(pageNo).indexOf(chaine);
        System.out.println("******************index " + index);
        return index;
    }

    public String readParaFromPDF(int pageNo) {
        String returnString = "";
        try {
            PDDocument document = PDDocument.load(new File(this.pdfPath));
            document.getClass();
            if (!document.isEncrypted()) {
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                tStripper.setStartPage(pageNo);
                tStripper.setEndPage(pageNo);
                String pdfFileInText = tStripper.getText(document);
                document.close();
                returnString = pdfFileInText;


            }
        } catch (Exception e) {
            returnString = "No ParaGraph Found";
        }
        return returnString;
    }

    public void savePdf(int start, int end) throws IOException {
        PDDocument document = PDDocument.load(new File(this.pdfPath));
        document.getClass();
        PageExtractor instance = new PageExtractor(document, start, end);
        PDDocument result = instance.extract();
        result.save(this.destination + "/" + this.fileNameExtracté);
    }


}

