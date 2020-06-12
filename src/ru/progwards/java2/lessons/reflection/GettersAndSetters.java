package ru.progwards.java2.lessons.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class GettersAndSetters {
    public  static void check(String className) {
        try {
            String[] arrPref = new String[] {"get", "set"};
            Class clazz = Class.forName(className);
            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getDeclaredMethods();
            /*Arrays.stream(fields).filter(f-> Arrays.stream(methods).
                    allMatch (m-> !m.getName().toLowerCase().contains(f.getName().toLowerCase())))
                     .forEach(f1-> System.out.println(f1.getName()));*/
            List<MyField> list = new ArrayList<>();
            for (int i = 0; i < arrPref.length; i++) {
                for (int j = 0; j < fields.length; j++) {
                    String field = fields[j].getName();
                    if (field.contains("this"))
                        continue;
                    MyField myField = new MyField();
                    myField.name=arrPref[i] + field.substring(0,1).toUpperCase()+ field.substring(1);
                    myField.type = fields[j].getType().getSimpleName();
                    myField.simplename = field;
                    list.add (myField);
                }
            }
            for (MyField item : list) {
                if (Arrays.stream(methods).filter(m->m.getName().contains(item.name)).toArray().length==0) {
                    if (item.name.contains("get")) {
                        System.out.println("public " + item.type + " " + item.name + " ();");
                    } else  {
                        System.out.println("public void " + item.name
                                + " (" + item.type + " " + item.simplename + ");");
                    }
                }
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class MyField {
        public String type;
        public String name;
        public String simplename;
    }

    class Person {
        private String name;
        private int age;
        private boolean sex;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean getSex() {
            return sex;
        }
    }

    public static void main(String[] args) {
        check(Person.class.getName());
    }
}
