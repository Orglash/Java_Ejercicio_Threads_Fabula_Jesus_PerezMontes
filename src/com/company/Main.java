package com.company;

public class Main {

    public static void main(String[] args) {

        long startChrono = System.currentTimeMillis();
        long tortoiseLap = 0;
        long hareLap = 0;

        Tortoise tortoise = new Tortoise("Tortoise");
        Hare hare= new Hare("Hare");

        System.out.println("Race started!");
        System.out.println();

        tortoise.start();
        hare.start();

        while(tortoise.isAlive() || hare.isAlive()){
            long time = System.currentTimeMillis() - startChrono;
            if(tortoise.isAlive()){
                tortoiseLap = time;
            }

            if(hare.isAlive()){
                hareLap = time;
            }
        }

        System.out.println();

        if(tortoiseLap == hareLap){
            System.out.println("The race ended in a draw.");
        }else if(tortoiseLap < hareLap){
            System.out.println("Tortoise won the race!");
        }else{
            System.out.println("Hare won the race!");
        }
    }
}
