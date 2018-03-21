package civ5.civa.controller;


import org.hibernate.boot.jaxb.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;
import civ5.civa.repo.*;
import civ5.civa.model.*;
import org.springframework.web.client.RestOperations;

import javax.annotation.PostConstruct;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.security.Principal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
@RestController
public class WebController {
    final String GRAPH_API = "https://graph.facebook.com/";
    @Autowired
    UserRepository userRepository;
    @Qualifier("oauth2ClientContext")
    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @GetMapping("/user")
    public Principal user(Principal principal) {
        OAuth2Authentication auth = (OAuth2Authentication) principal;
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
        System.out.println(details.getTokenValue());
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) auth.getUserAuthentication();
        LinkedHashMap<String, String> list =  (LinkedHashMap<String, String>)token.getDetails();
        if(userRepository.findByFacebook(list.get("id")) == null)
            userRepository.save(new User(list.get("name"), list.get("id")));
        return principal;
    }

    @DeleteMapping("/logout/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.delete(userRepository.findByFacebook(id));
    }


//    @GetMapping("/getposts")
//    public void getPosts(){
//        OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
//        facebookTemplate.getAccessToken();
//    }
//
//    @Bean
//    @ConfigurationProperties("facebook.client")
//    public AuthorizationCodeResourceDetails facebook() {
//        return new AuthorizationCodeResourceDetails();
//    }
//
//    @Bean
//    @ConfigurationProperties("facebook.resource")
//    public ResourceServerProperties facebookResource() {
//        return new ResourceServerProperties();
//    }



}

