package nocallouts.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class HomeController {
	@RequestMapping(value="",method = RequestMethod.GET)
	public String getHome()
	{
		return "views/home";
	}
	
	/*@RequestMapping(value="/login",method = RequestMethod.GET)
	public String getLoginForm()
	{
		return "views/login";
	}
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String getRegisterForm()
	{
		return "views/register";	
	}*/

}
