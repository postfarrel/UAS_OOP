package com.oop.jdbc.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.oop.jdbc.dao.DosenDAO;
import com.oop.jdbc.pojo.Dosen;
import com.oop.jdbc.utils.DatabaseConnection;

public class DosenDAOImpl implements DosenDAO{

	@Override
	public void getDosenByEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDosen(Dosen dosen) {
		DatabaseConnection db = new DatabaseConnection();
		String query;
		
		try {
			db.connect();
			query = "INSERT INTO dosen (nip, nama, email)"
					+ " VALUES (" + dosen.getNip() + ", '"
					+ dosen.getNama() + "', '"
					+ dosen.getEmail() + "')";
			
			db.executeQuery(query);
			System.out.println("Data berhasil ditambahkan");
		} catch (Exception ex) {
			System.out.println("Terjadi error : " + ex.getMessage());
		}
		
	}

	@Override
	public void updateDosen(Dosen dosen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDosen(Dosen dosen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dosen> getAllDosen() {
		List<Dosen> listDosen = new ArrayList<Dosen>();
		DatabaseConnection db = new DatabaseConnection();
		
		try {
			db.connect();
			
			String query = "SELECT * FROM Dosen";
			
			ResultSet rs = db.readData(query);
			
			while(rs.next()) {
				Dosen dosen = new Dosen();
				
				dosen.setNip(Integer.parseInt(rs.getObject(1).toString()));
				dosen.setNama(rs.getObject(2).toString());
				dosen.setEmail(rs.getObject(3).toString());
				
				listDosen.add(dosen);
			}
			
			db.disconnect();
			
		} catch (SQLException ex) {
			 System.out.println("Terjadi error : " + ex.getMessage());
		}
		
		return listDosen;
	}

	@Override
	public Dosen login(String email, String password) {
		DatabaseConnection db = new DatabaseConnection();
		Dosen dosen = new Dosen();
		dosen = null;
		
		try {
			db.connect();
			
			String query = "SELECT * FROM dosen WHERE email = '" + email + "' AND password = '" + password + "'";
			
			ResultSet rs = db.readData(query);
			
			List<Dosen> listDosen = new ArrayList<Dosen>();
			
			// process query results
			while (rs.next()) {
				Dosen dsn = new Dosen();
				dsn.setNip(Integer.parseInt(rs.getObject(1).toString()));
				dsn.setNama(rs.getObject(2).toString());
				dsn.setEmail(rs.getObject(3).toString());
				dsn.setUsername(rs.getObject(4).toString());
				dsn.setPassword(rs.getObject(5).toString());
				
				listDosen.add(dsn);
				
				for(Dosen ds : listDosen) {
					if(email.equals(ds.getEmail()) && password.equals(ds.getPassword())){
						dosen = ds;
					}
				}
			}
			
			db.disconnect();
			
		} catch (SQLException ex) {
			System.out.println("Terjadi Error : " + ex.getMessage());
		}
		
		return dosen;
	}
	
	
}
