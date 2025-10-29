import java.util.Scanner;


public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String askForMove(int rows, int cols) {
        String move;
        while (true) {
            System.out.print("Vilken ruta vill du undersöka? (ex: b2) ");
            move = scanner.nextLine().toLowerCase().trim();
            if (validateInput(move, rows, cols)) break;
            System.out.println("Felaktig input. Skriv en bokstav följt av en siffra, t.ex. b2.");
        }
        return move;
    }

    public static boolean validateInput(String move, int rows, int cols) {
        if (move.length() != 2) return false;
        char row = move.charAt(0);
        char col = move.charAt(1);
        if (row < 'a' || row >= 'a' + rows) return false;
        if (!Character.isDigit(col)) return false;
        int colIndex = Character.getNumericValue(col);
        return colIndex >= 1 && colIndex <= cols;
    }
}
