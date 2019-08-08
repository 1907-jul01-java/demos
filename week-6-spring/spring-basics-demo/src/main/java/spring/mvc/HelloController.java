package spring.mvc;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class HelloController {
	@RequestMapping(path="hello", method=RequestMethod.GET)
	@ResponseBody
	public String hello(@RequestParam(name="name", required = false, defaultValue = "World") String s) {
		return "Hello, " + s + "!";
	}
	
	@GetMapping("/hello/{name}")
	public ResponseEntity<String> helloName(@PathVariable(name = "name") String name) {
		return ResponseEntity.ok("hello, " + name);
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String home() {
		return "index.html";
	}
	
	@GetMapping("/google")
	public String google() {
		return "redirect:https://google.com";
	}
	
	@GetMapping("/home")
	public String forwardToIndex() {
		return "forward:/";
	}
}
