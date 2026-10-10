package com.binus.kasir;

public class Node {
	//input: nomorAntrian, namaPelanggan, totalBelanja
	String nomorAntrian;
	String namaPelanggan;
	double totalBelanja;
	Node next;
	
	//constructor
	public Node(String nomorAntrian, String namaPelanggan, double totalBelanja) {
		this.nomorAntrian = nomorAntrian;
		this.namaPelanggan = namaPelanggan;
		this.totalBelanja = totalBelanja;
		this.next = null;
	}
}