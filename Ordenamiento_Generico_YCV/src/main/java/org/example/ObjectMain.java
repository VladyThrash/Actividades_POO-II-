package org.example;

/* Clase Main donde definimos los arreglos como tipos contenedores (si se extienden de Object).
   La idea de esta clase es observar el correcto funcionamiento de los métodos implementados.
   :)
*/

public class ObjectMain {
    public static void main(String[] args) {
        Integer [] intVector = { 101, 99, 12, 19, 21, 111, 345, 25, 77, 81 };
        Integer [] resultInt = Utils.<Integer>ordena (intVector);
        Utils.Imprimir (resultInt);

        Float [] floatVector = { 19.1f, 456.6f, 23.45f, 12.34f, 11.11f, 354.55f, 78.45f, 28.33f, 45.99f, 108.88f };
        Float [] resultFloat = Utils.<Float>ordena (floatVector);
        Utils.Imprimir (resultFloat);

        //El método no permite vectores que no se extiendan de Number o sus primitivas correspondientes.
        String [] strVector = {"zz", "aa", "cc", "hh", "bb", "ee", "ll"};
        //String [] resultStr = Utils.ordena (strVector);
        Utils.Imprimir(strVector);
    }
}
