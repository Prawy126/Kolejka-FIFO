package Grafika;

import CSV.KlientCSV;
import Klient.Klient;
import Towary.MagazynSklapowy;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
    private JButton Cofnij;


    public Rejestracja(int numerKolejki, MagazynSklapowy magazynSklapowy, Klient[] klienci){
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
                String imie = Imie.getText();
                String nazwisko = Nazwisko.getText();
                String login = Login.getText();
                String stanKonta = StanKonta.getText();

                if(haslo.getText().equals(passwordField2)&&!(imie.isEmpty()||login.isEmpty()||nazwisko.isEmpty()||stanKonta.isEmpty())){
                    float stanKontaf = Float.valueOf(StanKonta.getText());
                    try{
                        Klient klient = new Klient(imie,nazwisko,null,login,haslo.getText(),stanKontaf);

                        KlientCSV odczyt = new KlientCSV("src\\CSV\\BazaDanychKlientow.csv");
                        if(odczyt.czyIstniejeKlient(klient)){
                            JOptionPane.showMessageDialog(null,"Posiadasz już konot","Konto",JOptionPane.INFORMATION_MESSAGE);
                        }else odczyt.zapiszDoCSV(klient);
                    }catch (NumberFormatException a) {
                        System.out.println("Nieprawidłowy format liczby: " + a.getMessage());
                    }catch (Exception a){
                        System.out.println("Coś poszło nie tak");
                    }
                }else if(imie.isEmpty()||login.isEmpty()||nazwisko.isEmpty()||stanKonta.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Nie uzupłniono wszystkich pól","ERROR",JOptionPane.ERROR_MESSAGE);

                }else {
                    JOptionPane.showMessageDialog(null,"Hasła nie są takeie same","ERROR",JOptionPane.ERROR_MESSAGE);
                }




            }
        });
        Cofnij.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logowanie logowanie = new Logowanie(numerKolejki,magazynSklapowy,klienci);
                dispose();
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
