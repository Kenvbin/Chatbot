import java.util.Scanner;

class Chatbot {
  public static void main(String[] args) {
    try (Scanner reader = new Scanner(System.in)) {
      System.out.printf("   _____ _           _   ____   ____ _______ \n  / ____| |         | | |  _ \\ / __ \\__   __|\n | |    | |__   __ _| |_| |_) | |  | | | |   \n | |    | '_ \\ / _` | __|  _ <| |  | | | |   \n | |____| | | | (_| | |_| |_) | |__| | | |   \n  \\_____|_| |_|\\__,_|\\__|____/ \\____/  |_|   \n\n\n");
          
      while (true) {
          System.out.print("YOU: ");
          String input = reader.nextLine();
          System.out.println("ChatBOT: "+ ChatBotClass.respondToKeyword(input));
          System.out.println("");

      }
    }
  }
}