package Grafika;

import CSV.KlientCSV;
import Dzwieki.MusicPlayerConsole;
import Klient.Klient;
import Towary.MagazynSklapowy;
import Towary.Zamowienia;
import Klient.Sprzedawca;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Praca extends JFrame{
    private JPanel Wyswietlacz;
    private JLabel ImieNazwisko;
    private JButton koniecPracyButton;
    private JButton skasujKlientaButton;
    private JButton liczIleDoZapłatyButton;
    private JLabel Koszt;
    private JTable table1;
    private JButton kolejnyKlientButton;
    public static int currentIndex = 0; // Ustalamy początkowy indeks klienta

    public Praca(Klient[] klient, Sprzedawca sprzedawca) {
        super("Sklep internetowy");
        this.setContentPane(Wyswietlacz);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        kolejnyKlientButton.setEnabled(false);
        MusicPlayerConsole muzyka = new MusicPlayerConsole();
        muzyka.playMusicLoop();
        ImieNazwisko.setText(sprzedawca.zwrocImie());
        liczIleDoZapłatyButton.setEnabled(true);
        ArrayList<Zamowienia> paragon = klient[currentIndex].zwrocZamowienia();
        Object[][] data = new Object[paragon.size()][3];
        klient[currentIndex].wyswieltZamowienia();
        for (int j = 0; j < paragon.size(); j++) {
            Zamowienia zamowienie = paragon.get(j);
            data[j][0] = zamowienie.nazwaTowaru();
            data[j][1] = zamowienie.iloscTowaru();
            data[j][2] = zamowienie.dajCene();
        }

        // Ustawienie danych tabeli
        table1.setModel(new DefaultTableModel(
                data,
                new String[]{"Nazwa Produktu", "Ilość Produktu", "Cena za jeden produkt"}
        ));

        // Pozostała konfiguracja tabeli (np. renderer)
        TableColumnModel columnModel = table1.getColumnModel();
        columnModel.getColumn(0).setMinWidth(200);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        columnModel.getColumn(1).setCellRenderer(cellRenderer);

        skasujKlientaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                skasujKlientaButton.setEnabled(false);
                if(klient[currentIndex].ileDoZaplaty()<=klient[currentIndex].zwrocStanKonta()){

                    JOptionPane.showMessageDialog(null,"Wszystko poszło pomyślnie","Transakcja zakończona pomyślnie",JOptionPane.INFORMATION_MESSAGE);
                    KlientCSV.updateKlientAccount(sprzedawca.podajLogin(),klient[currentIndex].ileDoZaplaty(),"src\\CSV\\BazaDanychSprzedawca.csv");
                    KlientCSV.updateKlientAccount(klient[currentIndex].podajLogin(),klient[currentIndex].ileDoZaplaty(),"src\\CSV\\BazaDanychKlientow.csv");
                }else{
                    JOptionPane.showMessageDialog(null,"Za mało pieniędzy na koncie","Transakcja zakończona błędem",JOptionPane.ERROR_MESSAGE);
                }
                kolejnyKlientButton.setEnabled(true);
            }
        });
        kolejnyKlientButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex++;
                if (currentIndex < klient.length) {
                    ArrayList<Zamowienia> paragon = klient[currentIndex].zwrocZamowienia();
                    Object[][] data = new Object[paragon.size()][3];
                    for (int j = 0; j < paragon.size(); j++) {
                        Zamowienia zamowienie = paragon.get(j);
                        data[j][0] = zamowienie.nazwaTowaru();
                        data[j][1] = zamowienie.iloscTowaru();
                        data[j][2] = zamowienie.dajCene();
                    }

                    // Ustawienie danych tabeli
                    table1.setModel(new DefaultTableModel(
                            data,
                            new String[]{"Nazwa Produktu", "Ilość Produktu", "Cena za jeden produkt"}
                    ));

                    // Pozostała konfiguracja tabeli (np. renderer)
                    TableColumnModel columnModel = table1.getColumnModel();
                    columnModel.getColumn(0).setMinWidth(200);
                    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
                    cellRenderer.setHorizontalAlignment(JLabel.CENTER);
                    columnModel.getColumn(1).setCellRenderer(cellRenderer);

                    liczIleDoZapłatyButton.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Kolejka jest pusta","Brak kolejki",JOptionPane.ERROR_MESSAGE);
                    skasujKlientaButton.setEnabled(false);
                    liczIleDoZapłatyButton.setEnabled(false);
                }
                kolejnyKlientButton.setEnabled(false);

            }
        });
        liczIleDoZapłatyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liczIleDoZapłatyButton.setEnabled(false);
                Koszt.setText(String.valueOf(klient[currentIndex].ileDoZaplaty()));
                skasujKlientaButton.setEnabled(true);
            }
        });
        koniecPracyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                muzyka.stopMusic();
                dispose();
            }
        });

    }
}
