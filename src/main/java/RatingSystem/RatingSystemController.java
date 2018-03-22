package RatingSystem;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RatingSystemController {

	@Autowired
	private UserAccountRepository userRepo;
	
	//home page
    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }
    
    //user information page
    @RequestMapping(value="/user", method=RequestMethod.POST)
    public String addNewUser(@Valid UserAccount user, BindingResult bindingResult, Model model) {
    	userRepo.save(new UserAccount(user.getUsername()));
    	model.addAttribute("users", userRepo.findAll());
    	return "redirect:user";
    }
}
