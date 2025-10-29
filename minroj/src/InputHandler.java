import java.util.Scanner;

public class InputHandler {


        private static Scanner scanner = new Scanner(System.in);

        public static String askForMove() {
            System.out.print("Vilken ruta vill du undersöka? ");
            return scanner.nextLine().toLowerCase();
        }



}
