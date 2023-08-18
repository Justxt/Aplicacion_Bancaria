package com.example.application.views.registrar;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String contra;
    private String correo;
    private double saldo;
    private String numeroCuenta;

    private List<String> movimientos = new ArrayList<>();

    public Usuario(String nombre, String correo, String contra, double saldo, String numeroCuenta) {
        this.nombre = nombre;
        this.correo = correo;
        this.contra = contra;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public List<String> getMovimientos() {
        return movimientos;
    }
    public void addMovimiento(String movimiento) {
        movimientos.add(movimiento);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getContra() {
        return contra;
    }
    public void setContra(String contra) {
        this.contra = contra;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setMovimientos(List<String> movimientos) {
        this.movimientos = movimientos;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

}
