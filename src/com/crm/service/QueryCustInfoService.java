package com.crm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.CustInfoDao;
import com.crm.dao.impl.CustInfoDaoImpl;
import com.crm.entity.extd.CustInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class QueryCustInfoService {
	
	private CustInfoDao custInfoDao=new CustInfoDaoImpl();
	
	public String[][] queryCustInfo(CustInfoEntityExtd custInfo,boolean flag){
		
		Connection conn=null;
		
			try {
				
				conn=ConnectionFactory.getInstance().getConnection();
				
				ResultSet rs=null;
				//如果为true，则用custName进行模糊查询，否则用custId进行模糊查询
				if (flag) {
					rs=custInfoDao.getX(conn, custInfo,custInfo.getCustName());
				} else {
					rs=custInfoDao.get(conn, custInfo,custInfo.getCustId());
				}
				
				int num=0;
				while (rs.next()) {
					num++;
				}
				
				if (num==0) {
					return null;
				}
				
				ResultSet rsx=null;
				
				if (flag) {
					rsx=custInfoDao.getX(conn, custInfo,custInfo.getCustName());
				} else {
					rsx=custInfoDao.get(conn, custInfo,custInfo.getCustId());
				}
				
				String infoList[][]=new String[num][6];
				int numx=0;
				while (rsx.next()) {
					infoList[numx][0]=rsx.getString("cust_id");
					//System.out.println(rs.getString("cust_id"));
					
					infoList[numx][1]=rsx.getString("cust_name");
					//System.out.println(rs.getString("cust_name"));
					
					infoList[numx][2]=rsx.getString("cust_status");
					//System.out.println(rs.getString("cust_status"));
					
					infoList[numx][3]=rsx.getString("cust_type");
					//System.out.println(rs.getString("cust_type"));
					
					infoList[numx][4]=rsx.getString("cust_lvl");
					//System.out.println(rs.getString("cust_lvl"));
					
					infoList[numx][5]=rsx.getString("cust_ind");
					//System.out.println(rs.getString("cust_ind"));
					
					numx++;
				}
				return infoList;
			} catch (SQLException e) {
				
				System.out.println("------------- 捕获到 SQL 异常 -------------");
				e.printStackTrace();
				
			}finally {
				try {
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		
		return null;
	}
}
