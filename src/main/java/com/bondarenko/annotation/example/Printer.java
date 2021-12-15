package com.bondarenko.annotation.example;

public class Printer {
    private String message;
   Object printerObject;

    @RandomInt(min=3, max=7)
    private int count;


    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(message);

        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
