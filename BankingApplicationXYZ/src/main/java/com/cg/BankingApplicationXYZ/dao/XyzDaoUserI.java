package com.cg.BankingApplicationXYZ.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BankingApplicationXYZ.model.User;

public interface XyzDaoUserI extends JpaRepository<User,Integer> {

}
