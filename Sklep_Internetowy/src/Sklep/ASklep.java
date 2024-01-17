package Sklep;

import Klient.Sprzedawca;
import Towary.MagazynSklapowy;

public abstract class ASklep implements ISklep {
    String nazwa;
    MagazynSklapowy magazyn;
    Sprzedawca sprzedawca;

}
