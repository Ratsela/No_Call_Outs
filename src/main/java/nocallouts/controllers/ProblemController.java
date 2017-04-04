package nocallouts.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import nocallouts.model.HomeOwner;
import nocallouts.model.Problem;
import nocallouts.service.HomeOwnerRepoImpl;
import nocallouts.service.ProblemService;
import nocallouts.service.ServiceProviderRepoImpl;

@Controller
@RequestMapping("")
@SessionAttributes({"homeOwnerEmail","spemail","serviceProviderEmail"})

public class ProblemController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private ProblemService problemService;
	
	@Autowired
	private ServiceProviderRepoImpl spService;
	
	@Autowired
	private HomeOwnerRepoImpl hoService;
	
	@Autowired
	private JavaMailSender jm;
	
	@RequestMapping(value="/spListForm",method = RequestMethod.GET)
	public String getProblemView(Model model,@ModelAttribute("homeOwnerEmail") String homeOwnerEmail,@RequestParam(value="spemail") String spemail)
	{
		logger.info("Inside GetProblemView method ************************");
		logger.info("Ho Email" + homeOwnerEmail);
		logger.info("SP Email" + spemail);
		model.addAttribute("spemail", spemail);
		return "views/problemView";
	}
	
	@RequestMapping(value="/problemForm",method=RequestMethod.POST)
	public ModelAndView sendProblem(@ModelAttribute(value="spemail") String spemail,
									@ModelAttribute(value="homeOwnerEmail") String hoemail,
									@RequestParam("problemtxt") String description,
									@RequestParam("imagefile")MultipartFile imageFile)
	{
		logger.info("Inside sendProblemMethod method ************************");
		logger.info("************************" + spemail);
		logger.info("************************" + hoemail);
		logger.info("************************" + description);
		try
		{
			byte[] image = imageFile.getBytes();
			HomeOwner homeOwner = hoService.getHomeOwner(hoemail);
			Problem problem = new Problem(0, homeOwner.getFname(), homeOwner.getEmail(), homeOwner.getAddress(), homeOwner.getContact(), description, image);
			problemService.addProblem(problem);
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
		    mailMessage.setTo(spemail);
		    mailMessage.setSubject("Service Request");
		    mailMessage.setText("Hello " + spService.getSP(spemail).getLname() +"\nYou have a service request from " + hoService.getHomeOwner(hoemail).getFname() + "\nPlease login to check full details.");
		    jm.send(mailMessage);
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return new ModelAndView("views/hoPage");
	}
	
	@RequestMapping(value="/respondProblems",method=RequestMethod.GET)
	public String getRespPage(@ModelAttribute("serviceProviderEmail") String serviceProviderEmail,Model model,@RequestParam(value="custemail") String custemail)
	{
		logger.info("Inside getRespPage method ************************");
		logger.info("************************" + custemail);
		logger.info("************************" + serviceProviderEmail);
		model.addAttribute("customer_email", custemail);
		model.addAttribute("serviceProvider_email", serviceProviderEmail);
		return "views/respPage";
	}
	
	
}
