package com.oop.jdbc.dao;

import java.util.List;

import com.oop.jdbc.pojo.Dosen;

public interface DosenDAO {
	public void getDosenByEmail(String email);
	public List<Dosen> getAllDosen();
	public void saveDosen(Dosen dosen);
	public void updateDosen(Dosen dosen);
	public void deleteDosen(Dosen dosen);
	public Dosen login(String email, String password);
}
