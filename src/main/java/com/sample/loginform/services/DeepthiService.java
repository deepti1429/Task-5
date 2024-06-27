package com.sample.loginform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.loginform.Entity.Deepthi;
import com.sample.loginform.Repo.DeepthiRepo;

@Service
public class DeepthiService {

	@Autowired
	private DeepthiRepo repo;
	 
	public Deepthi saveDetails(Deepthi deep) {
		return repo.save(deep);
	}

	 public boolean authenticate(String userid, String password) {
	        
	        Deepthi user = repo.findByUserid(userid);
	        if (user != null && user.getPassword().equals(password)) {
	            
	            return true;
	        }
	       
	        return false;
	    }
	}
