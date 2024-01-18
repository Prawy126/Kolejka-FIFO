package CSV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import Klient.*;

import javax.swing.*;

public class KlientCSV {
    private String filePath ;

    public KlientCSV(String filePath) {
        this.filePath = filePath;
    }

    // Metoda do zapisywania informacji o kliencie do pliku CSV
    public void zapiszDoCSV(Klient klient) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Format CSV: imie,nazwisko,login,haslo,stanKonta
            writer.write(klient.zwrocImie() + "," + klient.zwrocNazwisko() + ","
                    + klient.podajLogin() + "," + klient.podajHaslo() + ","
                    + klient.podajZawartoscKonta() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda do odczytywania informacji o klientach z pliku CSV
    public LinkedList<Klient> odczytajZCSV() {
        LinkedList<Klient> klientList = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String imie = parts[0];
                    String nazwisko = parts[1];
                    String login = parts[2];
                    String haslo = parts[3];
                    float stanKonta = Float.parseFloat(parts[4]);

                    Klient klient = new Klient(imie, nazwisko, null, login, haslo, stanKonta);
                    klientList.addLast(klient);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return klientList;
    }
    public boolean czyIstniejeHaslo(String haslo, String login) {
        LinkedList<Klient> klientList = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String imie = parts[0];
                    String nazwisko = parts[1];
                    String savedLogin = parts[2]; // Zmieniłem nazwę zmiennej, żeby uniknąć konfliktu z argumentem
                    String savedHaslo = parts[3]; // Zmieniłem nazwę zmiennej, żeby uniknąć konfliktu z argumentem
                    float stanKonta = Float.parseFloat(parts[4]);

                    Klient klient = new Klient(imie, nazwisko, null, savedLogin, savedHaslo, stanKonta);
                    klientList.addLast(klient);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Klient a : klientList) {
            if (a.podajHaslo().equals(haslo) && a.podajLogin().equals(login)) {
                return true;
            }
        }

        return false; // Jeśli nie znaleziono pasujących danych
    }
}
