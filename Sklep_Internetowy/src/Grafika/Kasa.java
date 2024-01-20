package Grafika;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import CSV.KlientCSV;
import Dzwieki.MusicPlayerConsole;
import Klient.Klient;
import Towary.MagazynSklapowy;


public class Kasa extends JFrame{
    private JPanel Wyswietlacz;
    private JButton zapłaćKartąButton;
    private JButton zrezygnujZZakupówButton;
    private JLabel Kolejka;
    private JButton cofnijButton;



    public Kasa(Klient klient, int numerKolejki, MagazynSklapowy magazynSklapowy,Klient[] klienci){
        super("Kasa");
        this.setContentPane(Wyswietlacz);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);

        MusicPlayerConsole muzyka = new MusicPlayerConsole();
        muzyka.playMusicLoop();
        Timer timer = new Timer();
        Random random = new Random();
        int interwal = (random.nextInt(5)+1) * 1000; // Interwał w milisekundach (3 minuty i 52 sekundy)


        timer.scheduleAtFixedRate(new TimerTask() {
            int lista2 = numerKolejki;
            @Override
            public void run() {

                lista2 = lista2 - 1;
                if (lista2 > 0) {
                    // Aktualizuj etykietę tekstową w wątku dystrybucji Swing
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            Kolejka.setText("Aktualnie jesteś " + lista2);
                        }
                    });
                } else {
                    // Zakończ zadanie po zadanym czasie
                    Kolejka.setText("Teraz twoja kolej \t Do zapłaty: " + klient.ileDoZaplaty());
                    timer.cancel();
                    System.out.println(klient.ileDoZaplaty());
                    zapłaćKartąButton.setEnabled(true);
                }
            }
        }, 0, interwal);
        // Dodaj WindowListener, aby zatrzymać odtwarzanie muzyki przy zamknięciu okna
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                timer.cancel(); // Zatrzymaj zadanie Timera
                muzyka.stopMusic();
            }

        });
        zapłaćKartąButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(klient.zwrocStanKonta()>=klient.ileDoZaplaty()){
                    JOptionPane.showMessageDialog(null,"Transakcja udana","Wszystko poszło pomyślnie",JOptionPane.INFORMATION_MESSAGE);
                    klient.odejmijZKonta(klient.ileDoZaplaty());
                    KlientCSV.updateKlientAccount(klient.podajLogin(),klient.podajZawartoscKonta(),"src\\CSV\\BazaDanychKlientow.csv");
                    JOptionPane.showMessageDialog(null,"Aktualny stan konta " + klient.zwrocStanKonta(),"Ile na koncie", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Za mało pieniędzy na koncie","Transakcja nie udana",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        zrezygnujZZakupówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.cancel();
                muzyka.stopMusic();
                dispose();

            }
        });
        cofnijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUISklep guiSklep = new GUISklep(numerKolejki,klient,magazynSklapowy,klienci);
                dispose();
                muzyka.stopMusic();
            }
        });

    }
}
