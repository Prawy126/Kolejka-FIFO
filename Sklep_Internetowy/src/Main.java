import Klient.Klient;
import Sklep.Sklep;
import Towary.MagazynSklapowy;
import Towary.Zamowienia;
import Klient.Sprzedawca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

//klasa Main aktualnie służy do testowania kodu

public class Main {
    public static void main(String[] args)
    {
        ArrayList<Zamowienia>list = new ArrayList();
        Sprzedawca sprzedawca = new Sprzedawca("Piotr","Nowak","Hasło","login",123);
        list.add(new Zamowienia("Ser",12,3,3.2f));
        MagazynSklapowy magazyn = new MagazynSklapowy(list);
        Sklep biedronka = new Sklep("Biedronka",magazyn,sprzedawca);
        Zamowienia zamowienia = new Zamowienia("Ser",2,3,3.2f);
        Klient klient = new Klient("Marek","Markowski",zamowienia,"login","haslo", 12314);

        biedronka.dodajDoKolejki(klient);
        biedronka.dodajDoKolejki(klient);

        try{
            System.out.println(biedronka.doZaplaty());
            System.out.println(biedronka.doZaplaty());
            System.out.println(biedronka.doZaplaty());

        }catch (NoSuchElementException e){
            System.out.println("Kolejka jest już pusta");
        }


    }
}