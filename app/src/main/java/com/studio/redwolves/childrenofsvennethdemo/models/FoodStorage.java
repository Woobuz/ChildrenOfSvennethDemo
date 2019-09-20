package com.studio.redwolves.childrenofsvennethdemo.models;

public class FoodStorage {
    private static int food = 0, allFoodGained = 0;

    public static int getFood() {
        return food;
    }

    public static void addFood(int countOfFood){
        food += countOfFood;
        allFoodGained += countOfFood;
    }

    public boolean useFood(int countOfFood){
        if (food - countOfFood >= 0){
            food -= countOfFood;
            return true;
        } else {
            return false;
        }
    }
}
