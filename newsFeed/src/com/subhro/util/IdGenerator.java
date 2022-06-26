package com.subhro.util;

public class IdGenerator {

    private static long id = 0;

    private IdGenerator(){

    }

    public static long getId(){
        id++;
        return id;
    }
}
