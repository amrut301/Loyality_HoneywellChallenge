package com.nec.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loyality.dao.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
