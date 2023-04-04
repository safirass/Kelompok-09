import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class perpustakaan {
    //Inisialisasi id dan password 
    public static boolean login(String noid, String password) {
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
    static {
        Map<String, Object> book1 = new HashMap<>();
        book1.put("judul", "The Newcomer");
        book1.put("pengarang", "Keigo Higashino");
        book1.put("jumlah", 5);
        books.put("001", book1);

        Map<String, Object> book2 = new HashMap<>();
        book2.put("judul", "Girls");
        book2.put("pengarang", "Minato Kanae");
        book2.put("jumlah", 3);
        books.put("002", book2);

        Map<String, Object> book3 = new HashMap<>();
        book3.put("judul", "Melangkah");
        book3.put("pengarang", "J.S. Khairen");
        book3.put("jumlah", 2);
        books.put("003", book3);
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


            if (choice.equals("1")) {
                tampilan();
            } else if (choice.equals("2")) {
                System.out.print("Masukkan ID buku: ");
                String bookId = scanner.nextLine();
                pinjam(bookId);
            } else if (choice.equals("3")) {
                System.out.print("Masukkan ID buku: ");
                String bookId = scanner.nextLine();
                pengembalian(bookId);
            } else if (choice.equals("4")) {
                System.out.println("Terima Kasih Telah Menggunakan Layanan perpustakaan");
                System.exit(0);
            } else {
                System.out.println("Pilihan tidak valid. Silahkan coba lagi.");
            }
        }
    }
}

