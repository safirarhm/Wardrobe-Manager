/* FINAL PROJECT ASD
*  WARDROBE MANAGER - 2 SORTING
*  NAMA : ANTIKE RAHMA SAFIRA
*  NIM : 235150707111009
*  KELAS : TEKNOLOGI INFORMASI - D */

import java.util.ArrayList;
import java.util.Scanner;

public class wardrobeManager {
    private ArrayList<Clothing> wardrobe;

    public wardrobeManager() {
        wardrobe = new ArrayList<>();
    }

    // Metode Bubble Sort
    public void bubbleSort(int criteria) {
        int n = wardrobe.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shouldSwap(wardrobe.get(j), wardrobe.get(j + 1), criteria)) {
                    Clothing temp = wardrobe.get(j);
                    wardrobe.set(j, wardrobe.get(j + 1));
                    wardrobe.set(j + 1, temp);
                }
            }
        }
    }

    // Metode Selection Sort
    public void selectionSort(int criteria) {
        int n = wardrobe.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (shouldSwap(wardrobe.get(minIdx), wardrobe.get(j), criteria)) {
                    minIdx = j;
                }
            }
            Clothing temp = wardrobe.get(minIdx);
            wardrobe.set(minIdx, wardrobe.get(i));
            wardrobe.set(i, temp);
        }
    }

    private boolean shouldSwap(Clothing item1, Clothing item2, int criteria) {
        switch (criteria) {
            case 1: // Sort by Color
                return item1.color.compareTo(item2.color) > 0;
            case 2: // Sort by Category
                return item1.category.compareTo(item2.category) > 0;
            case 3: // Sort by Times Worn (descending)
                return item1.timesWorn < item2.timesWorn;
            case 4: // Sort by Season
                return item1.season.compareTo(item2.season) > 0;
            default:
                return false;
        }
    }

    // Metode untuk melakukan sorting berdasarkan kriteria yang dipilih
    public void sortWardrobe(int criteria) {
        if (wardrobe.isEmpty()) {
            System.out.println("Wardrobe kosong! Tidak bisa melakukan sorting.");
            return;
        }

        // Memilih metode sorting secara otomatis berdasarkan kriteria
        switch (criteria) {
            case 1: // Warna - menggunakan Bubble Sort
                bubbleSort(criteria);
                System.out.println("Sorting warna dengan Bubble Sort selesai!");
                break;
            case 2: // Kategori - menggunakan Selection Sort
                selectionSort(criteria);
                System.out.println("Sorting kategori dengan Selection Sort selesai!");
                break;
            case 3: // Frekuensi Pemakaian - menggunakan Selection Sort
                selectionSort(criteria);
                System.out.println("Sorting frekuensi pemakaian dengan Selection Sort selesai!");
                break;
            case 4: // Musim - menggunakan Selection Sort
                selectionSort(criteria);
                System.out.println("Sorting musim dengan Selection Sort selesai!");
                break;
            default:
                System.out.println("Kriteria sorting tidak valid!");
                return;
        }
        displayWardrobe();
    }

    public void displayWardrobe() {
        if (wardrobe.isEmpty()) {
            System.out.println("Wardrobe kosong!");
            return;
        }
        System.out.println("\nDaftar Pakaian:");
        for (Clothing item : wardrobe) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        wardrobeManager manager = new wardrobeManager();

        while (true) {
            System.out.println("\n=== Wardrobe Manager ===");
            System.out.println("1. Tambah Pakaian");
            System.out.println("2. Lihat Semua Pakaian");
            System.out.println("3. Sort Pakaian");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Masukkan warna: ");
                    String color = scanner.nextLine();

                    System.out.print("Masukkan kategori (Atasan/Bawahan/Dress): ");
                    String category = scanner.nextLine();

                    System.out.print("Masukkan berapa kali dipakai: ");
                    int timesWorn = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer

                    System.out.print("Masukkan musim (Spring/Summer/Fall/Winter): ");
                    String season = scanner.nextLine();

                    Clothing newClothing = new Clothing(color, category, timesWorn, season);
                    manager.wardrobe.add(newClothing);
                    System.out.println("Pakaian berhasil ditambahkan!");
                    break;

                case 2:
                    manager.displayWardrobe();
                    break;

                case 3:
                    System.out.println("\nSort berdasarkan:");
                    System.out.println("1. Warna");
                    System.out.println("2. Kategori");
                    System.out.println("3. Frekuensi Pemakaian");
                    System.out.println("4. Musim");
                    System.out.print("Pilihan kriteria: ");
                    int sortCriteria = scanner.nextInt();

                    manager.sortWardrobe(sortCriteria);
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan Wardrobe Manager!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}

class Clothing {
    String color;
    String category;
    int timesWorn;
    String season;

    public Clothing(String color, String category, int timesWorn, String season) {
        this.color = color;
        this.category = category;
        this.timesWorn = timesWorn;
        this.season = season;
    }

    @Override
    public String toString() {
        return String.format("Warna: %s | Kategori: %s | Dipakai: %d kali | Musim: %s",
                color, category, timesWorn, season);
    }
}