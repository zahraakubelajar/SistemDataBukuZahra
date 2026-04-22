import java.util.Scanner;

// Node untuk menyimpan data buku
class Node {
    String kode, judul, penulis; // atribut buku
    Node next; // pointer ke node berikutnya

    // constructor
    Node(String k, String j, String p) {
        kode = k;
        judul = j;
        penulis = p;
        next = null;
    }
}

// Class Linked List
class LinkedList {
    Node head;
    int count = 0; // jumlah buku

    // menambah buku di akhir list
    void tambah(String k, String j, String p) {
        Node baru = new Node(k, j, p);

        if (head == null) {
            head = baru;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = baru;
        }

        count++;
        System.out.println("Data berhasil ditambahkan!");
    }

    // menghapus buku terakhir
    void hapus() {
        if (head == null) {
            System.out.println("Tidak ada data untuk dihapus.");
            return;
        }

        if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }

        count--;
        System.out.println("Data terakhir berhasil dihapus!");
    }

    // mencari buku berdasarkan kode
    void cari(String kode) {
        Node temp = head;

        while (temp != null) {
            if (temp.kode.equals(kode)) {
                System.out.println("Buku ditemukan:");
                System.out.println("Kode: " + temp.kode);
                System.out.println("Judul: " + temp.judul);
                System.out.println("Penulis: " + temp.penulis);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Buku tidak ditemukan.");
    }

    // menampilkan semua buku
    void tampil() {
        if (count < 5) {
            System.out.println("Minimal harus ada 5 buku!");
            return;
        }

        Node temp = head;
        System.out.println("Daftar Buku:");

        while (temp != null) {
            System.out.println("Kode: " + temp.kode +
                               " | Judul: " + temp.judul +
                               " | Penulis: " + temp.penulis);
            temp = temp.next;
        }

        System.out.println("Total Buku: " + count);
    }
}

// Class utama
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int pilih = 0; // variabel menu

        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    // input data buku
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = sc.nextLine();

                    // validasi panjang kode
                    if (kode.length() > 5) {
                        System.out.println("Kode maksimal 5 karakter!");
                        break;
                    }

                    System.out.print("Masukkan Judul: ");
                    String judul = sc.nextLine();

                    System.out.print("Masukkan Penulis: ");
                    String penulis = sc.nextLine();

                    list.tambah(kode, judul, penulis);
                    break;

                case 2:
                    // hapus buku terakhir
                    list.hapus();
                    break;

                case 3:
                    // cari buku
                    System.out.print("Masukkan kode yang dicari: ");
                    list.cari(sc.nextLine());
                    break;

                case 4:
                    // tampilkan semua buku
                    list.tampil();
                    break;
            }

        } while (pilih != 5);

        System.out.println("Program selesai.");
        sc.close(); // menutup scanner
    }
}
