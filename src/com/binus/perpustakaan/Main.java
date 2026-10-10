package com.binus.perpustakaan;

//import kelas sccanner untuk menerima input dari user
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//membuat object untuk menyimpan data buku
		LinkedList listBuku = new LinkedList();
		//minimal 5 data buku
		final int MIN_BUKU = 5;
		//user select menu
		int menu;
		System.out.println("===== SISTEM DATA BUKU =====");
		System.out.println("1. Tambah Buku");
		System.out.println("2. Hapus Buku");
		System.out.println("3. Cari Buku");
		System.out.println("4. Lihat Semua Buku");
		System.out.println("5. Keluar");
		do {
			System.out.println();
			System.out.print("Pilih menu: ");
			menu = input.nextInt();
			input.nextLine();
			switch (menu) {
				//Tambah Buku
				case 1:
					String kodeBuku;
					while (true) {
						System.out.print("Masukkan Kode Buku: ");
						kodeBuku = input.nextLine();	//input kodeBuku
						//validasi maksimal 5 karakter
						if (kodeBuku.length() > 0 && kodeBuku.length() <= 5) {
							break;
						}
						System.out.println("Kode buku maksimal 5 karakter.");
					}
					System.out.print("Masukkan Judul: ");
					String judul = input.nextLine();	//input judul
					System.out.print("Masukkan Penulis: ");
					String penulis = input.nextLine();	//input penulis
					//Data baru dimasukkan di akhir daftar
					listBuku.push(kodeBuku, judul, penulis);
					System.out.println("Data berhasil ditambahkan!");
					break;
				//Hapus Buku
				case 2:
					//menghapus data buku terakhir dari daftar
					Node deletedNode = listBuku.pop();
					if (deletedNode != null) {
						System.out.println("Data buku terakhir berhasil dihapus!");
						System.out.println("Kode: " + deletedNode.kodeBuku + " | Judul: " + deletedNode.judul + " | Penulis: " + deletedNode.penulis);
					}
					break;
				//Cari Buku
				case 3:
					System.out.print("Masukkan Kode Buku: ");
					String keyword = input.nextLine();		//input kodeBuku
					//mencari buku dari head sampai node terakhir
					Node resultNode = listBuku.cariBuku(keyword);
					if (resultNode != null) {
						//tampilkan detail buku
						System.out.println("Kode: " + resultNode.kodeBuku + " | Judul: " + resultNode.judul + " | Penulis: " + resultNode.penulis);
					}
					break;
				//Tampilkan Semua Buku
				case 4:
					System.out.println("Daftar Buku:");
					//menampilkan seluruh isi Linked List
					listBuku.tampilkan();
					break;
				//Keluar Program
				case 5:
					//validasi jumlah data minimal 5 buku
					if (listBuku.getJumlahBuku() < MIN_BUKU) {
						System.out.println("Jumlah buku harus minimal 5 buku.");
						System.out.println("Tambahkan " + (MIN_BUKU - listBuku.getJumlahBuku()) + " buku lagi.");
					} else {
						System.out.println("Program selesai.");
					}
					break;
				//Menu tidak tersedia
				default:
					System.out.println("Pilih 1-5.");
			}
		} while (
			menu != 5 || listBuku.getJumlahBuku() < MIN_BUKU
		);
		//close scanner setelah program selesai
		input.close();
	}
}