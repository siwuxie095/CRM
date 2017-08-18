package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.CustInfoDao;
import com.crm.dao.impl.CustInfoDaoImpl;
import com.crm.entity.extd.CustInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class ModifyCustInfoService {
	
	private CustInfoDao custInfoDao=new CustInfoDaoImpl();
	
	public void modifyCustInfo(CustInfoEntityExtd custInfo){
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			custInfoDao.update(conn, custInfo);
			conn.commit();
			
		} catch (SQLException e) {
			
			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();
			
			try {
				conn.rollback();
				System.out.println("------------- 事务回滚成功 -------------");
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
