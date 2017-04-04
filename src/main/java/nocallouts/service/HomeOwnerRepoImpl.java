package nocallouts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nocallouts.model.HomeOwner;
import nocallouts.model.Login;
import nocallouts.repository.HomeOwnerRepository;

@Service
public class HomeOwnerRepoImpl {
	
	@Autowired
	private HomeOwnerRepository hr;
	
	@Autowired
	private LoginRepoImpl lgr;
	
	public boolean addHomeOwner(HomeOwner homeOwner)
	{
		boolean addHO = false;
		
		List<HomeOwner> hoList = new ArrayList<>();
		hr.findAll().forEach(hoList::add);
		
		if(hoList.size() != 0)
		{
			for(int x = 0 ; x < hoList.size();x++)
			{
				if(hoList.get(x).getEmail().equals(homeOwner.getEmail()))
				{
					addHO = false;
				}
				else
				{
					hr.save(homeOwner);
					Login loginObj = new Login(homeOwner.getEmail(), homeOwner.getPassword(), homeOwner.getRole());
					lgr.addLogin(loginObj);
					addHO = true;
				}
			}
		}
		else
		{
			hr.save(homeOwner);
			Login loginObj = new Login(homeOwner.getEmail(), homeOwner.getPassword(), homeOwner.getRole());
			lgr.addLogin(loginObj);
			addHO = true;
		}
		
		return addHO;
	}
	
	public HomeOwner getHomeOwner(String email)
	{
		HomeOwner ho = null;
		if(hr.exists(email))
		{
			ho = hr.findOne(email);
		}
		return ho;
	}

}
