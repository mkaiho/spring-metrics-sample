package com.mkaiho.sample.springmetricsapp.infrastructure.datasource.configuration.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class MybatisConfiguration {
    @Bean
    SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeHandlersPackage("com.mkaiho.sample.springmetricsapp.infrastructure.datasource.configuration.mybatis.typehandler");
        return bean.getObject();
    }
}
