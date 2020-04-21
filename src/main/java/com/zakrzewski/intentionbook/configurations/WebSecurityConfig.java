package com.zakrzewski.intentionbook.configurations;

import com.zakrzewski.intentionbook.enums.AccessEnum;
import com.zakrzewski.intentionbook.services.ChurchWorkerDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private ChurchWorkerDetailsServiceImpl churchWorkerDetailsService;

    @Autowired
    public WebSecurityConfig(ChurchWorkerDetailsServiceImpl churchWorkerDetailsService) {
        this.churchWorkerDetailsService = churchWorkerDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(churchWorkerDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login").permitAll()
                .failureUrl("/login-error")
                .and()
                .exceptionHandling().accessDeniedPage("/access-forbidden")
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/add-new-intention").hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority(), AccessEnum.USER_KAPLAN.getAuthority(), AccessEnum.USER_ZAKRYS.getAuthority())
                .antMatchers("/show-all-workers").hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority())
                .antMatchers("/calendar-info").hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority(), AccessEnum.USER_KAPLAN.getAuthority(), AccessEnum.USER_ZAKRYS.getAuthority())
                .antMatchers("/intention-generate").hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority(), AccessEnum.USER_KAPLAN.getAuthority(), AccessEnum.USER_ZAKRYS.getAuthority())
                .antMatchers("/create-new-worker-page").hasAuthority(AccessEnum.SUPER_USER.getAuthority())
                .and()
                .httpBasic()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .csrf().disable()
                .headers().disable();
    }
}
