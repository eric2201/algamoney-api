package com.example.algamoney.api.config;

//AUTENTICAÇÃO
//configuration ja vem no enableWebSecurity, porem pra ficar mais visivel que a classe é de configuração
//@EnableWebSecurity
//@Configuration
//public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ROLE");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //toda requisição deve ser feita autenticado
//        //http.authorizeRequests().anyRequest().authenticated();
//
//
//        //ou categorias qualquer um pode alterar, o resto tem que ser autenticado
//        http.authorizeRequests().antMatchers( "/releases").permitAll()
//                .anyRequest().authenticated()
//                .and().httpBasic()
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // sem estado, não mantém estado de nada
//                .and().csrf().disable();
//
//    }
//}
