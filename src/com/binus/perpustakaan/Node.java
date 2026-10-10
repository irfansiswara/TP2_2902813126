package com.binus.perpustakaan;

public class Node {
	//input: kodeBuku, judul, dan penulis
	String kodeBuku;
	String judul;
	String penulis;
	Node next;

	//constructor
	public Node(String kodeBuku, String judul, String penulis) {
		this.kodeBuku = kodeBuku;
		this.judul = judul;
		this.penulis = penulis;
		this.next = null;
	}
}