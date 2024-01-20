package Dzwieki;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Scanner;

public class MusicPlayerConsole {
    private Clip clip;
    private int wybor = 1;

    public MusicPlayerConsole() {
    }

    public void playMusicLoop() {
        try {
            File musicPath = new File("src\\Dzwieki\\293-front-music.wav");
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);

                // Dodaj listener, który będzie odtwarzać muzykę od nowa po jej zakończeniu
                clip.addLineListener(new LineListener() {
                    @Override
                    public void update(LineEvent event) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            clip.setFramePosition(0); // Przewiń muzykę na początek
                            clip.start(); // Rozpocznij odtwarzanie od nowa
                        }
                    }
                });

                clip.start(); // Rozpocznij odtwarzanie
            } else {
                System.out.println("File path does not exist");
            }
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    public void coRobic(int wybor){
        this.wybor = wybor;
    }
    public void stopMusic() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    public void start() {

        boolean running = true;

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Play Music");
            System.out.println("2. Stop Music");
            System.out.println("3. Exit");
            switch (this.wybor) {
                case 1:
                    stopMusic(); // Zatrzymaj muzykę przed rozpoczęciem nowego odtwarzania
                    playMusicLoop();
                    System.out.println("Odtwarzam muzykę");
                    break;
                case 2:
                    stopMusic();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        System.out.println("Goodbye!");
    }


}
