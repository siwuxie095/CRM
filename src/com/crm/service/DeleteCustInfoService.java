package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.CustInfoDao;
import com.crm.dao.impl.CustInfoDaoImpl;
import com.crm.entity.extd.CustInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class DeleteCustInfoService {
	private CustInfoDao custInfoDao=new CustInfoDaoImpl();
	
	public void deleteCustInfo(CustInfoEntityExtd custInfo){
		
		Connection conn=null;
		
		conn=ConnectionFactory.getInstance().getConnection();
		try {
			custInfoDao.delete(conn, custInfo);
		} catch (SQLException e) {
			
			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public void delMulCustInfo(CustInfoEntityExtd custInfo[]) {
Connection conn=null;
		
		conn=ConnectionFactory.getInstance().getConnection();
		try {
			custInfoDao.deleteMul(conn, custInfo);
		} catch (SQLException e) {
			
			System.out.println("------------- 捕获到 SQL 异常 -------------");
			e.printStackTrace();
			
		}finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
