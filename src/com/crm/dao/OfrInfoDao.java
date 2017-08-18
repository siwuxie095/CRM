package com.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.entity.extd.OfrInfoEntityExtd;

public interface OfrInfoDao {
	public void save(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException;
	public void delete(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException;
	public void deleteMul(Connection conn,OfrInfoEntityExtd[] ofrInfo) throws SQLException;
	public void update(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException;
	public ResultSet get(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException; 
	public ResultSet getX(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException; 
	public ResultSet getDtlById(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException; 
	public ResultSet getDtlByName(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException; 
	public ResultSet getY(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException; 
	public ResultSet getZ(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException; 
	public ResultSet getAll(Connection conn) throws SQLException; 
	public ResultSet getAllX(Connection conn,OfrInfoEntityExtd ofrInfo) throws SQLException;
	public ResultSet getAllId(Connection conn) throws SQLException; 
	public ResultSet getNum(Connection conn) throws SQLException; 
}
