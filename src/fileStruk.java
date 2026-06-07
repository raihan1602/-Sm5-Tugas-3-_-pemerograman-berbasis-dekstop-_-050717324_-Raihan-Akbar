//Nama : Raihan Akbar
//Prodi: Sistem Informasi



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class fileStruk {
    
    public static void simpanStruk(pesanan pesanannya) {
        try {
            BufferedWriter bw = new BufferedWriter(
                new FileWriter("struk.txt")
            );

            bw.write(">>>     STRUK    <<<");
            bw.newLine();

            for(menuItem item : pesanannya.getDaftarPesanan()) {
                bw.write(
                    item.getNama() +
                    " - Rp. " +
                    item.getHarga()
                );

                bw.newLine();
            } 

            bw.write("---------------------------------------------");
            bw.newLine();
            bw.write(
                "TOTAL : Rp. " + pesanannya.hitungTotal()
            );

            bw.close();
            System.out.println(" Struk Berhasil disimpan");
        } catch (IOException e) {
            System.out.println(" GAGAL Menyimpan Struk");
        }
    }
}
