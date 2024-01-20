import CSV.KlientCSV;
import Grafika.Wejscie;
import Klient.Klient;
import Sklep.Sklep;
import Towary.MagazynSklapowy;
import Towary.Zamowienia;
import Klient.Sprzedawca;

import java.util.*;

//klasa Main aktualnie służy do testowania kodu

public class Main {
    public static void main(String[] args)
    {
        //Zamowienia zamowienia = new Zamowienia("Ser",2,3,3.2f);
        //Klient klient = new Klient("Marek","Markowski",zamowienia,"login","haslo", 12314);
        /*
        ArrayList<Zamowienia>list = new ArrayList();
        Sprzedawca sprzedawca = new Sprzedawca("Piotr","Nowak","Hasło","login",123);
        list.add(new Zamowienia("Ser",12,3,3.2f));
        MagazynSklapowy magazyn = new MagazynSklapowy(list);
        Sklep biedronka = new Sklep("Biedronka",magazyn,sprzedawca);



        biedronka.dodajDoKolejki(klient);
        biedronka.dodajDoKolejki(klient);

        try{
            System.out.println(biedronka.doZaplaty());
            System.out.println(biedronka.doZaplaty());
            System.out.println(biedronka.doZaplaty());

        }catch (NoSuchElementException e){
            System.out.println("Kolejka jest już pusta");
        }


        KlientCSV zapis = new KlientCSV("src\\CSV\\BazaDanychKlientow.csv");
        LinkedList<Klient> list = zapis.odczytajZCSV();
        for(Klient e: list){
            System.out.println(e.zwrocImie() + " " + e.zwrocNazwisko() + " " + e.zwrocStanKonta());
        }*/

        Wejscie wejscie = new Wejscie();
        wejscie.setVisible(true);

    }
}