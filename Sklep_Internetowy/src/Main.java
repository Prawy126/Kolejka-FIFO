import Klient.Klient;


public class Main {
    public static void main(String[] args)
    {
        Klient klient = new Klient("Piotr","Nowak");
        System.out.println(klient.zwrocImie());
        System.out.println(klient.zwrocNazwisko());
    }
}