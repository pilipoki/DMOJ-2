import java.util.Scanner;

public class App {
    // store variable to keep track of number of ways to catch fish
    public static int numberOfWaysToCatchFish = 0;
    // keep track of how many fish used
    public static int brownFish = -1, northernPike = -1, yellowPickerel = 0;

    public static void main(String[] args) throws Exception {
        // github is working now
        // Old Fishin' Hole

        Scanner sc = new Scanner(System.in);

        // take inputs for points and restrictions
        int brownTroutPoints = sc.nextInt(), northernPikePoints = sc.nextInt(), yellowPickerelPoints = sc.nextInt(),
                pointsPermitted = sc.nextInt();
        // store max number of fish possible with one type of fish.
        int maxBrown = 0, maxPike = 0, maxYellow = 0;
        // set temp variable that will be modified to check conditions
        int currentPointsLeft = pointsPermitted;

        int temp;
        // reset to original on the next iteration
        
        while (true) {
            if (currentPointsLeft - (brownFish + 1) * brownTroutPoints >= 0) {
                // decrement points left to permutate
                currentPointsLeft -= (brownFish + 1) * brownTroutPoints;
                // if incrementing num of brown fish by one doesnt make you go over points...
                brownFish++;
                // this is a possible combination... even if it is 1-0-0 for example
                printCombination();
                currentPointsLeft = pointsPermitted;
                // nested while to check the rest of combinations the fish for this number of
                // brown fish.
                while (true) {
                    if (currentPointsLeft - (northernPike + 1) * northernPikePoints >= 0) {
                        // store previous currentpointsleft
                        temp = currentPointsLeft;
                        // decrement points left
                        currentPointsLeft -= (northernPike + 1) * northernPikePoints;
                        // increment pike
                        northernPike++;
                        // print and add combination
                        printCombination();
                        currentPointsLeft = temp;
                        // nested loop again to check the rest of the fish...
                        while (true) {
                            if (currentPointsLeft - (yellowPickerel + 1) * yellowPickerelPoints >= 0) {
                                // store previous currentpointsleft
                                temp = currentPointsLeft;
                                // decrement points left
                                currentPointsLeft -= (yellowPickerel + 1) * yellowPickerelPoints;
                                // increment pickeerel
                                yellowPickerel++;
                                // print and add combination
                                printCombination();
                                // reset currentPoints left to original
                                currentPointsLeft = temp;

                            } else {
                                // reset count
                                yellowPickerel = -1;
                                break;
                            }
                        }
                    } else {
                        northernPike = -1;
                        break;
                    }
                }
            } else {
                // fully break out, reached all combinations
                break;
            }
        }

        System.out.println("Number of ways to catch fish: " + numberOfWaysToCatchFish);

        // //find end limit of each type of fish
        // while (true) {
        // if (pointsPermitted-(maxBrown+1)*brownTroutPoints >= 0) {
        // //if incrementing num of brown fish by one doesnt make you go over points,
        // print out combo.
        // maxBrown++;
        // }
        // //if we have reached limit of brown, find what other fish we can use...
        // else if(pointsPermitted-(maxPike+1)*northernPikePoints >= 0){
        // maxPike++;
        // }
        // //if we reached the limit of pike, find max yellow
        // else if(pointsPermitted-(maxYellow+1)*yellowPickerelPoints >= 0){
        // maxYellow++;
        // }
        // //if we have all of our maxes, exit while loop
        // else break;
        // }
        // //check each combination now that you have the maximum number.
        // //combinations with at least one brown
        // for (int i = 1; i < maxBrown; i++) {
        // if(((pointsPermitted-i*brownTroutPoints) - (maxPike+1)*northernPikePoints)
        // >=0){
        // //add to your number of brown fish
        // brownFish++;
        // //add to your number of pike
        // northernPike++;
        // }
        // }
    }

    public static void printCombination() {
        // if ((brownFish == 0 && northernPike == -1 && yellowPickerel == -1)
        // || (brownFish == 0 && northernPike == 0 && yellowPickerel == -1)
        // || (brownFish == 0 && northernPike == 0 && yellowPickerel == 0)) {
        // // print nothing
        // }
        if ((brownFish == -1 || northernPike == -1 || yellowPickerel == -1)
                || (brownFish == 0 && northernPike == 0 && yellowPickerel == 0)) {
            // print nothing
        } else {
            numberOfWaysToCatchFish++;
            System.out.println(brownFish + " Brown Trout, " + northernPike + " Northern Pike, " + yellowPickerel
                    + " Yellow Pickerel");
        }
    }

}
