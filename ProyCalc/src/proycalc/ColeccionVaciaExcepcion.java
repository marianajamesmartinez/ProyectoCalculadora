/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proycalc;

/**
 * @authors 
 * Esteban Reich
 * Esteban Kanahuati
 * Guillermo Ochoa
 * Mariana James
 * Gennevive Martínez
 */

public class ColeccionVaciaExcepcion extends RuntimeException {
    
     public ColeccionVaciaExcepcion() {
        super();
    }
     
    public ColeccionVaciaExcepcion (String mensaje) {
        super(mensaje);
    }
    
}
