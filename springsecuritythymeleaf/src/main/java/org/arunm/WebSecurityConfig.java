package org.arunm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.util.AntPathRequestMatcher;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	private CustomeAuthenticationFailureHandler authenticationfailure;

	/*
	 * @Autowired private JSONUserNamePasswordAuthenticationFilter
	 * jsonUserNamePasswordAuthenticationFilter;
	 */

	@Autowired
	private AuthenticationManager authManager;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.addFilter(getFilter());

		http.authorizeRequests()
				.antMatchers("/", "/home")
				.permitAll()
				.anyRequest()
				.authenticated()
				.withObjectPostProcessor(
						new ObjectPostProcessor<FilterSecurityInterceptor>() {
							public <O extends FilterSecurityInterceptor> O postProcess(
									O fsi) {
								FilterInvocationSecurityMetadataSource newSource = new MyFilterSecurityMetadataSource();
								fsi.setSecurityMetadataSource(newSource);
								return fsi;
							}
						}).and().formLogin()
				.failureHandler(authenticationfailure).loginPage("/login")
				.permitAll().and().logout().permitAll();

		/*
		 * FilterInvocationSecurityMetadataSource newSource = new
		 * MyFilterSecurityMetadataSource();
		 * filterSecurityInterceptor.setSecurityMetadataSource(newSource);
		 */
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customAuthenticationProvider());
	}

	@Bean
	public AuthenticationProvider customAuthenticationProvider() {
		CustomDAOAuthenticationProvider impl = new CustomDAOAuthenticationProvider();
		impl.setUserDetailsService(userDetailsService);
		return impl;
	}

	@Bean
	public JSONUserNamePasswordAuthenticationFilter getFilter() {
		JSONUserNamePasswordAuthenticationFilter authenticationFilter = new JSONUserNamePasswordAuthenticationFilter();
		try {
			authenticationFilter.setAuthenticationManager(super
					.authenticationManagerBean());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		authenticationFilter
				.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(
						"/login", "POST"));
		return authenticationFilter;
	}
}