package com.example.munafis.Config;

import com.example.munafis.Service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class ConfigSecurity {

    private final MyUserDetailsService myUserDetailsService;


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return daoAuthenticationProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests()
                .requestMatchers("api/v1/auth/register","api/v1/auth/login","api/v1/product/getProductsByName/**","api/v1/provider/getAllProductsByProvider/**","api/v1/provider/getAllServicesByProvider/**").permitAll()
                .requestMatchers("api/v1/auth/delete/**","api/v1/auth/get-All-Users","api/v1/company/delete/**","api/v1/company/get","api/v1/comp/add","api/v1/comp/**","api/v1/comp/get","api/v1/offer/get-all-offers","api/v1/order/get","api/v1/order/delete/**","api/v1/order/acceptOrder/**","api/v1/provider/get","api/v1/provider/delete/**").hasAuthority("ADMIN")
                .requestMatchers("api/v1/company/view-accepted-orders","api/v1/company/view-completed-orders","api/v1/company/view-pending-orders-orders","api/v1/company/add","api/v1/company/update","api/v1/order/add","api/v1/order/update/**","api/v1/order/invoice/**","api/v1/product/get").hasAuthority("company")
                .requestMatchers("api/v1/provider/add","api/v1/offer/create-offer/**","api/v1/offer/update-offer/**","api/v1/offer/delete-offer/**","api/v1/product/add","api/v1/product/delete/**","api/v1/product/update/**","api/v1/product/getProductInfo/**","api/v1/productsDetails/addStock/**","api/v1/provider/add","api/v1/provider/update","api/v1/provider/viewMyAcceptedOffers","api/v1/provider/viewMyPendingOffers","api/v1/provider/viewMyRejectedOffers").hasAuthority("provider")
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("api/v1/auth/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
                return http.build();
    }
}




