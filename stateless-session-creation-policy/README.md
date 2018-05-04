# STATELESS Session Creation Policy

See: https://github.com/spring-projects/spring-security/issues/5299

## Summary

By default CSRF protection creates a HTTP session even if session creation policy is configured to be STATELESS. This should not be the case as an user expects no session to occur (within Spring Security) after specifying STATELESS.

## Actual Behavior

A HTTP session is created when visiting the login page.

## Expected Behavior

No HTTP session is created.

## Configuration

```
@Bean
public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
    return new WebSecurityConfigurerAdapter() {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
             http
                 .sessionManagement().sessionCreationPolicy(STATELESS)
             .and()
                 .authorizeRequests().anyRequest().authenticated()
             .and()
                 .formLogin()
        }
    };
}
```

