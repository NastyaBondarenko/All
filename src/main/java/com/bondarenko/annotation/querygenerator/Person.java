package com.bondarenko.annotation.querygenerator;

@Table(name = "persons")
public class Person {
    Object value=1;
    @Column(name = "id")
    private int id;

    @Column(name = "person_name")
    private String name;

    @Column
    private double salary;

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
