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
import java.util.Timer;
import java.util.TimerTask;

public class GUISklep extends JFrame {


    private JPanel Wyswietlacz;
    private JButton wyjścieButton;

    public static void main(String[] args){
        GUISklep sklep = new GUISklep();

    }
    public GUISklep(){
        super("Sklep Internetowy");
        this.setContentPane(Wyswietlacz);
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

            playSound("src\\Dzwieki\\drzwi.wav");
            java.util.Timer timer = new Timer();
            int interwal = 3 * 60 * 1000 + 52 * 1000; // Interwał w milisekundach (3 minuty i 52 sekundy)

            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    playSound("src\\Dzwieki\\293-front-music.pl.wav");
                }
            }, 0, interwal);
            // Dodaj WindowListener, aby zatrzymać odtwarzanie muzyki przy zamknięciu okna
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    timer.cancel(); // Zatrzymaj zadanie Timera
                }

            });
            wyjścieButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    timer.cancel();
                    dispose();
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



