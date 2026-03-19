package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Film[] filmVector = new Film[5]; //<-- Para respetar el filmVector en el constructor
        var myCol = new MyMarvelCollection (filmVector);
        myCol.add (new Film ("Ironman", 2008));
        myCol.add (new Film ("Captain America", 2010));
        myCol.add (new Film ("The Avengers", 2012));

        var iterator = myCol.iterator ();
        while (iterator.hasNext ()) {
            System.out.println (iterator.next ());
        }

        for (var film: myCol) {
            System.out.println (film);
        }
    }
}