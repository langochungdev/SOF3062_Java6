package web.config;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) 
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable());

        http.authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll()
        );

        http.formLogin(form -> form
            .loginPage("/login/form")
            .loginProcessingUrl("/login/check")
            .defaultSuccessUrl("/login/success", false)
            .failureUrl("/login/failure")
            .usernameParameter("email")
            .passwordParameter("matkhau")
            .permitAll()
        );

        http.rememberMe(rm -> rm
            .rememberMeParameter("remember-me")
            .rememberMeCookieName("remember-me")
            .tokenValiditySeconds(3 * 24 * 60 * 60) 
        );

        http.logout(logout -> logout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login/exit")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("remember-me")
        );

        http.exceptionHandling(ex -> ex
            .accessDeniedPage("/access-denied.html")
        );

        http.oauth2Login(login -> {
            login.permitAll();
            login.successHandler((request, response, authentication) -> {
                DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal();
                String username = user.getEmail();
                String role = "OAUTH";

                UserDetails newUser = User.withUsername(username)
                        .password("{noop}")
                        .roles(role)
                        .build();

                Authentication newauth = new UsernamePasswordAuthenticationToken(
                        newUser, null, newUser.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(newauth);

                HttpSession session = request.getSession();
                String attr = "SPRING_SECURITY_SAVED_REQUEST";
                DefaultSavedRequest req = (DefaultSavedRequest) session.getAttribute(attr);
                String redirectUrl = (req == null) ? "/" : req.getRedirectUrl();
                response.sendRedirect(redirectUrl);
            });
        });

        return http.build();
    }
}
