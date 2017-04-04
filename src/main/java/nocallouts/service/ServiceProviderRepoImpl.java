package nocallouts.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nocallouts.controllers.RegisterController;
import nocallouts.model.Login;
import nocallouts.model.ServiceProvider;
import nocallouts.repository.ServiceProviderRepository;

@Service
public class ServiceProviderRepoImpl {
	@Autowired
	private ServiceProviderRepository servicePro;
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private LoginRepoImpl lgr;
	
	public boolean addServiceProvider(ServiceProvider s)
	{
		boolean addSP = false;
		
		List<ServiceProvider> slist = new ArrayList<>();
		servicePro.findAll().forEach(slist::add);
		
		logger.info("" + slist.size());
		
		if(slist.size() != 0)
		{
			for(int x = 0;x < slist.size();x++)
			{
				if(slist.get(x).getEmail().equals(s.getEmail()))
				{
					addSP = false;
				}
				else
				{
					servicePro.save(s);
					Login loginObj = new Login(s.getEmail(), s.getPassword(), s.getRole());
					lgr.addLogin(loginObj);
					addSP = true;
				}
			}
		}
		else
		{
			servicePro.save(s);
			Login loginObj = new Login(s.getEmail(), s.getPassword(), s.getRole());
			lgr.addLogin(loginObj);
			addSP = true;
		}
		
		return addSP;
	}
	
	public List<ServiceProvider> getAllServiceProviders()
	{
		List<ServiceProvider> spList = new ArrayList<>();
		servicePro.findAll().forEach(spList::add);
		return spList;
	}
	
	public ServiceProvider getSP(String email)
	{
		return servicePro.findOne(email);
	}
}
