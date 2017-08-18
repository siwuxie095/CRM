package com.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.entity.extd.CtcInfoEntityExtd;

public interface CtcInfoDao {
	public void save(Connection conn,CtcInfoEntityExtd ctcInfo) throws SQLException;
	public void delete(Connection conn,CtcInfoEntityExtd ctcInfo) throws SQLException;
	public void deleteMul(Connection conn,CtcInfoEntityExtd[] ctcInfo) throws SQLException;
	public void update(Connection conn,CtcInfoEntityExtd ctcInfo) throws SQLException;
	public ResultSet get(Connection conn,CtcInfoEntityExtd ctcInfo,String ctcId) throws SQLException; 
	public ResultSet getX(Connection conn,CtcInfoEntityExtd ctcInfo,String ctcName) throws SQLException; 
	public ResultSet getDtlById(Connection conn,CtcInfoEntityExtd ctcInfo) throws SQLException; 
	public ResultSet getDtlByName(Connection conn,CtcInfoEntityExtd ctcInfo) throws SQLException; 
	public ResultSet getY(Connection conn,CtcInfoEntityExtd ctcInfo) throws SQLException; 
	public ResultSet getZ(Connection conn,CtcInfoEntityExtd ctcInfo) throws SQLException; 
	public ResultSet getAll(Connection conn) throws SQLException; 
	public ResultSet getAllId(Connection conn) throws SQLException; 
	public ResultSet getAllName(Connection conn) throws SQLException; 
	public ResultSet getNum(Connection conn) throws SQLException; 
}
