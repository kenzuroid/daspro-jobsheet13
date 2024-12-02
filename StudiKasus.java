import java.util.Scanner;
public class StudiKasus {
    
    static void tambahPrestasi(String mahasiswa[][], int tahun[], int jumlahData){
        Scanner sc = new Scanner(System.in);
        boolean benar = true;
        if(jumlahData >= mahasiswa.length ){
            System.out.println("Data sudah penuh");
        }else{
            System.out.print("Masukkan Nama Mahasiswa: ");
            mahasiswa[jumlahData][0] = sc.nextLine();
            System.out.print("Masukkan NIM Mahasiswa: ");
            mahasiswa[jumlahData][1] = sc.nextLine();
            System.out.print("Masukkan Jenis Prestasi Mahasiswa: ");
            mahasiswa[jumlahData][2] = sc.nextLine();
            do { 
                System.out.print("Masukkan Tingkat Prestasi Mahasiswa (Lokal/Nasional/Internasional): ");
                mahasiswa[jumlahData][3] = sc.nextLine();
                if((mahasiswa[jumlahData][3].equals("Lokal")) || (mahasiswa[jumlahData][3].equals("Nasional"))  || (mahasiswa[jumlahData][3].equals("Internasional"))){
                    benar = false;
                }else{
                    System.out.println("Tingkat hanya Lokal/Nasional/Internasional!");
                    continue;
                }
            } while (benar);

            do { 
                System.out.print("Masukkan Tahun Prestasi Mahasiswa (2010 - 2024): ");
                tahun[jumlahData] = sc.nextInt();
                sc.nextLine();
                if(tahun[jumlahData] < 2010 || tahun[jumlahData] > 2024){
                    System.out.println("Input tidak valid!");
                    benar = true;
                    continue;
                }else{
                    benar = false;
                }
            } while (benar);


        }
    }

    static void tampilPrestasi(int jumlahData, int tahun[], String mahasiswa[][]){
        if ( tahun [1] == 0) {
            System.out.println("Belum ada data prestasi.");
        } else {
            System.out.println(" DAFTAR PRESTASI ");
            for (int i = 0; i < jumlahData; i++) {
                System.out.println("Nama: " + mahasiswa[i][0] + "| NIM: " + mahasiswa[i][1] + "| Jenis: " + mahasiswa[i][2] + "| Tingkat: " + mahasiswa[i][3] + "| Tahun: " + mahasiswa[i][4]);
            }
        }
    }

    static void pencarianPrestasi(String mahasiswa[][], int tahun[]){
        Scanner sc = new Scanner(System.in);

        String jenisPrestasi;
        System.out.print("Tampilkan jenis prestasi yang ingin dicari: ");
        jenisPrestasi = sc.nextLine();
        boolean ditemukan = false;

        System.out.print("Jenis prestasi " + jenisPrestasi + " : ");
        for (int i = 0; i <= mahasiswa.length; i++) {
            if (mahasiswa[i][2] == null) {
                break;
            } else if (mahasiswa[i][2].equalsIgnoreCase(jenisPrestasi)) {
                System.out.println("Nama: " + mahasiswa[i][0]);
                System.out.print("|NIM: " + mahasiswa[i][1]);
                System.out.print("|Tingkat: " + mahasiswa[i][3]);
                System.out.print("|Tahun: " + tahun[i]);
            }
            ditemukan = true;

            
        }
        if (!ditemukan) {
            System.out.print("Jenis prestasi yang anda cari  tidak ditemukan.");
        }

    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mahasiswa[][] = new String[25][4];
        int tahun[] = new int [25];
        int jumlahData = 0;
        int pilihan = 0;
        
        do { 
            System.out.println("\n\nMENU UTAMA");
            System.out.println("1. Tambah data prestasi");
            System.out.println("2. Tampilkan semua presatasi");
            System.out.println("3. Pencarian jenis prestasi");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 0:
                System.out.println("Keluar dari Program");
                break;
                case 1:
                tambahPrestasi(mahasiswa, tahun, jumlahData);
                jumlahData++;
                break;
                case 2:
                tampilPrestasi(jumlahData, tahun, mahasiswa);
                break;
                case 3:
                pencarianPrestasi(mahasiswa, tahun);
                break;
                default:
                System.out.println("Pilihan tidak valid");
                break;
            }
        } while (pilihan !=0 );    

    }
    
}