import Klient.Klient;
import Towary.MagazynSklapowy;
import Towary.Zamowienia;

import java.util.ArrayList;
import java.util.Iterator;

//klasa Main aktualnie służy do testowania kodu

public class Main {
    public static void main(String[] args)
    {
        Klient klient = new Klient("Piotr","Nowak",new Zamowienia("Jajka",10,2.5f));
         System.out.println(klient.zwrocImie());
         System.out.println(klient.zwrocNazwisko());
        klient.wyswieltZamowienia();
        klient.dodaZamowienie(new Zamowienia("Ser",1,0.523f));
        klient.wyswieltZamowienia();
        ArrayList<Zamowienia> list = new ArrayList<>();
        list.add(new Zamowienia("Jajka",2,2.3f));
        list.add(new Zamowienia("Buraki",2,0.3f));
        list.add(new Zamowienia("Mleko",3,2.3f));
        MagazynSklapowy magazyn = new MagazynSklapowy(list);
        System.out.println("------------------------------------------");
        magazyn.zabierzProdukt(new Zamowienia("Jajka",2,2.3f));
        magazyn.WypiszMagazyn();




    }
}