package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.CtcInfoDao;
import com.crm.dao.impl.CtcInfoDaoImpl;
import com.crm.entity.extd.CtcInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class DeleteCtcInfoService {
	
	private CtcInfoDao ctcInfoDao=new CtcInfoDaoImpl();
	
	public void deleteCtcInfo(CtcInfoEntityExtd ctcInfo) {
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			ctcInfoDao.delete(conn, ctcInfo);
			
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
	}
	
	
	
	public void deleteMulCtcInfo(CtcInfoEntityExtd ctcInfo[]) {
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			ctcInfoDao.deleteMul(conn, ctcInfo);
			
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
	}

}
