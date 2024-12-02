import java.util.Scanner;
public class StudiKasus {
    static String[][] prestasiMhs = new String[25][5];
    static int jmlData = 0;

    public static void tampilkanMenu() {
        System.out.println("\n==== MENU UTAMA ====");
        System.out.println("1. Tambah Prestasi Mahasiswa");
        System.out.println("2. Tampilkan Semua Prestasi");
        System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
        System.out.println("4. Keluar");
        System.out.println("=====================");
        System.out.print("Pilih menu: ");
    }
    public static void tambahPrestasi(Scanner scanner) {
        if (jmlData >= prestasiMhs.length) {
            System.out.println("Kapasitas data sudah penuh! Tidak dapat menambahkan lagi.");
        } else {
            System.out.print("Masukkan Nama Mahasiswa: ");
            prestasiMhs[jmlData][0] = scanner.nextLine();

            System.out.print("Masukkan NIM: ");
            prestasiMhs[jmlData][1] = scanner.nextLine();

            System.out.print("Masukkan Jenis Prestasi (misal: Juara 1, Juara Harapan): ");
            prestasiMhs[jmlData][2] = scanner.nextLine();

            System.out.print("Masukkan Tingkat Prestasi (Lokal, Nasional, Internasional): ");
            prestasiMhs[jmlData][3] = scanner.nextLine();
            while (!prestasiMhs[jmlData][3].equalsIgnoreCase("Lokal") &&
                    !prestasiMhs[jmlData][3].equalsIgnoreCase("Nasional") &&
                    !prestasiMhs[jmlData][3].equalsIgnoreCase("Internasional")) {
                System.out.println("Tingkat prestasi hanya bisa Lokal, Nasional, atau Internasional.");
                System.out.print("Masukkan Tingkat Prestasi: ");
                prestasiMhs[jmlData][3] = scanner.nextLine();
            }

            System.out.print("Masukkan Tahun Prestasi (2010 - " + java.time.Year.now() + "): ");
            int tahunPrestasi = scanner.nextInt();
            while (tahunPrestasi < 2010 || tahunPrestasi > java.time.Year.now().getValue()) {
                System.out.println("Tahun prestasi harus antara 2010 dan " + java.time.Year.now() + ".");
                System.out.print("Masukkan Tahun Prestasi: ");
                tahunPrestasi = scanner.nextInt();
            }
            scanner.nextLine(); // Membersihkan buffer
            prestasiMhs[jmlData][4] = String.valueOf(tahunPrestasi);

            jmlData++;
            System.out.println("Prestasi berhasil ditambahkan!");
        }
    }

    public static void tampilPrestasi() {
        if (jmlData == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            System.out.println(" DAFTAR PRESTASI ");
            for (int i = 0; i < jmlData; i++) {
                System.out.println("Nama: " + prestasiMhs[i][0] + ", NIM: " + prestasiMhs[i][1] + ", Jenis: " + prestasiMhs[i][2] + ", Tingkat: " + prestasiMhs[i][3] + ", Tahun: " + prestasiMhs[i][4]);
            }
        }
    }

    public static void analisisPrestasi(Scanner scanner) {
        System.out.print("Masukkan jenis prestasi yang ingin dianalisis: ");
        String jenisDicari = scanner.nextLine();
        boolean ditemukan = false;

        System.out.println("\nPrestasi dengan jenis '" + jenisDicari + "':");
        for (int i = 0; i < jmlData; i++) {
            if (prestasiMhs[i][2].equalsIgnoreCase(jenisDicari)) {
                System.out.println("Nama: " + prestasiMhs[i][0] +
                        ", NIM: " + prestasiMhs[i][1] +
                        ", Tingkat: " + prestasiMhs[i][3] +
                        ", Tahun: " + prestasiMhs[i][4]);
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada data prestasi dengan jenis '" + jenisDicari + "'.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahPrestasi(scanner);
                    break;
                case 2:
                    tampilPrestasi();
                    break;
                case 3:
                    analisisPrestasi(scanner);
                    break;
                case 4:
                    System.out.println("Keluar dari program. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 4);

        scanner.close();
    }
}