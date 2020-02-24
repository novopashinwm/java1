package ru.progwards.java1.lessons.test;

public class Test3 {
    public static void main(String[] args) {

    }

    String figDetect(Figure fig) {

        if (fig instanceof Square) {
            return "Сторона квадрата " + ((Square)fig).side;
        } else if (fig instanceof Round) {
            return  "Диаметр круга " + ((Round) fig).diameter;
        }
        return  "Неизвестная фигура";
    }

    class Figure {

    }

    class Square extends Figure {
        private double side;
        public Square(double side) {
            this.side = side;
        }
        public double getSide() {
            return side;
        }
    }

    class Round extends Figure {
        private double diameter;
        public Round(double diameter) {
            this.diameter = diameter;
        }
        public double getDiameter() {
            return diameter;
        }
    }
}
