package com.company;

public class Hare extends Thread{
    private int trail;

    public Hare(String name) {
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
                advance = -12;
                break;
            case 2:
            case 3:
                advance = -2;
                break;
            case 4:
            case 5:
                advance = 0;
                break;
            case 6:
            case 7:
                advance = 9;
                break;
            case 8:
            case 9:
            case 10:
                advance = 1;
                break;
        }

        return advance;
    }
}
