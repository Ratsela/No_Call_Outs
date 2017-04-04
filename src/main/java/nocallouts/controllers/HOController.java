package nocallouts.controllers;


import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nocallouts.model.ServiceProvider;
import nocallouts.service.ServiceProviderRepoImpl;

@Controller
@RequestMapping("")
public class HOController {

	//private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private ServiceProviderRepoImpl spService;
	
	@RequestMapping(value="/serviceProviders",method=RequestMethod.GET)
	public String getServiceProviders(Model model)
	{
		
		model.addAttribute("serviceProviders", spService.getAllServiceProviders());
		return "views/spList";
	}
	
	@RequestMapping(value="/serviceProvidersJ",method=RequestMethod.GET)
	public ResponseEntity<List<ServiceProvider>> getServiceProvidersJ()
	{
		return new ResponseEntity<>(spService.getAllServiceProviders(), HttpStatus.OK);
	}
	
	
}
