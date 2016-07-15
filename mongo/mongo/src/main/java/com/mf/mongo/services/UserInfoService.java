package com.mf.mongo.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mf.mongo.User;
import com.mf.mongo.Repositories.UsersRepository;
import com.mf.mongo.utills.ResourceWrapper;

@RestController
@RequestMapping("/users")
public class UserInfoService {

	private static final String DEFAULT_SORT_BY = "firstName";
	private static final String ASC = "asc";
	@Autowired
	  private UsersRepository usersRepository;

	 @CrossOrigin(origins = "http://localhost:9000")
	  @RequestMapping(method = RequestMethod.GET)
	  public ResourceWrapper<User> fetchUser( @RequestParam(defaultValue = "1", required = false) int page, @RequestParam(defaultValue = "20", required = false) int size, @RequestParam(defaultValue = DEFAULT_SORT_BY, required = false) String sortBy, @RequestParam(defaultValue = ASC,required = false) String orderBy){		 
		Sort sortObject = new Sort(Direction.fromString(orderBy), Arrays.asList(sortBy));
		  Pageable pageable = new PageRequest(page, size, sortObject);
	    Page<User> pageResult = usersRepository.findAll(pageable);	    	    	 
	    return new ResourceWrapper<User>(pageResult);
	  }
	  
	  @RequestMapping(method = RequestMethod.POST)
	  public User updateUsers(@RequestBody User user) {
		  		
	    User response =  usersRepository.insert(user);	    	    
	   /* Map<String,Object> response = new HashMap<String, Object>();	    
	    response.put("user", users);
	    response.put("userListSize", users.size());*/
	    return response;
	    
	  }
	  }
	  
	 /* @RequestMapping(method = RequestMethod.POST)
	  public Map<String,Object> createUser( @RequestParam(required = false) String sortBy, @RequestParam(required = false) String orderBy){
		  String direction = orderBy!=null?orderBy:Direction.ASC.toString();
		  String sortByField = sortBy!=null?sortBy:DEFAULT_SORT_BY;
		
	    List<User> users = usersRepository.findAll(new Sort(Direction.fromString(direction), Arrays.asList(sortByField)));	    	    
	    Map<String,Object> response = new HashMap<String, Object>();	    
	    response.put("user", users);
	    response.put("userListSize", users.size());
	    return response;
	  }*/
