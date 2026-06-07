//Raihan Akbar
//Sistem Informasi





public abstract class menuItem {

    private String nama;
    private double harga;
    private String kategori;

    public menuItem(String nama, double harga, String kategori) {
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public String getKategori() {
        return kategori;
    }

    public abstract void tampilMenu();
    
}
