package com.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.OppInfoDao;
import com.crm.entity.extd.OppInfoEntityExtd;

public class OppInfoDaoImpl implements OppInfoDao {

	@Override
	public void save(Connection conn, OppInfoEntityExtd oppInfo) throws SQLException {
		String insertSql="insert into opp_info(crm_name,opp_id,opp_name,cust_name,ctc_name,prod_sort,sale_stg,opp_src,pre_sale_sum,pre_deal_date,succ_per,opp_rmk) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(insertSql);
		ps.setString(1, oppInfo.getCrmName());
		ps.setString(2, oppInfo.getOppId());
		ps.setString(3, oppInfo.getOppName());
		ps.setString(4, oppInfo.getCustName());
		ps.setString(5, oppInfo.getCtcName());
		ps.setString(6, oppInfo.getProdSort());
		ps.setString(7, oppInfo.getSaleStg());
		ps.setString(8, oppInfo.getOppSrc());
		ps.setString(9, oppInfo.getPreSaleSum());
		ps.setString(10, oppInfo.getPreDealDate());
		ps.setString(11, oppInfo.getSuccPer());
		ps.setString(12, oppInfo.getOppRmk());
		ps.execute();
	}

	@Override
	public void delete(Connection conn, OppInfoEntityExtd oppInfo) throws SQLException {
		String deleteSql="delete from opp_info where opp_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		ps.setString(1, oppInfo.getOppId());
		ps.execute();
	}

	@Override
	public void deleteMul(Connection conn, OppInfoEntityExtd[] oppInfo) throws SQLException {
		String deleteSql="delete from opp_info where opp_id=?";
		PreparedStatement ps=conn.prepareStatement(deleteSql);
		for (int i = 0; i < oppInfo.length; i++) {
			ps.setString(1, oppInfo[i].getOppId());
			ps.execute();
		}
	}

	@Override
	public void update(Connection conn, OppInfoEntityExtd oppInfo) throws SQLException {
		String updateSql="update opp_info set crm_name=?,opp_name=?,cust_name=?,ctc_name=?,prod_sort=?,sale_stg=?,opp_src=?,pre_sale_sum=?,pre_deal_date=?,succ_per=?,opp_rmk=? where opp_id=?";
		PreparedStatement ps=conn.prepareStatement(updateSql);
		ps.setString(1, oppInfo.getCrmName());
		ps.setString(2, oppInfo.getOppName());
		ps.setString(3, oppInfo.getCustName());
		ps.setString(4, oppInfo.getCtcName());
		ps.setString(5, oppInfo.getProdSort());
		ps.setString(6, oppInfo.getSaleStg());
		ps.setString(7, oppInfo.getOppSrc());
		ps.setString(8, oppInfo.getPreSaleSum());
		ps.setString(9, oppInfo.getPreDealDate());
		ps.setString(10, oppInfo.getSuccPer());
		ps.setString(11, oppInfo.getOppRmk());
		ps.setString(12, oppInfo.getOppId());
		ps.execute();
	}

	/**
	 * 抽出每条部分信息，显示单条
	 */
	@Override
	public ResultSet get(Connection conn, OppInfoEntityExtd oppInfo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 检索问题：注意判断是不是该的销售负责人
	 */
	@Override
	public ResultSet getX(Connection conn, OppInfoEntityExtd oppInfo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public ResultSet getDtlById(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException {
		String selectSql="select * from opp_info where opp_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, oppInfo.getOppId());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getDtlByName(Connection conn,OppInfoEntityExtd oppInfo) throws SQLException {
		String selectSql="select * from opp_info where opp_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, oppInfo.getOppName());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getY(Connection conn, OppInfoEntityExtd oppInfo) throws SQLException {
		String selectSql="select cust_name,ctc_name,opp_id from opp_info where crm_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, oppInfo.getCrmName());
		return ps.executeQuery();
	}
	
	@Override
	public ResultSet getZ(Connection conn, OppInfoEntityExtd oppInfo) throws SQLException {
		String selectSql="select opp_id from opp_info where cust_name=? and ctc_name=? and opp_id=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, oppInfo.getCustName());
		ps.setString(2, oppInfo.getCtcName());
		ps.setString(3, oppInfo.getOppId());
		return ps.executeQuery();
	}
	

	/**
	 * 抽出每条部分信息，显示全部条数
	 * 用于管理员和客户经理
	 */
	@Override
	public ResultSet getAll(Connection conn) throws SQLException {
		String selectSql="select opp_id,opp_name,sale_stg,opp_src,pre_sale_sum,pre_deal_date,succ_per,crm_name,cust_name,ctc_name from opp_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 抽出每条部分信息，显示全部条数
	 * 用于销售人员
	 */
	@Override
	public ResultSet getAllX(Connection conn, OppInfoEntityExtd oppInfo) throws SQLException {
		String selectSql="select opp_id,opp_name,sale_stg,opp_src,pre_sale_sum,pre_deal_date,succ_per,crm_name,cust_name,ctc_name from opp_info where crm_name=?";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		ps.setString(1, oppInfo.getCrmName());
		return ps.executeQuery();
	}
	
	/**
	 * 抽出全部条数的 oppId
	 */
	@Override
	public ResultSet getAllId(Connection conn) throws SQLException {
		String selectSql="select opp_id from opp_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	/**
	 * 返回 oppInfo 的总条数
	 */
	@Override
	public ResultSet getNum(Connection conn) throws SQLException {
		String selectSql="select count(opp_id) from opp_info";
		PreparedStatement ps=conn.prepareStatement(selectSql);
		return ps.executeQuery();
	}
	
	
	
	

}
