package com.example.module309.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // authentication - the act of checking the users credentials .. meaning is the username and password correct
// authorization - is what the user can do
        // you guys can research this if you want .. its for preventing automated bots and helps to increase the likelyhood that its a human using your site
        //it is defaulted to on we should disable it
        http.csrf(csrf -> csrf.disable());

        // this part of the configuration secures acutal URLS
        // this is the list of URLS that require authentication to the website befroe the user can view the URL
        // this works on the idea .. that all URLS are accessable to everyone excpt for the ones listed here
        //this restriction is not including authorization  it is only for authentication
        //authorizeHttpRequests instead of authorizeRequests
        /*http.authorizeRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/customer/**"),
                        new AntPathRequestMatcher("/employee/**")).authenticated()
                .anyRequest().permitAll();*/
        //1)All URL are considfered open and we restrict URL we want to protect
        //2)All URL are protected and we open the ones we want
        http.authorizeHttpRequests()
                //require authentication for /customer/** and /employee/** endpoints
                //.requestMatchers("/customer/**").authenticated()
                //.requestMatchers("/employee/**").authenticated()
                //rest all are free
                .anyRequest().permitAll();


        // this section specifies where our login page is
        http.formLogin(formLogin -> formLogin
                // this is the URL for the login page ... this needs a controller method to listen and show the login page
                // this is alnalagous to /customer and the page is login
                .loginPage("/login/login")
                // spring security has this controller method created for us already .. and we are just configuring the URL where it submits to
                .loginProcessingUrl("/login/loginSubmit"));

        // this section is for configuing logout
        http.logout(formLogout -> formLogout
                // when the user logs out ... destroy the session the server side
                .invalidateHttpSession(true)
                // this is the acutal URL this is implemented by spring security and we are just specifying the get mapping for it
                .logoutUrl("/login/logout")
                // where does the user go after they have been logged out
                // this is a URL that we have implemented somewhere in our project or controllers
                .logoutSuccessUrl("/")
                // extra security and delete these cookies when logging out
                .deleteCookies("username", "JSESSIONID"));

        //this happens only if user goes to page where they dont have authorization, instead of white page error we get 404 error
        http.exceptionHandling(exception -> exception
                .accessDeniedPage("/error/404"));

        return http.build();
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

}
