package val.project.secyrity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    CustomeAuthEntryPoint customeAuthEntryPoint;

    @Autowired
    DataSource dataSource;
    private final  String  userNameQuery="select LOGIN,PASSWORD,IS_BLOCKED as enabled from ACCOUNTS where LOGIN=?";
    private final String userNameAndRole="select LOGIN,USER_ROLE as ROLE from ACCOUNTS join ROLE R on ACCOUNTS.ROLE_ID = R.ID where LOGIN=?";
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        passwordEncoder = new BCryptPasswordEncoder();
       /* auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).withUser("user")
                .password(passwordEncoder.encode("password"))
                .roles("USER");*/
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(userNameQuery).authoritiesByUsernameQuery(userNameAndRole).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/","/image/*","/productInfo/","/registration/","/mail/*","/advertising/*","/write/*").permitAll()
               .antMatchers("/order/*").access("hasAuthority('USER')");
        http.authorizeRequests().antMatchers("/autharization/auth").authenticated();
        http.httpBasic().authenticationEntryPoint(customeAuthEntryPoint);

        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/autharization/logoutSuccess");
    }
}
