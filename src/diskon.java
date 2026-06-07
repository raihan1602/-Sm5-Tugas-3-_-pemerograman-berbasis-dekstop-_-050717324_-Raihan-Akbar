//Nama : Raihan Akbar
//Prodi: Sistem Informasi

public class diskon extends menuItem {

    private double diskonnya;

    public diskon(String nama, double diskon) {
        super(nama, 0, "Diskon");
        this.diskonnya = diskonnya;
    }

    public double getDiskon() {
        return diskonnya;
    }

    @Override

    public void tampilMenu() {
        System.out.println(
                getNama() + " | Diskon " + diskonnya + "%");
    }
}
