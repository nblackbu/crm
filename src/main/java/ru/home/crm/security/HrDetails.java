package ru.home.crm.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.home.crm.model.HrModel;

import java.util.Collection;


public class HrDetails implements UserDetails {

    private final HrModel hrModel;

    public HrDetails(HrModel hrModel) {
        this.hrModel = hrModel;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.hrModel.getPassword();
    }

    @Override
    public String getUsername() {
        return this.hrModel.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    //Нужно, чтобы получать данные аутентифицированного пользователя
    public HrModel getHrModel() {
        return this.hrModel;
    }
}
