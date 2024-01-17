package Klient;

public class Sprzedawca implements IKlient{
    private String imie, nazwisko;
    private String haslo, login;
    private float kasa;
    public Sprzedawca(String imie, String nazwisko, String haslo, String login, float kasa){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.haslo = haslo;
        this.login = login;
        if(kasa>0){
            this.kasa = 0;
        }else this.kasa = kasa;

    }

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
        return this.kasa;
    }
    public boolean czySprzedawca(){
        return true;
    }
    public boolean czyKlient(){
        return false;
    }
}
