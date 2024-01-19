package Grafika;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
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

    public static void main(String[] args){
        Klient klient = new Klient("tak","nie",null,"login","Haslo",0.0f);
        ArrayList<Zamowienia> towary = new ArrayList<>();
        towary.add(new Zamowienia("ser",12.3f,12));
        towary.add(new Zamowienia("ser2",12.3f,2));
        towary.add(new Zamowienia("ser3",12.3f,2));
        MagazynSklapowy magazyn = new MagazynSklapowy(towary);
        GUISklep sklep = new GUISklep(klient, magazyn);

    }
    public GUISklep(Klient klient, MagazynSklapowy magazyn){
        super("Sklep Internetowy");
        this.setContentPane(Wyswietlacz);
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

            playSound("src\\Dzwieki\\drzwi.wav");
            Timer timer = new Timer();
            int interwal = 3 * 60 * 1000 + 52 * 1000; // Interwał w milisekundach (3 minuty i 52 sekundy)

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    playSound("src\\Dzwieki\\293-front-music.pl.wav");
                }
            }, 0, interwal);
            // Dodaj WindowListener, aby zatrzymać odtwarzanie muzyki przy zamknięciu okna
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    timer.cancel(); // Zatrzymaj zadanie Timera
                }

            });
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
                    int cena = 0;
                    switch (nazwa){
                        case "ser":
                            cena = 10;
                            break;
                    }
                    Zamowienia zamowienia = new Zamowienia(nazwa,liczba,0,cena);
                    System.out.println(comboBox1.getSelectedItem() + " " + comboBox2.getSelectedItem());
                    klient.dodaZamowienie(zamowienia);
                    klient.wyswieltZamowienia();
                    System.out.println(klient.ileDoZaplaty());
                    StanKonta.setText(String.valueOf(klient.ileDoZaplaty()));
                }
            });
            przejźDoKasyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

    }
    private void playSound(String filePath) {
        try {
            File musicPath = new File(filePath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("File path does not exist");
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();

        }
    }
}



