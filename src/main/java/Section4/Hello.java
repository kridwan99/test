package Section4;

public class Hello {

    public static void main(String[] args) {
        System.out.println("Hell, Ridwan");
        boolean isAlien = false;
        if (isAlien == false) {
            System.out.println("Is is not an alien");
        }
        int topScore = 80;
        if(topScore <= 100){
            System.out.println("you got the high score!");
        }

        int secondTopScore = 80;
        //&& = and || = or
        if ((topScore > secondTopScore) && (topScore < 100)){
            System.out.println("greater than second top score and less than 100");
        }

        if((topScore > 90) || (secondTopScore <= 90)){
            System.out.println("Either or both of the condition are true");
        }

        int newValue = 50;
        if(newValue == 50){
            System.out.println("this is true");
        }

        boolean isCar = false;
        if(isCar == true){ //we can use (isCar == true) or (!isCar)
            System.out.println("this not supposed to happen");
        }

        String makeOfCar = "Volkswagen";
        boolean isDomestic = makeOfCar == "Volkswagen" ? false : true;

        if (isDomestic) {
            System.out.println("This  car is domestic to our country");
        }

        String s = (isDomestic) ? "this car is domestic" : "this car is not domestic";
        System.out.println(s);


        double myFirstValue = 20.00d;
        double mySecondValue = 80.00d;
        double myValuesTotal = (myFirstValue + mySecondValue) * 100.00d;
        System.out.println("MyvaluesTotal = " + myValuesTotal);
        double theRemainder = myValuesTotal % 40.00d;
        System.out.println("theRemainder =" + theRemainder);
        boolean isNoRemainder = (theRemainder == 0) ? true : false;
        System.out.println("isNotremainder = " + isNoRemainder);
        if (!isNoRemainder){
            System.out.println("Got some remainder");
        }

    }
}
