public class Main {

    public static void main(String[] args) {

        //-----GAME VARIABLES-----
        int gameRuns = 1000000000;
        int maxDoors = 3;

        //-----ALWAYS SWITCHING-----
        int winSwitch = 0;
        int lossSwitch = 0;
        for (int i = 0; i < gameRuns; i++)
        {
            int answerDoor = randNum(maxDoors);
            int contestantChoice = randNum(maxDoors);
            int[] theDoor = doorCreation(answerDoor, maxDoors);

            if (theDoor[contestantChoice-1]==0) {
                winSwitch++;
            }
            else lossSwitch++;
        }

        int totalSwitch = winSwitch + lossSwitch;
        double switchPercent = (double) winSwitch / totalSwitch;

        System.out.println("-----ALWAYS SWITCHING-----");
        System.out.println("Wins = " + winSwitch);
        System.out.println("Losses = " + lossSwitch);
        System.out.println("win% = " + switchPercent*100);


        //-----NEVER SWITCHING-----
        int winStay = 0;
        int lossStay = 0;
        for (int j = 0; j < gameRuns; j++)
        {
            int answerDoor = randNum(maxDoors);
            int contestantChoice = randNum(maxDoors);
            int[] theDoor = doorCreation(answerDoor, maxDoors);

            if (theDoor[contestantChoice-1]==1) {
                winStay++;
            }
            else lossStay++;
        }

        int totalStay = winStay + lossStay;
        double stayPercent = (double) winStay / totalStay;

        System.out.println("-----NEVER SWITCHING-----");
        System.out.println("Wins = " +winStay);
        System.out.println("Losses = " +lossStay);
        System.out.println("win% = " + stayPercent*100);
    }


    //-----FUNCTIONS-----
    public static int randNum(int maxDoors)
    {
        int min = 1;
        return (int) (Math.random() * (maxDoors+1-min)) + min;
    }

    public static int[] doorCreation(int doorAnswer, int maxDoors)
        {
        int[] theDoor = new int[maxDoors];
        theDoor[doorAnswer-1] = 1;
        return theDoor;
    }

}
