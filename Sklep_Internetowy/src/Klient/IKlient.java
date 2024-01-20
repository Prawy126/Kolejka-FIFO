package Klient;

import Towary.Zamowienia;

import java.util.ArrayList;

public interface IKlient {
     public String zwrocImie();
     public String zwrocNazwisko();
     public float zwrocStanKonta();
     public void zmienImie(String imie);
     public void zmienNazwisko(String nazwisko);
     public String podajLogin();
     public String podajHaslo();
     public float podajZawartoscKonta();
     public boolean poprawneHaslo(String haslo);
     public boolean poprawnyLogi(String login);
     public ArrayList<Zamowienia> zwrocZamowienia();
}
