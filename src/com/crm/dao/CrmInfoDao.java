package com.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.entity.extd.CrmInfoEntityExtd;

public interface CrmInfoDao {
	public void save(Connection conn,CrmInfoEntityExtd crmInfo) throws SQLException;
	public void delete(Connection conn,CrmInfoEntityExtd crmInfo) throws SQLException;
	public void deleteMul(Connection conn,CrmInfoEntityExtd[] crmInfo) throws SQLException;
	public void update(Connection conn,CrmInfoEntityExtd crmInfo) throws SQLException;
	public ResultSet get(Connection conn,CrmInfoEntityExtd crmInfo) throws SQLException; 
	public ResultSet getX(Connection conn,CrmInfoEntityExtd crmInfo) throws SQLException; 
	public ResultSet getAll(Connection conn) throws SQLException; 
	public ResultSet getAllName(Connection conn) throws SQLException; 
	public ResultSet getNum(Connection conn) throws SQLException; 
}
