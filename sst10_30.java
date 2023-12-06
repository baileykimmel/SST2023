import java.lang.reflect.InvocationTargetException;
import java.util.*;

//import javax.sound.midi.SysexMessage;

class SST {

    public static void main(String[] args)

            throws ClassNotFoundException, NoSuchMethodException, SecurityException {

        // Game object
        Game game = new Game();

        // Getting the class for method usage through inputted command
        Class<?> myClass = Class.forName("Game");

        // String assigned at input
        String cmd;

        // Input stream scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("-SUPER STAR TREK\n");
        System.out.println("Latest update- 27 Sept 78\n");

        // All starter inputs that check validity
        do {
            System.out.printf("Would you like a regular, tournament, or frozen game? ");
            game.gametype = scanner.nextLine();
        } while (!game.gametype.equals("regular") && !game.gametype.equals("tournament")
                && !game.gametype.equals("frozen"));

        do {
            System.out.printf("Would you like a short, medium, or long game? ");
            game.length = scanner.nextLine();
        } while (!game.length.equals("short") && !game.length.equals("medium") && !game.gametype.equals("long"));

        do {
            System.out.printf("Are you a novice, fair, good, expert, or emeritus player? ");
            game.rank = scanner.nextLine();

        } while (!game.rank.equals("novice") && !game.rank.equals("fair") && !game.rank.equals("good")
                && !game.rank.equals("expert") && !game.rank.equals("emeritus"));

        // Password that doesn't exceed 9 characters
        do {
            System.out.printf("Please type in a secret password(9 characters maximum)- ");
            game.password = scanner.nextLine();
        } while (game.password.length() > 9);

        // Game loop
        do {
            System.out.printf("COMMAND> ");
            cmd = scanner.nextLine();

            if (game.commands.contains(cmd)) {
                try {
                    myClass.getMethod(cmd).invoke(game);
                } catch (SecurityException e) {
                } catch (NoSuchMethodException e) {
                } catch (IllegalArgumentException e) {
                } catch (IllegalAccessException e) {
                } catch (InvocationTargetException e) {
                }
            } else
                System.out.println("\nUNRECOGNIZED COMMAND. Type \"COMMANDS\" for a list of legal commands.");

        } while (cmd != "QUIT");

        scanner.close();
    }
}

class Game {

    // Arbitrary quadrant and sector
    Quadrant quadrant = new Quadrant();
    Sector sector = new Sector();
    Klingon klingon = new Klingon();

    // List of commands to check at input
    String[] cmds = { "SRSCAN", "MOVE", "PHASERS", "CALL", "STATUS", "IMPULSE", "PHOTONS", "ABANDON", "LRSCAN",
            "WARP", "SHIELDS", "DESTRUCT",
            "CHART", "REST", "DOCK", "QUIT", "DAMAGES", "REPORT", "SENSORS", "ORBIT", "TRANSPORT", "MINE",
            "CRYSTALS", "SHUTTLE", "PLANETS", "REQUEST",
            "DEATHRAY", "FREEZE", "COMPUTER", "EMEXIT", "PROBE", "COMMANDS", "SCORE", "CLOAK", "CAPTURE", "HELP" };

    // Converting array of commands to a list for the use of built-in functions
    List<String> commands = new ArrayList<String>(Arrays.asList(cmds));

    // Input stream scanner
    Scanner scanner = new Scanner(System.in);

    // Random number instance of Random class
    Random rand = new Random();

    String gametype;
    String length;
    String rank;
    String password;
    String score_yes_or_no;
    String filename;
    String playagain;
    String request;

    // Quadrant matrix
    int[][] randoms = new int[8][8];

    {
        for (int i = 0; i < 8; i++)

            randoms[i] = rand.ints(8, -1, 1000).toArray();
    }

    {

        // Making sure there aren't 0's for the LRSCAN numbers
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                if (String.valueOf(randoms[i][j]).contains("0")) {
                    randoms[i][j] /= 2;
                }
            }
    }

    // All command methods
    public void SRSCAN() {

        if(quadrant.damaged)
        {
         System.out.println("Short Range Sensors Damaged!");
        }
         else
         {
        if (quadrant.row == 1 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 E * * * * *   * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * K * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 *     * * * P * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * K * * *     * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * E * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * K * * * *   Position: 1, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * *     *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * E * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 3 "); // plus position (x,y a,b)
            System.out.println("  4 * *     * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * P * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * E * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * P * * * * * * * *   Position: 1, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * *     * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * E * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * *     * * * *   Position: 1, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * K *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * E * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 6"); // plus position (x,y a,b)
            System.out.println("  4     * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * *     * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * K * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * E * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * K * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * *     * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * K * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 *   * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * E * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * K * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }

        if (quadrant.row == 2 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 E * * * *       * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * K * * * *   * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * E * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * *     * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * K * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * *     *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * E * * * * *       Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * *     * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * K *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * E * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * K * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * P *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * E * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * K * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * E * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * K * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * E * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * K * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * *     * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * E * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * K * * * * * * * *   Position: 2, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * P * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }

        if (quadrant.row == 3 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 P * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 E * * * * * * * * *   Position: 3, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * K   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * E * * * * * * * *   Position: 3, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * P *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * E * * * * * * *   Position: 3, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * K * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * K * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * K * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * E * * * * * *   Position: 3, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * K * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * K * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * E * * * * *   Position: 3, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * *     * * * * K *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * K * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * K * E * * * *   Position: 3, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * *     * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * K * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 *     * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * K * * * * E * * *   Position: 3, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * K * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * *     * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * E * *   Position: 3, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * P * * *     *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * K * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }

        if (quadrant.row == 4 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 1"); // plus position (x,y a,b)
            System.out.println("  4 E * * * * * * K * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * P * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * *     * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 2"); // plus position (x,y a,b)
            System.out.println("  4 * E K * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * *     * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 *     * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * P * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * E * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * K * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * E * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * K * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * E * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * K * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * P * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * E * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * K *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 P * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * K * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * P * * * * * * * *   Position: 4, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * E * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * K * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * E K *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * K * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }

        if (quadrant.row == 5 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * P * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 E * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * P * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * K * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * E * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * K * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * P * * * * *     *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * E * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * K * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * *     * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * E * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * *     * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 *     * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 *     * * * * K * *   Position: 5, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * E * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * *   * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition ); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * E * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * P * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * K   Condition: "  + quadrant.condition ); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * E * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * P * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * K *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * E * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * K * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }

        if (quadrant.row == 6 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * P * * * * K * *   Position: 6, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 E * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * *     * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * K * * * * P   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * E * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * *     * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * K * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * E * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * K * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * K * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * E * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * K * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * K * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * E * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * K * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * K * *   Position: 6, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * K * * * E * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * K * * * * * * *   Position: 6, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * *   * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * E * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * K * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * *     * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * K * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * *    * * E * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * *   * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }

        if (quadrant.row == 7 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * *     * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * K * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 E * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * P * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * *      * *   Position: 7, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 *     * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * E * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * *     * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * K *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * P * * *   Position: 7, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * E     * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9     * * * * * P * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * K * * * * * * * *   Position: 7, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * K * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * E * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * *     * * *   Position: 7, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * K *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * E * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 *     * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * K * * * * * * * *   Position: 7, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * K * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * E * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * K * * * * * * *   Position: 7, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * E * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * K *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * K * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * E * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * K * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }

        if (quadrant.row == 8 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 1"); // plus position (x,y a,b)
            System.out.println("  4 * K * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * P * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 E * * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * P * * * * * * *   Position: 8, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * P * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * E * * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * K * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * E * * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 4"); // plus position (x,y a,b)
            System.out.println("  4 * K * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * E * * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * K * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * E * * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 6"); // plus position (x,y a,b)
            System.out.println("  4 *     * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * K * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * E * * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 7"); // plus position (x,y a,b)
            System.out.println("  4 * K * *     * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * * * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * E * * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: " + quadrant.stardate);// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "  + quadrant.condition); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support ACTIVE "); // + Life Support ACTIVE
            System.out.println("  5 * * * * * * * K * *   Warp factor: " + quadrant.warpFactor); // + Warp factor
            System.out.println("  6 *     * * * * * * *   Energy: 4908.29"); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: " + quadrant.torp); // + Torpedoes
            System.out.println("  8 * * * * * * * E * *   Shields: " + quadrant.shields); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: " + quadrant.klingons); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time left: " + quadrant.stardates); // + Time left
        }
                if(klingon.row < (quadrant.row + 1) && klingon.row > (quadrant.row - 1)
                && klingon.column < (quadrant.row + 1) && klingon.column > (quadrant.row - 1))
                {
                    System.out.println("Klingons have spotted you! You are under enemy fire");
                    System.out.println("You have taken damage");
                    quadrant.StarshipHealth--;
                    quadrant.damaged = true;
                    if (quadrant.StarshipHealth < 7 && quadrant.StarshipHealth> 5) {
                        quadrant.condition = "Yellow";   
                    }
                    else if(quadrant.StarshipHealth <= 5){
                        quadrant.condition = "Red";

                    }
                    if(quadrant.StarshipHealth <=0)
                    {
                        System.out.println("Your ship has been destroyed!");
 System.out.println("*************************************************");
        System.out.println("Do you want your score recorded? ");
        score_yes_or_no = scanner.nextLine();
        System.out.println("File name(9 characters maximum):");
        filename = scanner.nextLine();
        System.out.println("Can't freeze game as file " + filename + ".trk");
        System.out.println("Would you like to play again?");
        playagain = scanner.nextLine();;
                    }
                }
            }
    }

    public void MOVE() {
        System.out.println("Manual or automatic-");
        String manual_or_auto = scanner.nextLine();

        if (manual_or_auto.equals("Manual")) 
        {
            int xpos = scanner.nextInt();
            int ypos = scanner.nextInt();

            if ((quadrant.row + xpos) < 1 || (quadrant.row + xpos) > 8 || (quadrant.column + ypos) < 1
                    || (quadrant.column + ypos) > 8) {
                System.out.println("Cannot go past Barriers. If you do this three times, your ship will be destroyed.");
            }

            else {
                quadrant.row += xpos;
                quadrant.column += ypos;
                System.out.println("New Position is (" + quadrant.row + "," + quadrant.column + ")");
            }
        }

        else if (manual_or_auto.equals("AUTOMATIC") || manual_or_auto.equals("automatic") || manual_or_auto.equals("Automatic"))
        {
            System.out.println("Destination Quadrant");
            int xpos = scanner.nextInt();
            int ypos = scanner.nextInt();
            if (xpos > 8 || xpos < 1 || ypos < 1 || ypos > 8) {
                System.out.println("Invalid argument");
            }

            else {
                quadrant.row = xpos;
                quadrant.column = ypos;
                System.out.println("New Position is (" + quadrant.row + "," + quadrant.column + ")");
            }
        }
        if(klingon.row < (quadrant.row + 1) && klingon.row > (quadrant.row - 1)
                && klingon.column < (quadrant.row + 1) && klingon.column > (quadrant.row - 1))
                {
                    System.out.println("Klingons have spotted you! You are under enemy fire");
                    System.out.println("You have taken damage");
                    quadrant.StarshipHealth--;
                    quadrant.damaged = true;
                    if (quadrant.StarshipHealth < 7 && quadrant.StarshipHealth> 5) {
                        quadrant.condition = "Yellow";   
                    }
                    else if(quadrant.StarshipHealth <= 5){
                        quadrant.condition = "Red";

                    }
                    if(quadrant.StarshipHealth <=0)
                    {
                        System.out.println("Your ship has been destroyed!");
 System.out.println("*************************************************");
        System.out.println("Do you want your score recorded? ");
        score_yes_or_no = scanner.nextLine();
        System.out.println("File name(9 characters maximum):");
        filename = scanner.nextLine();
        System.out.println("Can't freeze game as file " + filename + ".trk");
        System.out.println("Would you like to play again?");
        playagain = scanner.nextLine();;
                    }
                }
    }

    public void PHASERS() {

        if (klingon.row == quadrant.row && klingon.column == quadrant.column) // if klingon in same quadrant
        {
            klingon.health = klingon.health - 20;
        }

        else if (klingon.row < (quadrant.row + 1) && klingon.row > (quadrant.row - 1)
                && klingon.column < (quadrant.row + 1) && klingon.column > (quadrant.row - 1)) // if it is in a quadrant
                                                                                               // next to us
        {
            klingon.health = klingon.health - 10;
        }

        else // if no klingon in range.
        {
            System.out.println("No enemies within range");
        }

        if (klingon.health <= 0) {
            System.out.println("Klingon ship destroyed.");
            quadrant.klingons--;
        }
                if(klingon.row < (quadrant.row + 1) && klingon.row > (quadrant.row - 1)
                && klingon.column < (quadrant.row + 1) && klingon.column > (quadrant.row - 1))
                {
                    System.out.println("Klingons have spotted you! You are under enemy fire");
                    System.out.println("You have taken damage");
                    quadrant.StarshipHealth--;
                    quadrant.damaged = true;
                    if (quadrant.StarshipHealth < 7 && quadrant.StarshipHealth> 5) {
                        quadrant.condition = "Yellow";   
                    }
                    else if(quadrant.StarshipHealth <= 5){
                        quadrant.condition = "Red";

                    }
                    if(quadrant.StarshipHealth <=0)
                    {
                        System.out.println("Your ship has been destroyed!");
 System.out.println("*************************************************");
        System.out.println("Do you want your score recorded? ");
        score_yes_or_no = scanner.nextLine();
        System.out.println("File name(9 characters maximum):");
        filename = scanner.nextLine();
        System.out.println("Can't freeze game as file " + filename + ".trk");
        System.out.println("Would you like to play again?");
        playagain = scanner.nextLine();;
                    }
                }
    }

    public void CALL() {
        System.out.println("Starbase in Quadrant " + quadrant.row + " - " + quadrant.column + " responds--Enterprise dematerializes.");
        System.out.println("1st attempt to re-materialize Enterprise . . . . . succeeds.");
        System.out.println("Docked");

        quadrant.condition = "DOCKED";
    }

    public void STATUS() {
        System.out.println("Stardate: " + quadrant.stardate);// + Stardate
        System.out.println("Condition: "  + quadrant.condition); // + condition
        System.out.println("Position: 1, 1"); // plus position (x,y a,b)
        System.out.println("Life Support ACTIVE "); // + Life Support ACTIVE
        System.out.println("Warp factor: " + quadrant.warpFactor); // + Warp factor
        System.out.println("Energy: 4908.29"); // + Energy
        System.out.println("Torpedoes:" + quadrant.torp); // + Torpedoes
        System.out.println("Shields: " + quadrant.shields + quadrant.shields + ", 100% " + quadrant.shieldUnits + " units"); // + Shields
        System.out.println("Klingons Left: " + quadrant.klingons); // + Klingons Left
        System.out.println("Time left: " + quadrant.stardates); // + Time left
    }

    public void IMPULSE() {
        System.out.println("Manual or automatic-");
        String input = scanner.nextLine();
        String random = "";
    
        if(input == "Manual")
        {
            System.out.println("X and Y displacements-");
            random = scanner.nextLine();
        }

        else if(input == "automatic")
        {
            System.out.println("Destination sector or quadrant&sector- ");
            random = scanner.nextLine();
        }

        System.out.println("Sulu- Course locked in for Sector " + random + " .");
    }

    public void PHOTONS() {
        //TORPEDOES
        //start with 10
        if(quadrant.torp > 0)
        {
            System.out.println("How many would you like to shoot?");
            int intrequest = scanner.nextInt(); //get input
            if(intrequest < quadrant.torp)
            {
                System.out.println("What direction would you like to shoot? (North, East, South, West)");
                String request = scanner.next(); //get input
                if(request.equals("NORTH") || request.equals("north") || request.equals("North"))
                {
                    if(klingon.column == quadrant.column && klingon.row >= quadrant.row)
                    {
                        klingon.health -= 20;
                        System.out.println("Photon Torpedos hit enemy Klingon ship!");
                        if (klingon.health <= 0) 
                        {
                            System.out.println("Klingon ship destroyed.");
                            quadrant.klingons--;
                        }
                    } 
                    else
                    {
                        System.out.println("Photon Torpedos shot into empty space");
                    }
                    quadrant.torp -= intrequest;
                }

                else if(request.equals("SOUTH")||request.equals("south")||request.equals("South"))
                {
                    if(klingon.column == quadrant.column && klingon.row <= quadrant.row)
                    {
                        klingon.health -= 20;
                        System.out.println("Photon Torpedos hit enemy Klingon ship!");//hit
                        if (klingon.health <= 0) 
                        {
                            System.out.println("Klingon ship destroyed.");
                            quadrant.klingons--;
                        }
                    } 
                    else
                    {
                        System.out.println("Photon Torpedos shot into empty space");
                    }
                    quadrant.torp -= intrequest;
                }

                else if(request.equals("EAST")||request.equals("East")||request.equals("east"))
                {
                    if(klingon.column >= quadrant.column && klingon.row == quadrant.row)
                    {
                        klingon.health -= 20;
                        System.out.println("Photon Torpedos hit enemy Klingon ship!");//hit
                        if (klingon.health <= 0) 
                        {
                            System.out.println("Klingon ship destroyed.");
                            quadrant.klingons--;
                        }
                    } 
                    else
                    {
                        System.out.println("Photon Torpedos shot into empty space");
                    }
                    quadrant.torp -= intrequest;
                }

                else if(request.equals("WEST")||request.equals("West")||request.equals("west"))
                {
                    if(klingon.column <= quadrant.column && klingon.row == quadrant.row)
                    {
                        klingon.health -= 20;
                        System.out.println("Photon Torpedos hit enemy Klingon ship!");//hit
                        if (klingon.health <= 0) 
                        {
                            System.out.println("Klingon ship destroyed.");
                            quadrant.klingons--;
                        }
                    } 
                    else
                    {
                        System.out.println("Photon Torpedos shot into empty space");
                    }
                    quadrant.torp -= intrequest;
                }

                else
                {
                    System.out.println("Invalid Input");
                }
            }

            else
            {
                System.out.println(" Not enough Photon Torpedoes.");
            }
            

        }
        else
        {
            System.out.println("No Photon Torpedoes available");
        }
                if(klingon.row < (quadrant.row + 1) && klingon.row > (quadrant.row - 1)
                && klingon.column < (quadrant.row + 1) && klingon.column > (quadrant.row - 1))
                {
                    System.out.println("Klingons have spotted you! You are under enemy fire");
                    System.out.println("You have taken damage");
                    quadrant.StarshipHealth--;
                    quadrant.damaged = true;
                    if (quadrant.StarshipHealth < 7 && quadrant.StarshipHealth> 5) {
                        quadrant.condition = "Yellow";   
                    }
                    else if(quadrant.StarshipHealth <= 5){
                        quadrant.condition = "Red";

                    }
                    if(quadrant.StarshipHealth <=0)
                    {
                        System.out.println("Your ship has been destroyed!");
 System.out.println("*************************************************");
        System.out.println("Do you want your score recorded? ");
        score_yes_or_no = scanner.nextLine();
        System.out.println("File name(9 characters maximum):");
        filename = scanner.nextLine();
        System.out.println("Can't freeze game as file " + filename + ".trk");
        System.out.println("Would you like to play again?");
        playagain = scanner.nextLine();;
                    }
                }
    }

    public void ABANDON() {
        System.out.println("***ABANDON SHIP!  ABANDON SHIP!");
        System.out.println("***ALL HANDS ABANDON SHIP!\n");
        System.out.println("Captain and crew escape in shuttle craft.");
        System.out.println("Remainder of ship's complement beam down");
        System.out.println("to nearest habitable planet.\n");
        System.out.println("You are captured by Klingons and released to");
        System.out.println("You are captured by Klingons and released to");
        System.out.println("the Federation in a prisoner-of-war exchange.");
        System.out.println("Starfleet puts you in command of another ship,");
        System.out.println("the Faerie Queene, which is antiquated but,");
        System.out.println("still usable.");
    }

    public void LRSCAN() {
        System.out.println("Long-range scan for Quadrant " + quadrant.row + " - " + quadrant.column);

        quadrant.scanned = true;
        if(quadrant.row == 1 && quadrant.column == 1)
        {
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[0][0], randoms[0][1]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[1][0], randoms[1][1]));
        }

        if(quadrant.row == 1 && quadrant.column == 2)
        {
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
        }

        if(quadrant.row == 1 && quadrant.column == 3)
        {
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
            System.out.println(String.format("%5d%5d%5d", randoms[0][1], randoms[0][2], randoms[0][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][1], randoms[1][2], randoms[1][3]));
        }
        
        if(quadrant.row == 1 && quadrant.column == 4)
        {
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
            System.out.println(String.format("%5d%5d%5d", randoms[0][2], randoms[0][3], randoms[0][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][2], randoms[1][3], randoms[1][4]));
        }

        if(quadrant.row == 1 && quadrant.column == 5)
        {
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
            System.out.println(String.format("%5d%5d%5d", randoms[0][3], randoms[0][4], randoms[0][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][3], randoms[1][4], randoms[1][5]));
        }

        if(quadrant.row == 1 && quadrant.column == 6)
        {
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
            System.out.println(String.format("%5d%5d%5d", randoms[0][4], randoms[0][5], randoms[0][6]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][4], randoms[1][5], randoms[1][6]));
        }

        if(quadrant.row == 1 && quadrant.column == 7)
        {
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
            System.out.println(String.format("%5d%5d%5d", randoms[0][5], randoms[0][6], randoms[0][7]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][5], randoms[1][6], randoms[1][7]));
        }

        if(quadrant.row == 1 && quadrant.column == 8)
        {
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
            System.out.println(String.format("%5d%5d%5d", randoms[0][6], randoms[0][7], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[1][6], randoms[1][7], -1));
        }

        if(quadrant.row == 2 && quadrant.column == 1)
        {
            System.out.println(String.format("%5d%5d%5d", -1, randoms[0][0], randoms[0][1]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[1][0], randoms[1][1]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[2][0], randoms[2][1]));
        }

        if(quadrant.row == 2 && quadrant.column == 2)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 2 && quadrant.column == 3)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][1], randoms[0][2], randoms[0][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][1], randoms[1][2], randoms[1][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][1], randoms[2][2], randoms[2][3]));
        }

        if(quadrant.row == 2 && quadrant.column == 4)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][2], randoms[0][3], randoms[0][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][2], randoms[1][3], randoms[1][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][2], randoms[2][3], randoms[2][4]));
        }

        if(quadrant.row == 2 && quadrant.column == 5)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][3], randoms[0][4], randoms[0][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][3], randoms[1][4], randoms[1][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][3], randoms[2][4], randoms[2][5]));
        }

        if(quadrant.row == 2 && quadrant.column == 6)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][4], randoms[0][5], randoms[0][6]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][4], randoms[1][5], randoms[1][6]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][4], randoms[2][5], randoms[2][6]));
        }

        if(quadrant.row == 2 && quadrant.column == 7)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][5], randoms[0][6], randoms[0][7]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][5], randoms[1][6], randoms[1][7]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][5], randoms[2][6], randoms[2][7]));
        }

        if(quadrant.row == 2 && quadrant.column == 8)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][6], randoms[0][7], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[1][6], randoms[1][7], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[2][6], randoms[2][7], -1));
        }

        if(quadrant.row == 3 && quadrant.column == 1)
        {
            System.out.println(String.format("%5d%5d%5d", -1, randoms[1][0], randoms[1][1]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[2][0], randoms[2][1]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[3][0], randoms[3][1]));
        }

        if(quadrant.row == 3 && quadrant.column == 2)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][0], randoms[3][1], randoms[3][2]));
        }

        if(quadrant.row == 3 && quadrant.column == 3)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][1], randoms[1][2], randoms[1][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][1], randoms[2][2], randoms[2][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][1], randoms[3][2], randoms[3][3]));
        }

        if(quadrant.row == 3 && quadrant.column == 4)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][2], randoms[1][3], randoms[1][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][2], randoms[2][3], randoms[2][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][2], randoms[3][3], randoms[3][4]));
        }

        if(quadrant.row == 3 && quadrant.column == 5)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][3], randoms[1][4], randoms[1][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][3], randoms[2][4], randoms[2][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][3], randoms[3][4], randoms[3][5]));
        }

        if(quadrant.row == 3 && quadrant.column == 6)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][4], randoms[1][5], randoms[1][6]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][4], randoms[2][5], randoms[2][6]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][4], randoms[3][5], randoms[3][6]));
        }

        if(quadrant.row == 3 && quadrant.column == 7)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][5], randoms[1][6], randoms[1][7]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][5], randoms[2][6], randoms[2][7]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][5], randoms[3][6], randoms[3][7]));
        }

        if(quadrant.row == 3 && quadrant.column == 8)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][6], randoms[1][7], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[2][6], randoms[2][7], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[3][6], randoms[3][7], -1));
        }

        if(quadrant.row == 4 && quadrant.column == 1)
        {
            System.out.println(String.format("%5d%5d%5d", -1, randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 4 && quadrant.column == 2)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][1], randoms[0][2], randoms[0][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][1], randoms[1][2], randoms[1][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][1], randoms[2][2], randoms[2][3]));
        }

        if(quadrant.row == 4 && quadrant.column == 3)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][2], randoms[0][3], randoms[0][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][2], randoms[1][3], randoms[1][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][2], randoms[2][3], randoms[2][4]));
        }

        if(quadrant.row == 4 && quadrant.column == 4)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][3], randoms[0][4], randoms[0][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][3], randoms[1][4], randoms[1][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][3], randoms[2][4], randoms[2][5]));
        }

        if(quadrant.row == 4 && quadrant.column == 5)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 4 && quadrant.column == 6)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 4 && quadrant.column == 7)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][2], randoms[0][3], randoms[0][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][2], randoms[1][3], randoms[1][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][2], randoms[2][3], randoms[2][4]));
        }

        if(quadrant.row == 4 && quadrant.column == 8)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][3], randoms[0][4], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[1][3], randoms[1][4], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[2][3], randoms[2][4], -1));
        }

        if(quadrant.row == 5 && quadrant.column == 1)
        {
            System.out.println(String.format("%5d%5d%5d", -1, randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[2][1], randoms[2][2]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[3][1], randoms[3][2]));
        }

        if(quadrant.row == 5 && quadrant.column == 2)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 5 && quadrant.column == 3)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 5 && quadrant.column == 4)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][1], randoms[0][2], randoms[0][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][1], randoms[1][2], randoms[1][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][1], randoms[2][2], randoms[2][3]));
        }

        if(quadrant.row == 5 && quadrant.column == 5)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][3], randoms[0][4], randoms[0][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][3], randoms[1][4], randoms[1][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][3], randoms[2][4], randoms[2][5]));
        }

        if(quadrant.row == 5 && quadrant.column == 6)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][2], randoms[0][3], randoms[0][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][2], randoms[1][3], randoms[1][4]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][2], randoms[2][3], randoms[2][4]));
        }

        if(quadrant.row == 5 && quadrant.column == 7)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 5 && quadrant.column == 8)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][1], randoms[0][2], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[1][1], randoms[1][2], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[2][1], randoms[2][2], -1));
        }

        if(quadrant.row == 6 && quadrant.column == 1)
        {
            System.out.println(String.format("%5d%5d%5d", -1, randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[2][1], randoms[2][2]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[3][1], randoms[3][2]));
        }

        if(quadrant.row == 6 && quadrant.column == 2)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 6 && quadrant.column == 3)
        {
           System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 6 && quadrant.column == 4)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][0], randoms[3][1], randoms[3][2]));
        }

        if(quadrant.row == 6 && quadrant.column == 5)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][1], randoms[0][2], randoms[0][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][1], randoms[1][2], randoms[1][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][1], randoms[2][2], randoms[2][3]));
        }

        if(quadrant.row == 6 && quadrant.column == 6)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][3], randoms[0][4], randoms[0][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][3], randoms[1][4], randoms[1][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][3], randoms[2][4], randoms[2][5]));
        }

        if(quadrant.row == 6 && quadrant.column == 7)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][0], randoms[3][1], randoms[3][2]));
        }

        if(quadrant.row == 6 && quadrant.column == 8)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], -1));
        }

        if(quadrant.row == 7 && quadrant.column == 1)
        {
            System.out.println(String.format("%5d%5d%5d", -1, randoms[1][5], randoms[1][6]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[2][5], randoms[2][6]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[3][5], randoms[3][6]));
        }

        if(quadrant.row == 7 && quadrant.column == 2)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][1], randoms[0][2], randoms[0][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][1], randoms[1][2], randoms[1][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][1], randoms[2][2], randoms[2][3]));
        }

        if(quadrant.row == 7 && quadrant.column == 3)
        {
           System.out.println(String.format("%5d%5d%5d", randoms[0][3], randoms[0][4], randoms[0][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][3], randoms[1][4], randoms[1][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][3], randoms[2][4], randoms[2][5]));
        }

        if(quadrant.row == 7 && quadrant.column == 4)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][1], randoms[0][2], randoms[0][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][1], randoms[1][2], randoms[1][3]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][1], randoms[2][2], randoms[2][3]));
        }

        if(quadrant.row == 7 && quadrant.column == 5)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
        }

        if(quadrant.row == 7 && quadrant.column == 6)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][0], randoms[3][1], randoms[3][2]));
        }

        if(quadrant.row == 7 && quadrant.column == 7)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[3][0], randoms[3][1], randoms[3][2]));
        }

        if(quadrant.row == 7 && quadrant.column == 8)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[3][0], randoms[3][1], -1));
        }
        
        if(quadrant.row == 8 && quadrant.column == 1)
        {
            System.out.println(String.format("%5d%5d%5d", -1, randoms[0][2], randoms[0][3]));
            System.out.println(String.format("%5d%5d%5d", -1, randoms[1][2], randoms[1][3]));
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
        }

        if(quadrant.row == 8 && quadrant.column == 2)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
        }

        if(quadrant.row == 8 && quadrant.column == 3)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
        }

        if(quadrant.row == 8 && quadrant.column == 4)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[1][4], randoms[1][5], randoms[1][6]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][4], randoms[2][5], randoms[2][6]));
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
        }

        if(quadrant.row == 8 && quadrant.column == 5)
        {
    
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[2][0], randoms[2][1], randoms[2][2]));
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
        }

        if(quadrant.row == 8 && quadrant.column == 6)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[0][1], randoms[0][2]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][0], randoms[1][1], randoms[1][2]));
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
        }

        if(quadrant.row == 8 && quadrant.column == 7)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][3], randoms[0][4], randoms[0][5]));
            System.out.println(String.format("%5d%5d%5d", randoms[1][3], randoms[1][4], randoms[1][5]));
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
        }
       
        if(quadrant.row == 8 && quadrant.column == 8)
        {
            System.out.println(String.format("%5d%5d%5d", randoms[0][2], randoms[0][3], -1));
            System.out.println(String.format("%5d%5d%5d", randoms[1][2], randoms[1][3], -1));
            System.out.println(String.format("%5d%5d%5d", -1, -1, -1));
        }
        
        System.out.println();

        if(klingon.row < (quadrant.row + 1) && klingon.row > (quadrant.row - 1)
                && klingon.column < (quadrant.row + 1) && klingon.column > (quadrant.row - 1))
                {
                    System.out.println("Klingons have spotted you! You are under enemy fire");
                    System.out.println("You have taken damage");
                    quadrant.StarshipHealth--;
                    quadrant.damaged = true;
                    if (quadrant.StarshipHealth < 7 && quadrant.StarshipHealth> 5) {
                        quadrant.condition = "Yellow";   
                    }
                    else if(quadrant.StarshipHealth <= 5){
                        quadrant.condition = "Red";

                    }
                    if(quadrant.StarshipHealth <=0)
                    {
                        System.out.println("Your ship has been destroyed!");
                        System.out.println("*************************************************");
                        System.out.println("Do you want your score recorded? ");
                        score_yes_or_no = scanner.nextLine();
                        System.out.println("File name(9 characters maximum):");
                        filename = scanner.nextLine();
                        System.out.println("Can't freeze game as file " + filename + ".trk");
                        System.out.println("Would you like to play again?");
                        playagain = scanner.nextLine();;
                    }
                }
    }

    public void WARP() {
        System.out.println("Warp factor-");
        Double factor = scanner.nextDouble();
        System.out.println("Helmsman Sulu- " + '"' + "Warp factor" + factor + ".0, Captain." + '"');
        quadrant.warpFactor = factor;
    }

    public void SHIELDS() {
        System.out.println("Do you wish to change shield energy? ");
        String wish = scanner.nextLine();
        if(wish == "yes")
        {
            System.out.println("Energy to transfer to shields- ");
            Double transfer = scanner.nextDouble();
            quadrant.shieldUnits += transfer;
            if(transfer < 0)
            {
                System.out.println("Scotty- " + '"' + "Draining energy from shields." + '"');
            }

            else
            {
                System.out.println("Shield energy maximized.");
                System.out.println("Excess energy requested returned to ship energy");
            }
        }

        else if(wish == "no")
        {
            if(quadrant.shields == "DOWN")
            {
                System.out.println("Shields are down. Do you want them up? ");
                wish = scanner.nextLine();

                if(wish == "yes")
                {
                    System.out.println("Shields raised.");
                }
            }

            else if(quadrant.shields == "UP")
            {
                System.out.println("Shields are up. Do you want them down? ");
                wish = scanner.nextLine();

                if(wish == "yes")
                {
                    System.out.println("Shields lowered.");
                }
            }
        }
    }

    public void DESTRUCT() {
        System.out.println("SELF-DESTRUCT-SEQUENCE-ACTIVATED");
        System.out.println("ENTER-CORRECT-PASSWORD-TO-CONTINUE");
        String pass = scanner.nextLine();
        if(pass == password)
        {
            System.out.println("PASSOWRD-ACCEPTED");

            System.out.println("It is stardate " + quadrant.stardate + "\n");
            System.out.println("Your starship is now an expanding cloud of subatomic particles");
        }

        else
        {
            System.out.println("OPERATION-ABORTED");
        }
    }

    public void CHART() {
        if(quadrant.scanned == true)
        {
            if(quadrant.row == 1 && quadrant.column == 1)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  " + randoms[0][0] + "  " + randoms[0][1] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  " + randoms[1][0] + "  " + randoms[1][1] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 1 && quadrant.column == 2)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  " + randoms[0][0] + "  " + randoms[0][1] + "  " + randoms[0][2] + "  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  " + randoms[1][0] + "  " + randoms[1][1] + "  " + randoms[1][2] + "  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 1 && quadrant.column == 3)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  " + randoms[0][1] + "  " + randoms[0][2] + "  " + randoms[0][3] + "  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  " + randoms[1][1] + "  " + randoms[1][2] + "  " + randoms[1][3] + "  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }
            
            if(quadrant.row == 1 && quadrant.column == 4)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  " + randoms[0][2] + "  " + randoms[0][3] + "  " + randoms[0][4] + "  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  " + randoms[1][2] + "  " + randoms[1][3] + "  " + randoms[1][4] + "  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 1 && quadrant.column == 5)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  " + randoms[0][3] + "  " + randoms[0][4] + "  " + randoms[0][5] + "  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  " + randoms[1][3] + "  " + randoms[1][4] + "  " + randoms[1][5] + "  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 1 && quadrant.column == 6)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  " + randoms[0][4] + "  " + randoms[0][5] + "  " + randoms[0][6] + "  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  " + randoms[1][4] + "  " + randoms[1][5] + "  " + randoms[1][6] + "  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 1 && quadrant.column == 7)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  " + randoms[0][5] + "  " + randoms[0][6] + "  " + randoms[0][7] + "  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  " + randoms[1][5] + "  " + randoms[1][6] + "  " + randoms[1][7] + "  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 1 && quadrant.column == 8)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  " + randoms[0][6] + "  " + randoms[0][7] + "  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  " + randoms[1][6] + "  " + randoms[1][7] + "  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 2 && quadrant.column == 1)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  " + randoms[0][0] + "  " + randoms[0][1] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  " + randoms[1][0] + "  " + randoms[1][1] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  " + randoms[2][0] + "  " + randoms[2][1] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 2 && quadrant.column == 2)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  " + randoms[0][0] + "  " + randoms[0][1] + "  " + randoms[0][2] + "  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  " + randoms[1][0] + "  " + randoms[1][1] + "  " + randoms[1][2] + "  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  " + randoms[2][0] + "  " + randoms[2][1] + "  " + randoms[2][2] + "  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 2 && quadrant.column == 3)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  " + randoms[0][1] + "  " + randoms[0][2] + "  " + randoms[0][3] + "  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  " + randoms[1][1] + "  " + randoms[1][2] + "  " + randoms[1][3] + "  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  " + randoms[2][1] + "  " + randoms[2][2] + "  " + randoms[2][3] + "  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 2 && quadrant.column == 4)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  " + randoms[0][2] + "  " + randoms[0][3] + "  " + randoms[0][4] + "  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  " + randoms[1][2] + "  " + randoms[1][3] + "  " + randoms[1][4] + "  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  " + randoms[2][2] + "  " + randoms[2][3] + "  " + randoms[2][4] + "  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 2 && quadrant.column == 5)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  " + randoms[0][3] + "  " + randoms[0][4] + "  " + randoms[0][5] + "  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  " + randoms[1][3] + "  " + randoms[1][4] + "  " + randoms[1][5] + "  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  " + randoms[2][3] + "  " + randoms[2][4] + "  " + randoms[2][5] + "  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 2 && quadrant.column == 6)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  " + randoms[0][4] + "  " + randoms[0][5] + "  " + randoms[0][6] + "  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  " + randoms[1][4] + "  " + randoms[1][5] + "  " + randoms[1][6] + "  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  " + randoms[2][4] + "  " + randoms[2][5] + "  " + randoms[2][6] + "  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 2 && quadrant.column == 7)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  " + randoms[0][5] + "  " + randoms[0][6] + "  " + randoms[0][7] + "  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  " + randoms[1][5] + "  " + randoms[1][6] + "  " + randoms[1][7] + "  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  " + randoms[2][5] + "  " + randoms[2][6] + "  " + randoms[2][7] + "  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 2 && quadrant.column == 8)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  " + randoms[0][6] + "  " + randoms[0][7] + "  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  " + randoms[1][6] + "  " + randoms[1][7] + "  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  " + randoms[2][6] + "  " + randoms[2][7] + "  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 3 && quadrant.column == 1)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  " + randoms[1][0] + "  " + randoms[1][1] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  " + randoms[2][0] + "  " + randoms[2][1] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  " + randoms[3][0] + "  " + randoms[3][1] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
            }

            if(quadrant.row == 3 && quadrant.column == 2)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  " + randoms[1][0] + "  " + randoms[1][1] + "  " + randoms[1][2] + "  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  " + randoms[2][0] + "  " + randoms[2][1] + "  " + randoms[2][2] + "  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  " + randoms[3][0] + "  " + randoms[3][1] + "  " + randoms[3][2] + "  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 3 && quadrant.column == 3)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  " + randoms[1][1] + "  " + randoms[1][2] + "  " + randoms[1][3] + "  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  " + randoms[2][1] + "  " + randoms[2][2] + "  " + randoms[2][3] + "  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  " + randoms[3][1] + "  " + randoms[3][2] + "  " + randoms[3][3] + "  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 3 && quadrant.column == 4)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  " + randoms[1][2] + "  " + randoms[1][3] + "  " + randoms[1][4] + "  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  " + randoms[2][2] + "  " + randoms[2][3] + "  " + randoms[2][4] + "  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  " + randoms[3][2] + "  " + randoms[3][3] + "  " + randoms[3][4] + "  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 3 && quadrant.column == 5)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  " + randoms[1][3] + "  " + randoms[1][4] + "  " + randoms[1][5] + "  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  " + randoms[2][3] + "  " + randoms[2][4] + "  " + randoms[2][5] + "  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  " + randoms[3][3] + "  " + randoms[3][4] + "  " + randoms[3][5] + "  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 3 && quadrant.column == 6)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  " + randoms[1][4] + "  " + randoms[1][5] + "  " + randoms[1][6] + "  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  " + randoms[2][4] + "  " + randoms[2][5] + "  " + randoms[2][6] + "  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  " + randoms[3][4] + "  " + randoms[3][5] + "  " + randoms[3][6] + "  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 3 && quadrant.column == 7)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  " + randoms[1][5] + "  " + randoms[1][6] + "  " + randoms[1][7] + "  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  " + randoms[2][5] + "  " + randoms[2][6] + "  " + randoms[2][7] + "  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  " + randoms[3][5] + "  " + randoms[3][6] + "  " + randoms[3][7] + "  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 3 && quadrant.column == 8)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  " + randoms[1][6] + "  " + randoms[1][7] + "  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  " + randoms[2][6] + "  " + randoms[2][7] + "  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  " + randoms[3][6] + "  " + randoms[3][7] + "  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 4 && quadrant.column == 1)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  " + randoms[0][1] + "  " + randoms[0][2] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  " + randoms[1][1] + "  " + randoms[1][2] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  " + randoms[2][1] + "  " + randoms[2][2] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 4 && quadrant.column == 2)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  " + randoms[0][1] + "  " + randoms[0][2] + "  " + randoms[0][3] + "  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  " + randoms[1][1] + "  " + randoms[1][2] + "  " + randoms[1][3] + "  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  " + randoms[2][1] + "  " + randoms[2][2] + "  " + randoms[2][3] + "  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 4 && quadrant.column == 3)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  " + randoms[0][2] + "  " + randoms[0][3] + "  " + randoms[0][4] + "  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  " + randoms[1][2] + "  " + randoms[1][3] + "  " + randoms[1][4] + "  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  " + randoms[2][2] + "  " + randoms[2][3] + "  " + randoms[2][4] + "  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 4 && quadrant.column == 4)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  " + randoms[0][3] + "  " + randoms[0][4] + "  " + randoms[0][5] + "  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  " + randoms[1][3] + "  " + randoms[1][4] + "  " + randoms[1][5] + "  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  " + randoms[2][3] + "  " + randoms[2][4] + "  " + randoms[2][5] + "  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 4 && quadrant.column == 5)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  " + randoms[0][3] + "  " + randoms[0][4] + "  " + randoms[0][5] + "  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  " + randoms[1][3] + "  " + randoms[1][4] + "  " + randoms[1][5] + "  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  " + randoms[2][3] + "  " + randoms[2][4] + "  " + randoms[2][5] + "  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 4 && quadrant.column == 6)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  " + randoms[0][0] + "  " + randoms[0][1] + "  " + randoms[0][2] + "  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  " + randoms[1][0] + "  " + randoms[1][1] + "  " + randoms[1][2] + "  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  " + randoms[2][0] + "  " + randoms[2][1] + "  " + randoms[2][2] + "  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 4 && quadrant.column == 7)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  " + randoms[0][2] + "  " + randoms[0][3] + "  " + randoms[0][4] + "  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  " + randoms[1][2] + "  " + randoms[1][3] + "  " + randoms[1][4] + "  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  " + randoms[2][2] + "  " + randoms[2][3] + "  " + randoms[2][4] + "  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 4 && quadrant.column == 8)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  " + randoms[0][3] + "  " + randoms[0][4] + "  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  " + randoms[1][3] + "  " + randoms[1][4] + "  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  " + randoms[2][3] + "  " + randoms[2][4] + "  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

            if(quadrant.row == 5 && quadrant.column == 1)
            {
                System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  " + randoms[1][1] + "  " + randoms[1][2] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  " + randoms[2][1] + "  " + randoms[2][2] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  " + randoms[3][1] + "  " + randoms[3][2] + "  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -"); 
            }

        }

        else
        {
            System.out.println("\n      1    2    3    4    5    6    7    8");
                System.out.println("    ----------------------------------------");
                System.out.println("  -");
                System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
                System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");  
        }
    }

    public void REST() {
        System.out.println("How long? ");
        Double period = scanner.nextDouble();
        quadrant.stardates -= period;
        System.out.println(quadrant.stardates + " stardates left.");
    }

    public void DOCK() {
        System.out.println("Roger that, the ship is docked");
        quadrant.condition = "DOCKED";
    }

    public void QUIT() {
        System.out.println("*************************************************");
        System.out.println("Do you want your score recorded? ");
        score_yes_or_no = scanner.nextLine();
        System.out.println("File name(9 characters maximum):");
        filename = scanner.nextLine();
        System.out.println("Can't freeze game as file " + filename + ".trk");
        System.out.println("Would you like to play again?");
        playagain = scanner.nextLine();
    }

    public void DAMAGES() {
        if(quadrant.damaged)
        {
                    System.out.println("Your ship is at " + (quadrant.StarshipHealth *10) +"% health");
        }
        else
        {
            System.out.println("Your ship is undamaged. Good job captain");
        }

    }

    public void REPORT() {

        // you are now playing a short novice game
        // push

        System.out.println("You are now playing a" + length + rank);
        // 0 of 3 Klingon ships have been destroyed. ldldldl
        if (klingon.health == 0) {
            System.out.println("1 out of 1 Klingon ships has been destroyed");
        } else {
            System.out.println("0 out of 1 Klingon ships have been destroyed");
        }
        // There are 4 bases.
        System.out.println("You have " + quadrant.starbases + " starbases");
        // You have 4 deep space probes.


        if(klingon.row < (quadrant.row + 1) && klingon.row > (quadrant.row - 1)
                && klingon.column < (quadrant.row + 1) && klingon.column > (quadrant.row - 1))
                {
                    System.out.println("Klingons have spotted you! You are under enemy fire");
                    System.out.println("You have taken damage");
                    quadrant.StarshipHealth--;
                    quadrant.damaged = true;
                    if (quadrant.StarshipHealth < 7 && quadrant.StarshipHealth> 5) {
                        quadrant.condition = "Yellow";   
                    }
                    else if(quadrant.StarshipHealth <= 5){
                        quadrant.condition = "Red";

                    }
                    if(quadrant.StarshipHealth <=0)
                    {
                        System.out.println("Your ship has been destroyed!");
 System.out.println("*************************************************");
        System.out.println("Do you want your score recorded? ");
        score_yes_or_no = scanner.nextLine();
        System.out.println("File name(9 characters maximum):");
        filename = scanner.nextLine();
        System.out.println("Can't freeze game as file " + filename + ".trk");
        System.out.println("Would you like to play again?");
        playagain = scanner.nextLine();;
                    }
                }
    }

    public void SENSORS() {
        System.out.println("Sensor scan for Quadrant " + quadrant.row + " - " + quadrant.column + "-\n");
        System.out.println("Planet at Sector 4 - 5 is of class M.");
        System.out.println("Readings indicate dilithium crystals present.");
    }

    public void ORBIT() {
        if(quadrant.orbitting == false)
        {
            System.out.println("Now orbiting planet " + '"' + "Purple." + '"'); 
            quadrant.orbitting = true;
        }
        
        else
        {
            System.out.println("Exiting orbit..."); 
            quadrant.orbitting = false;
        }
    }

    public void TRANSPORT() {
        if(quadrant.orbitting && !quadrant.transported)
        {
            System.out.println("Transporting to ground...");
            quadrant.transported = true;
        }

        else if(quadrant.transported)
        {
            System.out.println("Transporting to ship...");
            quadrant.transported = false;
        }

    }

    public void MINE() {
        if(quadrant.transported)
            System.out.println(rand.nextInt(0, 100) + " crystals found, returning to ship.");
    }

    public void CRYSTALS() {
        if(quadrant.crystals == 0)
            System.out.println("No dilithium crystals available.");
        else
            System.out.println(quadrant.crystals + "dilithium crystals available.");
    }

    public void SHUTTLE() {
        if(quadrant.orbitting == true)
            System.out.println("Shuttle taken to planet.");
    }

    public void PLANETS() {
        System.out.println("No information available");
    }

    public void REQUEST() {

        System.out.println("Information desired? ");
        request = scanner.next();
        if (request.equals("date")) {
            // int stardate = getSecondsRemaining();
            // System.out.println(stardate);

        } else if (request.equals("Condition")) {
            System.out.println("Condition:    "+ quadrant.condition);
        } else if (request.equals("Position")) {
            System.out.println(" Position is (" + quadrant.row + "," + quadrant.column + ")");
        } else if (request.equals("Life Support ACTIVE")) {
            System.out.println("Life Support ACTIVE    ACTIVE");
        } else if (request.equals("Warp Factor")) {
            System.out.println("Warp Factor = ");
        } else if (request.equals("Energy")) {
        } else if (request.equals("Torpedoes")) {
            System.out.println("You have " + quadrant.torp + " torpedoes left.");
        } else if (request.equals("Shields")) {

        } else if (request.equals("Klingons")) {
            System.out.println("Klingon Position is (" + klingon.row + "," + klingon.column + ")");
        } else if (request.equals("Time")) {

        } else {
            System.out.println(
                    "UNRECOGNIZED REQUEST. Legal requests are: date, condition, position, lsupport, warpfactor, energy, torpedoes, shields, klingons, time.");
        }


        if(klingon.row < (quadrant.row + 1) && klingon.row > (quadrant.row - 1)
                && klingon.column < (quadrant.row + 1) && klingon.column > (quadrant.row - 1))
                {
                    System.out.println("Klingons have spotted you! You are under enemy fire");
                    System.out.println("You have taken damage");
                    quadrant.StarshipHealth--;
                    quadrant.damaged = true;
                    if (quadrant.StarshipHealth < 7 && quadrant.StarshipHealth> 5) {
                        quadrant.condition = "Yellow";   
                    }
                    else if(quadrant.StarshipHealth <= 5){
                        quadrant.condition = "Red";

                    }
                    if(quadrant.StarshipHealth <=0)
                    {
                        System.out.println("Your ship has been destroyed!");
                        System.out.println("*************************************************");
                        System.out.println("Do you want your score recorded? ");
                        score_yes_or_no = scanner.nextLine();
                        System.out.println("File name(9 characters maximum):");
                        filename = scanner.nextLine();
                        System.out.println("Can't freeze game as file " + filename + ".trk");
                        System.out.println("Would you like to play again?");
                        playagain = scanner.nextLine();;
                    }
                }

    }

    public void DEATHRAY() {
        if (klingon.row == quadrant.row && klingon.column == quadrant.column) // if klingon in same quadrant
        {
            klingon.health = 0;
            System.out.println(
                    "Spock- Captain, the 'Experimental Death Ray is highly unpredictable.  Considering the alternatives, are you sure this is wise?");
            String yes_or_no_deathray = scanner.nextLine();
            if (yes_or_no_deathray == "yes") {
                System.out.println("Spock-acknowledged. WHOOEE....WHOEEE....WHOEEEE");
                System.out.println(
                        "Crew scrambles in emergency preperation. Spock and Scotty ready the deathray and prepare to channel all ships power to device");
                System.out
                        .println("Kirk- Engage! WHIRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
            }

            else
                return;
        }

        else
            System.out.println("But Sir, there are no enemies in this quadrant.");
                
            
            
            if(klingon.row < (quadrant.row + 1) && klingon.row > (quadrant.row - 1)
                && klingon.column < (quadrant.row + 1) && klingon.column > (quadrant.row - 1))
                {
                    System.out.println("Klingons have spotted you! You are under enemy fire");
                    System.out.println("You have taken damage");
                    quadrant.StarshipHealth--;
                    quadrant.damaged = true;
                    if (quadrant.StarshipHealth < 7 && quadrant.StarshipHealth> 5) {
                        quadrant.condition = "Yellow";   
                    }
                    else if(quadrant.StarshipHealth <= 5){
                        quadrant.condition = "Red";

                    }
                    if(quadrant.StarshipHealth <=0)
                    {
                        System.out.println("Your ship has been destroyed!");
 System.out.println("*************************************************");
        System.out.println("Do you want your score recorded? ");
        score_yes_or_no = scanner.nextLine();
        System.out.println("File name(9 characters maximum):");
        filename = scanner.nextLine();
        System.out.println("Can't freeze game as file " + filename + ".trk");
        System.out.println("Would you like to play again?");
        playagain = scanner.nextLine();;
                    }
                }
        }

    public void FREEZE() {
        System.out.printf("File name(9 characters maximum): ");
        filename = scanner.nextLine();
    }

    public void COMPUTER() {
        System.out.println("Destination quadrant and/or sector? ");
        System.out.println("Time or arrival date?");
        System.out.println("Remaining energy will be " + rand.nextDouble(1000.00, 4000.00) + ".");
        System.out.println("Minimum warp needed is " + rand.nextDouble(1, 5));
        System.out.println("and we will arrive at stardate " + rand.nextDouble(1000.00, 4000.00));
    }

    public void EMEXIT()
    {
        System.out.println("There's no emergency, just close command prompt bozo");
    }

    public void PROBE() {
        System.out.println(quadrant.probes + "probes left.");
        System.out.println("Are you sure you want to fire a probe? ");
        String wish = scanner.nextLine();
        
        if(wish == "yes")
        {
            System.out.println("The deep space probe is launched.");
        }
    }

    public void COMMANDS() {
        System.out.println("    SRSCAN     MOVE       PHASERS    CALL");
        System.out.println("    STATUS     IMPULSE    PHOTONS    ABANDON");
        System.out.println("    LRSCAN     WARP       SHIELDS    DESTRUCT");
        System.out.println("    CHART      REST       DOCK       QUIT");
        System.out.println("    DAMAGES    REPORT     SENSORS    ORBIT");
        System.out.println("    TRANSPORT  MINE       CRYSTALS   SHUTTLE");
        System.out.println("    PLANETS    REQUEST    DEATHRAY   FREEZE");
        System.out.println("    COMPUTER   EMEXIT     PROBE      COMMANDS");
        System.out.println("    SCORE      CLOAK      CAPTURE    HELP");
        System.out.println();
    }

    public void SCORE() {
        System.out.println("TOTAL SCORE: 0");
    }

    public void CLOAK() {
        System.out.println("Switch cloaking device on? ");

        String wish = scanner.nextLine();

        if(wish == "yes")
            System.out.println("The cloaking device has been engaged, Sir.");
    }

    public void CAPTURE() {
        System.out.println("We have no subspace radio communication, Sir.");
    }

    public void HELP() {
        System.out.println("No, figure it out yourself");
    }
}

class Quadrant {
    int row = 1;
    int column = 1;
    int klingons = 1;
    int starbases;
    int stars;
    int torp = 10;
    int StarshipHealth = 10;
    int crystals = 0;
    int probes = 3;

    Double stardates = 5.0;
    Double stardate = 4003.3;
    Double shieldUnits = 2500.0;
    Double warpFactor = 1.0;

    boolean damaged=false;
    boolean orbitting = false;
    boolean transported = false;
    boolean scanned = false;

    String condition = "Green";
    String shields = "DOWN";
}

class Klingon {
    int row = 7;
    int column = 5;
    int health = 20;
}

class Sector {
    int row;
    int column;
}
