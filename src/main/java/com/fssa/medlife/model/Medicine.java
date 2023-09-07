package com.fssa.medlife.model;

public class Medicine {
	
	
	private String MedicineName;
	private int MedicineRupees;
	private String MedicineUrl;
	private boolean isActive;
	private int id;

	
	@Override
	public String toString() {
		return "Medicine [MedicineName=" + MedicineName + ", MedicineRupees=" + MedicineRupees + ", MedicineUrl="
				+ MedicineUrl + ", isActive=" + isActive + ", id=" + id + ", getMedicineName()=" + getMedicineName()
				+ ", getMedicineRupees()=" + getMedicineRupees() + ", getMedicineUrl()=" + getMedicineUrl()
				+ ", isActive()=" + isActive() + ", getId()=" + getId() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
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
	public void setMedicineRupees(int i) {
		MedicineRupees = i;
	}
	public String getMedicineUrl() {
		return MedicineUrl;
	}
	public void setMedicineUrl(String medicineUrl) {
		MedicineUrl = medicineUrl;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Medicine(String medicineName, int medicineRupees, String medicineUrl) {
		this.MedicineName = medicineName;
		this.MedicineRupees = medicineRupees;
		this.MedicineUrl = medicineUrl;
	}
	public Medicine(String medicineName, int medicineRupees, String medicineUrl, boolean isActive, int id) {
		super();
		MedicineName = medicineName;
		MedicineRupees = medicineRupees;
		MedicineUrl = medicineUrl;
		this.isActive = isActive;
		this.id = id;
	}
	public Medicine() {
		// TODO Auto-generated constructor stub
	}

	
}