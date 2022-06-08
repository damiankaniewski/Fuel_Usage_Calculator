package fc;

import java.io.IOException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import fc.exceptions.*;
import fc.priceprovider.PriceProvider;

import fc.functions.Function;

public class KalkulatorPaliwa extends JFrame {

    private static KalkulatorPaliwa mForm;

    private JButton obliczButton;
    private JButton ZresetujButton;
    private JButton wyjdzButton;
    private JTextField spalanieText;
    private JTextField dlugosctrasyText;
    private JTextField kosztpaliwaText;
    private JSpinner liczbaosob;
    private JTextField kosztjednaosobaText;
    private JTextField kosztpaliwawynikText;
    private JPanel mainPanel;
    private JTextField dodatkowekoszty;
    private JLabel cenaON;
    private JLabel cenaONplus;
    private JLabel cena95;
    private JLabel cena98;
    private JLabel cenaLPG;
    private JButton wybierzON;
    private JButton wybierzONplus;
    private JButton wybierz95;
    private JButton wybierz98;
    private JButton wybierzLPG;
    private JLabel warning;
    private JList miastaOD;
    private JList miastaDO;
    private JLabel miastaOD_text;
    private JLabel miastaDO_text;
    private JButton oblicz_trase;
    private JButton podwojTrase;
    private JButton podzielTrase;

    double[] wspolrzedneOD;
    double[] wspolrzedneDO;

    public KalkulatorPaliwa() throws IOException {

        spalanieText.setText(null);
        dlugosctrasyText.setText(null);
        kosztpaliwaText.setText(null);
        kosztjednaosobaText.setText("0,00 zl");
        kosztpaliwawynikText.setText("0,00 zl");
        dodatkowekoszty.setText("0");
        warning.setText(null);

        PriceProvider priceProvider = new PriceProvider();
        priceProvider.PriceProvider();

        cenaON.setText(priceProvider.cenaON[0] + " zl");
        cenaONplus.setText(priceProvider.cenaONplus[0] + " zl");
        cena95.setText(priceProvider.cena95[0] + " zl");
        cena98.setText(priceProvider.cena98[0] + " zl");
        cenaLPG.setText(priceProvider.cenaLPG[0] + " zl");


        miastaOD.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Function function = new Function();
                String SelectedCity = (String) miastaOD.getSelectedValue();
                if (SelectedCity == "---WYCZYSC---")
                    miastaOD_text.setText(null);
                else {
                    miastaOD_text.setText(SelectedCity);
                    wspolrzedneOD = function.wspolrzedneOD(SelectedCity);
                }


            }
        });
        miastaDO.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Function function = new Function();
                String SelectedCity = (String) miastaDO.getSelectedValue();
                if (SelectedCity == "---WYCZYSC---")
                    miastaDO_text.setText(null);
                else {
                    miastaDO_text.setText(SelectedCity);
                    wspolrzedneDO = function.wspolrzedneDO(SelectedCity);
                }


            }
        });
        oblicz_trase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Function function = new Function();
                try {

                    if (miastaDO.getSelectedValue() == null || miastaOD.getSelectedValue() == null)
                        throw new EmptyRouteException();
                    double odleglosc = function.obliczOdleglosc(wspolrzedneOD, wspolrzedneDO);
                    if (miastaDO.getSelectedValue() == "---WYCZYSC---" || miastaOD.getSelectedValue() == "---WYCZYSC---" || miastaOD.getSelectedValue() == null || miastaDO.getSelectedValue() == null) {
                        dlugosctrasyText.setText(null);
                    } else {
                        dlugosctrasyText.setText(String.format("%.2f", odleglosc));
                    }
                } catch (Exception ex) {

                }


            }
        });
        podwojTrase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double odlegloscpodwojona = 2 * Double.parseDouble(dlugosctrasyText.getText().replaceAll(",", "."));
                dlugosctrasyText.setText(String.format("%.2f", odlegloscpodwojona));
            }
        });
        podzielTrase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double odlegloscpodzielona = (0.5) * Double.parseDouble(dlugosctrasyText.getText().replaceAll(",", "."));
                dlugosctrasyText.setText(String.format("%.2f", odlegloscpodzielona));
            }
        });

        wyjdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        ZresetujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                spalanieText.setText(null);
                dlugosctrasyText.setText(null);
                kosztpaliwaText.setText(null);
                kosztjednaosobaText.setText(null);
                kosztpaliwawynikText.setText(null);
                dodatkowekoszty.setText("0");
                warning.setText(null);
                kosztpaliwawynikText.setText("0,00 zl");
                kosztjednaosobaText.setText("0,00 zl");
            }
        });

        liczbaosob.setModel(new SpinnerNumberModel(1, 1, 50, 1));

        obliczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Function function = new Function();

                try {
                    if (spalanieText.getText().isEmpty() || dlugosctrasyText.getText().isEmpty() || kosztpaliwaText.getText().isEmpty()) {
                        warning.setText("Podaj wartosci!");
                        kosztpaliwawynikText.setText("0,00 zl");
                        kosztjednaosobaText.setText("0,00 zl");
                        throw new EmptyFieldException();
                    } else {
                        warning.setText(null);
                    }
                    double spalanie = Double.parseDouble(spalanieText.getText().replaceAll(",", "."));
                    double dlugosctrasy = Double.parseDouble(dlugosctrasyText.getText().replaceAll(",", "."));
                    double kosztpaliwa = Double.parseDouble(kosztpaliwaText.getText().replaceAll(",", "."));
                    double dodatkoweKoszty = Double.parseDouble(dodatkowekoszty.getText().replaceAll(",", "."));
                    int osoby = (int) liczbaosob.getValue();

                    double kosztPrzejazd = function.KosztPaliwaWynik(spalanie, dlugosctrasy, kosztpaliwa) + dodatkoweKoszty;
                    double kosztOsoby = function.KosztJednaosoba(osoby, spalanie, dlugosctrasy, kosztpaliwa) + dodatkoweKoszty / osoby;

                    kosztpaliwawynikText.setText(String.format("%.2f", kosztPrzejazd) + " zl");
                    kosztjednaosobaText.setText(String.format("%.2f", kosztOsoby) + " zl");

                } catch (EmptyFieldException ex) {
                }

            }
        });
        wybierz95.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kosztpaliwaText.setText(priceProvider.cena95[0]);
            }
        });
        wybierz98.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kosztpaliwaText.setText(priceProvider.cena98[0]);
            }
        });
        wybierzON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kosztpaliwaText.setText(priceProvider.cenaON[0]);
            }
        });
        wybierzONplus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kosztpaliwaText.setText(priceProvider.cenaONplus[0]);
            }
        });
        wybierzLPG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kosztpaliwaText.setText(priceProvider.cenaLPG[0]);
            }
        });
    }

    public static void main(String[] args) throws IOException {

        JFrame mainFrame = new JFrame("Kalkulator Spalania Paliwa");
        mForm = new KalkulatorPaliwa();
        JFrame.setDefaultLookAndFeelDecorated(true);

        mainFrame.setContentPane(mForm.mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}