package Grafika;

import CSV.KlientCSV;
import Klient.Klient;

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

    public static void main(String[] args) {
        ArrayList<Klient> klient = null;
        Logowanie2 logowanie2 = new Logowanie2();

    }
    public Logowanie2(){
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
                    //tutaj otwiera się sklep
                    //GUISklep sklep = new GUISklep();
                }else if(sprzedawca.czyIstniejeHaslo(haslo,login))
                {
                    JOptionPane.showMessageDialog(null,"POMYŚLNIE SIĘ ZALOGOWANO","LOGOWANIE", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    //tutaj otwiera się okno dla sprzedawcy
                }
                else{


                    JOptionPane.showMessageDialog(null,"NIE UDAŁO SIĘ ZALOGOWAĆ","BŁĄD LOGOWANIA", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        cofnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logowanie logowanie = new Logowanie(1);
                dispose();
            }
        });
        załóżKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Rejestracja rejestracja = new Rejestracja();
                dispose();
            }
        });
    }
}
