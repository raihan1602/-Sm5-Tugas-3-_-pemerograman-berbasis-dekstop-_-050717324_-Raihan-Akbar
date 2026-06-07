//Nama : Raihan Akbar
//Prodi: Sistem Informasi


import java.util.Scanner;

public class main {
    
    static void spasi() {
        System.out.println("\n");
        
    }

    static final String passwd = "elpidatoblunder";

    public static boolean loginAdmin(Scanner input) {
        int percobaan = 0;

        while(percobaan < 3) {
            System.out.print(" Masukkan Password : ");
            String pass = input.nextLine();

            if(pass.equals(passwd)) {
                return true;
            }

            percobaan++;
            System.out.println(" Password salah sisa percobaam : " +
            (3 -percobaan));
        }

        return false;
    }

    static double diskonini = 10;


    public static void main(String[] args) {
        

        Scanner input = new Scanner(System.in);

        menu menunya = new menu();

        fileMenu.muatMenu(menunya);

        if(menunya.getDaftarMenu().isEmpty()) {
            menunya.tambahMenu(new makanan(
                "Nasgor Goreng", 
                17000, 
                "Nasgor Kuadrat"));
                menunya.tambahMenu(new makanan(
                "Bakso Nuklir", 
                20000, 
                "Kuah"));
                menunya.tambahMenu(new makanan(
                "Mie Kuah Goreng", 
                15000, 
                "Setengan Campur"));

                menunya.tambahMenu(new minuman(
                "Es Teh Panas", 
                7000, 
                "Panas Dingin"));
                menunya.tambahMenu(new minuman(
                "Kopi Hitam Putih", 
                8000, 
                "Panas"));
                menunya.tambahMenu(new minuman(
                "Air Normal", 
                5000, 
                "Normal"));
        }

        pesanan pesananya = new pesanan();
        int pilihan;

        do { 
            

            spasi();
            System.out.println(">>>     SISTEM RESTORAN     <<<");
            System.out.println();

            System.out.println(" 1. Tambah Menu");
            System.out.println();

            System.out.println(" 2. Lihat Menu & Pesan");
            System.out.println();

            System.out.println(" 3. Hitung Total");
            System.out.println();

            System.out.println(" 4. Tampilkan Struk");
            System.out.println();

            System.out.println(" 5. Simpan Struk");
            System.out.println();

            System.out.println(" 6. Keluar <<<");
            System.out.println();

            System.out.print(" Pilih Aksi : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                if(!loginAdmin(input)) {
                    System.out.println(" Tidak bisa masuk ygy ");
                    break;
                }

                System.out.println();
                System.out.println(" 1. Makanan");
                System.out.println(" 2. Minuman");
                System.out.println(" 3. Ubah Diskon");
                System.out.println(" 0. Kembali");
                System.out.println();

                System.out.print(" Pilih Jenis : ");
                int jenis = input.nextInt();
                input.nextLine();

                if(jenis == 0) {
                    break;
                }

                if(jenis == 3) {
                    System.out.println(" Diskon saat ini " + 
                    diskonini + "%");

                    System.out.print(" Masukkan Diskon Baru : ");
                    diskonini = input.nextDouble();
                    input.nextLine();

                    pesananya.setDiskonMahasigma(diskonini);

                    System.out.println(" Diskon berhasil Di UBAH menjadi : " +
                    diskonini + "%");

                    break;
                }
                
                System.out.print(" Nama : ");
                String nama = input.nextLine();

                if(jenis == 1) {
                    System.out.print(" Harga : ");
                    double harga = input.nextDouble();
                    input.nextLine();

                    System.out.print(" Jenis Makanan : ");
                    String jm = input.nextLine();

                    menunya.tambahMenu(new makanan(nama, harga, jm));
                    System.out.println(" Menu Berhasil Ditambahkan");
                }

                else if(jenis == 2) {
                    System.out.print(" Harga : ");
                    double harga = input.nextDouble();
                    input.nextLine();

                    System.out.print(" Jenis Minuman : ");
                    String jmn = input.nextLine();

                    menunya.tambahMenu(new minuman(nama, harga, jmn));
                    System.out.println(" Menu Berhasil Ditambahkan");
                }

                else{
                    System.out.println(" Pilihan Tidak Valid");
                }

                break;

                case 2:
                spasi();
                menunya.tampilkanSemua();

                System.out.println();
                System.out.println(" 0 Untuk Membatalkan ");
                System.out.println();
                System.out.println(" Pilih Nomor Menu Untuk Memesan");
                System.out.print(" Masukkan Nomor Menu : ");
                int nomor = input.nextInt();

                if(nomor != 0) {
                    try {
                        pesananya.tambahPesanan(menunya.getMenu(nomor - 1));
                        System.out.println(" Pesanan Berhasil ditambahkan");
                    }

                    catch(menuTidakAda e) {
                        System.out.println(" Menu Tidak ada");
                    }

                }
                break;

                case 3:
                System.out.println();
                System.out.println(" Apakah Anda Mahasiga ?");
                System.out.print(" Ya / Tidak : ");
                String sigma = input.nextLine();

                pesananya.setMahasigma(sigma.equalsIgnoreCase("ya"));
                pesananya.setDiskonMahasigma(diskonini);

                System.out.println(" TOTAL : Rp." +
                pesananya.hitungTotal());

                break;

                case 4:
                pesananya.tampilkanStruk();
                break;

                case 5:
                fileStruk.simpanStruk(pesananya);

                case 6:
                fileMenu.simpanMenu(menunya);
                System.out.println(" Data Berhasil Disimpan ");
                System.out.println();
                System.out.println(" Sekian Tugas Saya kali ini");
                System.out.println(">>> TERIMAKASIH  <<<");

                break;
                default:
                System.out.println(" Pesanan Tidak Valid");
            }
        } while (pilihan != 6);
    }
}
