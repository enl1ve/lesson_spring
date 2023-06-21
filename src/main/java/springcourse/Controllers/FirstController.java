package springcourse.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name, //RequestParam говорит о том что параметры обязательны
                            // если не указыывать required=false
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("calculator")
    public String calculator(@RequestParam("a") int a,
                             @RequestParam("b") int b,
                             @RequestParam("action") String action,

                             Model model) {

        switch (action){
            case ("addition"):
                model.addAttribute("action", "Result = " + (a+b));
                break;
            case("multiplication"):
                model.addAttribute("action", "Result = " + (a*b));
                break;
            case ("subtraction"):
                model.addAttribute("action", "Result = " + (a-b));
                break;
            case ("division"):
                model.addAttribute("action", "Result = " + (a/b));
                break;
        }

        return "first/calculator";
    }
}
