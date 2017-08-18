package com.crm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.dao.CtcInfoDao;
import com.crm.dao.impl.CtcInfoDaoImpl;
import com.crm.entity.extd.CtcInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class QueryCtcInfoService {
	
	private CtcInfoDao  ctcInfoDao=new CtcInfoDaoImpl();
	
	public String[][] queryCtcInfo(CtcInfoEntityExtd ctcInfo,boolean flag) {
		
		Connection conn=null;
		
			try {
				
				conn=ConnectionFactory.getInstance().getConnection();
				ResultSet rs=null;
				if (flag) {
					rs=ctcInfoDao.getX(conn, ctcInfo, ctcInfo.getCtcName());
				} else {
					rs=ctcInfoDao.get(conn, ctcInfo, ctcInfo.getCtcId());
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
					rsx=ctcInfoDao.getX(conn, ctcInfo, ctcInfo.getCtcName());
				} else {
					rsx=ctcInfoDao.get(conn, ctcInfo, ctcInfo.getCtcId());
				}
				
				String infoList[][]=new String[num][6];
				int numx=0;
				while (rsx.next()) {
					infoList[numx][0]=rsx.getString("ctc_id");
					//System.out.println(rs.getString("ctc_id"));
					
					infoList[numx][1]=rsx.getString("ctc_name");
					//System.out.println(rs.getString("ctc_name"));
					
					infoList[numx][2]=rsx.getString("ctc_title");
					//System.out.println(rs.getString("ctc_title"));
					
					infoList[numx][3]=rsx.getString("ctc_cel");
					//System.out.println(rs.getString("ctc_cel"));
					
					infoList[numx][4]=rsx.getString("ctc_mail");
					//System.out.println(rs.getString("ctc_mail"));
					
					infoList[numx][5]=rsx.getString("cust_name");
					//System.out.println(rs.getString("cust_name"));
					
					numx++;
				}
				return infoList;
				
				
				
				
			} catch (SQLException e) {
				
				System.out.println("------------- 捕获到 SQL 异常 -------------");
				e.printStackTrace();
				
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		return null;
	}

}
