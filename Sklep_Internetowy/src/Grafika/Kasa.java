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
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import Klient.Klient;
import Towary.MagazynSklapowy;
import Towary.Zamowienia;


public class Kasa extends JFrame{
    private JPanel Wyswietlacz;
    private JButton zapłaćKartąButton;
    private JButton zrezygnujZZakupówButton;
    private JLabel Kolejka;

    public static void main(String[] args) {


        ArrayList<Zamowienia> towary = new ArrayList<>();
        towary.add(new Zamowienia("ser",12.3f, 21));
        towary.add(new Zamowienia("ser2",12.3f,32));
        towary.add(new Zamowienia("ser3",12.3f,2));
        Klient klient = new Klient("tak","nie",null,"login","Haslo",0.0f);
        MagazynSklapowy magazyn = new MagazynSklapowy(towary);
        klient.dodaZamowienie(towary.get(1));
        klient.dodaZamowienie(towary.get(2));


        Kasa kasa = new Kasa(klient);
    }

    public Kasa(Klient klient){
        super("Kasa");
        this.setContentPane(Wyswietlacz);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setVisible(true);


        java.util.Timer timer = new Timer();
        Random random = new Random();
        int interwal = (random.nextInt(3)+1) * 1000; // Interwał w milisekundach (3 minuty i 52 sekundy)
        int lista = random.nextInt(3);

        timer.scheduleAtFixedRate(new TimerTask() {
            int lista2 = lista;
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
            }

        });
        zapłaćKartąButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(klient.zwrocStanKonta()==klient.ileDoZaplaty()){
                    JOptionPane.showMessageDialog(null,"Transakcja udana","Wszystko poszło pomyślnie",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"Za mało pieniędzy na koncie","Transakcja nie udana",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        zrezygnujZZakupówButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }
}
