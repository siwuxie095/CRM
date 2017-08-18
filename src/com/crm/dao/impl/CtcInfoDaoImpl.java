package com.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.CtcInfoDao;
import com.crm.entity.extd.CtcInfoEntityExtd;

public class CtcInfoDaoImpl implements CtcInfoDao {

	@Override
	public void save(Connection conn, CtcInfoEntityExtd ctcInfo) throws SQLException {
		String insertSql="insert into ctc_info(crm_id,ctc_id,ctc_name,ctc_title,ctc_cel,ctc_tel,ctc_fax,ctc_mail,cust_name,ctc_prov,ctc_city,ctc_addr,ctc_rmk) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertSql);
		ps.setString(1, ctcInfo.getCrmId());
		ps.setString(2, ctcInfo.getCtcId());
		ps.setString(3, ctcInfo.getCtcName());
		ps.setString(4, ctcInfo.getCtcTitle());
		ps.setString(5, ctcInfo.getCtcCel());
		ps.setString(6, ctcInfo.getCtcTel());
		ps.setString(7, ctcInfo.getCtcFax());
		ps.setString(8, ctcInfo.getCtcMail());
		ps.setString(9, ctcInfo.getCustName());
		ps.setString(10, ctcInfo.getCtcProv());
		ps.setString(11, ctcInfo.getCtcCity());
		ps.setString(12, ctcInfo.getCtcAddr());
		ps.setString(13, ctcInfo.getCtcRmk());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, CtcInfoEntityExtd ctcInfo) throws SQLException {
		String deleteSql="delete from ctc_info where ctc_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		ps.setString(1, ctcInfo.getCtcId());
		ps.execute();
	}

	@Override
	public void deleteMul(Connection conn, CtcInfoEntityExtd[] ctcInfo) throws SQLException {
		String deleteSql="delete from ctc_info where ctc_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		for (int i = 0; i < ctcInfo.length; i++) {
			ps.setString(1, ctcInfo[i].getCtcId());
			ps.execute();
		}
	}

	@Override
	public void update(Connection conn, CtcInfoEntityExtd ctcInfo) throws SQLException {
		String updateSql="update ctc_info set crm_id=?,ctc_name=?,ctc_title=?,ctc_cel=?,ctc_tel=?,ctc_fax=?,ctc_mail=?,cust_name=?,ctc_prov=?,ctc_city=?,ctc_addr=?,ctc_rmk=? where ctc_id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, ctcInfo.getCrmId());
		ps.setString(2, ctcInfo.getCtcName());
		ps.setString(3, ctcInfo.getCtcTitle());
		ps.setString(4, ctcInfo.getCtcCel());
		ps.setString(5, ctcInfo.getCtcTel());
		ps.setString(6, ctcInfo.getCtcFax());
		ps.setString(7, ctcInfo.getCtcMail());
		ps.setString(8, ctcInfo.getCustName());
		ps.setString(9, ctcInfo.getCtcProv());
		ps.setString(10, ctcInfo.getCtcCity());
		ps.setString(11, ctcInfo.getCtcAddr());
		ps.setString(12, ctcInfo.getCtcRmk());
		ps.setString(13, ctcInfo.getCtcId());
		ps.execute();
	}

	/**
	 * 根据 ctcId 进行模糊查询
	 */
	@Override
	public ResultSet get(Connection conn, CtcInfoEntityExtd ctcInfo,String ctcId) throws SQLException {
		String selectSql="select ctc_id,ctc_name,ctc_title,ctc_cel,ctc_mail,cust_name from ctc_info where ctc_id like '%"+ctcId+"%'";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 根据 ctcName 进行模糊查询
	 */
	@Override
	public ResultSet getX(Connection conn, CtcInfoEntityExtd ctcInfo,String ctcName) throws SQLException {
		String selectSql="select ctc_id,ctc_name,ctc_title,ctc_cel,ctc_mail,cust_name from ctc_info where ctc_name like '%"+ctcName+"%'";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}

	@Override
	public ResultSet getDtlById(Connection conn, CtcInfoEntityExtd ctcInfo) throws SQLException {
		String selectSql="select * from ctc_info where ctc_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, ctcInfo.getCtcId());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getDtlByName(Connection conn, CtcInfoEntityExtd ctcInfo) throws SQLException {
		String selectSql="select * from ctc_info where ctc_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, ctcInfo.getCtcName());
		return ps.executeQuery();
	}
	
	
	@Override
	public ResultSet getY(Connection conn, CtcInfoEntityExtd ctcInfo) throws SQLException {
		String selectSql="select ctc_id from ctc_info where cust_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, ctcInfo.getCustName());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getZ(Connection conn, CtcInfoEntityExtd ctcInfo) throws SQLException {
		String selectSql="select ctc_id from ctc_info where cust_name=? and ctc_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, ctcInfo.getCustName());
		ps.setString(2, ctcInfo.getCtcName());
		return ps.executeQuery();
	}

	/**
	 * 抽出每条部分信息，显示全部条数
	 */
	@Override
	public ResultSet getAll(Connection conn) throws SQLException {
		String selectSql="select ctc_id,ctc_name,ctc_title,ctc_cel,ctc_mail,cust_name from ctc_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 抽出全部条数的 ctcId
	 */
	@Override
	public ResultSet getAllId(Connection conn) throws SQLException {
		String selectSql="select ctc_id from ctc_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 抽出全部条数的 ctcName
	 */
	@Override
	public ResultSet getAllName(Connection conn) throws SQLException {
		String selectSql="select ctc_id from ctc_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 返回 CtcInfo 的总条数
	 */
	@Override
	public ResultSet getNum(Connection conn) throws SQLException {
		String selectSql="select count(ctc_id) from ctc_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	

}
