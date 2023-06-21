package com.carmel.springSnippents;

public class Singleton {
    private Singleton(){

    }
    // JVM Loader will create only the outer class
    // And memory model ensures that class loading always performs sequentially
    // This is called initialization on demand holder
    private static class Holder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return Holder.INSTANCE; // so we will initialize Holder only when this method is called
    }
}
