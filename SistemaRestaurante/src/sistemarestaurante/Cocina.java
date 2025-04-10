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
   
    public void agregarVaso() {
        try {
            String input = JOptionPane.showInputDialog("Ingresa un numero de vaso:");
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
            JOptionPane.showMessageDialog(null, "Ingrese un número valido.");
        }
    }

    public void agregarPlatilloDesdeMenu() {
        if (contadorPlatillos < platillos.length) {
            String bebida = JOptionPane.showInputDialog("Ingrese el nombre de la bebida: ");
            String platillo = JOptionPane.showInputDialog("Ingrese el nombre del platillo: ");
            String tipo = JOptionPane.showInputDialog("Ingrese el tipo de platillo: ");
            String precioS = JOptionPane.showInputDialog("Ingrese el precio del platillo: ");
            try {
                double precio = Double.parseDouble(precioS);
                Menu nuevoMenu = new implementarMenu(bebida, platillo, tipo, precio);
                platillos[contadorPlatillos] = nuevoMenu;
                contadorPlatillos++;
                JOptionPane.showMessageDialog(null, "Platillo agregado exitosamente:\n" + nuevoMenu);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Precio no valido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay espacio para platillos.");
        }
    }
    
    public String toString() {
    String resultado = "Resumen de la Cocina:\n";
    resultado += "Numero de vasos agregados: " + contadorVasos + "\n";
    resultado += "Lista de vasos: ";
    for (int i = 0; i < contadorVasos; i++) {
        resultado += vasos[i];
        if (i < contadorVasos - 1) {
            resultado += ", ";
        }
    }
    resultado += "\n\nNumero de platillos agregados: " + contadorPlatillos + "\n";
    resultado += "Lista de platillos:\n";

    for (int i = 0; i < contadorPlatillos; i++) {
        resultado += (i + 1) + ") " + platillos[i].toString() + "\n";
    }
    return resultado;
}
  
}

