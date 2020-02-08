package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food another = (Food) smthHasWeigt;
        if (this.getWeight() < another.getWeight()) {
            return CompareResult.LESS;
        }
        if (this.getWeight() > another.getWeight()) {
            return CompareResult.GREATER;
        }
        return CompareResult.EQUAL;
    }


}
