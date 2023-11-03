import java.util.Scanner;

public class App {
    // store variable to keep track of number of ways to catch fish
    public static int numberOfWaysToCatchFish = 0;
    // keep track of how many fish used
    public static int brownFish = -1, northernPike = -1, yellowPickerel = 0;

    public static void main(String[] args) throws Exception {
        // github is working now
        // Old Fishin' Hole

        //create scanner for input
        Scanner sc = new Scanner(System.in);

        // take inputs for points and restrictions
        int brownTroutPoints = sc.nextInt(), northernPikePoints = sc.nextInt(), yellowPickerelPoints = sc.nextInt(),
                pointsPermitted = sc.nextInt();
        // set temp variable that will be modified to check conditions
        int currentPointsLeft = pointsPermitted;
        //create another temporary variable to manipulate
        int temp;

        while (true) {
            // reset to original for the next iteration
            currentPointsLeft = pointsPermitted;
            if (currentPointsLeft - (brownFish + 1) * brownTroutPoints >= 0) {
                // decrement points left to permutate
                currentPointsLeft -= (brownFish + 1) * brownTroutPoints;
                // if incrementing num of brown fish by one doesnt make you go over points...
                brownFish++;
                // this is a possible combination... even if it is 1-0-0 for example
                printCombination();
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
                        // nested loop again to check the rest of the fish...
                        while (true) {
                            if (currentPointsLeft - (yellowPickerel + 1) * yellowPickerelPoints >= 0) {
                                // // store previous currentpointsleft
                                // temp = currentPointsLeft;
                                // // decrement points left
                                // currentPointsLeft -= (yellowPickerel + 1) * yellowPickerelPoints;
                                // increment pickeerel
                                yellowPickerel++;
                                // print and add combination
                                printCombination();
                                // // reset currentPoints left to original
                                // currentPointsLeft = temp;

                            } else {
                                // reset count
                                yellowPickerel = -1;
                                break;
                            }
                        }
                        //once finished counting + output of all the combinations of pickerel, restart loop with +1 pike...
                        //reset the currenetPoints to the original (since it was current points minus x brown fish)
                        currentPointsLeft = temp;
                    } else {
                        //reset to original 
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
    }

    public static void printCombination() {
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
