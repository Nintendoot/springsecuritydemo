package by.nintendo.springsecuritydemo.servise;

import by.nintendo.springsecuritydemo.entity.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService  {
    private static final List<Calculator> calcList=new ArrayList<>();

    @Autowired
    public CalculatorService() {
    }

    public void calc(Calculator calculator) {
        double resoult;
        switch (calculator.getSimbol()) {
            case "+":
                resoult = calculator.getNumOne() + calculator.getNumTwo();
                break;

            case "*":
                resoult = calculator.getNumOne() * calculator.getNumTwo();
                break;

            case "-":
                resoult = calculator.getNumOne() - calculator.getNumTwo();
                break;

            case "/":
                resoult = calculator.getNumOne() / calculator.getNumTwo();
                break;
            default:
                resoult = 0;
        }

        calculator.setResult(resoult);

    }
    public void addCalc(Calculator calculator) {
       calcList.add(calculator);
    }

    public List<Calculator> getAllList() {

        return calcList;
    }
}

