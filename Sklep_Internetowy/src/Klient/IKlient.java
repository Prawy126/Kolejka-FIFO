package Klient;

public interface IKlient {
     public String zwrocImie();
     public String zwrocNazwisko();
     public void zmienImie(String imie);
     public void zmienNazwisko(String nazwisko);
     public String podajLogin();
     public String podajHaslo();
     public float podajZawartoscKonta();
}
