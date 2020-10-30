
package com.reimbursement.repo;

import com.reimbursement.model.Reimbursement;
import com.reimbursement.model.Reimbursement.status;
import com.reimbursement.model.Reimbursement.type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import com.reimbursement.config.EnvironmentConnectionUtil;

public class ReimbursementDao implements DaoContract<Reimbursement,Integer>{
	
	@Override
	public ArrayList<Reimbursement> findAll() {
		String sql = "select * from reimbursements";
		ArrayList<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement reim = new Reimbursement();

		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();
			
			status rStatus;
			type rType;

			//set status
			while (rs.next()) {
				switch(rs.getInt(9)) {
				case 1:
					rStatus = status.PENDING;
					break;
				case 2:
					rStatus = status.ACCEPTED;
					break;
				case 3:
					rStatus = status.REJECTED;
					break;
				default:
					throw new SQLException();
				}
				//set type
				switch(rs.getInt(10)) {
				case 1:
					rType = type.GAS;
					break;
				case 2:
					rType = type.TRAVEL;
					break;
				case 3:
					rType = type.FOOD;
					break;
				case 4:
					rType = type.TOOLS;
					break;
				case 5:
					rType = type.TRAINING;
					break;
				case 6:
					rType = type.MISC;
					break;
				default:
					throw new SQLException();					
				}
				
				reim = new Reimbursement(rs.getInt(1),rs.getFloat(2),rs.getTimestamp(3).toLocalDateTime(),rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getBytes(6),rs.getInt(7),rs.getInt(8),rStatus,rType);
				rList.add(reim);

			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;

	}

	@Override
	public void update(Reimbursement reim) {
		String sql = "update reimbursements set amount=?,resolved= ?,description = ?,receipt=?, resolver=?,reim_status=?,reim_type=? where reim_id=?"; 
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			Timestamp now = new Timestamp(System.currentTimeMillis());

			ps.setInt(10, reim.getId());
			ps.setFloat(1,reim.getAmount());
			ps.setString(3, reim.getDescription());
			ps.setBytes(4, reim.getReceipt());
			ps.setInt(5, reim.getResolverID());;

			switch(reim.getReimbursementStatus()) {
			case PENDING:
				ps.setNull(2, Types.TIMESTAMP);
				ps.setInt(6, 1);
				break;
			case ACCEPTED:
				ps.setTimestamp(2, now);
				ps.setInt(6, 2);
				break;
			case REJECTED:
				ps.setTimestamp(2, now);
				ps.setInt(6, 3);
				break;	
			}
			
			//set type
			int typeId;
			switch(reim.getReimType()) {
			case FOOD:
				typeId = 3;
				break;
			case GAS:
				typeId = 1;
				break;
			case MISC:
				typeId = 6;
				break;
			case TOOLS:
				typeId = 4;
				break;
			case TRAINING:
				typeId = 5;
				break;
			case TRAVEL:
				typeId = 2;
				break;
			default:
				throw new SQLException();
			
			}
			
			ps.setInt(7, typeId);


			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void create(Reimbursement reim) {
		String sql = "insert into reimbursements(amount,submitted,description,receipt,author,reim_status,reim_type) values (?,?,?,?,?,?,?)";
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
		
		ps.setFloat(1, reim.getAmount());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		ps.setTimestamp(2,now);
		ps.setString(3,reim.getDescription());
		ps.setBytes(4,reim.getReceipt());
		ps.setInt(5,reim.getAuthorID());
		ps.setInt(6, 1);
		
		int typeId;
		switch(reim.getReimType()){
		case FOOD:
			typeId = 3;
			break;
		case GAS:
			typeId = 1;
			break;
		case MISC:
			typeId = 6;
			break;
		case TOOLS:
			typeId = 4;
			break;
		case TRAINING:
			typeId = 5;
			break;
		case TRAVEL:
			typeId = 2;
			break;
		default:
			throw new SQLException();
		}
		
		
		
		
		ps.setInt(7, typeId);
		
		ps.execute();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from reimbursements where reim_id=?"; // this will sanitize the input
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1,id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public Reimbursement findById(Integer i) {
		String sql = "select * from users where reim_id = ?";
		Reimbursement reim = new Reimbursement();

		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, i);
			
			ResultSet rs = ps.executeQuery();
			
			status rStatus;
			type rType;
			
			rs.next();
			switch(rs.getInt(9)) {
			case 1:
				rStatus = status.PENDING;
				break;
			case 2:
				rStatus = status.ACCEPTED;
				break;
			case 3:
				rStatus = status.REJECTED;
				break;
			default:
				throw new SQLException();
			}
			//set type
			switch(rs.getInt(10)) {
			case 1:
				rType = type.GAS;
				break;
			case 2:
				rType = type.TRAVEL;
				break;
			case 3:
				rType = type.FOOD;
				break;
			case 4:
				rType = type.TOOLS;
				break;
			case 5:
				rType = type.TRAINING;
				break;
			case 6:
				rType = type.MISC;
				break;
			default:
				throw new SQLException();					
			}
			
			reim = new Reimbursement(rs.getInt(1),rs.getFloat(2),rs.getTimestamp(3).toLocalDateTime(),rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getBytes(6),rs.getInt(7),rs.getInt(8),rStatus,rType);
			
			rs.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reim;

	}
	
	
	public ArrayList<Reimbursement> findAllByUserId(int id){

		String sql = "select * from reimbursements where author = ?";
		ArrayList<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement reim = new Reimbursement();

		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			
			status rStatus;
			type rType;

			//set status
			while (rs.next()) {
				switch(rs.getInt(9)) {
				case 1:
					rStatus = status.PENDING;
					break;
				case 2:
					rStatus = status.ACCEPTED;
					break;
				case 3:
					rStatus = status.REJECTED;
					break;
				default:
					throw new SQLException();
				}
				//set type
				switch(rs.getInt(10)) {
				case 1:
					rType = type.GAS;
					break;
				case 2:
					rType = type.TRAVEL;
					break;
				case 3:
					rType = type.FOOD;
					break;
				case 4:
					rType = type.TOOLS;
					break;
				case 5:
					rType = type.TRAINING;
					break;
				case 6:
					rType = type.MISC;
					break;
				default:
					throw new SQLException();					
				}
				
				reim = new Reimbursement(rs.getInt(1),rs.getFloat(2),rs.getTimestamp(3).toLocalDateTime(),rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getBytes(6),rs.getInt(7),rs.getInt(8),rStatus,rType);
				rList.add(reim);

			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rList;

	
		
	}

	
	
	
	
}
