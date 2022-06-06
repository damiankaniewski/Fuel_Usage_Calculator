package fc.priceprovider;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class PriceProvider implements IPriceProvider {
    public String[] cena95;
    public String[] cena98;
    public String[] cenaON;
    public String[] cenaONplus;
    public String[] cenaLPG;

    @Override
    public void PriceProvider() throws IOException {
        Connection connect = Jsoup.connect("https://www.autocentrum.pl/paliwa/ceny-paliw/malopolskie/");
        Document document = connect.get();
        cena95 = document.select("div.content-col > div.part-wrapper.petrol-station-wrapper > div > a.station-detail-wrapper.pb.text-center.active > div").text().replaceAll(",", ".").split(" ");
        cena98 = document.select("div.content-col > div.part-wrapper.petrol-station-wrapper > div > a.station-detail-wrapper.pbp.text-center.active > div").text().replaceAll(",", ".").split(" ");
        cenaON = document.select("div.content-col > div.part-wrapper.petrol-station-wrapper > div > a.station-detail-wrapper.on.text-center.active > div").text().replaceAll(",", ".").split(" ");
        cenaONplus = document.select("div.content-col > div.part-wrapper.petrol-station-wrapper > div > a.station-detail-wrapper.onp.text-center.active > div").text().replaceAll(",", ".").split(" ");
        cenaLPG = document.select("div.content-col > div.part-wrapper.petrol-station-wrapper > div > a.station-detail-wrapper.lpg.text-center.active > div").text().replaceAll(",", ".").split(" ");
    }
}