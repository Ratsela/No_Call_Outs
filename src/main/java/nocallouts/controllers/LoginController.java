package nocallouts.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import nocallouts.model.Login;
import nocallouts.service.LoginRepoImpl;

@Controller
@RequestMapping("")
@SessionAttributes({"homeOwnerEmail","serviceProviderEmail"})
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private LoginRepoImpl loginService;

	
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String getLoginForm()
	{
		return "views/login";
	}
	
	@RequestMapping(value="/loginForm",method = RequestMethod.POST)
	public ModelAndView userLogin(Model model,@RequestParam("inputEmail")String email,@RequestParam("inputPassword")String password)
	{
		String page = "";
		ModelAndView modelAndView = new ModelAndView();
		Login login = loginService.getLogin(email, password);
		if(login != null)
		{
			if(login.getRole().equals("HOME_OWNER"))
			{
				logger.info("" + login.getEmail() + " " + login.getRole());
				modelAndView.addObject("homeOwnerEmail",login.getEmail());
				model.addAttribute("homeOwnerEmail",login.getEmail());
				page = "views/hoPage";
			}
			else if(login.getRole().equals("SERVICE_PROVIDER"))
			{
				logger.info("" + login.getEmail() + " " + login.getRole());
				modelAndView.addObject("serviceProviderEmail",login.getEmail());
				model.addAttribute("serviceProviderEmail",login.getEmail());
				page = "views/spPage";
			}
		}
		
		
		return new ModelAndView(page);
	}
}
