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
import java.util.Arrays;

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

                char[] hasloChars = Haslo.getPassword(); // Pobierz hasło jako tablicę znaków
                char[] haslo2Chars = passwordField2.getPassword(); // Pobierz drugie hasło jako tablicę znaków

                // Porównaj hasła za pomocą metody Arrays.equals()
                if (Arrays.equals(hasloChars, haslo2Chars) && (!imie.isEmpty() && !login.isEmpty() && !nazwisko.isEmpty() && !stanKonta.isEmpty() && haslo2Chars.length!=0 && hasloChars.length!=0)) {
                    try {
                        KlientCSV odczyt = new KlientCSV("src\\CSV\\BazaDanychKlientow.csv");
                        stanKonta = stanKonta.replace(",",".");
                        float stanKontaf = Float.valueOf(StanKonta.getText());
                        // Utwórz obiekt Klienta
                        Klient klient = new Klient(imie, nazwisko, null, login, new String(hasloChars), stanKontaf);

                        // Sprawdź, czy klient już istnieje

                        if (odczyt.czyIstniejeKlient(klient)) {
                            JOptionPane.showMessageDialog(null, "Posiadasz już konto", "Konto", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            odczyt.zapiszDoCSV(klient);
                            JOptionPane.showMessageDialog(null,"Udało się założyć konto","Wszystko poszło pomyslnie",JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            Logowanie2 login2 = new Logowanie2(numerKolejki,magazynSklapowy,klienci);
                        }
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null,"Nieprawidłowy format, kwota na kocnie musi być w systemie 10 i może zawierać jedynie cyfry a nie litery lub znaki specjalne","ERROR",JOptionPane.ERROR_MESSAGE);

                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null,"Cos poszło nie tak spróbuj ponownie","ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                } else if (imie.isEmpty() || login.isEmpty() || nazwisko.isEmpty() || stanKonta.isEmpty()||hasloChars.length==0||haslo2Chars.length==0) {
                    JOptionPane.showMessageDialog(null, "Nie uzupełniono wszystkich pól", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Hasła nie są takie same", "ERROR", JOptionPane.ERROR_MESSAGE);
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
