/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proycalc;

/**
 * @authors 
 * Esteban Reich
 * Esteban Kanahuati
 * Guillermo Mercado
 * Mariana James
 * Genevieve Martínez
 */

public class FuncionalidadCalculadora {

    /**
     * @param cad
     * recibe la expresión que vayamos a checar
     * @return boolean que diga si los parentesis esten balanceados
     */
    public static boolean parentesis(String cad){
        PilaA<String> pila= new PilaA();
        int i=0;
        boolean res=true;
        while(i<cad.length() && res){
            if(cad.charAt(i)=='('){
                pila.push("(");
            }
            else{
                if(cad.charAt(i)==')'){
                    if(!pila.isEmpty()){
                        pila.pop();
                    }
                    else{
                        res=false;
                    }
                }
            }
            i++;
        }
       return pila.isEmpty();
    }
    
    /**
     * 
     * @param c
     * @return boolean 
     * Indica true en caso de que el char dado sea un operador de suma, resta, multiplicación o división
     * 
     */
    public static boolean esOperador(Character c){
        boolean resp = false;
        if(c.equals('+') || c.equals('-') ||  c.equals('*') || c.equals('/')){
            resp = true;
        }
         return resp;   
    }
    
    /**
     * 
     * @param cad
     * @return boolean
     * checa que no haya dos operadores seguidos (que no sería una expresion valida)
     */
    public static boolean operadoresSeguidos(String cad){
         boolean resp=true;
         int i=0;
         cad = cad.replaceAll(" ", ""); 
         while(resp && i < cad.length()){
             if(esOperador(cad.charAt(i)) && esOperador(cad.charAt(i+1))){
                 if(cad.charAt(i+1) != '-'){
                    resp = false; 
                 }
             }
             i++; 
         }
         return resp;
     }
                 
    
    /**
     * 
     * @param cad
     * @return boolean
     * Paso 1 del requirimiento de la calculadora, que valida si esta bien escrita la operación matemática
     * (Evalua la sintaxis de la expresión)
     */
    public static boolean expresionCorrecta(String cad){
         boolean resp=false;
         
         if(operadoresSeguidos(cad) && parentesis(cad)){
             resp=true;
         }
         return resp;
     }

    /**
     * 
     * @param c
     * @return 
     * Dado un char con un operador, define la jerarquía de importancia de dicho operador
     */
    public static int nivelPorOp(char c){
        int jer=0;
        switch(c){
            case '+': 
                jer=1;
                break; 
            case '-':
                jer=1;
                break; 
            case '*':
                jer=2;
                break;
            case '/': 
                jer=2;
                break; 
            case '^': 
                jer=3;
                break;
            case '(': 
                jer=4;
                break;
            case ')':
                jer=4;
                break; 
             
        }
        return jer;        
    }
    
    /**
     * 
     * @param expresion
     * @return String 
     * Cambia la notación infija a la notación postfija
     * Paso 2 del requirimiento de la calculadora
     * La string que se manda tiene que ir con espacios
     * Es decir: ( a + b )
     * No (a+b)
     */
    public static String infijaAPostfija(String expresion) {
        StringBuilder cad = new StringBuilder();
        boolean neg = false;
        PilaA<Character> operadores = new PilaA();
        char token;
        for(int i=0;i<expresion.length();i++){
            token = expresion.charAt(i);
            if(!esOperador(token) && token!='(' && token!=')') { 
                if (neg){
                    cad.append(" 0 ");
                    neg = false;
                    cad.append(token);
                    cad.append(" - ");
                } else {
                   cad.append(token);
                }
            } else if(token=='(') {
                operadores.push(token);
            } else if(token==')') {
                while(!operadores.isEmpty() && operadores.peek()!='(')
                    cad.append(operadores.pop());
                operadores.pop();
                
            } 
            else if(token=='-' && expresion.charAt(i+1)!=' '){
                neg = true;
            }
            
            else if(esOperador(token) && expresion.charAt(i-1)==' '){
                while(!operadores.isEmpty() && operadores.peek()!='(' && nivelPorOp(token) <= nivelPorOp(operadores.peek()))
                    cad.append(operadores.pop());
                operadores.push(token);
            }
        }
        cad.append(" ");
        while(!operadores.isEmpty())
            cad.append(operadores.pop());
        return cad.toString();
    }
    
    /**
     * 
     * @param ex
     * @return double
     * Paso 3 del requirimiento de la calculadora
     * Evalua la expresión en postfija por medio de pilas
     * Cuando encuentra un operador, saca los elementos que haya en una pila y hace la operación indicada
     * Mete el resultado de dicha operación
     * Así sucesivamente hasta que se termine de analizar toda la expresión
     */
    
    
    public static double resolverPosfija(String ex){
        double res=0;
        char token;
        double aux1,aux2;
        double aux3 =0;
        PilaA<Double> expresion = new PilaA();
        StringBuilder cad = new StringBuilder();
        if(ex.charAt(0)!=' '){
            cad.append(' ');
            cad.append(ex);
            ex = cad.toString();
            cad.setLength(0);
        }
        for(int i=1; i<ex.length(); i++){
            token=ex.charAt(i);
            if(token!=' ' && !esOperador(token)){
                cad.append(token);
            } else if (token==' '){
                if(cad.length()!=0){
                    expresion.push(Double.parseDouble(cad.toString()));
                    cad.setLength(0);
                } 
            } else if(esOperador(token)){
                aux2 = expresion.pop();
                aux1 = expresion.pop();
                switch(token){
                    case '+': 
                        aux3 = aux1 + aux2;
                        break; 
                    case '-':
                        aux3 = aux1 - aux2;
                        break; 
                    case '*':
                        aux3 = aux1 * aux2;
                        break;
                    case '/': 
                        aux3 = aux1 / aux2;
                        break; 
                }
                expresion.push(aux3);
            }
        } 
        res = expresion.pop();
        
        return res;
    }
    /**
     * 
     * @param cad
     * @return String
     * Este es el método que se corre cuando se le da click a '=' en la interfaz 
     * gráfica y se envía como parámetro la cadena que se construyó con los inputs del usuario
     * Lo que regresa es lo que tiene que mostrar en la pantalla de la calculadora
     */
    
    public static String respuestaCalculadora(String cad){
        String res="";
        if(expresionCorrecta(cad)){
            String aux = infijaAPostfija(cad);
            Double aux2 = resolverPosfija(aux);
            res=""+aux2;
        } else {
            res="SYNTAX ERROR";
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        /**
         * Casos de prueba
         */
        
        String uno = "( 2 + 3 )";
        String dos = "( 2 + 3 ) * 5 + ( 4 * 3 ) ";
        String tres = " ( 2 + 3 ) * 5 + ( 4 * / 3  ";
        String cuatro =" ( 2 + 3 ) * 5 + ( 4 * 3  ";
        String cinco = "( 2 + 3 ) * -5 ";
        
        System.out.println(respuestaCalculadora(uno));
        System.out.println(respuestaCalculadora(dos));
        System.out.println(respuestaCalculadora(tres));
        System.out.println(respuestaCalculadora(cuatro));
        System.out.println(respuestaCalculadora(cinco));

        
        
    }
}
