package com.reimbursement.repo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.reimbursement.config.EnvironmentConnectionUtil;

public class DaoUtil {
	
	public int getRemainingPayments(float owed,float intRate,float monthlyPayment) {
		int result = 0;
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql="{ ? = call remaining_payments(?,?,?) }";
			CallableStatement cs = conn.prepareCall(sql);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.setFloat(2, owed);
			cs.setFloat(3, intRate);
			cs.setFloat(4, monthlyPayment);
			cs.execute();
			result = cs.getInt(1);
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void removeUnaccepted(String vin) {
		try(Connection conn = EnvironmentConnectionUtil.getInstance().getConnection()){
			String sql="CALL remove_unaccepted(?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, vin);
			cs.execute();
			cs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
