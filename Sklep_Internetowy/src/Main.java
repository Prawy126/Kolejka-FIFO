import CSV.KlientCSV;
import Dzwieki.MusicPlayerConsole;
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
        ArrayList<Zamowienia> lista = new ArrayList<>();
        lista.add(new Zamowienia("Ser",12,2.3f));
        lista.add(new Zamowienia("Ciastka",324,1.3f));
        lista.add(new Zamowienia("Masło",32,12.3f));
        MagazynSklapowy magazynSklapowy = new MagazynSklapowy(lista);
        magazynSklapowy.WypiszMagazyn();
        KlientCSV odczyt = new KlientCSV("src\\CSV\\BazaDanychKlientow.csv");
        LinkedList<Klient> listaKlienotw = odczyt.odczytajZCSV();
        Klient[] klienci = new Klient[listaKlienotw.size()];
        int i = 0;
        for(Klient a: listaKlienotw){
            klienci[i] = a.zwroc();
            i++;
        }
        klienci[0].dodaZamowienie(lista.get(0));
        klienci[2].dodaZamowienie(lista.get(1));
        klienci[3].dodaZamowienie(lista.get(2));
        Random random = new Random();
        int pomoc = random.nextInt(3);
        for(int a = 0; a<6;a++){
            for(int j = 0;j<=pomoc;j++){
                klienci[a].dodaZamowienie(lista.get(j));
            }
        }
        Wejscie wejscie = new Wejscie(magazynSklapowy,klienci);
        wejscie.setVisible(true);
        //Test2 test2 = new Test2();

    }
}