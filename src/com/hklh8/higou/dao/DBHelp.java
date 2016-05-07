package com.hklh8.higou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 使用DbUtils实现的工具类
 * 
 * @author tanlan
 * 
 */
public class DBHelp {
	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		DbUtils.loadDriver("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "xikeda", "xikeda");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 */
	public static void closeConnection(Connection conn) {
		try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行增加，修改和删除的SQL
	 * 
	 * @param sql
	 * @param params
	 *            为占位符准备的参数
	 */
	public static void execute(String sql, Object... params) {
		QueryRunner qr = new QueryRunner();
		try {
			qr.update(getConnection(), sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行查询的SQL
	 * 
	 * @param sql
	 * @param c
	 * @param params
	 * @return 实体类的集合
	 */
	public static <T> List<T> executeQuery(String sql, Class<T> c,
			Object... params) {
		QueryRunner qr = new QueryRunner();
		try {
			return qr.query(getConnection(), sql, new BeanListHandler<>(c),
					params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 执行查询SQL，返回单个实体
	// 执行查询SQL，返回单个实体
	public static <T> T getSingle(String sql, Class<T> c, Object... params) {
		QueryRunner qr = new QueryRunner();
		try {
			return qr.query(getConnection(), sql, new BeanHandler<>(c), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 执行查询SQL，返回是一个标量，例如，数量，最大值，最小值，平均值，求和
	public static <T> T getScalar(String sql, Object... params) {
		QueryRunner qr = new QueryRunner();
		try {
			return qr.query(getConnection(), sql, new ScalarHandler<T>(),
					params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}