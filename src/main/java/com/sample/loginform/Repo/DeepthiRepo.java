package com.sample.loginform.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.loginform.Entity.Deepthi;

public interface DeepthiRepo extends JpaRepository<Deepthi,Integer> {

	Deepthi findByUserid(String userid);

}
