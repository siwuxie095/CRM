package com.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.entity.extd.LogInfoEntityExtd;

public interface LogInfoDao {
	public void save(Connection conn,LogInfoEntityExtd logInfo) throws SQLException;
	public void delete(Connection conn,LogInfoEntityExtd logInfo) throws SQLException;
	public void deleteMul(Connection conn,LogInfoEntityExtd[] logInfo) throws SQLException;
	public void update(Connection conn,LogInfoEntityExtd logInfo) throws SQLException;
	public ResultSet get(Connection conn,LogInfoEntityExtd logInfo) throws SQLException; 
	public ResultSet getX(Connection conn,LogInfoEntityExtd logInfo) throws SQLException; 
	public ResultSet getDtlById(Connection conn,LogInfoEntityExtd logInfo) throws SQLException; 
	public ResultSet getDtlByName(Connection conn,LogInfoEntityExtd logInfo) throws SQLException; 
	public ResultSet getAll(Connection conn) throws SQLException; 
	public ResultSet getAllX(Connection conn,LogInfoEntityExtd logInfo) throws SQLException; 
	public ResultSet getAllId(Connection conn) throws SQLException; 
	public ResultSet getNum(Connection conn) throws SQLException; 
}
