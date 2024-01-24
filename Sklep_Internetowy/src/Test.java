import CSV.KlientCSV;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {
        KlientCSV klientCSV = new KlientCSV("src\\CSV\\BazadanychSprzedawca.CSV");
        klientCSV.usunKlienta("sprzedawca1");

    }
}
