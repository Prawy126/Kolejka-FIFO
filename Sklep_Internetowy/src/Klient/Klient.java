package Klient;

import Towary.Zamowienia;
import java.util.ArrayList;

public class Klient extends AKlient implements IKlient{
    private ArrayList<Zamowienia> list =  new ArrayList();
    public Klient(String imie, String nazwisko,Zamowienia zamowienia, String login, String haslo, float stanKonta){
        this.imie=imie;
        this.nazwisko = nazwisko;
        if(zamowienia!=null){
            list.add(zamowienia);
        }

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
    public float zwrocStanKonta() {

        return this.stanKonta;
    }

    @java.lang.Override
    public void zmienImie(java.lang.String imie) {

    }

    @java.lang.Override
    public void zmienNazwisko(java.lang.String nazwisko) {

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

    @Override
    public boolean poprawneHaslo(String haslo) {
        if(this.haslo.equals(haslo)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean poprawnyLogi(String login) {
        if(this.login.equals(login)) return true;
        else return false;
    }

    @Override
    public ArrayList<Zamowienia> zwrocZamowienia() {
        return list;
    }

    @Override
    public Klient zwroc() {
        return this;
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
