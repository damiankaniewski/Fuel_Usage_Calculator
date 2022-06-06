package fc.functions;

import javax.swing.*;

public interface IFunctions {

    double KosztJednaosoba(int osoby, double spalanie, double trasa, double kosztpaliwa);
    double KosztPaliwaWynik(double spalanie, double trasa, double kosztpaliwa);
    double[] wspolrzedneDO(String miastoDO);
    double[] wspolrzedneOD(String miastoOD);
    double obliczOdleglosc(double[] wspolrzedneOD, double[] wspolrzedneDO);
    //void RuchomyTekst(JLabel ruchomyTekst);
}
