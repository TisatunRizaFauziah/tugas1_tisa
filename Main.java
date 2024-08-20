import java.util.ArrayList;
import java.util.Scanner;

class Mahasiswa {
    String nama;
    int nilai;
    String grade;

    public Mahasiswa(String nama, int nilai) {
        this.nama = nama;
        this.nilai = nilai;
        this.grade = hitungGrade(nilai);
    }

    public String hitungGrade(int nilai) {
        if (nilai >= 85 && nilai <= 100) {
            return "A";
        } else if (nilai >= 70 && nilai < 85) {
            return "B";
        } else if (nilai >= 55 && nilai < 70) {
            return "C";
        } else if (nilai >= 40 && nilai < 55) {
            return "D";
        } else {
            return "E";
        }
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Nilai: " + nilai + ", Grade: " + grade;
    }
}

public class Main {
    private static ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== Menu Data Nilai Mata Kuliah Perpajakan ===");
            System.out.println("1. Tambah data mahasiswa");
            System.out.println("2. Update data mahasiswa");
            System.out.println("3. Delete data mahasiswa (berdasarkan nama)");
            System.out.println("4. Lihat semua data mahasiswa");
            System.out.println("5. Cari data mahasiswa berdasarkan nama");
            System.out.println("6. Keluar dari program");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer input

            switch (pilihan) {
                case 1:
                    tambah();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    hapus();
                    break;
                case 4:
                    tampilkanSemua();
                    break;
                case 5:
                    cari();
                    break;
                case 6:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 6);
    }

    private static void tambah() {
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
    
        // Cek apakah nama sudah ada di dataMahasiswa
        for (Mahasiswa mhs : dataMahasiswa) {
            if (mhs.nama.equalsIgnoreCase(nama)) {
                System.out.println("Mahasiswa dengan nama " + nama + " sudah ada, tidak dapat menambahkan data.");
                return;
            }
        }
    
        System.out.print("Nilai : ");
        int nilai = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer input
    
        dataMahasiswa.add(new Mahasiswa(nama,nilai));
        System.out.println("Data mahasiswa berhasil ditambahkan.");
    }
    

    private static void update() {
        System.out.print("Masukkan nama mahasiswa yang ingin diupdate: ");
        String nama = scanner.nextLine();

        for (Mahasiswa mhs : dataMahasiswa) {
            if (mhs.nama.equalsIgnoreCase(nama)) {
                System.out.print(" nilai baru: ");
                int nilaiBaru = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer input

                mhs.nilai = nilaiBaru;
                mhs.grade = mhs.hitungGrade(nilaiBaru);

                System.out.println("Data mahasiswa berhasil diupdate.");
                return;
            }
        }
        System.out.println("Mahasiswa dengan nama " + nama + " tidak ditemukan.");
    }

    private static void hapus() {
        System.out.print("Masukkan nama mahasiswa yang ingin dihapus: ");
        String nama = scanner.nextLine();

        for (int i = 0; i < dataMahasiswa.size(); i++) {
            if (dataMahasiswa.get(i).nama.equalsIgnoreCase(nama)) {
                dataMahasiswa.remove(i);
                System.out.println("Data mahasiswa berhasil dihapus.");
                return;
            }
        }
        System.out.println("Mahasiswa dengan nama " + nama + " tidak ditemukan.");
    }

    private static void tampilkanSemua() {
        if (dataMahasiswa.isEmpty()) {
            System.out.println("Belum ada data mahasiswa.");
        } else {
            for (Mahasiswa mhs : dataMahasiswa) {
                System.out.println(mhs);
            }
        }
    }

    private static void cari() {
        System.out.print("Masukkan nama mahasiswa yang ingin dicari: ");
        String nama = scanner.nextLine();

        for (Mahasiswa mhs : dataMahasiswa) {
            if (mhs.nama.equalsIgnoreCase(nama)) {
                System.out.println(mhs);
                return;
            }
        }
        System.out.println("Mahasiswa dengan nama " + nama + " tidak ditemukan.");
    }
}
