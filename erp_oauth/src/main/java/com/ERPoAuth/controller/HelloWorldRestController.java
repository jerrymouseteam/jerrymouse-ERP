package com.ERPoAuth.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ERPoAuth.model.User;
import com.ERPoAuth.service.UserService;

@RestController
public class HelloWorldRestController {

	@Autowired
	UserService userService; // Service which will do all data
								// retrieval/manipulation work

	// -------------------Retrieve All
	// Users--------------------------------------------------------
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers() {
		List<User> users = userService.findAllUsers();
		System.out.println(" Users in web service " + users);
		if (users.isEmpty()) {
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);// You
																			// many
																			// decide
																			// to
																			// return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/checkEmail/{ssoId}", method = RequestMethod.GET)
	public ResponseEntity<User> checkEmail(@PathVariable String ssoId) {
		System.out.println("Fetching & Deleting User with ssoId " + ssoId);

		User user = userService.check(ssoId);
		if (user == null) {
			System.out.println("Unable to delete. User with ssoId " + ssoId + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		//userService.deleteUserBySSO(ssoId);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	// -------------------Retrieve Single
	// User--------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> getUser(@PathVariable("id") int id) {
		System.out.println("Fetching User with id " + id);
		User user = userService.findById(id);
		if (user == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/user/ssoid/{ssoId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<User> getUserBySSO(@PathVariable String ssoId) {
		System.out.println("Fetching User with ssoId " + ssoId);
		User user = userService.findBySSO(ssoId);
		if (user == null) {
			System.out.println("User with ssoId " + ssoId + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// -------------------Create a
	// User--------------------------------------------------------

	@RequestMapping(value = "/user/create/", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating User " + user.getSsoId());

		if (userService.isUserSSOUnique(user.getId(), user.getSsoId())) {
			System.out.println("A User with name " + user.getSsoId() + " already exist");
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}

		userService.saveUser(user);

		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.
		 * getId()).toUri());
		 */
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// ------------------- Update a User
	// --------------------------------------------------------

	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody User user) {
		System.out.println("Updating User " + id);

		User currentUser = userService.findById(id);

		if (currentUser == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setEmail(user.getEmail());
		currentUser.setUserProfiles(user.getUserProfiles());

		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}

	// ------------------- Delete a User
	// --------------------------------------------------------

	@RequestMapping(value = "/user/delete/{ssoId}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable String ssoId) {
		System.out.println("Fetching & Deleting User with ssoId " + ssoId);

		User user = userService.findBySSO(ssoId);
		if (user == null) {
			System.out.println("Unable to delete. User with ssoId " + ssoId + " not found");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}

		//userService.deleteUserBySSO(ssoId);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

	/*
	 * //------------------- Delete All Users
	 * --------------------------------------------------------
	 * 
	 * @RequestMapping(value = "/user/", method = RequestMethod.DELETE) public
	 * ResponseEntity<User> deleteAllUsers() {
	 * System.out.println("Deleting All Users");
	 * 
	 * userService.deleteAllUsers(); return new
	 * ResponseEntity<User>(HttpStatus.NO_CONTENT); }
	 */

}