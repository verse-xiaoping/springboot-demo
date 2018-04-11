package com.github.springboot.datasource;//package com.github.springboot.datasource.datasource;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author xiaoping
 * @date 2018-04-10 14:50
 */
@Configuration //注册到springboot容器中
@MapperScan(basePackages = "com.github.springboot.test2", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class TestMybatisConfig2 {
    /**
     * 配置数据源
     */
    @Bean(name = "test2DataSource")
    public DataSource testDataSource(DbConfig2 testConfig) throws SQLException{
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(testConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(testConfig.getPassword());
        mysqlXADataSource.setUser(testConfig.getUsername());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("test2DataSource");
        atomikosDataSourceBean.setMinPoolSize(testConfig.getMinPoolSize());
        atomikosDataSourceBean.setMaxPoolSize(testConfig.getMaxPoolSize());
        atomikosDataSourceBean.setMaxLifetime(testConfig.getMaxLifetime());
        atomikosDataSourceBean.setBorrowConnectionTimeout(testConfig.getBorrowConnectionTimeout());
        atomikosDataSourceBean.setLoginTimeout(testConfig.getLoginTimeout());
        atomikosDataSourceBean.setMaintenanceInterval(testConfig.getMaintenanceInterval());
        atomikosDataSourceBean.setMaxIdleTime(testConfig.getMaxIdleTime());
        atomikosDataSourceBean.setTestQuery(testConfig.getTestQuery());

        return atomikosDataSourceBean;
    }

    /**
     * test2 sql会话工厂
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    /**
     * test2 事务管理(不用事务管理，已经交给了Atomikos)
     */
   /* @Bean(name = "test2TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }*/
    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
