package pl.hal.ara.core.config;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Morphia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import pl.hal.ara.core.database.MorphiaFactory;

@Configuration
@ComponentScan("pl.hal.ara.core.*")
@PropertySource(value = {"classpath:database/db.properties"})
public class CoreConfig {

    private @Value("${mongo.db.name}") String dbName;

    @Autowired
    private MorphiaFactory morphiaFactory;

    @Bean
    public MongoClient mongo(){
        return morphiaFactory.getMongoInstance();
    }

    @Bean
    public Morphia morphia(){
        return morphiaFactory.getMorphiaInstance();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public String getDbName() {
        return dbName;
    }



}
