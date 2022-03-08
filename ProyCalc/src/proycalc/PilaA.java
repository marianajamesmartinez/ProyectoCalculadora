/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proycalc;

/**
 * @param <T>
 * @authors 
 * Esteban Reich
 * Esteban Kanahuati
 * Guillermo Mercado
 * Mariana James
 * Gennevive Martínez
 */
public class PilaA <T> implements PilaADT<T>  {
    
    private T[] pila;               
    private int tope;
    private final int MAXIMO = 20;          
    
    
    public PilaA() {
        pila = (T[]) new Object[MAXIMO];
        tope = -1;
    }
    
    //metodo para agregar
    @Override
    public void push (T dato) {
        if ( tope == pila.length -1 )
            expand();
        tope ++;
        pila [tope] = dato;
    }
    
    // metodo auxiliar para generar una pila más grande que la actual
    private void expand () {
        T [] nuevo = (T[]) new Object [pila.length * 2];    //aqui lo duplicamos, pero no necesariamente hay que duplicar
        
        for (int i = 0; i <= tope; i++) 
            nuevo[i] = pila[i];
        pila = nuevo;
    }
    
    @Override
    public T pop () {
        if (this.isEmpty())
            throw new ColeccionVaciaExcepcion("Pila vacia");
        
        T resultado = pila[tope];
        pila[tope] = null;
        tope --;
        return resultado;
    }   
     
    @Override
    public boolean isEmpty () {
        return tope == -1;
    }
    
    @Override
    public T peek () {
        if (this.isEmpty())
            throw new ColeccionVaciaExcepcion("Pila vacia");    // El throw te saca de la función e interrumpe 
        return pila[tope];                                      // entonces ya no llega al return
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = tope; i >= 0; i-- )
            sb.append(pila[i]).append("\n");
        return sb.toString();
    }
    
    

    
    
    
}
