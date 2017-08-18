package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.OfrInfoDao;
import com.crm.dao.impl.OfrInfoDaoImpl;
import com.crm.entity.extd.OfrInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class DeleteOfrInfoService {

	private OfrInfoDao ofrInfoDao=new OfrInfoDaoImpl();


	public void deleteOfrInfo(OfrInfoEntityExtd ofrInfo){

		Connection conn=null;

		try {

			conn=ConnectionFactory.getInstance().getConnection();
			ofrInfoDao.delete(conn, ofrInfo);

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

	public void deleteMulOfrInfo(OfrInfoEntityExtd ofrInfo[]){

		Connection conn=null;

		try {

			conn=ConnectionFactory.getInstance().getConnection();
			ofrInfoDao.deleteMul(conn, ofrInfo);

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
