package Towary;

import java.util.ArrayList;

public interface IMagazyn {
    public void WypiszMagazyn();
    public ArrayList<Zamowienia> listaProduktow();
    public void dodajProdukt(Zamowienia zamowienia);
    public void zabierzProdukt(Zamowienia zamowienia);
}
