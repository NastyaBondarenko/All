package com.bondarenko.annotation.anotations;

import com.bondarenko.annotation.example.Printer;

public class MessagePrint {
    private String message;
    private int count = 5;

    @Inject(clazz = Printer.class)
    private Object injectObject;

    public void printObject() {
        System.out.println(injectObject.getClass());
    }

    @Run
    public void method1() {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }

    @Run
    public void method2() {

    }

    public void method3() {
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

