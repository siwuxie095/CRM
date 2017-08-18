package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.CtcInfoDao;
import com.crm.dao.impl.CtcInfoDaoImpl;
import com.crm.entity.extd.CtcInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class ModifyCtcInfoService {
	
	private CtcInfoDao ctcInfoDao=new CtcInfoDaoImpl();
	
	public void modifyCtcInfo(CtcInfoEntityExtd ctcInfo) {
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			ctcInfoDao.update(conn, ctcInfo);
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
