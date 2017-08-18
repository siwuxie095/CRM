package com.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.entity.extd.DealInfoEntityExtd;

public interface DealInfoDao {
	public void save(Connection conn,DealInfoEntityExtd dealInfo) throws SQLException;
	public void delete(Connection conn,DealInfoEntityExtd dealInfo) throws SQLException;
	public void deleteMul(Connection conn,DealInfoEntityExtd[] dealInfo) throws SQLException;
	public void update(Connection conn,DealInfoEntityExtd dealInfo) throws SQLException;
	public ResultSet get(Connection conn,DealInfoEntityExtd dealInfo) throws SQLException; 
	public ResultSet getX(Connection conn,DealInfoEntityExtd dealInfo) throws SQLException; 
	public ResultSet getDtlById(Connection conn,DealInfoEntityExtd dealInfo) throws SQLException; 
	public ResultSet getDtlByName(Connection conn,DealInfoEntityExtd dealInfo) throws SQLException;
	public ResultSet getAll(Connection conn) throws SQLException; 
	public ResultSet getAllX(Connection conn,DealInfoEntityExtd dealInfo) throws SQLException;
	public ResultSet getAllId(Connection conn) throws SQLException; 
	public ResultSet getNum(Connection conn) throws SQLException; 
}
