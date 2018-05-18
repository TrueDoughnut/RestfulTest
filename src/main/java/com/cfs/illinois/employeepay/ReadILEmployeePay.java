package com.cfs.illinois.employeepay;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord; 

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import java.nio.file.Files; 
import java.nio.file.Paths;

public class ReadILEmployeePay {

    public final File file;
    public static List<Employee> employees;

    public ReadILEmployeePay(String string){
        this.file = new File(string);
    }
    
    public void run(){
        employees = new ArrayList<>();
        try(Reader reader = Files.newBufferedReader(Paths.get(file.getPath()));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                                                .withFirstRecordAsHeader()
                                                .withIgnoreHeaderCase()
                                                .withTrim())
        ){
            for(CSVRecord record : csvParser){
                Employee employee = new Employee(record.get("Employee Name"), record.get("Agency"),
                        record.get("Agency Division"), record.get("Position Title"),
                        record.get("Period Pay Rate"), record.get("YTD Gross"));
                employees.add(employee);
            }

        } catch(IOException e){
            e.printStackTrace();    
        }
    }
}
