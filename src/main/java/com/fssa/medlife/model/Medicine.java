package com.fssa.medlife.model;

public class Medicine {
	
	private String MedicineName;
	private int MedicineRupees;
	private int userID;
	private String MedicineUrl;
	private boolean isActive;
	private int id;

	

	public Medicine(String medicineName2, String price, String url) {
		// TODO Auto-generated constructor stub
	}
 



	public Medicine(String medicineName, int medicineRupees, int userID, String medicineUrl) {
		super();
		MedicineName = medicineName;
		MedicineRupees = medicineRupees;
		this.userID = userID;
		MedicineUrl = medicineUrl;
	}




	public Medicine() {
		// TODO Auto-generated constructor stub
	}




	public int getId() {
		return id;
	}

	
	
	
	public void setId(int id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getMedicineName() {
		return MedicineName;
	}

	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}

	public int getMedicineRupees() {
		return MedicineRupees;
	}

	public void setMedicineRupees(int medicineRupees) {
		MedicineRupees = medicineRupees;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getMedicineUrl() {
		return MedicineUrl;
	}

	public void setMedicineUrl(String medicineUrl) {
		MedicineUrl = medicineUrl;
	}

	@Override
	public String toString() {
		return "Medicine [MedicineName=" + MedicineName + ", MedicineRupees=" + MedicineRupees + ", userID=" + userID
				+ ", MedicineUrl=" + MedicineUrl + ", isActive=" + isActive + ", id=" + id + "]";
	}

}
