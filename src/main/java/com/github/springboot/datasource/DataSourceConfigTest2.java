//package com.github.springboot.datasource;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//
//import javax.sql.DataSource;
//
///**
// * @author xiaoping
// * @date 2018-04-10 14:50
// */
//@Configuration //注册到springboot容器中
//@MapperScan(basePackages = "com.github.springboot.test2", sqlSessionFactoryRef = "test2SqlSessionFactory")
//public class DataSourceConfigTest2 {
//    /**
//     * 配置test2数据库
//     * @return
//     */
//    @Bean(name = "test2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.test2")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    /**
//     * test2 sql会话工厂
//     * @param dataSource
//     * @return
//     * @throws Exception
//     */
//    @Bean("test2SqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource) throws Exception{
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        return bean.getObject();
//    }
//
//    /**
//     * test2 事务管理
//     * @param dataSource
//     * @return
//     */
//    @Bean("test2TransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean("test2SqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory)throws Exception{
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
