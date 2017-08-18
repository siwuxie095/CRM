package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.CrmInfoDao;
import com.crm.dao.CrmPwdxDao;
import com.crm.dao.impl.CrmInfoDaoImpl;
import com.crm.dao.impl.CrmPwdxDaoImpl;
import com.crm.entity.extd.CrmInfoEntityExtd;
import com.crm.entity.extd.CrmPwdxEntityExtd;
import com.crm.util.ConnectionFactory;

public class DeleteCrmInfoService {
	
	private CrmInfoDao crmInfoDao=new CrmInfoDaoImpl();
	private CrmPwdxDao crmPwdxDao=new CrmPwdxDaoImpl();
	
public void deleteCrmInfo(CrmInfoEntityExtd crmInfo,CrmPwdxEntityExtd crmPwdx) {
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			crmInfoDao.delete(conn, crmInfo);
			crmPwdxDao.delete(conn, crmPwdx);
			
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
	
	
	
	public void deleteMulCrmInfo(CrmInfoEntityExtd crmInfo[],CrmPwdxEntityExtd crmPwdx[]) {
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			crmInfoDao.deleteMul(conn, crmInfo);
			crmPwdxDao.deleteMul(conn, crmPwdx);
			
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
