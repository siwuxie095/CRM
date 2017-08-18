package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.OppInfoDao;
import com.crm.dao.impl.OppInfoDaoImpl;
import com.crm.entity.extd.OppInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class DeleteOppInfoService {
	
	private OppInfoDao oppInfoDao=new OppInfoDaoImpl();
	
	
	public void deleteOppInfo(OppInfoEntityExtd oppInfo){
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			oppInfoDao.delete(conn, oppInfo);
			
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
	
	public void deleteMulOppInfo(OppInfoEntityExtd oppInfo[]){
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			oppInfoDao.deleteMul(conn, oppInfo);
			
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
