/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemarestaurante;

/**
 *
 * @author Harry Orozco
 */
public class Menu {
    private String bebida;
    private String platillo;
    private String tipo;
    private double precio;

    public Menu(String bebida, String platillo, String tipo, double precio) {
        this.bebida = bebida;
        this.platillo = platillo;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getPlatillo() {
        return platillo;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
     @Override
    public String toString() {
        return super.toString()
                + "\nNombre de la bebida: " + bebida
                + "\nNombre del Platillo: " + platillo
                + "\nTipo de Platillo: " + tipo
                + "\nPrecio del platillo: " + precio;
    } 
    
}
