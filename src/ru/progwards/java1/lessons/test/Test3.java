package ru.progwards.java1.lessons.test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

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

    public TreeSet<User> createSet() {
        TreeSet<User> set = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.id, o1.id);
            }
        });
        return set;
    }

    class User {
        public Integer id;
        public String name;
        User (Integer id, String name) {
            this.id = id;
            this.name = name;
        }
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
