package com.binus.kasir;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Scanner digunakan untuk menerima input dari user
		Scanner input = new Scanner(System.in);
		// Membuat object queue untuk antrian pelanggan
		Queue antrian = new Queue();
		// Membuat object stack untuk riwayat transaksi
		Stack riwayat = new Stack();
		//gunakan Scanner untuk input dan validasi jumlah data ≤ 5
		final int MAX_DATA = 5;
		//minimal 5 pelanggan dalam antrian?
		final int MIN_ANTRIAN = 5;
		System.out.println("=== SISTEM KASIR TOKO ===");
		System.out.println("1. Tambah Antrian");
		System.out.println("2. Layani Pelanggan");
		System.out.println("3. Tampilkan Antrian");
		System.out.println("4. Lihat Riwayat Transaksi");
		System.out.println("5. Keluar");
		int menu;
		do {
			System.out.println();
			System.out.print("Pilih menu: ");
			menu = input.nextInt();
			input.nextLine();
			switch (menu) {
				//Tambah Antrian
				case 1:
					String nomorAntrian;
					String namaPelanggan;
					double totalBelanja;
					//validasi jumlah data ≤ 5
					if (antrian.getJumlahAntrian() >= MAX_DATA) {
						System.out.println("Antrian penuh. Maksimal 5 pelanggan.");
						break;
					}
					System.out.print("Masukkan Nomor Antrian: ");
					nomorAntrian = input.nextLine();
					System.out.print("Masukkan Nama Pelanggan: ");
					namaPelanggan = input.nextLine();
					System.out.print("Masukkan Total Belanja: ");
					totalBelanja = input.nextDouble();
					input.nextLine();
					//memasukkan pelanggan ke bagian akhir antrian
					boolean isSucceed = antrian.enqueue(nomorAntrian, namaPelanggan, totalBelanja);
					if (isSucceed) {
						System.out.println("Data pelanggan ditambahkan ke antrian!");
					} else {
						System.out.println("Data pelanggan gagal ditambahkan.");
					}
					break;
                //Melayani pelangggan
				case 2:
					// Mengambil pelanggan paling awal dari antrian
					Node pelanggan = antrian.dequeue();
					// Jika antrian kosong
					if (pelanggan == null) {
						System.out.println("Tidak ada pelanggan dalam antrian.");
						break;
					}
					System.out.println("Melayani pelanggan " + pelanggan.nomorAntrian + " ("+ pelanggan.namaPelanggan + ")");
					//menambahkan pelanggan yang sudah dilayani ke bagian atas stack
					boolean berhasilPush = riwayat.push(pelanggan);
					if (berhasilPush) {
						System.out.println("Transaksi disimpan ke riwayat.");
					} else {
						System.out.println("Riwayat transaksi penuh.");
					}
					break;
				//Tampilkan antrian
				case 3:
					antrian.tampilkan();
					break;
				//Tampilkan riwayat transaksi
				case 4:
					riwayat.tampilkan();
					break;
				//Keluar program
				case 5:
					//minimal 5 pelanggan dalam antrian
					if (antrian.getJumlahAntrian() < MIN_ANTRIAN) {
						System.out.println("Jumlah antrian minimal 5 pelanggan.");
						System.out.println("Tambahkan " + (MIN_ANTRIAN - antrian.getJumlahAntrian()) + " pelanggan lagi.");
					} else {
						System.out.println("Program selesai.");
					}
					break;
				//Menu tidak tersedia
				default:
					System.out.println("Pilih 1-5.");
			}
		} while (menu != 5 || antrian.getJumlahAntrian() < MIN_ANTRIAN);
		//close scanner setelah program selesai
		input.close();
	}
}