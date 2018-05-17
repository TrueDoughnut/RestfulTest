package com.cfs;

import com.cfs.illinois.employeepay.ReadCSVData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        ReadCSVData data = new ReadCSVData("data\\ILEmployeePay.csv");
        data.run();
        SpringApplication.run(Application.class, args);
    }

}
