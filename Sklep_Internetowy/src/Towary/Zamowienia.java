package Towary;

public class Zamowienia implements ITowayry{

    private float wagaTowaru, iloscTowaru;
    private String nazwaTowaru;
    public Zamowienia(String nazwaTowaru, float iloscTowaru, float wagaTowaru){
        this.nazwaTowaru = nazwaTowaru;
        ustawWage(wagaTowaru);
        ustawIlosc(iloscTowaru);
    }
    public Zamowienia(String nazwaTowaru, float iloscTowaru){
        this.nazwaTowaru = nazwaTowaru;
        ustawIlosc(iloscTowaru);
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
}
