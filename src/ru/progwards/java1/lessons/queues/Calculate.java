package ru.progwards.java1.lessons.queues;

public class  Calculate {
    public static double calculation1() {
        StackCalc calc = new StackCalc();
        calc.push(12.1);
        calc.push(3.0);
        calc.add();
        calc.push(2.2);
        calc.mul();
        return calc.pop();
    }
    public static double calculation2() {
        //(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2))
        StackCalc stackCalc = new StackCalc();

        stackCalc.push(24.0);
        stackCalc.push(737.22);
        stackCalc.add();
        stackCalc.push(55.6);
        stackCalc.push(12.1);
        stackCalc.sub();
        stackCalc.div();
        stackCalc.push(13.001);
        stackCalc.push(9.2);
        stackCalc.sub();
        stackCalc.push(2.0);
        stackCalc.mul();
        stackCalc.push(87.0);
        stackCalc.add();
        stackCalc.push(19.0);
        stackCalc.push(3.33);
        stackCalc.sub();
        stackCalc.mul();
        stackCalc.add();


        return stackCalc.pop();
    }

}