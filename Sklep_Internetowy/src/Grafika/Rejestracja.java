package Grafika;

import CSV.KlientCSV;
import Klient.Klient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;

public class Rejestracja extends JFrame{
    private JPanel panel1;
    private JLabel imie;
    private JPanel Wyswietlacz;
    private JTextField StanKonta;
    private JPasswordField Haslo;
    private JPasswordField passwordField2;
    private JButton zamknijButton;
    private JButton zarejestrujSięButton;
    private JTextField Login;
    private JLabel login;
    private JLabel nazwisko;
    private JTextField Imie;
    private JLabel stanKonta;
    private JLabel haslo;
    private JTextField Nazwisko;

    public static void main(String[] args){
        Rejestracja rejestracja = new Rejestracja();

    }
    public Rejestracja(){
        super("Rejestracja");
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(Wyswietlacz);
        this.setVisible(true);

        zamknijButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        zarejestrujSięButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Klient klient = new Klient(Imie.getText(),Nazwisko.getText(),null,Login.getText(),Haslo.getText(),parseStanKonta(StanKonta.getText()));
                KlientCSV odczyt = new KlientCSV("src\\CSV\\BazaDanychKlientow.csv");
                odczyt.zapiszDoCSV(klient);
            }
        });


    }
    private float parseStanKonta(String value) {
        try {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setDecimalSeparator(',');

            DecimalFormat decimalFormat = new DecimalFormat("#.##", symbols);
            decimalFormat.setParseBigDecimal(true);

            return decimalFormat.parse(value).floatValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0.0f; // Jeśli wystąpi błąd, zwracamy 0
        }
    }
}
