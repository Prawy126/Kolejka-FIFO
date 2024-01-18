package Grafika;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logowanie extends JFrame{
    private JPanel Ekran;
    private JButton logowanie;
    private JButton Wyjscie;
    private JLabel numer;
    private JButton zalogujSięJakoSprzedawcaButton;

    public static void main(String[] args){

    }

    public Logowanie(int numer){
        super("Sklep Internetowy");
        this.setContentPane(Ekran);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,500);
        this.setVisible(true);

        this.numer.setText("Aktualnie zajmujesz " + numer + " miejsce w kolejce");

        Wyjscie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }
}
