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

        // if(damaged)
        // {
        // System.out.println("Short Range Sensors Damaged!")
        // }
        // else
        // {
        if (quadrant.row == 1 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 3 "); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 1 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 1, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }

        if (quadrant.row == 2 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 2 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 2, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }

        if (quadrant.row == 3 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 3, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 3, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 3, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 3, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 3, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 3, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 3, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 3 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 3, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }

        if (quadrant.row == 4 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 4 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 4, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }

        if (quadrant.row == 5 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 5 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 5, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }

        if (quadrant.row == 6 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 6 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 6, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }

        if (quadrant.row == 7 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 7 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 7, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }

        if (quadrant.row == 8 && quadrant.column == 1) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 1"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 2) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 2"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 3) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 3"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 4) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 4"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 5) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 5"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 6) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 6"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 7) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 7"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
        }
        if (quadrant.row == 8 && quadrant.column == 8) {
            System.out.println("    1 2 3 4 5 6 7 8 9 10");
            System.out.println("  1 * * * * * * * * * *   Stardate: ");// + Stardate
            System.out.println("  2 * * * * * * * * * *   Condition: "); // + condition
            System.out.println("  3 * * * * * * * * * *   Position: 8, 8"); // plus position (x,y a,b)
            System.out.println("  4 * * * * * * * * * *   Life Support "); // + Life support
            System.out.println("  5 * * * * * * * * * *   Warp Factor: "); // + Warp factor
            System.out.println("  6 * * * * * * * * * *   Energy: "); // + Energy
            System.out.println("  7 * * * * * * * * * *   Torpedoes: "); // + Torpedoes
            System.out.println("  8 * * * * * * * * * *   Shields: "); // + Shields
            System.out.println("  9 * * * * * * * * * *   Klingons Left: "); // + Klingons Left
            System.out.println(" 10 * * * * * * * * * *   Time Left: "); // + Time left
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
          
        else if(manual_or_auto.equals("Automatic")){
            System.out.println("Destination Quadrant");
            int xpos = scanner.nextInt();
            int ypos = scanner.nextInt();
            if(xpos > 8 || xpos < 1 || ypos < 1 || ypos > 8)
            {
                System.out.println("Invalid argument");
            }
          
            else
            {
                quadrant.row = xpos;
                quadrant.column = ypos;
                System.out.println("New Position is (" + quadrant.row + "," + quadrant.column + ")");
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
    }

    public void CALL() {
    }

    public void STATUS() {
    }

    public void IMPULSE() {
    }

    public void PHOTONS() {
    }

    public void ABANDON() {
    }

    public void LRSCAN() {
        System.out.println(quadrant.row);
        System.out.println(quadrant.column);
        System.out.println("Long-range scan for Quadrant 4 - 7");
        System.out.println(String.format("%5d%5d%5d", randoms[0][0], randoms[1][0], randoms[2][0]));
        System.out.println(String.format("%5d%5d%5d", randoms[3][0], randoms[4][0], randoms[5][0]));
        System.out.println(String.format("%5d%5d%5d", randoms[6][0], randoms[7][0], randoms[0][1]));
        System.out.println();
    }

    public void WARP() {
    }

    public void SHIELDS() {
    }

    public void DESTRUCT() {
    }

    public void CHART() {
        System.out.println("\n      1    2    3    4    5    6    7    8");
        System.out.println("    ----------------------------------------");
        System.out.println("  -");
        System.out.println("1 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
        System.out.println("2 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
        System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
        System.out.println("3 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
        System.out.println("4 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
        System.out.println("5 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
        System.out.println("6 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
        System.out.println("7 -  ...  ...  ...  ...  ...  ...  ...  ...  -");
        System.out.println("8 -  ...  ...  ...  ...  ...  ...  ...  ...  -");

        // System.out.println("\nEnterprise is currently in Quadrant " + ___ + " - " +
        // ___ +);
    }

    public void REST() {
    }

    public void DOCK() {
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
    }

    public void REPORT() {
    }

    public void SENSORS() {
    }

    public void ORBIT() {
    }

    public void TRANSPORT() {
    }

    public void MINE() {
    }

    public void CRYSTALS() {
    }

    public void SHUTTLE() {
    }

    public void PLANETS() {
    }

    public void REQUEST() {

        System.out.println("Information desired? ");
        request = scanner.nextLine();
        if (request == "date") {
            // int stardate = getSecondsRemaining();
            // System.out.println(stardate);

        } else if (request == "condition") {
            System.out.println("Condition:    GREEN");
        } else if (request == "position") {
            System.out.println(" Position is (" + quadrant.row + "," + quadrant.column + ")");
        } else if (request == "lsupport") {
            System.out.println("Life support    ACTIVE");
        } else if (request == "warpfactor") {
            System.out.println("Warp Factor = ");
        } else if (request == "energy") {
        } else if (request == "torpedoes") {
        } else if (request == "shields") {

        } else if (request == "klingons") {
        } else if (request == "time") {

        } else {
            System.out.println(
                    "UNRECOGNIZED REQUEST. Legal requests are: date, condition, position, lsupport, warpfactor, energy, torpedoes, shields, klingons, time.");
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
    }

    public void FREEZE() {
        System.out.printf("File name(9 characters maximum): ");
        filename = scanner.nextLine();
    }

    public void COMPUTER() {
    }

    public void EMEXIT() {
    }

    public void PROBE() {
    }

    public void COMMANDS() {
        System.out.println("    SRSCAN     MOVE     PHASERS    CALL");
        System.out.println("    STATUS     IMPULSE  PHOTONS    ABANDON");
        System.out.println("    LRSCAN     WARP     SHIELDS    DESTRUCT");
        System.out.println("    CHART      REST     DOCK       QUIT");
        System.out.println("    DAMAGES    REPORT   SENSORS    ORBIT");
        System.out.println("    TRANSPORT  MINE     CRYSTALS   SHUTTLE");
        System.out.println("    PLANETS    REQUEST  DEATHRAY   FREEZE");
        System.out.println("    COMPUTER   EMEXIT   PROBE      COMMANDS");
        System.out.println("    SCORE      CLOAK    CAPTURE    HELP");
        System.out.println();
    }

    public void SCORE() {
    }

    public void CLOAK() {
    }

    public void CAPTURE() {
    }

    public void HELP() {
    }
}

class Quadrant {
    int row = 1;
    int column = 1;

    int klingons = 1;
    int starbases;
    int stars;
}

class Klingon {
    int row;
    int column;
    int health = 20;
}

class Sector {
    int row;
    int column;
}

// Natalie was here as well on line 1326;