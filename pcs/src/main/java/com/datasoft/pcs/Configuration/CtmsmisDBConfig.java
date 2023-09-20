package com.datasoft.pcs.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "ctmsmisEntityManagerFactory",
        basePackages = {"com.datasoft.pcs.Repository.ctmsmis"}, transactionManagerRef = "ctmsmisTransactionManager")
public class CtmsmisDBConfig {

    @Bean(name = "ctmsmisDatasource")
    @ConfigurationProperties(prefix = "spring.ctmsmis.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "ctmsmisEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("ctmsmisDatasource") DataSource dataSource){

        Map<String,Object> properties = new HashMap<>();

        return builder.dataSource(dataSource).properties(properties)
                .packages("com.datasoft.pcs.Model.ctmsmis").persistenceUnit("Ctmsmis").build();

    }

    @Bean(name = "ctmsmisTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("ctmsmisEntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }

}
