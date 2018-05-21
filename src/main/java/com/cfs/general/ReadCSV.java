package com.cfs.general;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadCSV {

    public final File file;
    public List<Record> list;

    public ReadCSV(String string){
        this.file = new File(string);
    }

    public void run(){
        list = new ArrayList<>();
        try(Reader reader = Files.newBufferedReader(Paths.get(file.getPath()));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                                        .withFirstRecordAsHeader()
                                                        .withIgnoreHeaderCase()
                                                        .withTrim())
        ){
            for(CSVRecord record : csvParser){
                list.add(new Record(record.toMap()));
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
