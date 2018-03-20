package TheLeftOvers.TermProject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class GreetingController {
    @GetMapping("/user")
    public String greeting(Model model) {
        model.addAttribute("UserAccount", new UserAccount());
        return "user";
    }
    
    @PostMapping("/user")
    public String greetingSubmit(@ModelAttribute UserAccount UserAccount)
    {
    	return "allusers";
    }
}
