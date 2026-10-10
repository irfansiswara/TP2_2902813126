package com.binus.kasir;

public class Stack {
	Node top;
	int jumlahData;
	
	//Menambahkan transaksi di bagian atas stack
	public boolean push(Node transaksi) {
		//validasi parameter
		if (transaksi == null) {
            return false;
        }
		//transaksi baru menunjuk ke top sebelumnya
		transaksi.next = top;
		//top dipindahkan ke node baru
		top = transaksi;
		jumlahData++;
		return true;
	}
	
	//Menampilkan riwayat transaksi dari terbaru ke lama (LIFO)
	public void tampilkan() {
		//cek transaksi kosong
		if (top == null) {
			System.out.println("Belum ada riwayat transaksi.");
			return;
		}
		Node current = top;
		System.out.println("Riwayat Transaksi:");
		//menampilkan riwayat transaksi yang terbaru dahulu
		while (current != null) {
			System.out.println("Nomor: " + current.nomorAntrian + " | Nama: " + current.namaPelanggan + " | Total Belanja: " + current.totalBelanja);
			//pindah ke transaksi sebelumnya
			current = current.next;
		}
		System.out.println("Jumlah Transaksi: " + jumlahData);
	}
}