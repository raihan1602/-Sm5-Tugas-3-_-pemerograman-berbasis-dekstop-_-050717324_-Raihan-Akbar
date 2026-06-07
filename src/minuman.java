//Nama : Raihan Akbar
//Prodi: Sistem Informasi


public class minuman extends menuItem {

    private String jenisMinuman;

    public minuman(String nama, double harga, String jenisMinuman) {
        super(nama, harga, "Minuman");
        this.jenisMinuman = jenisMinuman;
    }

    public String getJenisMinuman() {
        return jenisMinuman;
    }

    @Override

    public void tampilMenu() {
        System.out.println(
            getNama() + " | Rp." + getHarga() + " | " + jenisMinuman
        );
    }
    
}
