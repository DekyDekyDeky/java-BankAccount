import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String clientName = "Luquitas";
        String accountType = "Checking account";

        double clientBalance = 2500;
        double receivedValue = 0;
        double transferedValue = 0;

        String info = """
                    ***********************
                    Initial client info
                    
                    Name: %s
                    Account Type: %s
                    Balance: %.2f
                    ***********************
                 """.formatted(clientName, accountType, clientBalance);

        String menu = """
                      
                      Operations
                      
                      1- Check balance
                      2- Receive value
                      3- Transfer value
                      4- Exit
                      
                      Write the desired option...
                      
                """;

        System.out.println(info);
        System.out.println(menu);

        //Ler os inputs
        Scanner reading = new Scanner(System.in);
        int valueDesired = reading.nextInt();
        Scanner enter = new Scanner(System.in);


        while (valueDesired != 4){
            switch (valueDesired) {
                case 1:
                    System.out.println("Your balance is: " + clientBalance);
                    enter.nextLine();
                    break;
                case 2:
                    System.out.println("Input the received value: \n");
                    receivedValue = reading.nextDouble();
                    clientBalance += receivedValue;
                    System.out.println("\nYour new balance is: " + clientBalance);
                    receivedValue = 0;
                    enter.nextLine();
                    break;
                case 3:
                    System.out.println("Input the transfered value: ");
                    transferedValue = reading.nextDouble();
                    if (transferedValue > clientBalance){
                        System.out.println("insufficient fund, invalid operation");
                        System.out.println("Press \"Enter\" to continue...");
                        enter.nextLine();
                        break;
                    }else{
                        clientBalance -= transferedValue;
                        System.out.println("Your new balance is: " + clientBalance);
                        enter.nextLine();
                    }
                    transferedValue = 0;
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Error, invalid value!");
                    System.out.println("Press \"Enter\" to continue...");
                    enter.nextLine();
            }

            System.out.println(menu);
            valueDesired = reading.nextInt();
        }
    }
}