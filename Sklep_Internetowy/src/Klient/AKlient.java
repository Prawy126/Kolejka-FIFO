package Klient;

public abstract class AKlient implements IKlient{
    String imie, nazwisko;


    @Override
    public String zwrocImie() {
        return this.imie;
    }

    @Override
    public String zwrocNazwisko() {
        return this.nazwisko;
    }

    @Override
    public void zmienImie(String imie) {
        this.imie = imie;
    }

    @Override
    public void zmienNazwisko(String Nazwisko) {
        this.nazwisko = nazwisko;
    }
}
