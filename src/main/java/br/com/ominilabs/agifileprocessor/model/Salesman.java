package br.com.ominilabs.agifileprocessor.model;

import java.math.BigInteger;

public class Salesman {

    //001çCPFçNameçSalary

    private BigInteger cpf;
    private String name;
    private Float salary;

    public Salesman(BigInteger cpf, String name, Float salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public BigInteger getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public Float getSalary() {
        return salary;
    }
}
