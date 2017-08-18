package com.crm.service;

import java.sql.Connection;
import java.sql.ResultSet;

import com.crm.dao.CrmPwdxDao;
import com.crm.dao.impl.CrmPwdxDaoImpl;
import com.crm.entity.extd.CrmPwdxEntityExtd;
import com.crm.util.ConnectionFactory;


public class CheckCrmPwdxService {
	
	private CrmPwdxDao crmPwdxDao=new CrmPwdxDaoImpl();
	
	
	public boolean checkCrmId(CrmPwdxEntityExtd crmPwdx){
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			ResultSet rs=crmPwdxDao.getX(conn, crmPwdx);
			
			while (rs.next()) {
				
				return true;				
			}
		} catch (Exception e) {
			
			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean checkCrmPwdx(CrmPwdxEntityExtd crmPwdx){
		
		Connection conn=null;
		
		try {
			
			conn=ConnectionFactory.getInstance().getConnection();
			ResultSet rs=crmPwdxDao.get(conn, crmPwdx);
			
			while (rs.next()) {
				
				return true;				
			}
			
		} catch (Exception e) {
			
			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
		return false;
	}

}
