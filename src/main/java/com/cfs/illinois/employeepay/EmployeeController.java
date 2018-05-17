package com.cfs.illinois.employeepay;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {


    @RequestMapping("/employee")
    public Employee getEmployee(@RequestParam(value="id", required = false, defaultValue = "0") int id){
        return ReadCSVData.employees.get(id);
    }
}
