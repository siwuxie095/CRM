package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.LogInfoDao;
import com.crm.dao.impl.LogInfoDaoImpl;
import com.crm.entity.extd.LogInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class DeleteLogInfoService {
	
	private LogInfoDao logInfoDao=new LogInfoDaoImpl();
	
	
	public void deleteLogInfo(LogInfoEntityExtd logInfo){

		Connection conn=null;

		try {

			conn=ConnectionFactory.getInstance().getConnection();
			logInfoDao.delete(conn, logInfo);

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

	public void deleteMulLogInfo(LogInfoEntityExtd logInfo[]){

		Connection conn=null;

		try {

			conn=ConnectionFactory.getInstance().getConnection();
			logInfoDao.deleteMul(conn, logInfo);

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
