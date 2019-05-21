package com.company;

public class Tortoise extends Thread{
    private int trail;

    public Tortoise(String name) {
        super(name);
        trail = 0;
    }

    @Override
    public void run() {
        try{
            while (this.trail != 70){
                Thread.sleep(1000);
                int rng = (int) Math.floor(Math.random() * 10) + 1;
                int advance = calculateAdvance(rng);

                if(this.trail + advance < 1) {
                    this.trail = 1;
                }else if(this.trail + advance > 70){
                    this.trail = 70;
                }else{
                    this.trail += advance;
                }
                System.out.println(getName() + ": " + this.trail);
            }
            System.out.println(getName() + " has completed the race.");

        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }

    private int calculateAdvance(int rng){
        int advance = 0;
        switch (rng){
            case 1:
            case 2:
                advance = -6;
                break;
            case 3:
            case 4:
            case 5:
                advance = 1;
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                advance = 3;
                break;
        }
        return advance;
    }
}
