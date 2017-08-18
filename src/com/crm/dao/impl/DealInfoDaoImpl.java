package com.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.DealInfoDao;
import com.crm.entity.extd.DealInfoEntityExtd;

public class DealInfoDaoImpl implements DealInfoDao {

	@Override
	public void save(Connection conn, DealInfoEntityExtd dealInfo) throws SQLException {
		String insertSql="insert into deal_info(crm_name,deal_id,deal_thm,cust_name,ctc_name,opp_id,ofr_id,prod_sort,deal_status,deal_date,over_date,sale_sum) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertSql);
		ps.setString(1, dealInfo.getCrmName());
		ps.setString(2, dealInfo.getDealId());
		ps.setString(3, dealInfo.getDealThm());
		ps.setString(4, dealInfo.getCustName());
		ps.setString(5, dealInfo.getCtcName());
		ps.setString(6, dealInfo.getOppId());
		ps.setString(7, dealInfo.getOfrId());
		ps.setString(8, dealInfo.getProdSort());
		ps.setString(9, dealInfo.getDealStatus());
		ps.setString(10, dealInfo.getDealDate());
		ps.setString(11, dealInfo.getOverDate());
		ps.setString(12, dealInfo.getSaleSum());
		
		ps.execute();
	}

	@Override
	public void delete(Connection conn, DealInfoEntityExtd dealInfo) throws SQLException {
		String deleteSql="delete from deal_info where deal_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		ps.setString(1, dealInfo.getDealId());
		ps.execute();
	}

	@Override
	public void deleteMul(Connection conn, DealInfoEntityExtd[] dealInfo) throws SQLException {
		String deleteSql="delete from deal_info where deal_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		for (int i = 0; i < dealInfo.length; i++) {
			ps.setString(1, dealInfo[i].getDealId());
			ps.execute();
		}
	}

	@Override
	public void update(Connection conn, DealInfoEntityExtd dealInfo) throws SQLException {
		String updateSql="update deal_info set crm_name=?,deal_thm=?,cust_name=?,ctc_name=?,opp_id=?,ofr_id=?,prod_sort=?,deal_status=?,deal_date=?,over_date=?,sale_sum=? where deal_id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, dealInfo.getCrmName());
		ps.setString(2, dealInfo.getDealThm());
		ps.setString(3, dealInfo.getCustName());
		ps.setString(4, dealInfo.getCtcName());
		ps.setString(5, dealInfo.getOppId());
		ps.setString(6, dealInfo.getOfrId());
		ps.setString(7, dealInfo.getProdSort());
		ps.setString(8, dealInfo.getDealStatus());
		ps.setString(9, dealInfo.getDealDate());
		ps.setString(10, dealInfo.getOverDate());
		ps.setString(11, dealInfo.getSaleSum());
		ps.setString(12, dealInfo.getDealId());
		ps.execute();
	}

	/**
	 * 抽出每条部分信息，显示单条
	 */
	@Override
	public ResultSet get(Connection conn, DealInfoEntityExtd dealInfo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 检索问题：注意判断是不是该的销售负责人
	 */
	@Override
	public ResultSet getX(Connection conn, DealInfoEntityExtd dealInfo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResultSet getDtlById(Connection conn, DealInfoEntityExtd dealInfo) throws SQLException {
		String selectSql="select * from deal_info where deal_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, dealInfo.getDealId());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getDtlByName(Connection conn, DealInfoEntityExtd dealInfo) throws SQLException {
		String selectSql="select * from deal_info where deal_thm=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, dealInfo.getDealThm());
		return ps.executeQuery();
	}

	/**
	 * 抽出每条部分信息，显示全部条数
	 */
	@Override
	public ResultSet getAll(Connection conn) throws SQLException {
		String selectSql="select deal_id,deal_thm,cust_name,deal_date,sale_sum,crm_name from deal_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getAllX(Connection conn,DealInfoEntityExtd dealInfo) throws SQLException {
		String selectSql="select deal_id,deal_thm,cust_name,deal_date,sale_sum,crm_name from deal_info where crm_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, dealInfo.getCrmName());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getAllId(Connection conn) throws SQLException {
		String selectSql="select deal_id from deal_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getNum(Connection conn) throws SQLException {
		String selectSql="select count(deal_id) from deal_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}

}
