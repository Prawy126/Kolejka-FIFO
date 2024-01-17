package Grafika;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Wejscie extends JFrame {
    private JPanel Wyswietlacz;
    private JButton wejścieButton;
    private JButton nieWchodzęButton;

    public static void main(String[] args) {
        Wejscie wejscie = new Wejscie();
        wejscie.setVisible(true);
    }

    public Wejscie() {
        super("Sklep Internetowy");
        this.setContentPane(this.Wyswietlacz);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);


        wejścieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("src\\Dzwieki\\drzwi.wav");
                dispose();
                Logowanie logowanie = new Logowanie(1);
                logowanie.setVisible(true);
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
