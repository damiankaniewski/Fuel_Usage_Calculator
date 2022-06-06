package fc.functions;

import fc.KalkulatorPaliwa;

import javax.swing.*;

public class Function implements IFunctions {
    @Override
    public double KosztJednaosoba(int osoby, double spalanie, double trasa, double kosztpaliwa) {
        return (spalanie * trasa / 100 * kosztpaliwa) / osoby;
    }

    @Override
    public double KosztPaliwaWynik(double spalanie, double trasa, double kosztpaliwa) {
        return spalanie * trasa / 100 * kosztpaliwa;
    }

    @Override
    public double[] wspolrzedneOD(String miastoOD) {
        double[] wspolrzedne = new double[2];
        if (miastoOD == "Bialystok") {
            wspolrzedne[0] = 23.16;
            wspolrzedne[1] = 53.11;
        }

        if (miastoOD == "Bydgoszcz") {
            wspolrzedne[0] = 18.00;
            wspolrzedne[1] = 53.13;
        }

        if (miastoOD == "Gdansk") {
            wspolrzedne[0] = 18.63;
            wspolrzedne[1] = 54.37;
        }

        if (miastoOD == "Zielona Gora") {
            wspolrzedne[0] = 15.50;
            wspolrzedne[1] = 52.93;
        }

        if (miastoOD == "Katowice") {
            wspolrzedne[0] = 19.00;
            wspolrzedne[1] = 50.93;
        }

        if (miastoOD == "Kielce") {
            wspolrzedne[0] = 20.61;
            wspolrzedne[1] = 50.88;
        }

        if (miastoOD == "Krakow") {
            wspolrzedne[0] = 19.95;
            wspolrzedne[1] = 50.05;
        }

        if (miastoOD == "Lublin") {
            wspolrzedne[0] = 22.57;
            wspolrzedne[1] = 51.23;
        }

        if (miastoOD == "Lodz") {
            wspolrzedne[0] = 19.47;
            wspolrzedne[1] = 51.78;
        }

        if (miastoOD == "Olsztyn") {
            wspolrzedne[0] = 20.50;
            wspolrzedne[1] = 53.78;
        }

        if (miastoOD == "Opole") {
            wspolrzedne[0] = 17.95;
            wspolrzedne[1] = 50.66;
        }

        if (miastoOD == "Poznan") {
            wspolrzedne[0] = 16.90;
            wspolrzedne[1] = 52.42;
        }

        if (miastoOD == "Rzeszow") {
            wspolrzedne[0] = 22.02;
            wspolrzedne[1] = 50.05;
        }

        if (miastoOD == "Szczecin") {
            wspolrzedne[0] = 14.56;
            wspolrzedne[1] = 53.43;
        }

        if (miastoOD == "Warszawa") {
            wspolrzedne[0] = 21.04;
            wspolrzedne[1] = 52.20;
        }
        if (miastoOD == "Wroclaw") {
            wspolrzedne[0] = 17.04;
            wspolrzedne[1] = 51.12;
        }

        return wspolrzedne;
    }
    @Override
    public double[] wspolrzedneDO(String miastoDO) {
        double[] wspolrzedne = new double[2];
        if (miastoDO == "Bialystok") {
            wspolrzedne[0] = 23.16;
            wspolrzedne[1] = 53.11;
        }

        if (miastoDO == "Bydgoszcz") {
            wspolrzedne[0] = 18.00;
            wspolrzedne[1] = 53.13;
        }

        if (miastoDO == "Gdansk") {
            wspolrzedne[0] = 18.63;
            wspolrzedne[1] = 54.37;
        }

        if (miastoDO == "Zielona Gora") {
            wspolrzedne[0] = 15.50;
            wspolrzedne[1] = 52.93;
        }

        if (miastoDO == "Katowice") {
            wspolrzedne[0] = 19.00;
            wspolrzedne[1] = 50.93;
        }

        if (miastoDO == "Kielce") {
            wspolrzedne[0] = 20.61;
            wspolrzedne[1] = 50.88;
        }

        if (miastoDO == "Krakow") {
            wspolrzedne[0] = 19.95;
            wspolrzedne[1] = 50.05;
        }

        if (miastoDO == "Lublin") {
            wspolrzedne[0] = 22.57;
            wspolrzedne[1] = 51.23;
        }

        if (miastoDO == "Lodz") {
            wspolrzedne[0] = 19.47;
            wspolrzedne[1] = 51.78;
        }

        if (miastoDO == "Olsztyn") {
            wspolrzedne[0] = 20.50;
            wspolrzedne[1] = 53.78;
        }

        if (miastoDO == "Opole") {
            wspolrzedne[0] = 17.95;
            wspolrzedne[1] = 50.66;
        }

        if (miastoDO == "Poznan") {
            wspolrzedne[0] = 16.90;
            wspolrzedne[1] = 52.42;
        }

        if (miastoDO == "Rzeszow") {
            wspolrzedne[0] = 22.02;
            wspolrzedne[1] = 50.05;
        }

        if (miastoDO == "Szczecin") {
            wspolrzedne[0] = 14.56;
            wspolrzedne[1] = 53.43;
        }

        if (miastoDO == "Warszawa") {
            wspolrzedne[0] = 21.04;
            wspolrzedne[1] = 52.20;
        }
        if (miastoDO == "Wroclaw") {
            wspolrzedne[0] = 17.04;
            wspolrzedne[1] = 51.12;
        }

        return wspolrzedne;
    }

    @Override //x0 - wspolrzedneOD[1], x1 - wspolrzedneDO[1], y0 - wspolrzedneOD[0], y1 - wspolrzedneDO[0]
    public double obliczOdleglosc(double[] wspolrzedneOD, double[] wspolrzedneDO) {
        double odleglosc = 1.2*(Math.sqrt(Math.pow((wspolrzedneDO[1]-wspolrzedneOD[1]),2)+Math.pow(((Math.cos(wspolrzedneOD[1]*Math.PI/180))*(wspolrzedneDO[0]-wspolrzedneOD[0])),2))*(40075.704/360));
        //double odleglosc = Math.sqrt((wspolrzedneDO[1]-wspolrzedneOD[1])*(wspolrzedneDO[1]-wspolrzedneOD[1])-(wspolrzedneDO[0]-wspolrzedneOD[0])*(wspolrzedneDO[0]-wspolrzedneOD[0]));
        if(wspolrzedneDO == wspolrzedneOD){
            return 0.0;
        }
        else{
            return odleglosc;
        }

    }
    /*@Override
    public void RuchomyTekst(JLabel ruchomyTekst){
        String[] ruchomyTekstString = "K A L K U L A T O R   P A L I W A".split(" ");
        for (int i=0;i<18;i++){
            System.out.println(ruchomyTekstString[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/
}
