package Grafika;

import CSV.KlientCSV;
import Klient.Klient;
import Klient.Sprzedawca;
import Towary.MagazynSklapowy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Logowanie2 extends JFrame{
    private JPanel panel1;
    private JPanel Wyswietlacz;
    private JTextField Login;
    private JPasswordField Haslo;
    private JButton zalogujSięButton;
    private JButton załóżKontoButton;
    private JButton cofnij;


    public Logowanie2(int numerKolejki, MagazynSklapowy magazynSklapowy,Klient[] klienci){
        super("Logowanie");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(Wyswietlacz);
        this.setSize(250,250);
        this.setVisible(true);

        zalogujSięButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = Login.getText();
                String haslo = Haslo.getText();
                KlientCSV zapis = new KlientCSV("src\\CSV\\BazaDanychKlientow.csv");
                KlientCSV sprzedawca = new KlientCSV("src\\CSV\\BazaDanychSprzedawca.csv");
                if(zapis.czyIstniejeHaslo(haslo,login)){
                    JOptionPane.showMessageDialog(null,"POMYŚLNIE SIĘ ZALOGOWANO","LOGOWANIE", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    Klient klient = KlientCSV.findClientByLogin(login,"src\\CSV\\BazaDanychKlientow.csv");
                    //tutaj otwiera się sklep
                    //GUISklep sklep = new GUISklep();
                    GUISklep sklep = new GUISklep(numerKolejki,klient,magazynSklapowy);
                }else if(sprzedawca.czyIstniejeHaslo(haslo,login))
                {
                    Sprzedawca sprzedawca1 = KlientCSV.findSprzedawcaByLogin(login,"src\\CSV\\BazaDanychSprzedawca.csv");
                    JOptionPane.showMessageDialog(null,"POMYŚLNIE SIĘ ZALOGOWANO","LOGOWANIE", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    Praca kasa = new Praca(klienci,sprzedawca1);
                }
                else{


                    JOptionPane.showMessageDialog(null,"NIE UDAŁO SIĘ ZALOGOWAĆ","BŁĄD LOGOWANIA", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        cofnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logowanie logowanie = new Logowanie(numerKolejki,magazynSklapowy,klienci);
                dispose();
            }
        });
        załóżKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rejestracja rejestracja = new Rejestracja(numerKolejki,magazynSklapowy,klienci);
                dispose();
            }
        });
    }
}
