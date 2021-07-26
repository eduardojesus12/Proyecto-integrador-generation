package generation.mx.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import generation.mx.models.UserModel;
import generation.mx.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public ArrayList<UserModel> getUsers() {
		return userService.getUsers();
	}
	
	@PostMapping
	public UserModel saveUser(@RequestBody UserModel user) {
		return userService.saveUser(user);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
		return userService.getUserById(id);
	}
	
	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		boolean ok = userService.deleteUser(id);
		
		//ok == true es igual a ok		
		if(ok) {
			return "Se eliminó el usuario";
		} else {
			return "No se pudo eliminar el usuario";
		}
	}
	

	@GetMapping("/query")
	public ArrayList<UserModel> getUsersByName(@RequestParam(value = "name", defaultValue = "") String name) {
		return userService.getUsersByName(name);
	}
	
	
	
}
