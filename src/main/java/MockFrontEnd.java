//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.reimbursement.model.Reimbursement;
//import com.reimbursement.model.Reimbursement.status;
//import com.reimbursement.model.Reimbursement.type;
//import com.reimbursement.model.User;
//import com.reimbursement.model.User.role;
//import com.reimbursement.repo.ReimbursementDao;
//import com.reimbursement.repo.UserDao;
//import com.reimbursement.service.SystemService;
//
//public class MockFrontEnd {
//	
//
//	public static void main(String[] args) {
////		int id=0;
////		String username = "elaineb";
////		String password = "dingobaby";
////		String firstName = "Elaine";
////		String lastName = "Benes";
////		String email = "ebenes@vandelay.net";
////		role userRole = role.EMPLOYEE;
////		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
////		password = encoder.encode(password);
////		
////		User u = new User(0,username,password,firstName,lastName,email,userRole);
////		addUser(u);
////		
////		
////		float amount = 80f;
////		String description = "trip to vacation house in the Hamptons with clients";
////		byte[] receipt = null;
////		int author = 2;
////		status reimbursementStatus = status.PENDING;
////		type reimType = type.GAS;
////		
////		Reimbursement r = new Reimbursement(amount,description,receipt,author,reimbursementStatus,reimType);
////		
////		addReimbursement(r);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		SystemService ss =new SystemService();
//		User u = ss.getUser("drapedinvelvet");
//		System.out.println(encoder.matches("bosco",u.getPassword()));
//		
//
//	}
//	
//	
//	
//	public static void addUser(User u) {
//		UserDao ud = new UserDao();
//		ud.create(u);
//	}
//	
//	public static void addReimbursement(Reimbursement r) {
//		ReimbursementDao rd = new ReimbursementDao();
//		rd.create(r);
//	}
//
//	
//}
