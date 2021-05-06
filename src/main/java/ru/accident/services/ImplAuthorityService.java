package ru.accident.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.accident.domain.Authority;
import ru.accident.repositories.jpa.AuthorityRepository;

@Service
@AllArgsConstructor
public class ImplAuthorityService implements AuthorityService{

    private final AuthorityRepository authorityRepository;

    @Override
    public Authority findByAuthority(String authority) {
      return authorityRepository.findByAuthority(authority);
    }
}
