package kuckjwi.com.example.spring.oauth.infrastructure.oauth2;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
  private final KakaoOAuth2UserService kakaoOAuth2UserService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
      .disable()
      .authorizeRequests()
      .antMatchers("/login/oauth/**")
      .permitAll()
      .anyRequest()
      .authenticated()
      .and()
      .logout()
      .logoutSuccessUrl("/login")
      .and()
      .oauth2Login()
      .userInfoEndpoint()
      .userService(kakaoOAuth2UserService);
  }
}
