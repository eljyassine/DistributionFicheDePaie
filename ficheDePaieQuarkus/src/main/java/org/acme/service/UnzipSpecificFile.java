package org.acme.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.List;


import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class UnzipSpecificFile {


    public UnzipSpecificFile( ) {

    }













      /*   public void unzipfonctionE( ) throws IOException  {
       ZipFile zipFile = new ZipFile(this.source);
       FileInputStream fs = new FileInputStream(this.source);
        ZipInputStream Zs = new ZipInputStream( new BufferedInputStream( fs ));;
        ZipEntry ze = null;


            while ((ze = Zs.getNextEntry()) != null) {
                System.out.println(ze.getName());
                zipFile.extractFile(ze.getName(), this.destination+"/"+ze.getName().replace(".pdf", ""));
            }
            Zs.close(); }*/




/*


    public void unzipfonction( ) throws IOException  {
        Path zipFile= Paths.get(this.source);
          Path outputFile= Paths.get(this.destination);
        FileInputStream fs = new FileInputStream(this.source);

        ZipInputStream Zs = new ZipInputStream( new BufferedInputStream( fs ));;
        ZipEntry ze = null;
            try (FileSystem fileSystem = FileSystems.newFileSystem(zipFile, (ClassLoader) null)) {

                while ((ze = Zs.getNextEntry()) != null) {
                    System.out.println(ze.getName());
                    ze.clone();

                }
                Zs.close();
            //    Path fileToExtract = fileSystem.getPath(this.fileName);
             //   Files.copy(fileToExtract, outputFile);
            }
        }


    public void unzipfonctionb(String source,String destination,String fileName) throws IOException  {
        Path zipFile= Paths.get(source);
        Path outputFile= Paths.get(destination);

        try (FileSystem fileSystem = FileSystems.newFileSystem(zipFile, (ClassLoader) null)) {




            Path fileToExtract = fileSystem.getPath(fileName);
            Files.copy(fileToExtract, outputFile);
        }
    }
/*
     public void autreunzipfonction( ) throws ZipException {
        ZipFile zipFile = new ZipFile(this.source);
        zipFile.extractFile(this.fileName, this.destination);
    }*/
/*
    public static void main(String[] args) throws IOException, ZipException {

     //   String fileName="08-2021/1414.pdf";
        String destination="F:\\quarks\\fichiertest\\nouveau\\zip";
        String source ="F:\\quarks\\fichiertest\\zip"+"\\"+"2020-01"+".zip";
        UnzipSpecificFile unzipSpecificFile=new UnzipSpecificFile(source, destination);
        unzipSpecificFile.unzipfonctionc();

     //   unzipSpecificFile.autreunzipfonction("");

    }}
 */}

