package com.finalexception.rs;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finalexception.domain.Person;
import com.finalexception.repository.PersonRepository;

@RestController("/")
public class AppInfo {

	@Autowired
	Environment env;
	@Autowired
	PersonRepository personRep;
	
	@PostMapping(value = "/save")
	public Person save(@RequestBody Person person) {		
		return personRep.save(person);
	}
	
	@GetMapping(value = "/all")
	public List<Person> save() {		
		return personRep.findAll();
	}
	
	@RequestMapping("/hello")
	public String hello() throws UnknownHostException {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E ',' dd 'de' MMMM 'de' yyyy ', 'H:m:s");
		
		String host = InetAddress.getLocalHost().getHostName();
		String port = env.getProperty("local.server.port");
		
		return "<h1>"+ dtf.format(now) +"<br>From host "+host+"<br>From port: "+ port +"</h1>";
	}
}
