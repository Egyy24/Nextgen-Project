package LOGIN;

public class Destinasi {
    private String nama;
    private String alamat;
    private String gambarPath;
    private String deskripsi;
    private String jamOperasional;

    // Constructor
    public Destinasi(String nama, String alamat, String gambarPath, String deskripsi, String jamOperasional) {
        this.nama = nama;
        this.alamat = alamat;
        this.gambarPath = gambarPath;
        this.deskripsi = deskripsi;
        this.jamOperasional = jamOperasional;
    }

    // Getter and Setter for nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter and Setter for alamat
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    // Getter and Setter for gambarPath
    public String getGambarPath() {
        return gambarPath;
    }

    public void setGambarPath(String gambarPath) {
        this.gambarPath = gambarPath;
    }

    // Getter and Setter for deskripsi
    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // Getter and Setter for jamOperasional
    public String getJamOperasional() {
        return jamOperasional;
    }

    public void setJamOperasional(String jamOperasional) {
        this.jamOperasional = jamOperasional;
    }
}
