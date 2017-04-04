package nocallouts.controllers;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import nocallouts.model.HomeOwner;
import nocallouts.model.ServiceProvider;
import nocallouts.service.HomeOwnerRepoImpl;
import nocallouts.service.ServiceProviderRepoImpl;

@Controller
@RequestMapping("")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private ServiceProviderRepoImpl servProService;
	
	@Autowired
	private HomeOwnerRepoImpl homeOService;
	
	@Autowired
	private JavaMailSender jm;
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String getRegisterForm()
	{
		return "views/register";	
	}
	
	
	
	@RequestMapping(value="/registerSP",method = RequestMethod.POST)
	public ModelAndView createAccount(@RequestParam("service")String radio,
										@RequestParam("serviceCheckboc")String[] servicesList,
										@RequestParam("firstName")String fname,@RequestParam("lasttName")String lname,
										@RequestParam("inputEmail")String email,@RequestParam("inputContact")String contact,
										@RequestParam("addresstxt")String address,@RequestParam("descriptiontxt")String service_description,
										@RequestParam("inputPassword")String password,
										@RequestParam("profile_pic")MultipartFile profile_image)
	{
		logger.info("Inside create acount Method---------------------------------------------**");
		String role = "";
		boolean create = false;
			
		if(radio.equals("2"))
		{
			logger.info("Home Owner");
			role = "HOME_OWNER";
			HomeOwner ho = new HomeOwner(fname, lname, email, contact, address, role, password);
			if(homeOService.addHomeOwner(ho))
			{
				logger.info("Reg Seccesful*****************");
				create = true;
			
				 SimpleMailMessage mailMessage=new SimpleMailMessage();
			     mailMessage.setTo(ho.getEmail());
			     mailMessage.setSubject("Registration");
			     mailMessage.setText("Hello " +ho.getFname() +"\n Your registration is successful\nUse you email and password to login.");
			     jm.send(mailMessage);
			}
			else
			{
				create = false;
				logger.info("Reg Failed*****************");
			}
		}
		else if(radio.equals("1"))
		{
			logger.info("Service Provider");
			role = "SERVICE_PROVIDER";
			String services = "";
			for(int x = 0;x < servicesList.length;x++)
			{
				logger.info("" + servicesList[x]);
				services += servicesList[x] + "\n";
			}
			
			byte[] profile_pic = null;
			try {
				profile_pic = profile_image.getBytes();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				logger.info("Image*****************" + e.getMessage());
			}
			
			
			
			ServiceProvider serviceProvider = new ServiceProvider(fname, lname, email, contact, address, role, service_description, services, password,profile_pic);
			if(servProService.addServiceProvider(serviceProvider))
			{
				logger.info("Reg Seccesful*****************");
				create = true;
				SimpleMailMessage mailMessage=new SimpleMailMessage();
			    mailMessage.setTo(serviceProvider.getEmail());
			    mailMessage.setSubject("Registration");
			    mailMessage.setText("Hello " +serviceProvider.getFname() +"\n Your registration is successful\nUse you email and password to login.");
			    jm.send(mailMessage);
			}
			else
			{
				create = false;
				logger.info("Reg Failed*****************");
			}
		}
		String page = "";
		if(create)
		{
			page = "redirect:/login";
		}
		else
		{
			page = "redirect:/register";
		}
		return new ModelAndView(page);	
	}
}
