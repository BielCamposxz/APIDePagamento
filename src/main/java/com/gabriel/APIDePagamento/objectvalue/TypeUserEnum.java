package com.gabriel.APIDePagamento.objectvalue;

public enum TypeUserEnum {
    Cliente("user"),
    Logista("logista"),
    Bancario("admin");

    private String role;

    TypeUserEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
