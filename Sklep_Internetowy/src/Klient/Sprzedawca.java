package Klient;

public class Sprzedawca implements IKlient{
    private String imie, nazwisko;

    @Override
    public String zwrocImie() {
        return imie;
    }

    @Override
    public String zwrocNazwisko() {
        return nazwisko;
    }

    @Override
    public void zmienImie(String imie) {
        this.imie = imie;
    }

    @Override
    public void zmienNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
