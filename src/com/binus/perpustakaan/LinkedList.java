package com.binus.perpustakaan;

public class LinkedList {
	Node head;
	int jumlahBuku;
	
	//Tambah Buku (Push)
	//menambahkan buku ke bagian paling akhir
	public void push(String kodeBuku, String judul, String penulis) {
		//membuat node baru dari data buku
		Node newNode = new Node(kodeBuku, judul, penulis);
		//jika list masih kosong, node baru jadi head
		if (head == null) {
			head = newNode;
		} else {
			//mulai dari node pertama (head)
			Node current = head;
			//bergerak sampai ke node terakhir
			while (current.next != null) {
				current = current.next;
			}
			//node terakhir diarahkan ke node baru
			current.next = newNode;
		}
		//menambah jumlah data
		jumlahBuku++;
    }
	
	//Hapus Buku (Pop)
	//menghapus buku terakhir dan return node yang dihapus
	public Node pop() {
		//jika list kosong (head = null), return null
		if (head == null) {
			//tampilkan pesan "Tidak ada data untuk dihapus."
			System.out.println("Tidak ada data untuk dihapus.");
			return null;
		}
		//hanya ada satu buku
		if (head.next == null) {
			Node deletedNode = head;
			//head dihapus
			head = null;
			jumlahBuku--;
			//return node yang dihapus
			return deletedNode;
		}
		//mulai dari node pertama (head)
		Node current = head;
		//mencari node sebelum node terakhir
		while (current.next.next != null) {
			current = current.next;
		}
		//simpan node terakhir yang akan dihapus
		Node deletedNode = current.next;
		//hapus hubungan (next) dengan node terakhir (yang dihapus)
		current.next = null;
		jumlahBuku--;
		//return node yang dihapus
		return deletedNode;
    }
	
	//Cari Buku
	//Input: kodeBuku
	public Node cariBuku(String kodeBuku) {
		//mulai dari node pertama (head)
		Node current = head;
		//mencari sampai node terakhir
		while (current != null) {
			//jika ditemukan, return node untuk menampilkan detail buku
			if (current.kodeBuku.equals(kodeBuku)) {
				return current;
			}
			//pindah ke node berikutnya
			current = current.next;
		}
		//tampilkan pesan "Buku tidak ditemukan."
		System.out.println("Buku tidak ditemukan.");
		//mengembalikan null
		return null;
	}
	
	//Tampilkan Semua Buku
	public void tampilkan() {
		//list kosong
		if (head == null) {
			System.out.println("Total Buku: 0");
			return;
		}
		//mulai dari node pertama (head)
		Node current = head;
		//menampilkan semua node
		while (current != null) {
			System.out.println("Kode: " + current.kodeBuku + " | Judul: " + current.judul + " | Penulis: " + current.penulis);
			//pindah ke node berikutnya
			current = current.next;
		}
		//menampilkan jumlah seluruh buku
		System.out.println("Total Buku: " + jumlahBuku);
	}
	
	//Mendapat jumlah buku
	public int getJumlahBuku() {
		return jumlahBuku;
	}
}