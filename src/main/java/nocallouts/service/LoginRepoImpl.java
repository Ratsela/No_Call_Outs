package nocallouts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nocallouts.model.Login;
import nocallouts.repository.LoginRepository;

@Service
public class LoginRepoImpl {

	@Autowired
	private LoginRepository loginRepo;
	
	public void addLogin(Login login)
	{
		loginRepo.save(login);
	}
	
	public Login getLogin(String email,String password)
	{
		Login login = null;
		
		List<Login> loginObjects = new ArrayList<>();
		loginRepo.findAll().forEach(loginObjects::add);
		
		if(!loginObjects.isEmpty())
		{
			for(int x = 0;x < loginObjects.size();x++)
			{
				if(loginObjects.get(x).getEmail().equals(email) && loginObjects.get(x).getPassword().equals(password))
				{
					login = new Login(loginObjects.get(x).getEmail(), loginObjects.get(x).getPassword(), loginObjects.get(x).getRole());
				}
			}
		}
		
		return login;
	}
	
}
