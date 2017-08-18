package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.CrmPwdxDao;
import com.crm.dao.impl.CrmPwdxDaoImpl;
import com.crm.entity.extd.CrmPwdxEntityExtd;
import com.crm.util.ConnectionFactory;

public class ModifyCrmPwdxService {
	
	private CrmPwdxDao crmPwdxDao=new CrmPwdxDaoImpl();
	
	public void modifyCrmPwdx(CrmPwdxEntityExtd crmPwdx) {
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			crmPwdxDao.update(conn, crmPwdx);
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
