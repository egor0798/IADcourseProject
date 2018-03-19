//package civ5.civa.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
//import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.client.OAuth2ClientContext;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
//import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
//import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.filter.CompositeFilter;
//
//import javax.servlet.Filter;
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@EnableOAuth2Client
//@EnableOAuth2Sso
//public class AuthControllerOld extends WebSecurityConfigurerAdapter {
//
//    @GetMapping("/user")
//    public Principal user(Principal principal) {
//        return principal;
//    }
//
////    @Autowired
////    OAuth2ClientContextFilter oAuth2ClientContextFilter;
//
//    @Qualifier("oauth2ClientContext")
//    @Autowired
//    OAuth2ClientContext oauth2ClientContext;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.antMatcher("/**")
//                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
////                .addFilterBefore(ssoFilter(), OAuth2AuthenticationProcessingFilter.class)
//                //.addFilterAfter(oauth2ClientContextFilter, SecurityContextPersistenceFilter.class)
//                .authorizeRequests()
//                    .antMatchers("/", "/connect**")
//                    .permitAll()
//                .anyRequest()
//                    .authenticated()
//                .and()
//                    .logout()
//                    .logoutSuccessUrl("/").permitAll().and().csrf()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//    }
//
//    private Filter ssoFilter(){
//        CompositeFilter filter = new CompositeFilter();
//        List<Filter> filters = new ArrayList<>();
//        OAuth2ClientAuthenticationProcessingFilter facebookFilter = new OAuth2ClientAuthenticationProcessingFilter("/connect/facebook");
//        OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
//        facebookFilter.setRestTemplate(facebookTemplate);
//        UserInfoTokenServices tokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(),facebook().getClientId());
//        tokenServices.setRestTemplate(facebookTemplate);
//        facebookFilter.setTokenServices(tokenServices);
//
//
//
//        filters.add(facebookFilter);
//        filter.setFilters(filters);
//        return filter;
//    }
//
//    @Bean
//    public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(filter);
//        registration.setOrder(-100);
//        return registration;
//    }
//
//    @Bean
//    @ConfigurationProperties("facebook.client")
//    public AuthorizationCodeResourceDetails facebook(){
//        return new AuthorizationCodeResourceDetails();
//    }
//    @Bean
//    @Primary
//    @ConfigurationProperties("facebook.resource")
//    public ResourceServerProperties facebookResource(){
//        return new ResourceServerProperties();
//    }
//
//}