package Klient;

import Towary.Zamowienia;
import java.util.ArrayList;

public class Klient extends AKlient implements IKlient{
    private ArrayList<Zamowienia> list =  new ArrayList();
    public Klient(String imie, String nazwisko,Zamowienia zamowienia, String login, String haslo, float stanKonta){
        this.imie=imie;
        this.nazwisko = nazwisko;
        list.add(zamowienia);
        this.login = login;
        this.haslo = haslo;
        this.stanKonta = stanKonta;
    }
    public void dodaZamowienie(Zamowienia zamowienia){
        list.add(zamowienia);
    }
    public void wyswieltZamowienia(){
        for(Zamowienia a : list){
            a.wypiszZamowienie();
        }
    }

    @Override
    public String podajLogin() {
        return this.login;
    }

    @Override
    public String podajHaslo() {
        return this.haslo;
    }

    @Override
    public float podajZawartoscKonta() {
        return this.stanKonta;
    }
    public boolean czyKlient(){
        return true;
    }
    public boolean czySprzedawca(){
        return false;
    }
    public float ileDoZaplaty(){
        float cena = 0;
        for(Zamowienia a : list){
            cena+=a.iloscTowaru()*a.dajCene();
        }
        return cena;
    }
}
