package com.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.OfrInfoDao;
import com.crm.entity.extd.OfrInfoEntityExtd;

public class OfrInfoDaoImpl implements OfrInfoDao {

	@Override
	public void save(Connection conn, OfrInfoEntityExtd ofrInfo) throws SQLException {
		String insertSql="insert into ofr_info(crm_name,ofr_id,ofr_name,cust_name,ctc_name,opp_id,ofr_status,ofr_vali,sale_disc,sale_sum) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertSql);
		ps.setString(1, ofrInfo.getCrmName());
		ps.setString(2, ofrInfo.getOfrId());
		ps.setString(3, ofrInfo.getOfrName());
		ps.setString(4, ofrInfo.getCustName());
		ps.setString(5, ofrInfo.getCtcName());
		ps.setString(6, ofrInfo.getOppId());
		ps.setString(7, ofrInfo.getOfrStatus());
		ps.setString(8, ofrInfo.getOfrVali());
		ps.setString(9, ofrInfo.getSaleDisc());
		ps.setString(10, ofrInfo.getSalcSum());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, OfrInfoEntityExtd ofrInfo) throws SQLException {
		String deleteSql="delete from ofr_info where ofr_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		ps.setString(1, ofrInfo.getOfrId());
		ps.execute();
	}

	@Override
	public void deleteMul(Connection conn, OfrInfoEntityExtd[] ofrInfo) throws SQLException {
		String deleteSql="delete from ofr_info where ofr_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		for (int i = 0; i < ofrInfo.length; i++) {
			ps.setString(1, ofrInfo[i].getOfrId());
			System.out.println(ofrInfo[i].getOfrId());
			ps.execute();
		}
	}

	@Override
	public void update(Connection conn, OfrInfoEntityExtd ofrInfo) throws SQLException {
		String updateSql="update ofr_info set crm_name=?,ofr_name=?,cust_name=?,ctc_name=?,opp_id=?,ofr_status=?,ofr_vali=?,sale_disc=?,sale_sum=? where ofr_id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, ofrInfo.getCrmName());
		ps.setString(2, ofrInfo.getOfrName());
		ps.setString(3, ofrInfo.getCustName());
		ps.setString(4, ofrInfo.getCtcName());
		ps.setString(5, ofrInfo.getOppId());
		ps.setString(6, ofrInfo.getOfrStatus());
		ps.setString(7, ofrInfo.getOfrVali());
		ps.setString(8, ofrInfo.getSaleDisc());
		ps.setString(9, ofrInfo.getSalcSum());
		ps.setString(10, ofrInfo.getOfrId());
		ps.execute();
	}

	/**
	 * 抽出每条部分信息，显示单条
	 */
	@Override
	public ResultSet get(Connection conn, OfrInfoEntityExtd ofrInfo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 检索问题：注意判断是不是该的销售负责人
	 */
	@Override
	public ResultSet getX(Connection conn, OfrInfoEntityExtd ofrInfo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public ResultSet getDtlById(Connection conn, OfrInfoEntityExtd ofrInfo) throws SQLException {
		String selectSql="select * from ofr_info where ofr_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, ofrInfo.getOfrId());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getDtlByName(Connection conn, OfrInfoEntityExtd ofrInfo) throws SQLException {
		String selectSql="select * from ofr_info where ofr_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, ofrInfo.getOfrName());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getY(Connection conn, OfrInfoEntityExtd ofrInfo) throws SQLException {
		String selectSql="select cust_name,ctc_name,opp_id,ofr_id from ofr_info where crm_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, ofrInfo.getCrmName());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getZ(Connection conn, OfrInfoEntityExtd ofrInfo) throws SQLException {
		String selectSql="select ofr_id from ofr_info where cust_name=? and ctc_name=? and opp_id=? and ofr_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, ofrInfo.getCustName());
		ps.setString(2, ofrInfo.getCtcName());
		ps.setString(3, ofrInfo.getOppId());
		ps.setString(4, ofrInfo.getOfrId());
		return ps.executeQuery();
	}
	

	/**
	 * 抽出每条部分信息，显示全部条数
	 */
	@Override
	public ResultSet getAll(Connection conn) throws SQLException {
		String selectSql="select ofr_id,ofr_name,cust_name,ctc_name,sale_disc,sale_sum,crm_name from ofr_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getAllX(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException {
		String selectSql="select ofr_id,ofr_name,cust_name,ctc_name,sale_disc,sale_sum,crm_name from ofr_info where crm_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, ofrInfo.getCrmName());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getAllId(Connection conn) throws SQLException {
		String selectSql="select ofr_id from ofr_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	public ResultSet getNum(Connection conn) throws SQLException {
		String selectSql="select count(ofr_id) from ofr_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}

}
