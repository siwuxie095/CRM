package com.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.CrmPwdxDao;
import com.crm.entity.extd.CrmPwdxEntityExtd;

public class CrmPwdxDaoImpl implements CrmPwdxDao {

	@Override
	public void save(Connection conn, CrmPwdxEntityExtd crmPwdx) throws SQLException {
		String insertSql="insert into crm_pwdx(crm_id,crm_pwd) values(?,?)";
		PreparedStatement ps=conn.prepareStatement(insertSql);
		ps.setString(1, crmPwdx.getCrmId());
		ps.setString(2, crmPwdx.getCrmPwd());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, CrmPwdxEntityExtd crmPwdx) throws SQLException {
		String deleteSql="delete from crm_pwdx where crm_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		ps.setString(1, crmPwdx.getCrmId());
		ps.execute();
	}
	
	@Override
	public void deleteMul(Connection conn, CrmPwdxEntityExtd[] crmPwdx) throws SQLException {
		String deleteSql="delete from crm_pwdx where crm_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		for (int i = 0; i < crmPwdx.length; i++) {
			ps.setString(1, crmPwdx[i].getCrmId());
			ps.execute();
		}
	}

	@Override
	public void update(Connection conn, CrmPwdxEntityExtd crmPwdx) throws SQLException {
		String updateSql="update crm_pwdx set crm_pwd=? where crm_id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, crmPwdx.getCrmPwd());
		ps.setString(2, crmPwdx.getCrmId());
		ps.execute();
	}
	
	@Override
	public ResultSet get(Connection conn, CrmPwdxEntityExtd crmPwdx) throws SQLException {
		String selectSql="select * from crm_pwdx where crm_id=? and crm_pwd=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, crmPwdx.getCrmId());
		ps.setString(2, crmPwdx.getCrmPwd());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getX(Connection conn, CrmPwdxEntityExtd crmPwdx) throws SQLException {
		String selectSql="select * from crm_pwdx where crm_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, crmPwdx.getCrmId());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getAll(Connection conn) throws SQLException {
		String selectSql="select * from crm_pwdx";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}

}
