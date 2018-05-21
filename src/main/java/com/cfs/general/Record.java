package com.cfs.general;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Record {

    public Map<String, String> data;

    public Record(Map<String, String> data){
        this.data = data;
    }

    public String run(){
        String info = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            info = objectMapper.writeValueAsString(data);
        } catch(JsonProcessingException e){
            e.printStackTrace();
        }
        return info;
    }
}
