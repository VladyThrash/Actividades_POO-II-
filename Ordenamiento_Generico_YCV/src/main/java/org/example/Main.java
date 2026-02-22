package org.example;

/* El problema es que los métodos genéricos implementados en Utils esperan cualquier cosa que se
   extienda de Object, sin embargo, por la arquitectura de Java, los primitivos no son objetos.
   Podría sobrecargar los métodos, pero significaría escribir código redundante. También podría hacer la
   conversión antes de pasar los arreglos como parámetros.

   Dejo esta clase Main así, para que se vea como existe un error de compilación, lo que realmente es lo que
   se busca con las Bounded definition, seguridad en tiempo de ejecución.
*/
public class Main {
    public static void main(String[] args) {
        int [] intVector = { 101, 99, 12, 19, 21, 111, 345, 25, 77, 81 };
        //int [] resultInt = Utils.<Integer>ordena (intVector);
        //Utils.Imprimir (resultInt);

        float [] floatVector = { 19.1f, 456.6f, 23.45f, 12.34f, 11.11f, 354.55f, 78.45f, 28.33f, 45.99f, 108.88f };
        //float [] resultFloat = Utils.<Double>ordena (floatVector);
        //Utils.Imprimir (resultFloat);

        //El método no permite vectores que no se extiendan de Number o sus primitivas correspondientes.
        String [] strVector = {"zz", "aa", "cc", "hh", "bb", "ee", "ll"};
        //String [] resultStr = Utils.ordena (strVector);
    }
}
