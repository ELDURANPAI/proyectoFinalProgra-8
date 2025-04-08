package sistemarestaurante;

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
    
       public void agregarVaso(String vaso) {
        if (vaso != null && !vaso.equals("")) {
            if (contadorVasos < vasos.length) {
                vasos[contadorVasos] = vaso;
                contadorVasos++;
                System.out.println("Vaso agregado: " + vaso);
            } else {
                System.out.println("No hay espacio para vasos ");
            }
        } else {
            System.out.println("No se puede agregar un vaso ");
        }
    }

    public void agregarPlatillo(String platillo) {
        if (platillo != null && !platillo.equals("")) {
            if (contadorPlatillos < platillos.length) {
                platillos[contadorPlatillos] = platillo;
                contadorPlatillos++;
                System.out.println("Platillo agregado: " + platillo);
            } else {
                System.out.println("No hay espacio para platillo ");
            }
        } else {
            System.out.println("No se puede agregar un platillo ");
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nNumero de vasos: " + vasos
                + "\nNumero de Platillos: " + platillos;
    }
    
}
