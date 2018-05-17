package com.cfs;

import com.cfs.illinois.employeepay.ReadILEmployeePay;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        run();
        SpringApplication.run(Application.class, args);
    }

    public static void run(){
        ReadILEmployeePay data = new ReadILEmployeePay("data\\ILEmployeePay.csv");
        data.run();
    }

}
