package actions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionsController {
	
	@GetMapping(value = "/api/actions")
	public String actionsTest() {
		return "app-with-actions version:0.0.1";
	}
	
}
