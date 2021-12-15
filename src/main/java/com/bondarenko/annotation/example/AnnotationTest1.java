package com.bondarenko.annotation.example;

import java.lang.reflect.Field;
import java.util.Random;

public class AnnotationTest1 {
    public static void main(String[] args) throws IllegalAccessException {
        Printer printer = new Printer();

        printer.setMessage("Hello");


        injectRandomInt(printer);
        printer.print();
    }

    static void injectRandomInt(Object value) throws IllegalAccessException {
        Class<?> clazz = value.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            RandomInt annotation = field.getAnnotation(RandomInt.class);{
                if(annotation!=null){
                    int min = annotation.min();
                    int max = annotation.max();
                    int Random= min + new Random().nextInt(max-min-1);
                    field.setAccessible(true);
                    field.setInt(value,Random);
                    field.setAccessible(false);

                }
            }
        }

    }

}
