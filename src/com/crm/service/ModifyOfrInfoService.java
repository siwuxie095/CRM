package com.crm.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.crm.dao.OfrInfoDao;
import com.crm.dao.impl.OfrInfoDaoImpl;
import com.crm.entity.extd.OfrInfoEntityExtd;
import com.crm.util.ConnectionFactory;

public class ModifyOfrInfoService {

	private OfrInfoDao ofrInfoDao = new OfrInfoDaoImpl();

	public void modifyOfrInfo(OfrInfoEntityExtd ofrInfo) {

		Connection conn = null;

		try {

			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			ofrInfoDao.update(conn, ofrInfo);
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
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
