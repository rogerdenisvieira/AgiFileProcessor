package br.com.ominilabs.agifileprocessor.model;

import java.math.BigInteger;

public class Salesman {

    //001çCPFçNameçSalary

    private String cpf;
    private String name;
    private Float salary;

    public Salesman(String cpf, String name, Float salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "cpf=" + cpf +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
