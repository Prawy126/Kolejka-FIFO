package Towary;

public class Zamowienia implements ITowary {

    private float wagaTowaru, iloscTowaru, cena;

    private String nazwaTowaru;
    public Zamowienia(String nazwaTowaru, float iloscTowaru, float wagaTowaru, float cena){
        this.nazwaTowaru = nazwaTowaru;
        ustawWage(wagaTowaru);
        ustawIlosc(iloscTowaru);
        ustawCene(cena);
    }
    public Zamowienia(String nazwaTowaru, float iloscTowaru){
        this.nazwaTowaru = nazwaTowaru;
        ustawIlosc(iloscTowaru);
    }
    public void ustawCene(float cena){
        this.cena = Math.abs(cena);
    }
    public void ustawIlosc(float iloscTowaru){
        this.iloscTowaru = Math.abs(iloscTowaru);
    }
    private void ustawWage(float wagaTowaru){
        this.wagaTowaru = Math.abs(wagaTowaru);
    }
    @Override
    public float wagaTowaru() {
        return wagaTowaru;
    }

    @Override
    public String nazwaTowaru() {
        return nazwaTowaru;
    }

    @Override
    public float iloscTowaru() {
        return iloscTowaru;
    }
    public void wypiszZamowienie(){
        System.out.println("Nazwa towaru: " + nazwaTowaru + "\t Ilość towaru: " + iloscTowaru + "\t Waga towaru: " + wagaTowaru);
    }
    public float dajCene(){
        return this.cena;
    }
}
