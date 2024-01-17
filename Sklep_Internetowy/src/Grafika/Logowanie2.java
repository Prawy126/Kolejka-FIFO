package Grafika;

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

    public static void main(String[] args) {
        ArrayList<Klient> klient = null;
        Logowanie2 logowanie2 = new Logowanie2(klient);

    }
    public Logowanie2(ArrayList<Klient> klienci){
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

            }
        });
    }
}
