package com.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.LogInfoDao;
import com.crm.entity.extd.LogInfoEntityExtd;

public class LogInfoDaoImpl implements LogInfoDao {

	@Override
	public void save(Connection conn, LogInfoEntityExtd logInfo) throws SQLException {
		String insertSql="insert into log_info(crm_name,log_id,log_thm,cust_name,ctc_name,opp_id,ctcx_style,ctcx_date,ctcx_detail,next_visit_date) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertSql);
		ps.setString(1, logInfo.getCrmName());
		ps.setString(2, logInfo.getLogId());
		ps.setString(3, logInfo.getLogThm());
		ps.setString(4, logInfo.getCustName());
		ps.setString(5, logInfo.getCtcName());
		ps.setString(6, logInfo.getOppId());
		ps.setString(7, logInfo.getCtcxStyle());
		ps.setString(8, logInfo.getCtcxDate());
		ps.setString(9, logInfo.getCtcxDetail());
		ps.setString(10, logInfo.getNextVistDate());
		ps.execute();
		
	}

	@Override
	public void delete(Connection conn, LogInfoEntityExtd logInfo) throws SQLException {
		String deleteSql="delete from log_info where log_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		ps.setString(1, logInfo.getLogId());
		ps.execute();
	}

	@Override
	public void deleteMul(Connection conn, LogInfoEntityExtd[] logInfo) throws SQLException {
		String deleteSql="delete from log_info where log_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		for (int i = 0; i < logInfo.length; i++) {
			ps.setString(1, logInfo[i].getLogId());
			ps.execute();
		}
	}

	@Override
	public void update(Connection conn, LogInfoEntityExtd logInfo) throws SQLException {
		String updateSql="update log_info set crm_name=?,log_thm=?,cust_name=?,ctc_name=?,opp_id=?,ctcx_style=?,ctcx_date=?,ctcx_detail=?,next_visit_date=? where log_id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, logInfo.getCrmName());
		ps.setString(2, logInfo.getLogThm());
		ps.setString(3, logInfo.getCustName());
		ps.setString(4, logInfo.getCtcName());
		ps.setString(5, logInfo.getOppId());
		ps.setString(6, logInfo.getCtcxStyle());
		ps.setString(7, logInfo.getCtcxDate());
		ps.setString(8, logInfo.getCtcxDetail());
		ps.setString(9, logInfo.getNextVistDate());
		ps.setString(10, logInfo.getLogId());
		ps.execute();

	}

	/**
	 * 抽出每条部分信息，显示单条
	 */
	@Override
	public ResultSet get(Connection conn, LogInfoEntityExtd logInfo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 检索问题：注意判断是不是该的销售负责人
	 */
	@Override
	public ResultSet getX(Connection conn, LogInfoEntityExtd logInfo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResultSet getDtlById(Connection conn, LogInfoEntityExtd logInfo) throws SQLException {
		String selectSql="select * from log_info where log_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, logInfo.getLogId());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getDtlByName(Connection conn, LogInfoEntityExtd logInfo) throws SQLException {
		String selectSql="select * from log_info where log_thm=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, logInfo.getLogThm());
		return ps.executeQuery();
	}
	
	/**
	 * 此接口留作备用
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	@Override
	public ResultSet getAll(Connection conn) throws SQLException {
		String selectSql="select log_id,log_thm,cust_name,ctc_name,ctcx_style,ctcx_date,ctcx_detail,next_visit_date,crm_name from log_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}

	/**
	 * 抽出每条部分信息，显示全部条数
	 */
	@Override
	public ResultSet getAllX(Connection conn, LogInfoEntityExtd logInfo) throws SQLException {
		String selectSql="select log_id,log_thm,cust_name,ctc_name,ctcx_style,ctcx_date,ctcx_detail,next_visit_date from log_info where crm_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		System.out.println(logInfo.getCrmName());
		ps.setString(1, logInfo.getCrmName());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getAllId(Connection conn) throws SQLException {
		String selectSql="select log_id from log_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getNum(Connection conn) throws SQLException {
		String selectSql="select count(log_id) from log_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}

}
