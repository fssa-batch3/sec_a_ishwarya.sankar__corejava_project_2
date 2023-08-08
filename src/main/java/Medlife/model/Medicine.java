package Medlife.model;

public class Medicine {
	private String MedicineName;
	private int MedicineRupees;
	private int userID;
	private String MedicineUrl;

	
	
	public Medicine(String medicineUrl) {
		super();
		MedicineUrl = medicineUrl;
	}
	public String getMedicineUrl() {
		return MedicineUrl;
	}
	public void setMedicineUrl(String medicineUrl) {
		MedicineUrl = medicineUrl;
	}
	public Medicine(String medicineName, int medicineRupees) {
		super();
		MedicineName = medicineName;
		MedicineRupees = medicineRupees;
	}
	@Override
	public String toString() {
		return "Medicine [MedicineName=" + MedicineName + ", MedicineRupees=" + MedicineRupees + ", userID=" + userID
				+ ", getUserID()=" + getUserID() + ", getMedicineRupees()=" + getMedicineRupees()
				+ ", getMedicineName()=" + getMedicineName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Medicine(int userID) {
		super();
		this.userID = userID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getMedicineRupees() {
		return MedicineRupees;
	}
	public void setMedicineRupees(int medicineRupees) {
		MedicineRupees = medicineRupees;
	}
	public String getMedicineName() {
		return MedicineName;
	}
	public void setMedicineName(String medicineName) {
		MedicineName = medicineName;
	}
	
}

