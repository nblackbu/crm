package ru.home.crm.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.home.crm.model.HrModel;
import ru.home.crm.repos.HrRepo;
import ru.home.crm.security.HrDetails;

import java.util.Optional;

public class HrDetailsService implements UserDetailsService {
    private final HrRepo hrRepo;

    public HrDetailsService(HrRepo hrRepo) {
        this.hrRepo = hrRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<HrModel> hrModelOptional = hrRepo.findByLogin(username);

        if(hrModelOptional.isEmpty())
            throw new UsernameNotFoundException("Пользователь не был найден");
        return new HrDetails(hrModelOptional.get());
    }
}
