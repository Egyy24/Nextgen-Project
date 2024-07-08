package LOGIN;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;

public class FXMLSearchbarController {
    private List<Destinasi> listDestinasi = new ArrayList<>();

    @FXML
    private void loadDestinasi() {
        listDestinasi.add(new Destinasi(
            "Jalan Malioboro",
            "Sosromenduran, Gedong Tengen, Kota Yogyakarta, Daerah Istimewa Yogyakarta",
            "/AppProto/ImageSRC/Malioboro1.jpg",
            "Malioboro merupakan nama salah satu jalan di pusat Kota Yogyakarta. Jalan Malioboro itu sendiri merupakan salah satu jalan dari tiga jalan di Kota Yogyakarta yang membentang dari Tugu Yogyakarta hingga ke perempatan Kantor Pos Yogyakarta. Secara keseluruhan terdiri dari Jalan Pangeran Mangkubumi, Jalan Malioboro, dan Jalan Jend. A. Yani. Jalan Malioboro merupakan poros Garis Imajiner Kraton Yogyakarta.",
            "24 Jam"
        ));
        listDestinasi.add(new Destinasi(
            "Pantai Parangtritis",
            "Parangtritis, Kretek, Bantul Regency, Special Region of Yogyakarta",
            ".jpg",
            "Pantai Parangtritis adalah tempat wisata yang terletak di Desa Parangtritis, Kecamatan Kretek, Kabupaten Bantul, Daerah Istimewa Yogyakarta. Jaraknya kurang lebih 27 km dari pusat Kota Yogyakarta. Pantai ini terkenal dengan pemandangan matahari terbenamnya yang indah dan aktivitas wisata seperti naik delman atau motor ATV di sepanjang pantai.",
            "06.00 - 17.00 WIB"
        ));
        listDestinasi.add(new Destinasi(
            "Puncak Mangunan",
            "Jl. Imogiri - Dlingo, Bantul",
            "/AppProto/ImageSRC/Mangunan1.jpg",
            "Kebun Buah Mangunan di Bantul, Yogyakarta, menawarkan pesona alam yang memukau dengan kebun-kebun buah yang teratur di lereng perbukitan. Pengunjung dapat menikmati panorama indah perbukitan dan sawah hijau, serta menikmati suasana sejuk dari hutan pinus di sekitarnya. Tempat ini juga terkenal dengan spot-spot foto yang menarik dan menyediakan berbagai buah segar langsung dari kebunnya.",
            "05.00 - 18.00 WIB"
        ));
    }

    public static void main(String[] args) {
        FXMLSearchbarController app = new FXMLSearchbarController();
        app.loadDestinasi();
        
        // Output the list of destinations
        for (Destinasi destinasi : app.listDestinasi) {
            System.out.println("Nama: " + destinasi.getNama());
            System.out.println("Alamat: " + destinasi.getAlamat());
            System.out.println("Gambar Path: " + destinasi.getGambarPath());
            System.out.println("Deskripsi: " + destinasi.getDeskripsi());
            System.out.println("Jam Operasional: " + destinasi.getJamOperasional());
            System.out.println();
        }
    }
}
