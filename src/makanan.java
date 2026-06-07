//Nama : Raihan Akbar
//Prodi: Sistem Informasi


public class makanan extends menuItem {

    private String jenisMakanan;

    public makanan(String nama, double harga, String jenisMakanan) {
        super(nama, harga, "Makanan");
        this.jenisMakanan = jenisMakanan;
    }

    public String getJenisMakanan() {
        return jenisMakanan;
    }

    @Override

    public void tampilMenu() {
        System.out.println(
            getNama() + " | Rp." + getHarga() + " | " + jenisMakanan
        );
    }
    
}
