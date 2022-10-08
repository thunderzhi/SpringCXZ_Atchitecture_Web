package com.cxz.cxzspringboot_web.config;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author cxz
 * @Title:
 * @Package
 * @Description:
 * @date 2021/8/26 15:40
 */
@Configuration
@MapperScan(basePackages ="com.cxz.cxzspringboot_web.mapper.CommonTest",
sqlSessionFactoryRef = "CommonTestSqlSessionFactory")
public class CommonTestDataSourceConfig {

    @Autowired
    @Qualifier("CommonTestSource")
    private DataSource ds;

    @Bean(name="CommonTestSqlSessionFactory")
    @Primary
    public SqlSessionFactory CommonTestSqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        //指定mapper xml目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mapper/CommonTest/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);


        return sqlSessionFactoryBean.getObject();
    }


    @Bean
    public SqlSessionTemplate CommonTestSqlSessionTemplate(@Qualifier("CommonTestSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factoryc
         return template;
    }
}