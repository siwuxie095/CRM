package com.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.entity.extd.CrmPwdxEntityExtd;

public interface CrmPwdxDao {
	public void save(Connection conn,CrmPwdxEntityExtd crmPwdx) throws SQLException;
	public void delete(Connection conn,CrmPwdxEntityExtd crmPwdx) throws SQLException;
	public void deleteMul(Connection conn,CrmPwdxEntityExtd[] crmPwdx) throws SQLException;
	public void update(Connection conn,CrmPwdxEntityExtd crmPwdx) throws SQLException;
	public ResultSet get(Connection conn,CrmPwdxEntityExtd crmPwdx) throws SQLException;
	public ResultSet getX(Connection conn,CrmPwdxEntityExtd crmPwdx) throws SQLException;
	public ResultSet getAll(Connection conn) throws SQLException;
}
