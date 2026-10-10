package com.binus.kasir;

public class Queue {
	Node front;
	Node rear;
	int jumlahAntrian;
	
	//Menambahkan pelanggan ke bagian belakang antrian
	public boolean enqueue(String nomorAntrian, String namaPelanggan, double totalBelanja) {
		//validasi parameter
		if (nomorAntrian == null || nomorAntrian.trim().isEmpty() || namaPelanggan == null || namaPelanggan.trim().isEmpty() || totalBelanja < 0) {
            return false;
        }
		//membuat node pelanggan
		Node newNode = new Node(nomorAntrian, namaPelanggan, totalBelanja);
		//initial queue
		if (front == null) {
			//front dan rear menunjuk ke node baru
			front = newNode;
			rear = newNode;
		} else {
			//node baru dihubungkan setelah node terakhir
			rear.next = newNode;
			//rear dipindahkan ke node baru
			rear = newNode;
		}
		jumlahAntrian++;
		return true;
	}
	
	//Menghapus pelanggan yang paling depan antrian
	public Node dequeue() {
		//cek antrian kosong
		if (front == null) {
			return null;
		}
		//simpan node yang akan dihapus
		Node deletedNode = front;
		//front dipindahkan ke node berikutnya
		front = front.next;
		//jika antrian jadi kosong, rear dibikin null
		if (front == null) {
			rear = null;
		}
		//menghapus hubungan node yang akan dihapus
		deletedNode.next = null;
		jumlahAntrian--;
		return deletedNode;
	}
	
	//Tampilkan seluruh pelanggan yang sedang mengantri
	public void tampilkan() {
		//cek antrian kosong
		if (front == null) {
			System.out.println("Antrian kosong.");
			return;
		}
		//mulai dari node pertama (front)
		Node current = front;
		System.out.println("Antrian Pelanggan:");
		//menampilkan antrian dari front sampai null
		while (current != null) {
			System.out.println("Nomor: " + current.nomorAntrian + " | Nama: " + current.namaPelanggan + " | Total Belanja: " + current.totalBelanja);
			//pindah ke node berikutnya
			current = current.next;
		}
		System.out.println("Total Antrian: " + jumlahAntrian);
	}
	
	//Mendapat jumlah pelanggan dalam antrian
	public int getJumlahAntrian() {
		return jumlahAntrian;
	}
}