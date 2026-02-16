package org.example;

public class Utilities {
    static boolean compare(Object p1, Object p2){
        //No podemos utilizar operadores con clases contenedoras; usamos el metodo equals.
        if (p1 instanceof Object[] && p2 instanceof Object[]) { //Para arreglos de Object se utiliza deepEquals.
            return java.util.Arrays.deepEquals((Object[]) p1, (Object[]) p2); //Type cast a arreglo de Object.
        }
        return java.util.Objects.equals(p1, p2);
    }
}
