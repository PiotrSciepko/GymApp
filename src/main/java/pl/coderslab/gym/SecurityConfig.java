package pl.coderslab.gym;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**/delete/**").hasRole("ADMIN")
                .and().formLogin();
//                .antMatchers("/**/add/**", "/**/update/**", "/**/show/**").hasAnyRole("USER", "ADMIN")
//                .and().formLogin();
        http.authorizeRequests()
                .antMatchers("/**/add/**", "/**/update/**", "/**/show/**").hasAnyRole("USER", "ADMIN")
                .and().formLogin();
    }
}
