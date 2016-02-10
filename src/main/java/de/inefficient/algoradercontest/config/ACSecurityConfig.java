package de.inefficient.algoradercontest.config;

import de.inefficient.algoradercontest.config.management.ACSecurityAccessDeniedHandler;
import de.inefficient.algoradercontest.config.management.ACSecurityAuthenticationSuccessHandler;
import de.inefficient.algoradercontest.core.service.ACUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * Created by samuel on 09.02.16.
 * @author samuel
 * @version 0.1
 */
@Configuration
@EnableWebSecurity
public class ACSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private ACUserService userService;

    @Autowired
    private TomcatEmbeddedServletContainerFactory factory;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/js/**", "/css/**", "/img/**", "/lib/**", "/register").permitAll().anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(new ACSecurityAuthenticationSuccessHandler(userService)).permitAll()
                .and()
                .logout().invalidateHttpSession(true);

        http.exceptionHandling().accessDeniedHandler(new ACSecurityAccessDeniedHandler("/login?expired"));

        if (factory.getAdditionalTomcatConnectors().stream().anyMatch(c -> c.getSecure())) {
            http.requiresChannel().anyRequest().requiresSecure();
        }
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // sha-256
        return new StandardPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}