import java.util.Scanner;

public class jobsheet13 {

    // Array untuk menyimpan data prestasi
    static String[][] prestasiMahasiswa = new String[100][5];
    static int jumlahData = 0;

    // Fungsi untuk menampilkan menu utama
    public static void tampilkanMenu() {
        System.out.println("\n==== MENU UTAMA ====");
        System.out.println("1. Tambah Prestasi Mahasiswa");
        System.out.println("2. Tampilkan Semua Prestasi");
        System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
        System.out.println("4. Keluar");
        System.out.println("=====================");
        System.out.print("Pilih menu: ");
    }

    // Fungsi untuk menambahkan data prestasi mahasiswa
    public static void tambahPrestasi(Scanner scanner) {
        if (jumlahData >= prestasiMahasiswa.length) {
            System.out.println("Kapasitas data sudah penuh! Tidak dapat menambahkan lagi.");
        } else {
            System.out.print("Masukkan Nama Mahasiswa: ");
            prestasiMahasiswa[jumlahData][0] = scanner.nextLine();

            System.out.print("Masukkan NIM: ");
            prestasiMahasiswa[jumlahData][1] = scanner.nextLine();

            System.out.print("Masukkan Jenis Prestasi (misal: Juara 1, Juara Harapan): ");
            prestasiMahasiswa[jumlahData][2] = scanner.nextLine();

            System.out.print("Masukkan Tingkat Prestasi (Lokal, Nasional, Internasional): ");
            prestasiMahasiswa[jumlahData][3] = scanner.nextLine();
            while (!prestasiMahasiswa[jumlahData][3].equalsIgnoreCase("Lokal") &&
                    !prestasiMahasiswa[jumlahData][3].equalsIgnoreCase("Nasional") &&
                    !prestasiMahasiswa[jumlahData][3].equalsIgnoreCase("Internasional")) {
                System.out.println("Tingkat prestasi hanya bisa Lokal, Nasional, atau Internasional.");
                System.out.print("Masukkan Tingkat Prestasi: ");
                prestasiMahasiswa[jumlahData][3] = scanner.nextLine();
            }

            System.out.print("Masukkan Tahun Prestasi (2010 - " + java.time.Year.now() + "): ");
            int tahunPrestasi = scanner.nextInt();
            while (tahunPrestasi < 2010 || tahunPrestasi > java.time.Year.now().getValue()) {
                System.out.println("Tahun prestasi harus antara 2010 dan " + java.time.Year.now() + ".");
                System.out.print("Masukkan Tahun Prestasi: ");
                tahunPrestasi = scanner.nextInt();
            }
            scanner.nextLine(); // Membersihkan buffer
            prestasiMahasiswa[jumlahData][4] = String.valueOf(tahunPrestasi);

            jumlahData++;
            System.out.println("Prestasi berhasil ditambahkan!");
        }
    }

    // Fungsi untuk menampilkan semua data prestasi
    public static void tampilkanSemuaPrestasi() {
        if (jumlahData == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            System.out.println("\n==== DAFTAR PRESTASI ====");
            for (int i = 0; i < jumlahData; i++) {
                System.out.print("Nama: " + prestasiMahasiswa[i][0]);
                System.out.print("\nNIM: " + prestasiMahasiswa[i][1] );
                System.out.print("\nJenis: " + prestasiMahasiswa[i][2]);
                System.out.print("\nTingkat: " + prestasiMahasiswa[i][3]);
                System.out.print("\nTahun: " + prestasiMahasiswa[i][4]);
            }
        }
    }

    // Fungsi untuk menganalisis prestasi berdasarkan jenis
    public static void analisisPrestasi(Scanner scanner) {
        System.out.print("Masukkan jenis prestasi yang ingin dianalisis: ");
        String jenisDicari = scanner.nextLine();
        boolean ditemukan = false;

        System.out.println("\nPrestasi dengan jenis '" + jenisDicari + "':");
        for (int i = 0; i < jumlahData; i++) {
            if (prestasiMahasiswa[i][2].equalsIgnoreCase(jenisDicari)) {
                System.out.println("Nama: " + prestasiMahasiswa[i][0] +
                        ", NIM: " + prestasiMahasiswa[i][1] +
                        ", Tingkat: " + prestasiMahasiswa[i][3] +
                        ", Tahun: " + prestasiMahasiswa[i][4]);
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
                    tampilkanSemuaPrestasi();
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
