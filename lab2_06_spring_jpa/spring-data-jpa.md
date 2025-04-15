# Spring Data JPA

https://docs.spring.io/spring-data/data-jpa/snapshot-site/reference/html/




Конфигурация:

@Configuration
@EnableJpaRepositories("ru.itis.dis301.lab2_06.repository")
@EnableTransactionManagement
@ComponentScan("ru.itis.dis301.lab2_06")
public class Config {

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("ru.itis.dis301.lab2_06.model");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(additionalProperties());
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/lab05");
        config.setUsername("postgres");
        config.setPassword("post");
        config.setDriverClassName("org.postgresql.Driver");
        return config;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update"); //update, none, create
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL10Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        return properties;
    }
}

@Repository
public class ActorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Actor> findAll() {
        Query query = entityManager.createQuery("select a from Actor a");
        return query.getResultList();
    }

    public Actor save(Actor actor) {
        if (actor.getId() != null) {
            return entityManager.merge(actor);
        } else {
            entityManager.persist(actor);
            return actor;
        }
    }

}


public interface GenreRepository extends CrudRepository<Genre, Long> {

    @Query("select g from Genre g where g.id = :id ")
    Genre getGenre(@Param("id") Long id);
}