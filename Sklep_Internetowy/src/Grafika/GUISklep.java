package Grafika;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import CSV.KlientCSV;
import Dzwieki.MusicPlayerConsole;
import Klient.Klient;
import Towary.MagazynSklapowy;
import Towary.Zamowienia;

public class GUISklep extends JFrame {


    private JPanel Wyswietlacz;
    private JLabel StanKonta;
    private JLabel ImieNazwisko;
    private JButton przejźDoKasyButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton dodajDoListyButton;
    private JButton cofnijButton;
    private JButton wylogujButton;
    private JButton usuńKontoButton;


    public GUISklep(int numerKolejki,Klient klient, MagazynSklapowy magazyn,Klient[] klienci){
        super("Sklep Internetowy");
        this.setContentPane(Wyswietlacz);
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        MusicPlayerConsole muzyka = new MusicPlayerConsole();
        muzyka.playMusicLoop();
            ArrayList<Zamowienia> lista = magazyn.listaProduktow();
             for (Zamowienia a : lista) {
                 System.out.println(a.dajCene());
                 comboBox1.addItem(a.nazwaTowaru());
             }
            ImieNazwisko.setText(klient.zwrocImie() + " " + klient.zwrocNazwisko());
            String konto = Float.toString(klient.zwrocStanKonta());
            StanKonta.setText(konto);
            dodajDoListyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String pomoc = comboBox2.getSelectedItem().toString();
                    float liczba = Float.parseFloat(pomoc);
                    String nazwa = (String)comboBox1.getSelectedItem();
                    int cena = 10;
                    Zamowienia zamowienia = new Zamowienia(nazwa,liczba,cena);
                    System.out.println(comboBox1.getSelectedItem() + " " + comboBox2.getSelectedItem());
                    klient.dodaZamowienie(zamowienia);
                    klient.wyswieltZamowienia();
                    System.out.println(klient.ileDoZaplaty()+"\n"+klient.zwrocStanKonta());
                    StanKonta.setText(String.valueOf(klient.ileDoZaplaty()));
                }
            });
            przejźDoKasyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(klient.zwrocZamowienia().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Chcesz iść do kasy a nie wybrano profuktów","ERROR",JOptionPane.ERROR_MESSAGE);
                    }else{
                        Kasa kasa = new Kasa(klient,numerKolejki,magazyn,klienci);
                        dispose();
                        muzyka.stopMusic();
                    }

                }
            });
                cofnijButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Logowanie2 logowanie2 = new Logowanie2(numerKolejki,magazyn,klienci);
                        dispose();
                        muzyka.stopMusic();
                    }
                });
                wylogujButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Random random = new Random();
                        dispose();
                        Logowanie2 logowanie2 = new Logowanie2(numerKolejki+random.nextInt(5),magazyn,klienci);
                    }
                });
                usuńKontoButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Random random = new Random();
                        Logowanie2 logowanie2 = new Logowanie2(numerKolejki+random.nextInt(4),magazyn,klienci);
                        KlientCSV klientCSV = new KlientCSV("src\\CSV\\BazaDanychKlientow.csv");
                        klientCSV.usunKlienta(klient.podajLogin());
                        dispose();
                        muzyka.stopMusic();
                    }
                });
    }


}



