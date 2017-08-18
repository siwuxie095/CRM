package com.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.CrmInfoDao;
import com.crm.entity.extd.CrmInfoEntityExtd;

public class CrmInfoDaoImpl implements CrmInfoDao {

	@Override
	public void save(Connection conn, CrmInfoEntityExtd crmInfo) throws SQLException {
		String insertSql="insert into crm_info(crm_id,crm_name,crm_title,crm_role) values(?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertSql);
		ps.setString(1, crmInfo.getCrmId());
		ps.setString(2, crmInfo.getCrmName());
		ps.setString(3, crmInfo.getCrmTitle());
		ps.setString(4, crmInfo.getCrmRole());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, CrmInfoEntityExtd crmInfo) throws SQLException {
		String deleteSql="delete from crm_info where crm_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		ps.setString(1, crmInfo.getCrmId());
		ps.execute();
	}
	
	@Override
	public void deleteMul(Connection conn, CrmInfoEntityExtd[] crmInfo) throws SQLException {
		String deleteSql="delete from crm_info where crm_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		for (int i = 0; i < crmInfo.length; i++) {
			ps.setString(1, crmInfo[i].getCrmId());
			ps.execute();
		}
	}

	@Override
	public void update(Connection conn, CrmInfoEntityExtd crmInfo) throws SQLException {
		String updateSql="update crm_info set crm_name=?,crm_title=?,crm_role=? where crm_id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, crmInfo.getCrmName());
		ps.setString(2, crmInfo.getCrmTitle());
		ps.setString(3, crmInfo.getCrmRole());
		ps.setString(4, crmInfo.getCrmId());
		ps.execute();
	}

	@Override
	public ResultSet get(Connection conn, CrmInfoEntityExtd crmInfo) throws SQLException {
		String selectSql="select * from crm_info where crm_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, crmInfo.getCrmId());
		return ps.executeQuery();
	}
	
	/**
	 * 只获取 crm_name，crm_title，crm_role
	 */
	@Override
	public ResultSet getX(Connection conn, CrmInfoEntityExtd crmInfo) throws SQLException {
		String selectSql="select crm_name,crm_title,crm_role from crm_info where crm_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, crmInfo.getCrmId());
		return ps.executeQuery();
	}

	@Override
	public ResultSet getAll(Connection conn) throws SQLException {
		String selectSql="select * from crm_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 返回全部条数的 crmName
	 */
	@Override
	public ResultSet getAllName(Connection conn) throws SQLException {
		String selectSql="select crm_name from crm_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 返回 crmInfo 的总条数
	 */
	@Override
	public ResultSet getNum(Connection conn) throws SQLException {
		String selectSql="select count(crm_id) from crm_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}

}
