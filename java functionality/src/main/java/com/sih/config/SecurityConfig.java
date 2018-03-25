package com.sih.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;
	
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
		//add our users for in memory authentication
		
		/*UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
				.withUser(users.username("admin").password("admin123").roles("ADMIN"))
				.withUser(users.username("manager").password("manager123").roles("MANAGER"))
				.withUser(users.username("user").password("user123").roles("USER"));
		*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/users/**").hasRole("USER")
			.antMatchers("/managers/**").hasRole("MANAGER")
			.antMatchers("/admins/**").hasRole("ADMIN")
			.and()
			.formLogin()
			.successHandler(successHandler)
			.loginPage("/login")
			.loginProcessingUrl("/authenticate")
			.permitAll().and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}

	@Bean
	public UserDetailsManager userDetailsManager(){
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
		jdbcUserDetailsManager.setDataSource(securityDataSource);
		return jdbcUserDetailsManager;
	}
	
}
