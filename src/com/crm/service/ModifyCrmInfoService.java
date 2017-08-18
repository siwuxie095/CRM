package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.CrmInfoDao;
import com.crm.dao.impl.CrmInfoDaoImpl;
import com.crm.entity.extd.CrmInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class ModifyCrmInfoService {
	
	private CrmInfoDao crmInfoDao=new CrmInfoDaoImpl();
	
	
	public void modifyCrmInfo(CrmInfoEntityExtd crmInfo) {
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			crmInfoDao.update(conn, crmInfo);
			conn.commit();
			
		} catch (SQLException e) {
			
			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();
			
			try {
				conn.rollback();
				System.out.println("------------- 事务回滚成功 -------------");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
