//Nama : Raihan Akbar
//Prodi: Sistem Informasi


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class fileMenu {
    public static void simpanMenu(menu menunya) {
        try {
            BufferedWriter bw = new BufferedWriter(
                new FileWriter("menu.txt")
            );

            for(menuItem item : menunya.getDaftarMenu()) {
                if(item instanceof makanan) {
                    makanan m = (makanan) item;
                    bw.write(
                        "Makanan" +
                        m.getNama() + ", " +
                        m.getHarga() + ", " +
                        m.getJenisMakanan()
                    );
                }

                else if(item instanceof  minuman) {
                    minuman m = (minuman) item;
                    bw.write(
                        "Minuman" +
                        m.getNama() + ", " +
                        m.getHarga() + ", " +
                        m.getJenisMinuman()
                    );
                }

                else if(item instanceof  diskon) {
                    diskon d = (diskon) item;
                    bw.write(
                        "Diskon" +
                        d.getNama() + ", " +
                        d.getDiskon()
                    );
                }

                bw.newLine();
            }
            
            bw.close();

        } catch (IOException e) {
            System.out.println(" Gagal Menyimpan Menu");
        }
    }

    public static void muatMenu(menu menunya) {
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("menu.txt")
            );

            String baris;

            while((baris = br.readLine()) != null) {
                String[] data = baris.split(" , ");

                if(data[0].equals("Makanan")) {
                    menunya.tambahMenu(
                        new makanan(
                            data[1], 
                            Double.parseDouble(data[2]), 
                            data[3])
                    );
                }

                else if(data[0].equals("Minuman")) {
                    menunya.tambahMenu(
                        new minuman(
                            data[1],
                            Double.parseDouble(data[2]),
                            data[3]
                        )
                    );
                }

                else if(data[0].equals("Diskon")) {
                    menunya.tambahMenu(
                        new diskon(data[1],
                        Double.parseDouble(data[2]))
                    );
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println(" File Menu Belum ada");
        }
    }
}
