package com.dgsg.integration.vouchers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .authorizeHttpRequests(authR -> authR.anyRequest().authenticated())
//                .oauth2ResourceServer(authServer ->authServer
//                        .authenticationManagerResolver(JwtIssuerAuthenticationManagerResolver
//                                .fromTrustedIssuers("https://localapi.digitalams.net:8443/realms/vouchers-dev"))
//                        .)
//                .build();
//    }
}
