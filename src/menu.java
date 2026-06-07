//Nama : Raihan Akbar
//Prodi: Sistem Informasi


import java.util.ArrayList;

public class menu {
    

    private ArrayList<menuItem> daftarMenu;

    public menu() {
        daftarMenu = new ArrayList<>();
    }

    public void tambahMenu(menuItem item) {
        daftarMenu.add(item);
    }

    public void tampilkanSemua() {
        if(daftarMenu.isEmpty()) {
            System.out.println(" Menu Masiih Kosong");
            return;
        }

        for(int i = 0; i < daftarMenu.size(); i++) {
            System.out.print((i + 1) + ", ");
            daftarMenu.get(i).tampilMenu();
        }
    }

    public menuItem getMenu(int index) throws menuTidakAda {
        if(index < 0 || index >= daftarMenu.size()) {
            throw new menuTidakAda(" Menu Tidak Ditemukan");
        }
        return daftarMenu.get(index);
    }

    public ArrayList<menuItem> getDaftarMenu() {
        return daftarMenu;
    }
}
