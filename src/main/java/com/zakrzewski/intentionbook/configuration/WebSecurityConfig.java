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
                .antMatchers("/show-all-church-worker").hasAuthority(AccessEnum.SUPER_USER.getAuthority())
                .antMatchers("/show-sacristians").hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority(), AccessEnum.USER_KAPLAN.getAuthority())
                .antMatchers("/show-priests").hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority(), AccessEnum.USER_ZAKRYS.getAuthority())
                .antMatchers("/show-intentions").permitAll()//hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority(), AccessEnum.USER_KAPLAN.getAuthority(), AccessEnum.USER_ZAKRYS.getAuthority())
                .antMatchers("/add-intention").permitAll()//.hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority(), AccessEnum.USER_KAPLAN.getAuthority(), AccessEnum.USER_ZAKRYS.getAuthority())
                .antMatchers("/show-one-intention/{id}").hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority(), AccessEnum.USER_KAPLAN.getAuthority(), AccessEnum.USER_ZAKRYS.getAuthority())
                .antMatchers("/edit-intention/{id}").hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority())
                .antMatchers("/delete-intention/{id}").hasAnyAuthority(AccessEnum.SUPER_USER.getAuthority())
                .and()
                .formLogin().permitAll()
                .and()
                .csrf().disable();
    }
}
