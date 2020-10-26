package com.reimbursement.repo;

import com.reimbursement.model.Reimbursement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.reimbursement.config.EnvironmentConnectionUtil;

public class ReimbursementDao implements DaoContract<Reimbursement,Integer>{
	
	@Override
	public List<Reimbursement> findAll() {
		String sql = "select * from reimbursements";
		List<Reimbursement> rList = new ArrayList<Reimbursement>();
		Reimbursement reim = new Reimbursement();

		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ResultSet rs = ps.executeQuery();


			while (rs.next()) {
				switch(rs.getInt(7)) {
				case 1:
					reim = new Reimbursement(rs.getInt(1),rs.getFloat(2),rs.getTimestamp(3).toLocalDateTime(),rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getBytes(6),rs.getInt(7),rs.getInt(8),Reimbursement.status.PENDING,rs.getString(9));
					rList.add(reim);
					break;
				case 2:
					reim = new Reimbursement(rs.getInt(1),rs.getFloat(2),rs.getTimestamp(3).toLocalDateTime(),rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getBytes(6),rs.getInt(7),rs.getInt(8),Reimbursement.status.ACCEPTED,rs.getString(9));
					rList.add(reim);	
					break;
				case 3:
					reim = new Reimbursement(rs.getInt(1),rs.getFloat(2),rs.getTimestamp(3).toLocalDateTime(),rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getBytes(6),rs.getInt(7),rs.getInt(8),Reimbursement.status.REJECTED,rs.getString(9));
					rList.add(reim);
					break;
				default:
					throw new SQLException();
				}

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
			ps.setString(7, reim.getType());


			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public void create(Reimbursement reim) {
		String sql = "insert into users(amount,submitted,description,receipt,author,reim_status,reim_type) values (?,?,?,?,?,?,?)";
		try (Connection conn = EnvironmentConnectionUtil.getInstance().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)) {
		
		ps.setFloat(1, reim.getAmount());
		Timestamp now = new Timestamp(System.currentTimeMillis());
		ps.setTimestamp(2,now);
		ps.setString(3,reim.getDescription());
		ps.setBytes(4,reim.getReceipt());
		ps.setInt(5,reim.getAuthorID());
		ps.setInt(6, 1);
		ps.setString(7, reim.getType());
		
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
			
			switch(rs.getInt(7)) {
			case 1:
				reim = new Reimbursement(rs.getInt(1),rs.getFloat(2),rs.getTimestamp(3).toLocalDateTime(),rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getBytes(6),rs.getInt(7),rs.getInt(8),Reimbursement.status.PENDING,rs.getString(9));
				break;
			case 2:
				reim = new Reimbursement(rs.getInt(1),rs.getFloat(2),rs.getTimestamp(3).toLocalDateTime(),rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getBytes(6),rs.getInt(7),rs.getInt(8),Reimbursement.status.ACCEPTED,rs.getString(9));
				break;
			case 3:
				reim = new Reimbursement(rs.getInt(1),rs.getFloat(2),rs.getTimestamp(3).toLocalDateTime(),rs.getTimestamp(4).toLocalDateTime(),rs.getString(5),rs.getBytes(6),rs.getInt(7),rs.getInt(8),Reimbursement.status.REJECTED,rs.getString(9));
				break;
			default:
				throw new SQLException();
			}
			
			rs.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reim;

	}

	
	
	
	
}
