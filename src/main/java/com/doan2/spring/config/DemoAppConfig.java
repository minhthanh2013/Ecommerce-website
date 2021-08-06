package com.doan2.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "com.doan2.spring")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig extends WebMvcConfigurerAdapter {

    // Setup the variable to hold the properties

    // Hold data that is read from the properties file.
    @Autowired
    private Environment env;

    // Setup logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());

    // define a bean for View Resolver
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setContentType("text/html;charset=UTF-8");
        return viewResolver;
    }
    // define a bean for security datasouce
    @Bean
    public DataSource securityDataSource(){
        ComboPooledDataSource securityDataSource
                = new ComboPooledDataSource();
        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));

        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        // log the connection props
        // just to make sure we're real
        logger.info(">>> jdbc.url="+env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user="+env.getProperty("jdbc.user"));

        // set database connection pool props
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        // set connection pool props

        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize")
        );
        securityDataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize")
        );
        securityDataSource.setMaxPoolSize(
                getIntProperty("connection.pool.maxPoolSize")
        );
        securityDataSource.setMaxIdleTime(
                getIntProperty("connection.pool.maxIdleTime")
        );
        return securityDataSource;
    }

    private int getIntProperty(String propName){
        String propVal = env.getProperty(propName);

        // convert to int
        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }
    private Properties getHibernateProperties() {

        // set hibernate properties
        Properties props = new Properties();

        props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
        props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));

        return props;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(){

        // create session factorys
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        // set the properties
        sessionFactory.setDataSource(securityDataSource());
        sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
        sessionFactory.setHibernateProperties(getHibernateProperties());

        return sessionFactory;
    }
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

        // setup transaction manager based on session factory
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }
   @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

}
