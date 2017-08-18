package com.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.CustInfoDao;
import com.crm.entity.extd.CustInfoEntityExtd;

public class CustInfoDaoImpl implements CustInfoDao {

	@Override
	public void save(Connection conn, CustInfoEntityExtd custInfo) throws SQLException {
		String insertSql="insert into cust_info(crm_id,cust_id,cust_name,cust_status,cust_type,cust_lvl,cust_ind,cust_prov,cust_city,cust_addr,cust_rmk) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertSql);
		ps.setString(1, custInfo.getCrmId());
		ps.setString(2, custInfo.getCustId());
		ps.setString(3, custInfo.getCustName());
		ps.setString(4, custInfo.getCustStatus());
		ps.setString(5, custInfo.getCustType());
		ps.setString(6, custInfo.getCustLvl());
		ps.setString(7, custInfo.getCustInd());
		ps.setString(8, custInfo.getCustProv());
		ps.setString(9, custInfo.getCustCity());
		ps.setString(10, custInfo.getCustAddr());
		ps.setString(11, custInfo.getCustRmk());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, CustInfoEntityExtd custInfo) throws SQLException {
		String deleteSql="delete from cust_info where cust_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		ps.setString(1, custInfo.getCustId());
		ps.execute();
	}
	
	@Override
	public void deleteMul(Connection conn, CustInfoEntityExtd[] custInfo) throws SQLException {
		String deleteSql="delete from cust_info where cust_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		for (int i = 0; i < custInfo.length; i++) {
			ps.setString(1, custInfo[i].getCustId());
			ps.execute();
		}
	}

	@Override
	public void update(Connection conn, CustInfoEntityExtd custInfo) throws SQLException {
		String updateSql="update cust_info set crm_id=?,cust_name=?,cust_status=?,cust_type=?,cust_lvl=?,cust_ind=?,cust_prov=?,cust_city=?,cust_addr=?,cust_rmk=? where cust_id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, custInfo.getCrmId());
		ps.setString(2, custInfo.getCustName());
		ps.setString(3, custInfo.getCustStatus());
		ps.setString(4, custInfo.getCustType());
		ps.setString(5, custInfo.getCustLvl());
		ps.setString(6, custInfo.getCustInd());
		ps.setString(7, custInfo.getCustProv());
		ps.setString(8, custInfo.getCustCity());
		ps.setString(9, custInfo.getCustAddr());
		ps.setString(10, custInfo.getCustRmk());
		ps.setString(11, custInfo.getCustId());
		ps.execute();
	}

	/**
	 * 根据 custId 进行模糊查询
	 */
	@Override
	public ResultSet get(Connection conn, CustInfoEntityExtd custInfo,String custId) throws SQLException {
		String selectSql="select cust_id,cust_name,cust_status,cust_type,cust_lvl,cust_ind from cust_info where cust_id like '%"+custId+"%'";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}

	
	/**
	 * 根据 custName 进行模糊查询
	 */
	@Override
	public ResultSet getX(Connection conn, CustInfoEntityExtd custInfo,String custName) throws SQLException {
		String selectSql="select cust_id,cust_name,cust_status,cust_type,cust_lvl,cust_ind from cust_info where cust_name like '%"+custName+"%'";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 根据 custName 进行模糊查询
	 */
	@Override
	public ResultSet getY(Connection conn, CustInfoEntityExtd custInfo) throws SQLException {
		String selectSql="select cust_id,cust_name,cust_status,cust_type,cust_lvl,cust_ind from cust_info where cust_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, custInfo.getCustName());
		return ps.executeQuery();
	}
	
	
	
	
	/**
	 * 根据 custId 抽出每条全部信息，显示单条
	 */
	@Override
	public ResultSet getDtlById(Connection conn,CustInfoEntityExtd custInfo) throws SQLException {
		String selectSql="select * from cust_info where cust_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, custInfo.getCustId());
		return ps.executeQuery();
	}
	
	/**
	 * 根据 custName 抽出每条全部信息，显示单条
	 */
	@Override
	public ResultSet getDtlByName(Connection conn,CustInfoEntityExtd custInfo) throws SQLException {
		String selectSql="select * from cust_info where cust_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, custInfo.getCustName());
		return ps.executeQuery();
	}
	
	/**
	 * 根据 custStatus 抽出每条部分信息，显示多条
	 */
	@Override
	public ResultSet getByStatus(Connection conn,CustInfoEntityExtd custInfo) throws SQLException {
		String selectSql="select cust_id,cust_name,cust_status,cust_type,cust_lvl,cust_ind from cust_info where cust_status=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, custInfo.getCustStatus());
		return ps.executeQuery();
	}
	
	/**
	 * 根据 custType 抽出每条部分信息，显示多条
	 */
	@Override
	public ResultSet getByType(Connection conn,CustInfoEntityExtd custInfo) throws SQLException {
		String selectSql="select cust_id,cust_name,cust_status,cust_type,cust_lvl,cust_ind from cust_info where cust_type=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, custInfo.getCustType());
		return ps.executeQuery();
	}
	
	/**
	 * 根据 custLvl 抽出每条部分信息，显示多条
	 */
	@Override
	public ResultSet getByLvl(Connection conn,CustInfoEntityExtd custInfo) throws SQLException {
		String selectSql="select cust_id,cust_name,cust_status,cust_type,cust_lvl,cust_ind from cust_info where cust_lvl=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, custInfo.getCustLvl());
		return ps.executeQuery();
	}

	/**
	 * 抽出每条部分信息，显示全部条数
	 */
	@Override
	public ResultSet getAll(Connection conn) throws SQLException {
		String selectSql="select cust_id,cust_name,cust_status,cust_type,cust_lvl,cust_ind from cust_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 抽出全部条数的 custId
	 */
	@Override
	public ResultSet getAllId(Connection conn) throws SQLException {
		String selectSql="select cust_id from cust_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 抽出全部条数的 custName
	 */
	@Override
	public ResultSet getAllName(Connection conn) throws SQLException {
		String selectSql="select cust_name from cust_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 返回 CustInfo 的总条数
	 */
	@Override
	public ResultSet getNum(Connection conn) throws SQLException {
		String selectSql="select count(cust_id) from cust_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
}
