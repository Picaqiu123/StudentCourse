package com.xiaohe.utils;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
//加载db.properties配置文件,返回Datasource数据源
//QueryRunner queryRunner = new QueryRunner(dataSource);		//此处传入连接池
public class PropertiesUtils {
    private static Properties properties = new Properties();

    static {
        InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSourse() throws Exception {
        BasicDataSourceFactory.createDataSource(properties);
        return null;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException, SQLException {
        String RL = "jdbc:mysql://localhost:3306/stu_course?serverTimezone=UTC&characterEncoding=utf-8";
        String user = "root";
        String password = "123456";
        Connection conn = null;
        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库
        conn = DriverManager.getConnection(RL, user, password);
        return conn;
    }

    //关闭数据库连接
    public static void closeConnection(Connection conn) throws SQLException, SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
