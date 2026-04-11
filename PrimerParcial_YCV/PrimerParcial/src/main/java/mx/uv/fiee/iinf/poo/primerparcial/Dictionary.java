package mx.uv.fiee.iinf.poo.primerparcial;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

class Dictionary<T> implements JSONParser<T> {
       private ArrayList<Entry<String, String>> dict = new ArrayList<>();

       @Override
       public void parse(T source) {
              String contText = "";

              if (source instanceof File){  //Leemos y convertimos los datos a String
                     contText = sourceToString((File) source);
              }
              else if (source instanceof String){
                     contText = sourceToString((String) source);
              }
              else{
                     System.out.println("Tipo no soportado!!!");
                     return;
              }

              if (contText == null || contText.isEmpty()){ //La conversión a String falló
                     System.out.println("Fallo :(");
                     return;
              }

              //Se aplica el parseo
              contText = contText.trim().replace("{", "").replace("}", "").replace("\"", "").replace(" ", "").replace("\n", "").replace("\r", "");;
              String[] pares = contText.split(",");
              for (String par : pares){
                     String[] partes = par.split(":");
                     if (partes.length == 2){
                            dict.add(new Entry<>(partes[0], partes[1]));
                     }
              }
              Collections.reverse(dict); //Volteamos dict para que este en orden descendente
       }

       private String sourceToString(File file) { //Lee los datos del archivo y los convierte a String
              try {
                     BufferedReader br = new BufferedReader(new FileReader(file));
                     try {
                            StringBuilder sb = new StringBuilder();
                            String line = br.readLine();

                            while (line != null) {
                                   sb.append(line);
                                   sb.append(System.lineSeparator());
                                   line = br.readLine();
                            }
                            return sb.toString();
                     } finally {
                            br.close();
                     }
              }
              catch (IOException e) {
                     return null;
              }
       }

       private String sourceToString(String text) { //Pues ya es String XD
              return text;
       }

       public ArrayList<Entry<String, String>> elements() {
              return dict;
       }
}