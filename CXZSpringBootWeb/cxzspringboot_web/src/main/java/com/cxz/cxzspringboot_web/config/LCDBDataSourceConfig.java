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
@MapperScan(basePackages ="com.cxz.cxzspringboot_web.mapper.LCDB",
sqlSessionFactoryRef = "LCDBSqlSessionFactory")
public class LCDBDataSourceConfig {

    @Autowired
    @Qualifier("LCDBSource")
    private DataSource ds;

    @Bean(name="LCDBSqlSessionFactory")
    @Primary
    public SqlSessionFactory LCDBSqlSessionFactory() throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        //指定mapper xml目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath:mapper/LCDB/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);


        return sqlSessionFactoryBean.getObject();
    }


    @Bean
    public SqlSessionTemplate LCDBSqlSessionTemplate(@Qualifier("LCDBSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factoryc
         return template;
    }
}
