package Klient;

import Towary.Zamowienia;
import java.util.ArrayList;

public class Klient extends AKlient{
    private ArrayList<Zamowienia> list =  new ArrayList();
    public Klient(String imie, String nazwisko,Zamowienia zamowienia){
        this.imie=imie;
        this.nazwisko = nazwisko;
        list.add(zamowienia);
    }
    public void dodaZamowienie(Zamowienia zamowienia){
        list.add(zamowienia);
    }
    public void wyswieltZamowienia(){
        for(Zamowienia a : list){
            a.wypiszZamowienie();
        }
    }

}
