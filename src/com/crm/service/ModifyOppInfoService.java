package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.OppInfoDao;
import com.crm.dao.impl.OppInfoDaoImpl;
import com.crm.entity.extd.OppInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class ModifyOppInfoService {
	
	OppInfoDao oppInfoDao=new OppInfoDaoImpl();
	
	public void modifyOppInfo(OppInfoEntityExtd oppInfo) {
		
		Connection conn=null;
		
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			oppInfoDao.update(conn, oppInfo);
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
