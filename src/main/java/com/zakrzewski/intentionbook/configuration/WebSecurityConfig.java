package com.zakrzewski.intentionbook.configuration;

import com.zakrzewski.intentionbook.enums.AccessEnum;
import com.zakrzewski.intentionbook.services.ChurchWorkerDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/show-all-church-worker").hasAuthority(AccessEnum.ADMIN.getAuthority())
                .antMatchers("/show-sacristians").hasAnyRole("Proboszcz", "Kaplan")
                .antMatchers("/show-priests").hasAnyRole("Proboszcz", "Zakrystianin")
                .antMatchers("/show-intentions").hasAnyRole("Proboszcz", "Kaplan", "Zakrystianin")
                .antMatchers("/add-intention").hasAnyRole("Proboszcz", "Kaplan", "Zakrystianin")
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }
}
