# Spring security

https://docs.spring.io/spring-security/reference/servlet/authorization/architecture.html

# DelegatingFilterProxy
DelegatingFilterProxy - фильтр, связывающий контекст контейнера сервлетов и контекст Spring
Основная задача - извлечь из контекста spring бины-фильтры и пропустить через них запрос

Для удобства контроля фильтры удобнее регистрировать в контексте spring

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
            .authorizeHttpRequests(authorize -> authorize
                .anyRequest().authenticated()
            );

        return http.build();
    }

}
```

## Авторизация

AuthorizationManager



## На уровне методов

@EnableMethodSecurity

```java
@Service
public class MyCustomerService {
    @PreAuthorize("hasAuthority('permission:read')")
    @PostAuthorize("returnObject.owner == authentication.name")
    public Customer readCustomer(String id) { ... }
}
```

@PreAuthorize("hasRole('ADMIN')")

```java
@Component
public class BankService {
	@PreAuthorize("hasRole('ADMIN')")
	public Account readAccount(Long id) {
        // ... is only invoked if the `Authentication` has the `ROLE_ADMIN` authority
	}
}
```


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Bean
    static GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("ROLE_");
    }

