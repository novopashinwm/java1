package ru.progwards.java2.lessons.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ClassInspector {
    public static void inspect(String clazz_name) {
        try {
            Class clazz = Class.forName(clazz_name);
            System.out.println("class " + clazz.getSimpleName() + " {");
            showConstructors(clazz);
            showFields(clazz);
            showMethods(clazz);
            System.out.println("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void showMethods(Class clazz) {
        System.out.println();
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).forEach(m ->
                System.out.println("\t" + Modifier.toString(m.getModifiers()) + " "
                        + m.getReturnType().getSimpleName()
                        + " " + m.getName() + " ("
                        + getParametersInfo(m.getParameters()) + ") {}" ) );
    }

    private static void showFields(Class clazz) {
        System.out.println();
        Field[] fields =clazz.getDeclaredFields();
        for (Field field: fields) {
            String modStr = Modifier.toString(field.getModifiers());
            System.out.println("\t" + modStr + " " + field.getType().getSimpleName() + " "
                    + field.getName() + ";");
        }
    }

    private static void showConstructors(Class clazz) {
        System.out.println();
        Constructor[] constructors= clazz.getDeclaredConstructors();
        for (Constructor item : constructors) {
            String modStr = Modifier.toString(item.getModifiers());
            System.out.print("\t" + modStr + " " + clazz.getSimpleName() + "(");
            System.out.print(getParametersInfo(item.getParameters()));
            System.out.println(") {}");
        }

    }

    private static String getParametersInfo(Parameter[] parameters) {
        if (parameters.length==0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parameters.length-1; i++) {
            sb.append(getParamInfo(parameters[i]) + ", ");
        }
        sb.append(getParamInfo(parameters[parameters.length-1]));
        return sb.toString();
    }

    private static String getParamInfo(Parameter parameter) {
        return parameter.getType().getSimpleName() + " "
                + parameter.getName();
    }

    class Person {
        private String name;
        public Person() {}
        private Person(String name) {}
        public String getName() {
            return "";
        }
        public void setName(String value) {}
    }

    public static void main(String[] args) {
        inspect(Person.class.getName());
    }
}
