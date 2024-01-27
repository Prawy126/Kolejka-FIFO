package Towary;

import java.util.ArrayList;
import java.util.Iterator;

public class MagazynSklapowy implements IMagazyn {
    ArrayList<Zamowienia> list;

    public MagazynSklapowy(ArrayList<Zamowienia> list) {
        this.list = list;
    }

    @Override
    public void WypiszMagazyn() {
        for (Zamowienia i : list) {
            i.wypiszZamowienie();
        }
    }

    @Override
    public ArrayList<Zamowienia> listaProduktow() {
        return list;
    }

    @Override
    public void dodajProdukt(Zamowienia zamowienia) {
        list.add(zamowienia);
    }

    @Override
    public void zabierzProdukt(Zamowienia nazwaProduktu) {
        Iterator<Zamowienia> iterator = list.iterator();
        while (iterator.hasNext()) {
            Zamowienia z = iterator.next();
            if (z.nazwaTowaru().equals(nazwaProduktu.nazwaTowaru())) {
                if (z.iloscTowaru() == nazwaProduktu.iloscTowaru()) {
                    iterator.remove();

                } else if (z.iloscTowaru() > nazwaProduktu.iloscTowaru()) {
                    z.ustawIlosc(z.iloscTowaru() - nazwaProduktu.iloscTowaru());

                }
                else if(z.iloscTowaru() > nazwaProduktu.iloscTowaru()){
                    iterator.remove();
                    System.out.println("Produkty się skończyły");
                }
            }

        }

    }

}
