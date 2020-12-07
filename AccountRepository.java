package com.spring.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account,String> {
    List<Account> findBytype(String type);
}
