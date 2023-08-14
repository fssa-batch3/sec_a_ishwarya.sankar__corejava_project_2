package TestMedicine;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Medlife.model.Medicine;
import Medlife.services.MedicineService;
import Medlife.services.exception.ServiceException;

public class testMedicineFeature {

	 @Test
	    public void testMedicineadd() {
		 MedicineService medicineService = new MedicineService();
	        Medicine medicine = new Medicine("para",110 );
	        
	        try {
	            assertTrue(MedicineService.MedicineUser(medicine));
	        } catch (ServiceException e) {
	            e.printStackTrace();
	            fail();
	        }
	 
	    }
	 
	 
//	 @Test
//	    public void testMedicineupdate() {
//		 MedicineService medicineService = new MedicineService();
//	        Medicine medicine = new Medicine("coughsyrup",110,1);
//	        
//	        try {
//	            assertTrue(MedicineService.MedicineUpdate(medicine));
//	        } catch (ServiceException e) {
//	            e.printStackTrace();
//	            fail();
//	        }
//	 
//	 
//	    }
//	 
	 // delete 
//	 @Test
//	    public void testMedicinedelete() {
//		 MedicineService medicineService = new MedicineService();
//	        Medicine medicine = new Medicine(1);
//	        
//	        try {
//	            assertTrue(MedicineService.MedicineDelete(medicine));
//	        } catch (ServiceException e) {
//	            e.printStackTrace();
//	            fail();
//	        }
//	 
//	 
//	    }
//
//	 
	 
}
