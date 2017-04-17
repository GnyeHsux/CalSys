package com.lcnet.lynn.config;

import org.nutz.dao.ConnCallback;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * Created by xusha on 2017/4/17.
 */
@Configuration
@Component("dao")
public class DaoConfig  extends NutDao implements Dao {
    DataSource druidDataSource;

    @Autowired   //这里注解只能写到set方法上，不然druidDataSource获取不到
    public void setDruidDataSource(DataSource druidDataSource) {
        this.druidDataSource = druidDataSource;
        setDataSource(druidDataSource);
    }

    public void run(ConnCallback callback) {
        Connection con = DataSourceUtils.getConnection(druidDataSource);
        try {
            callback.invoke(con);
        } catch (Exception e) {
            if (e instanceof RuntimeException)
                throw (RuntimeException) e;
            else
                throw new RuntimeException(e);
        } finally {
            DataSourceUtils.releaseConnection(con, druidDataSource);
        }
    }
}
