package br.com.sanadev.mvc.mudi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		//.authorizeHttpRequests().anyRequest().authenticated().and()
		.authorizeHttpRequests(aut->{aut.anyRequest().authenticated();})
		.formLogin().loginPage("/login").permitAll();
		
		http.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/home")
				.invalidateHttpSession(true));
		
     return http.build();
	}

	@Bean(name = "userDetails")
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder().username("sana").password("1234").roles("ADM").build();
		return new InMemoryUserDetailsManager(user);

	}

}
