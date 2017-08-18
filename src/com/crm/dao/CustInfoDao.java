package com.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.entity.extd.CustInfoEntityExtd;

public interface CustInfoDao {
	public void save(Connection conn,CustInfoEntityExtd custInfo) throws SQLException;
	public void delete(Connection conn,CustInfoEntityExtd custInfo) throws SQLException;
	public void deleteMul(Connection conn,CustInfoEntityExtd[] custInfo) throws SQLException;
	public void update(Connection conn,CustInfoEntityExtd custInfo) throws SQLException;
	public ResultSet get(Connection conn,CustInfoEntityExtd custInfo,String custId) throws SQLException; 
	public ResultSet getX(Connection conn,CustInfoEntityExtd custInfo,String custName) throws SQLException; 
	public ResultSet getY(Connection conn,CustInfoEntityExtd custInfo) throws SQLException; 
	public ResultSet getDtlById(Connection conn,CustInfoEntityExtd custInfo) throws SQLException; 
	public ResultSet getDtlByName(Connection conn,CustInfoEntityExtd custInfo) throws SQLException; 
	public ResultSet getByStatus(Connection conn,CustInfoEntityExtd custInfo) throws SQLException; 
	public ResultSet getByType(Connection conn,CustInfoEntityExtd custInfo) throws SQLException; 
	public ResultSet getByLvl(Connection conn,CustInfoEntityExtd custInfo) throws SQLException; 
	public ResultSet getAll(Connection conn) throws SQLException; 
	public ResultSet getAllId(Connection conn) throws SQLException; 
	public ResultSet getAllName(Connection conn) throws SQLException; 
	public ResultSet getNum(Connection conn) throws SQLException; 
}
