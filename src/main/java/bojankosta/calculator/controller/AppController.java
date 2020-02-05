package bojankosta.calculator.controller;

import bojankosta.calculator.Calculator;
import bojankosta.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CalculatorService calculatorService;

    // method to view all calculator objects fom database on homepage if there is one
    @RequestMapping("/")
    public String homeView(Model model) {
        List<Calculator> list = calculatorService.getAll();
        model.addAttribute("list", list);
        return "index";
    }

    // method to save calculator object to database and redirect to homepage
    @RequestMapping("/save/{str}")
    public String save(@PathVariable(name = "str") String str) {

        // we get path variable in format like this 10*10 and then extract data first and second number to do calculation
        int ch = str.indexOf("*");
        int ch2 = str.indexOf("}");
        int firstNum = Integer.parseInt(str.substring(0, ch));
        int secondNum = Integer.parseInt(str.substring(ch + 1, ch2));
        int result = firstNum * secondNum;

        // we then create calculator object with data that was sent and save it in database
        Calculator calculator = new Calculator(firstNum, secondNum, "*", result);
        calculatorService.save(calculator);

        return "redirect:/";
    }
}
