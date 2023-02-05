package ru.home.crm.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import ru.home.crm.service.HrDetailsService;

import java.util.Collections;

//здесь будем смотреть на бд и данные с формы

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final HrDetailsService hrDetailsService;

    @Autowired
    public AuthProviderImpl(HrDetailsService hrDetailsService) {
        this.hrDetailsService = hrDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        UserDetails userDetails = hrDetailsService.loadUserByUsername(login);
        String password = authentication.getCredentials().toString();

        if (!password.equals(userDetails.getPassword()))
            throw new BadCredentialsException("Неверный пароль");
        return new UsernamePasswordAuthenticationToken(userDetails, password,
                Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
