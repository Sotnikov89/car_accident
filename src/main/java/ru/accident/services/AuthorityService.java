package ru.accident.services;

import ru.accident.domain.Authority;

public interface AuthorityService {
    Authority findByAuthority(String authority);
}
