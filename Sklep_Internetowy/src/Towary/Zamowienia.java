package Towary;

public class Zamowienia implements ITowary {

    private float iloscTowaru, cena;

    private String nazwaTowaru;

    public Zamowienia(String nazwaTowaru, float iloscTowaru, float cena){
        this.nazwaTowaru = nazwaTowaru;
        ustawIlosc(iloscTowaru);
        ustawCene(cena);
    }
    public void ustawCene(float cena){
        this.cena = Math.abs(cena);
    }
    public void ustawIlosc(float iloscTowaru){
        this.iloscTowaru = Math.abs(iloscTowaru);
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
        System.out.println("Nazwa towaru: " + nazwaTowaru + "\t Ilość towaru: " + iloscTowaru);
    }
    public float dajCene(){
        return this.cena;
    }
}
