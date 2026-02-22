package org.example;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import java.lang.reflect.Array;

public class Utils {

    //Este método solo ordena vectores con tipos que se extienden de Number.
    //Retorna un T[].
    //Se utiliza Quicksort.
    static <T extends Number>  T[] ordena (T[] disorder){
        if(disorder.length <= 1){
            return disorder;
        }

        int mediana = (int)Math.floor((double) disorder.length/2);
        //Java olvida el tipo de T en tiempo de ejecución, lo obtiene desde disorder
        T[] men = (T[]) Array.newInstance(disorder.getClass().getComponentType(), disorder.length);
        T[] may = (T[]) Array.newInstance(disorder.getClass().getComponentType(), disorder.length);
        int j = 0, k = 0;

        for(int i = 0; i < disorder.length; i++){
            if(i == mediana){ //No utilizar (==) porque compararíamos direcciones de memoria
                continue;
            }
            if(disorder[i].doubleValue() > disorder[mediana].doubleValue()){
                may[k] = disorder[i];
                k++;
            }
            else{
                men[j] = disorder[i];
                j++;
            }
            //System.out.printf("%d\n", i);
        }

        //Recortamos los arreglos (eliminamos los valores en NULL)
        T [] menores = Arrays.copyOfRange(men, 0, j); //Para hacer slices como en Python :)
        T [] mayores = Arrays.copyOfRange(may, 0, k);

        //Concatenamos los arreglos
        //En tiempo de ejecución Java olvida que tipo es T, por lo que debemos indicarle el tipo según el parámetro
        T [] pivote = Arrays.copyOfRange(disorder, mediana, mediana + 1);
        if(j > 0 && k > 0){ //Menores + Pivote + Mayores
            return Stream.concat(Arrays.stream(Utils.<T>ordena(menores), 0, j), Stream.concat(Arrays.stream(pivote),
                    Arrays.stream(Utils.<T>ordena(mayores), 0, k))).toArray(size -> Arrays.copyOf(disorder, size));
        }
        if(j <= 0){ //Pivote + Mayores
            return Stream.concat(Arrays.stream(pivote),
                    Arrays.stream(Utils.<T>ordena(mayores), 0, k)).toArray(size -> Arrays.copyOf(disorder, size));
        }
        return Stream.concat(Arrays.stream(Utils.<T>ordena(menores), 0, j), //Menores + Pivote
                Arrays.stream(pivote)).toArray(size -> Arrays.copyOf(disorder, size));
    }


    //No es eficiente, solo es para tener un formato de impresión :)
    static void Imprimir(Object[] list){
        int tam = list.length;

        System.out.printf("Vector del tipo: " + list.getClass().toString() + "\n" + "<");
        for(int i = 0; i < tam - 1; i++){
            System.out.printf("%s, ", list[i].toString());
        }
        System.out.printf("%s>\n\n", list[tam-1].toString());
    }
}
