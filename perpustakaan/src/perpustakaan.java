import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class perpustakaan {

    public static boolean login(String noid, String password) {
        // ganti dengan logika atau database untuk validasi username dan password
        if (noid.equals("2201") && password.equals("12345")) {
            return true;
        } else if (noid.equals("2202") && password.equals("67890")) {
            return true;
        } else {
            return false;
        }
    }

    // Inisialisasi data buku
    static Map<String, Map<String, Object>> books = new HashMap<>();

    static{
        books.put("001",Map.of("judul","The Newcomer","pengarang","Keigo Higashino","jumlah",5));
        books.put("002",Map.of("judul","Girls","pengarang","Minato Kanae","jumlah",3));
        books.put("003",Map.of("judul","Melangkah","pengarang","J.S. Khairen","jumlah",2));
    }
    // Method untuk menampilkan semua buku yang tersedia
     static void tampilan() {
        System.out.println("Buku yang tersedia di perpustakaan:");
        for (Map.Entry<String, Map<String, Object>> entry : books.entrySet()) {
            System.out.println("ID Buku: " + entry.getKey());
            System.out.println("Judul: " + entry.getValue().get("judul"));
            System.out.println("Pengarang: " + entry.getValue().get("pengarang"));
            System.out.println("Jumlah: " + entry.getValue().get("jumlah"));
            System.out.println();
        }
    }

    // Method untuk meminjam buku
     static void pinjam(String bookId) {
        if (books.containsKey(bookId)) {
            int jumlah = (int) books.get(bookId).get("jumlah");
            if (jumlah > 0) {
                books.get(bookId).put("jumlah", jumlah - 1);
                System.out.println("Buku telah dipinjam.");
            } else {
                System.out.println("Maaf, buku sedang habis.");
            }
        } else {
            System.out.println("Buku tidak tersedia.");
        }
    }

    // Method untuk mengembalikan buku
     static void pengembalian(String bookId) {
        if (books.containsKey(bookId)) {
            int jumlah = (int) books.get(bookId).get("jumlah");
            books.get(bookId).put("jumlah", jumlah + 1);
            System.out.println("Buku telah dikembalikan.");
        } else {
            System.out.println("Buku tidak ditemukan.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String noid, password;

        System.out.print("Masukkan nomor id: ");
        noid = scanner.nextLine();

        System.out.print("Masukkan password: ");
        password = scanner.nextLine();

        if (login(noid, password)) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Login gagal!");
        }


        // Tampilan menu
        while (true) {
            System.out.println("\nSelamat datang di Perpustakaan.");
            System.out.println("1. Tampilkan Buku");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Kembalikan Buku");
            System.out.println("4. Keluar");

            System.out.print("Masukkan pilihan Anda: ");
            String choice = scanner.nextLine();

//            switch (choice) {
//                case 1:
//                    tampilan();
//                    break;
//                case 2:
//                    System.out.print("Masukkan ID buku: ");
//                    String bookId = scanner.nextLine();
//                    pinjam(bookId);
//                    break;
//                case 3:
//                    System.out.print("Masukkan ID buku: ");
//                    String bookId = scanner.nextLine();
//                    pengembalian(bookId);
//                    break;
//                case 4:
//                    System.out.println("Terima Kasih Telah Menggunakan Layanan perpustakaan");
//                    System.exit(0);
//                default:
//                    System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
//                    break;
//            }


            if (choice.equals("1")) {
                tampilan();
            } else if (choice.equals("2")) {
                System.out.print("Masukkan ID buku: ");
                String bookId = scanner.next();
                int jumlah = (int) books.get(bookId).get("jumlah");
                System.out.println(jumlah);
                pinjam(bookId);
            } else if (choice.equals("3")) {
                System.out.print("Masukkan ID buku: ");
                String bookId = scanner.next();
                pengembalian(bookId);
            } else if (choice.equals("4")) {
                break;
            } else {
                System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        }
    }
}

