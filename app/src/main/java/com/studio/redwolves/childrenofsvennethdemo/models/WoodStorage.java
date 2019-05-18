package com.studio.redwolves.childrenofsvennethdemo.models;

public class WoodStorage {
    private static final int ADD_WOOD = 1;
    private static int wood;

    public static int getWood() {
        return wood;
    }

    public void addWood(){
        wood += ADD_WOOD;
    }
}