package bojankosta.calculator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "calculator")
public class Calculator {

    // === fields ===
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "factor1")
    private int factor1;
    @Column(name = "factor2")
    private int factor2;
    @Column(name = "factor_operation")
    private String factor_operation;
    @Column(name = "final_result")
    private int final_result;
    @Column(name = "operation_date")
    private Date operation_date;

    // === constructors ===

    public Calculator() {
    }

    public Calculator(int factor1, int factor2, String factor_operation, int final_result) {
        this.factor1 = factor1;
        this.factor2 = factor2;
        this.factor_operation = factor_operation;
        this.final_result = final_result;
    }

    // === methods ===

    // method sets current date when we create calculator object
    @PrePersist
    protected void onCreate() {
        this.operation_date = new Date();
    }

    // === getters and setters ===

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFactor1() {
        return factor1;
    }

    public void setFactor1(int factor1) {
        this.factor1 = factor1;
    }

    public int getFactor2() {
        return factor2;
    }

    public void setFactor2(int factor2) {
        this.factor2 = factor2;
    }

    public String getFactor_operation() {
        return factor_operation;
    }

    public void setFactor_operation(String factor_operation) {
        this.factor_operation = factor_operation;
    }

    public int getFinal_result() {
        return final_result;
    }

    public void setFinal_result(int final_result) {
        this.final_result = final_result;
    }

    public Date getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Date operation_date) {
        this.operation_date = operation_date;
    }
}
