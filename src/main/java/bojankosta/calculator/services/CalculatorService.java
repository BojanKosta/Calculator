package bojankosta.calculator.services;

import bojankosta.calculator.Calculator;
import bojankosta.calculator.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private CalculatorRepository calculatorRepository;

    // method to save calculator object in database
    public Calculator save(Calculator calculator) {
        return calculatorRepository.save(calculator);
    }

    // method to get all calculator objects from database
    public List<Calculator> getAll() {
        return (List<Calculator>) calculatorRepository.findAll();
    }
}
