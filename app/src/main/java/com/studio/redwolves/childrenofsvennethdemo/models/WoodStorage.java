package com.studio.redwolves.childrenofsvennethdemo.models;

public class WoodStorage {
    private static final int ADD_WOOD = 1;
    private static int wood, wood_bonus = 30, allWoodChopped = 0, milestone = 50;

    public static int getWood() {
        return wood;
    }

    public void addWood(){
        wood += ADD_WOOD;
        allWoodChopped += ADD_WOOD;
        if (allWoodChopped == milestone){
            wood += wood_bonus;
            allWoodChopped += wood_bonus;
            wood_bonus += 40;
            milestone = milestone*3;
        }
    }
}