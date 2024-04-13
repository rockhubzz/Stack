package stack;

import java.util.Scanner;

public class stackMain {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int key=0;
        System.out.print("Enter element count: ");
        int elm= sc.nextInt();
        Stack num= new Stack(elm);
        while(true){
            System.out.println("\nStack: ");
            num.print();
            System.out.println("Options: ");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Clear");
            System.out.println("5. Full?");
            System.out.println("6. Empty?");
            System.out.println("7. Calculate");
            System.out.println("8. Find number");
            System.out.println("9. Quit");
            System.out.print("Enter option: ");
            int menu= sc.nextInt();

            switch (menu) {
                case 1:
                if(!num.isFull()){
                    for(int i=num.top; i<num.data.length; i++){
                        if(i>=0){
                            num.print();
                        }
                        System.out.print("Enter number to push: ");
                        String toPush= sc.next();
                        if(toPush.equalsIgnoreCase("stop")) break;
                        else num.push(Integer.valueOf(toPush));
                        if(num.isFull()){
                            num.print();
                            System.out.println("\n==================");
                            System.out.println("The stack is full.");
                            System.out.println("==================");
                            System.out.println("Press ENTER to return to menu.");
                            sc.nextLine();
                            sc.nextLine();
                            break;
                        }
                    }
                }else{
                    System.out.println("\n==================");
                    System.out.println("The stack is full.");
                    System.out.println("==================");
                    System.out.println("Press ENTER to return to menu.");
                    sc.nextLine();
                    sc.nextLine();

                }
                break;
                    
                case 2:
                    if(!num.isEmpty()){
                        int popped= num.pop();
                        System.out.println("\n=========================");
                        System.out.println("Popped value: "+popped);
                        System.out.println("=========================");
                    }else{
                        System.out.println("\n===================");
                        System.out.println("The stack is empty.");
                        System.out.println("===================");
            
                    }
                    System.out.println("Press ENTER to return to menu.");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 3:
                if(!num.isEmpty()){
                    System.out.println("\n=========================");
                    System.out.print("Peek at top value: ");
                    num.peek();
                    System.out.println("=========================");
                }else{
                    System.out.println("\n===================");
                    System.out.println("The stack is empty.");
                    System.out.println("===================");
                }
                    System.out.println("Press ENTER to return to menu.");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 4:
                    num.clear();
                    System.out.println("\n=======================");
                    System.out.println("Stack has been cleared.");
                    System.out.println("=======================");
                    System.out.println("Press ENTER to return to menu.");
                    sc.nextLine();
                    sc.nextLine();
            
                    break;
                case 5:
                    if(num.isFull()){
                        System.out.println("\n==================");
                        System.out.println("The stack is full.");
                        System.out.println("==================");
                    }else{
                        System.out.println("\n==========================");
                        System.out.println("The stack is not full yet.");
                        System.out.println("==========================");
                    }
                    System.out.println("Press ENTER to return to menu.");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 6:
                    if(num.isEmpty()){
                        System.out.println("\n==================");
                        System.out.println("The stack is empty.");
                        System.out.println("==================");
                    }else{
                        System.out.println("\n==========================");
                        System.out.println("The stack is not empty.");
                        System.out.println("==========================");
                    }
                    System.out.println("Press ENTER to return to menu.");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 7:
                    num.calculate();
                    System.out.println("Press ENTER to return to menu.");
                    sc.nextLine();
                    sc.nextLine();
                    break;
                case 8:
                if(!num.isEmpty()){

                    System.out.print("\nEnter number to find in stack: ");
                    key= sc.nextInt();
                    num.findNums(key);
                }else{
                    System.out.println("\n==================");
                    System.out.println("The stack is empty.");
                    System.out.println("==================");
                    
                }
                System.out.println("Press ENTER to return to menu.");
                sc.nextLine();
                sc.nextLine();
                break;
                case 9:
                    System.exit(0);
                    
                default:
                    System.out.println("\n==========================");
                    System.out.println("Entered option is invalid.");
                    System.out.println("==========================");
                    System.out.println("Press ENTER to return to menu.");
                    sc.nextLine();
                    sc.nextLine();
                    break;
            }
        }
    }
}
