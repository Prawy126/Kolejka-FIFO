package Sklep;

import Klient.Klient;
import Klient.Sprzedawca;
import Towary.MagazynSklapowy;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Sklep extends ASklep implements ISklep{

    LinkedList<Klient> kolejka = new LinkedList();
    public Sklep(String nazwa, MagazynSklapowy magazyn, Sprzedawca sprzedawca){
        this.magazyn = magazyn;
        this.sprzedawca = sprzedawca;
        this.nazwa = nazwa;
    }
    @Override
    public float doZaplaty()throws NoSuchElementException {
        if(kolejka.getFirst()!=null){
            float kwota = kolejka.getFirst().ileDoZaplaty();
            kolejka.removeFirst();
            return kwota;
        }else{
            throw new NoSuchElementException();
        }

    }
    public void dodajDoKolejki(Klient klient){
        kolejka.addLast(klient);
    }
    @Override
    public void podajProdukt() {

    }

    @Override
    public boolean czyJest() {
        return false;
    }

    @Override
    public int aktualnaIlosc(String nazwa) {
        return 0;
    }
}
