package bojankosta.calculator.repository;


import bojankosta.calculator.Calculator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorRepository extends CrudRepository<Calculator, Long> {
}
