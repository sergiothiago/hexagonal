package com.mendonca.hexagonal.application.core.domain;

public class Customer {

    public Customer() {
        this.isValidcpf = false;
    }

    public Customer(String id, String name, Address address, String cpf, boolean isValidcpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidcpf = isValidcpf;
    }

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private boolean isValidcpf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isValidcpf() {
        return isValidcpf;
    }

    public void setValidcpf(boolean validcpf) {
        isValidcpf = validcpf;
    }
}
