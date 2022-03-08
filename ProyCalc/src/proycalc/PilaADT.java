/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proycalc;

/**
 * @param <T>
 * @authors 
 * Esteban Reich
 * Esteban Kanahuati
 * Guillermo Ochoa
 * Mariana James
 * Gennevive Martínez
 */

public interface PilaADT <T> {
    public void push (T dato);
    public T pop();
    public boolean isEmpty();
    public T peek();

}
