package my.antonov.study;

import my.antonov.study.dao.StudentDao;
import my.antonov.study.web.config.SpringAppConfig;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//@Configuration
////@Import(SpringAppConfig.class)
//@ComponentScan(basePackages = "my.antonov.study")
public class TestConfiguration {
//    @Bean
//    public EntityManagerFactory getEntityManagerFactory() {
//        return Persistence.createEntityManagerFactory("TestPersistenceUnit");
//    }
//
//    @Bean
//    public EntityManager getEntityManager(@Autowired EntityManagerFactory emf) {
//        return emf.createEntityManager();
//    }
}
