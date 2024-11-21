import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try { 
                System.out.println("\n=== Input Data Transaksi ===\n");
                System.out.print("Masukkan No Faktur: ");
                String noFaktur = scanner.nextLine().trim();
                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine().trim();
                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine().trim();

                int hargaBarang = 0; 
                while (true) {
                    try { // Exception Handling, try-catch
                        System.out.print("Masukkan Harga Barang: ");
                        hargaBarang = Integer.parseInt(scanner.nextLine().trim()); 
                        if (hargaBarang <= 0) throw new IllegalArgumentException("Harga barang harus lebih besar dari 0.");// Validasi Konstruktor, Exception Handling
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Terjadi kesalahan di bagian harga barang: Input tidak valid.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Terjadi kesalahan di bagian harga barang: " + e.getMessage());
                    }
                }

                int jumlahBeli = 0;
                while (true) {
                    try { // Exception Handling, try-catch
                        System.out.print("Masukkan Jumlah Beli: ");
                        jumlahBeli = Integer.parseInt(scanner.nextLine().trim());
                        if (jumlahBeli <= 0) throw new IllegalArgumentException("Jumlah beli harus lebih besar dari 0.");// Validasi Konstruktor, Exception Handling
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Terjadi kesalahan di bagian jumlah beli: Input tidak valid.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Terjadi kesalahan di bagian jumlah beli: " + e.getMessage());
                    }
                }

                // Membuat objek Transaksi dan menghitung total
                Transaksi transaksi = new Transaksi(kodeBarang, namaBarang, hargaBarang, noFaktur, jumlahBeli); // Sesuaikan konstruktor
                transaksi.hitungTotal();

                // Menampilkan invoice
                System.out.println("\n--- Faktur Pembelian ---");
                System.out.println(transaksi.displayInvoice());

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }

            // Tanya ulang setelah input selesai
            System.out.print("\nApakah kamu ingin memasukkan data transaksi lain? (y/n): ");
            if (!konfirmasiUlang(scanner)) {
                System.out.println("Program berhasil diselesaikan. Terima kasih.");
                break;
            }
        }
        scanner.close();
    }

    private static boolean konfirmasiUlang(Scanner scanner) {
        while (true) {
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("y")) {
                return true;
            } else if (response.equals("n")) {
                return false;
            } else {
                System.out.print("Input tidak valid. Masukkan 'y' atau 'n': ");
            }
        }
    }
}
