package com.oop.jdbc.test;

import java.util.Scanner;

import com.oop.jdbc.dao.DosenDAO;
import com.oop.jdbc.daoimpl.DosenDAOImpl;
import com.oop.jdbc.pojo.Dosen;
import com.oop.jdbc.utils.DatabaseConnection;
//import com.oop.jdbc.utils.DatabaseConnection;
import com.oop.jdbc.utils.Validator;

public class MainTest {
	public static void main(String[] args) {
		DatabaseConnection db = new DatabaseConnection();
		db.connect();
		
		/*
		DosenDAO operation = new DosenDAOImpl();
		
		for (Dosen dosen : operation.getAllDosen()) {
			System.out.println("NIP : " + dosen.getNip());
			System.out.println("Nama : " + dosen.getNama());
			System.out.println("Email : " + dosen.getEmail());
			System.out.println("Username : " + dosen.getUsername());
			System.out.println("Password : " + dosen.getPassword());
		}
		*/
		
		/*
		Dosen dosen = new Dosen();
		DosenDAO operation = new DosenDAOImpl();
		
		dosen.setNip(120160503);
		dosen.setNama("Nur Fitriani");
		dosen.setEmail("nur.fitriani@itenas.ac.id");
		
		operation.saveDosen(dosen);
		*/
		
		Scanner scan = new Scanner(System.in);
		Validator val = new Validator();
		DosenDAO operation = new DosenDAOImpl();
		Dosen dosen;
		String email, password;
		boolean login = false;
		
		do {
			//System.out.println("Email    : "); email = scan.nextLine();
			email = val.validateInput(scan, "Email : ", "email");
			System.out.println("Password : "); password = scan.nextLine();
			System.out.println();
			
			dosen = operation.login(email, password);
			if (dosen != null) {
				login = true;
				System.out.println("Login Berhasil...");
			} else {
				System.out.println("Email atau password yang Anda masukkan salah, coba lagi...");
			}
		} while (!login);
		
		scan.close();
	}
}
