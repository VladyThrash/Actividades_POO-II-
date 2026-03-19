package org.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyMarvelCollection implements Iterable<Film> {
    private Film[] filmList;
    private int pass;
    private int last = 0;
    private int count = 1;

    MyMarvelCollection(int initialSize){
        if(initialSize >= 1){
            this.pass = initialSize;
            filmList = new Film[initialSize];
        }
    }

    MyMarvelCollection(Film[] initialList){
        if(initialList.length >= 1){
            this.filmList = initialList;
            this.pass = initialList.length;
        }
    }

    public void add(Film nf){
        if(count == pass){
            filmList = Arrays.copyOf(filmList, filmList.length + pass);
            count = 1;
        }
        else{ count++; }
        filmList[last++] = nf;
    }

    @Override
    public Iterator<Film> iterator() { //Estamos obligados a implementar Iterable para poder utilizar el forEach.
        return new FilmVector(); //Se retorna un objeto con la clase que implementa iterator, ya que requerimos sus
    }                               //métodos.

    private class FilmVector implements Iterator<Film>{
        private int current = 0;

        @Override
        public boolean hasNext() {
            if(filmList[current] == null){ //Para verificar si podemos seguir iterando en el arreglo,
                return false;                 //debe de haber instancias de Film para continuar
            }
            return true;
        }

        @Override
        public Film next() {  //Avanzamos en el arreglo
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return filmList[current++];
        }
    }
}
