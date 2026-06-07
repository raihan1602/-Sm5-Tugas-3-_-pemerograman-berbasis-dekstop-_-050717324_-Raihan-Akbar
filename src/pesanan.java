//Nama : Raihan Akbar
//Prodi: Sistem Informasi


import java.util.ArrayList;

public class pesanan {
    
    static void spasi() {
        System.out.println("\n");
    }

    private ArrayList<menuItem> daftarPesanan;

    public pesanan() {
        daftarPesanan = new ArrayList<>();
    }

    public void tambahPesanan(menuItem item) {
        daftarPesanan.add(item);
    }

    private boolean mahasigma = false;

    public void setMahasigma(boolean mahasigma) {
        this.mahasigma = mahasigma;
    }

    private double diskonMahasigma = 10;

    public void setDiskonMahasigma(double diskonMahasigma) {
        this.diskonMahasigma = diskonMahasigma;
    }

    public double hitungTotal() {
        double total = 0;

        for(menuItem item : daftarPesanan) {
            if(!(item instanceof diskon)) {
                total += item.getHarga();
            }
        }

        if(mahasigma) {
            total = total - (total * diskonMahasigma / 100);
        }

        return total;
    }

    public void tampilkanStruk() {

        spasi();

        System.out.println("=======================================");
        System.out.println(">>>         STRUK PEMBELIAN         <<<");
        System.out.println("=======================================");

        double subTotal = 0;

        for(menuItem item : daftarPesanan) {
            if(!(item instanceof diskon)) {
                System.out.printf("%-20s Rp.%,.0f\n",
                item.getNama(), item.getHarga());
                subTotal += item.getHarga();
            }
        }

        System.out.println("---------------------------------------");
        System.out.printf("%-20s Rp.%,.0f\n",
        "SubTotal" , subTotal);

        if(mahasigma) {
            System.out.printf("%-20s %.0f%%\n",
            "Diskon Mahasigma", diskonMahasigma);
        }

        System.out.println("---------------------------------------");
        System.out.printf("%-20s Rp.%,.0f\n", "TOTAL", hitungTotal());
        System.out.println("=======================================");
        System.out.println();
    }

    public ArrayList<menuItem> getDaftarPesanan() {
        return daftarPesanan;
    }
}
