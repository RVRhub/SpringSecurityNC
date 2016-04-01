//package com.rvr.lecture.common.spring;
//
//import com.rvr.lecture.security.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
//public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private CustomUserDetailsService userDetailsService;
//
//    // регистрируем нашу реализацию UserDetailsService
//    // а также PasswordEncoder для приведения пароля в формат SHA1
//    @Autowired
//    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService);
//        // .passwordEncoder(getShaPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // включаем защиту от CSRF атак
//        http.csrf()
//                .disable()
//                        // указываем правила запросов
//                        // по которым будет определятся доступ к ресурсам и остальным данным
//                .authorizeRequests()
//                        //   .antMatchers("/**").permitAll()
//                        //     .anyRequest().permitAll()
//                        //      .and()
//                        //  .antMatchers("/pages/firstpage/**").anyRequest().hasRole("ADMIN")
//                .antMatchers("/pages/firstpage/**").access("hasRole('ROLE_ADMIN')")
//                // .authenticated()
//                .anyRequest().permitAll()
//                .and()
//        ;6aef88f9e2f437571b5649196ffd5fc6:FK8FTCUFE0aSJW8RxZW105i1DnG0Hqlj
//
//        http.formLogin()
//                // указываем страницу с формой логина
//                .loginPage("/pages/login.html")
//                        // указываем action с формы логина
//                .loginProcessingUrl("/j_spring_security_check")
//                        // указываем URL при неудачном логине
//                        //   .failureUrl("/login?error")
//                        // Указываем параметры логина и пароля с формы логина
//                .usernameParameter("j_username")
//                .passwordParameter("j_password")
//                        // даем доступ к форме логина всем
//                .permitAll();
//
//        http.logout()
//                // разрешаем делать логаут всем
//                .permitAll()
//                        // указываем URL логаута
//                .logoutUrl("/logout")
//                        // указываем URL при удачном логауте
//                .logoutSuccessUrl("/login?logout")
//                        // делаем не валидной текущую сессию
//                .invalidateHttpSession(true);
//
//    }
//
//    // Указываем Spring контейнеру, что надо инициализировать <b></b>ShaPasswordEncoder
//    // Это можно вынести в WebAppConfig, но для понимаемости оставил тут
////    @Bean
////    public ShaPasswordEncoder getShaPasswordEncoder(){
////        return new ShaPasswordEncoder();
////    }
//
//}
