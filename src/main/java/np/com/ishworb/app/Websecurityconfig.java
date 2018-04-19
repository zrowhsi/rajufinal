package np.com.ishworb.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Websecurityconfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("user").password("password").roles("USER")
//		.and()
//		.withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
//		http.
//		csrf().disable()
//		.formLogin().loginProcessingUrl("/login")
//		.defaultSuccessUrl("/home")
//		.failureUrl("/login")
//		.and()
//		.logout()
//		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//		.logoutSuccessUrl("/")
//		.and()
//		.authorizeRequests()
//		.antMatchers("/customer/**").permitAll()
//		.antMatchers("/","**/login").permitAll() // Enabling URL to be accessed by all users (even un-authenticated)
//
//		.antMatchers("**/admin/**").access("hasRole('ADMIN')") //Configures specified URL to be accessed with user having role as ADMIN
//		.anyRequest().authenticated() // Any resources not mentioned above needs to be authenticated
//		.and()
//		.exceptionHandling().accessDeniedPage("/");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
}
