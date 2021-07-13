package com.EffectiveJavaBook.CreateAndDestroyObj;

//public class BuilderExample {
//}

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BuilderExample {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public enum ErrorCode{
        SUCCESS(0, "successfull"),
        FALID(1, "faild");

        private final int code;
        private final String description;

        private ErrorCode(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int getCode()
        {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val)
        { calories = val; return this; }
        public Builder fat(int val)
        { fat = val; return this; }
        public Builder sodium(int val)
        { sodium = val; return this; }
        public Builder carbohydrate(int val)
        { carbohydrate = val; return this; }

        public BuilderExample build() {
            return new BuilderExample(this);
        }
    }
    private BuilderExample(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        BuilderExample cocaCola = new BuilderExample.Builder(240,9)
                .calories(100).sodium(35).carbohydrate(27).build();

        Builder builder = new BuilderExample.Builder(12,13);

        List list = new ArrayList<Integer>();
        System.out.println(cocaCola.toString());
        int status = ErrorCode.SUCCESS.getCode();
        System.out.println("end");
    }
}