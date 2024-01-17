import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {
        Timer timer = new Timer();
        int interwal = 3 * 60 * 1000 + 52 * 1000; // Interwał w milisekundach (3 minuty i 52 sekundy)

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                playSound("src\\Dzwieki\\293-front-music.pl.wav");
            }
        }, 0, interwal);

    }
    private static void playSound(String filePath) {
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
