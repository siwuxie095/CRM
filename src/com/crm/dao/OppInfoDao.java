package com.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.entity.extd.OppInfoEntityExtd;

public interface OppInfoDao {
	public void save(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException;
	public void delete(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException;
	public void deleteMul(Connection conn,OppInfoEntityExtd[] oppInfo) throws SQLException;
	public void update(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException;
	public ResultSet get(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException; 
	public ResultSet getX(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException; 
	public ResultSet getDtlById(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException; 
	public ResultSet getDtlByName(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException; 
	public ResultSet getY(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException; 
	public ResultSet getZ(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException; 
	public ResultSet getAll(Connection conn) throws SQLException; 
	public ResultSet getAllX(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException; 
	public ResultSet getAllId(Connection conn) throws SQLException; 
	public ResultSet getNum(Connection conn) throws SQLException; 
}
