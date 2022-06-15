package pl.sda.sapiens.ep.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import pl.sda.sapiens.ep.model.entity.EventEntity;
import pl.sda.sapiens.ep.model.entity.TagEntity;

@Configuration
class SpringConfiguration {

    @Autowired
    private ApplicationContext context;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        factoryBean.setAnnotatedClasses(EventEntity.class, TagEntity.class);
        factoryBean.setAnnotatedPackages("pl.sda.sapiens.ep.model.entity");
        return factoryBean;
    }
}
