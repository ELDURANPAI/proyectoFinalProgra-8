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
public class Cocina {
    private String[] vasos = new String[10];
    private String[] platillos = new String[10];
    private int contadorVasos = 0;
    private int contadorPlatillos = 0;

    public String[] getVasos() {
        return vasos;
    }

    public void setVasos(String[] vasos) {
        this.vasos = vasos;
    }

    public String[] getPlatillos() {
        return platillos;
    }

    public void setPlatillos(String[] platillos) {
        this.platillos = platillos;
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
    
 public void agregarVaso() {
    try {
        String input = JOptionPane.showInputDialog("Ingresa un número de vaso:");
        if (input != null && !input.equals("")) {
            int vaso = Integer.parseInt(input);
            if (contadorVasos < vasos.length) {
                vasos[contadorVasos] = String.valueOf(vaso);
                contadorVasos++;
                JOptionPane.showMessageDialog(null, "Vaso agregado correctamente: " + vaso);
            } else {
                JOptionPane.showMessageDialog(null, "No hay espacio para vasos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede agregar un vaso.");
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "ingrese un número valido.");
    }
 }
    public void agregarPlatillo() {
        String platillo = JOptionPane.showInputDialog("Ingresa el nombre del platillo:");
        if (platillo != null && !platillo.equals("")) {
            if (contadorPlatillos < platillos.length) {
                platillos[contadorPlatillos] = platillo;
                contadorPlatillos++;
                JOptionPane.showMessageDialog(null, "Platillo agregado: " + platillo);
            } else {
                JOptionPane.showMessageDialog(null, "No hay espacio para platillos. ");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede agregar un platillo. ");
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nNumero de vasos: " + vasos
                + "\nNumero de Platillos: " + platillos;
    }
    
}
