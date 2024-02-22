package in.itsp.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 
 
@Controller
@RequestMapping
public class SayHello {
	
	@GetMapping("/say/{name}")
	public String sayHello(@PathVariable("name") String name , Model model) {
		LocalTime time = LocalTime.now();
		String msg ="";
		if(time.isBefore(LocalTime.NOON)) {
			msg = "Good Morning "+ name;
		}else if(time.isBefore(LocalTime.of(18,0))) {
			msg = "Good after Noon " +name;
		}else {
			msg = "Good evening ";
		}
		model.addAttribute("message",msg);
		return "sayHello";
	}

}
