package sistemarestaurante;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Harry Orozco
 */
public abstract class Cocina {
    private String[] vasos = new String[10];
    private Menu[] platillos = new Menu[10];
    private int contadorVasos = 0;
    private int contadorPlatillos = 0;
   
    public String[] getVasos() {
        return vasos;
    }

    public void setVasos(String[] vasos) {
        this.vasos = vasos;
    }

    public int getContadorVasos() {
        return contadorVasos;
    }

    public void setContadorVasos(int contadorVasos) {
        this.contadorVasos = contadorVasos;
    }

    public int getContadorPlatillos() {
        return contadorPlatillos;
    }

    public void setContadorPlatillos(int contadorPlatillos) {
        this.contadorPlatillos = contadorPlatillos;
    }
}