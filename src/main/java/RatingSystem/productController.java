package RatingSystem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// Controls the product page
@Controller
public class productController {

	//Gets the information on the product
    @GetMapping("/product")
    public String productForm(Model model) {
    	Product p = new Product("google.com", "Google", "A search engine", new UserAccount("Person"));
        model.addAttribute("product", p);
        return "product";
    }

    //Creates and posts a new product
    @PostMapping("/product")
    public String greetingSubmit(@ModelAttribute Product greeting) {
        return "result";
    }

}