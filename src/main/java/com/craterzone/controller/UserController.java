package com.craterzone.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.craterzone.model.Address;
import com.craterzone.model.User;
import com.craterzone.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> list = userService.getUser();
		if (list.size() <= 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(list));
	}

	// Not Idempotent
	@PostMapping("/registerUser")
	private ResponseEntity<User> registerUser(@RequestBody User user) {
		Optional<User> userdb = userService.saveUser(user);
		if (Objects.nonNull(userdb))
			return ResponseEntity.status(HttpStatus.CREATED).body(user);
		else
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
	}

	@PostMapping("/login")
	private ResponseEntity<Optional<User>> login(@RequestBody User user) {

		Optional<User> userdb = userService.login(user);
		if (userdb != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(userdb);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@GetMapping("/{id}")
	private ResponseEntity getUserById(@PathVariable("id") int id) {
		Optional<User> user = userService.getById(id);
		if (user.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<User> deleteUserById(@PathVariable("id") int id) {
		Optional<Boolean> user = Optional.of(userService.deleteId(id));
		if (user.isPresent())
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);

		else
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

}