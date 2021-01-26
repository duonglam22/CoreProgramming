package com.lamdn.Gson;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExamGson {
    Logger logger = LoggerFactory.getLogger(ExamGson.class);

    public static void main(String[] args) {
        String jsonStr = "{\"name\": \"duong ngoc lam\", \"gen\": \"123\", \"age\": 27, \"position\": \"engineer\", \"address\": \"HN\"}";

        Gson gson = new Gson();
        Employee em = gson.fromJson(jsonStr, Employee.class);
        System.out.println("name: {}");

        Employee em2 = new Employee("Mr Ben", null, 1, "norn", "LQ");

        String result = gson.toJson(em2);

        System.out.println("result: {}" + result);
    }

}

