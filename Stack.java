package stack;

import java.util.Scanner;


public class Stack {
    int data[];
    int top= -1;
    
    public Stack(int capacity){
        data= new int[capacity];
    }
    
    public void push(int toPush){
        if(!isFull()){
            top++;
            data[top]= toPush;
        }
    }
    
    public int pop(){
        int toPop= data[top];
        top--;
        return toPop;
    }
    
    public void peek(){
        if(top!=-1)
        System.out.println(data[top]);
    }
    
    public void clear(){
        if(!isEmpty()){
            for(int i=top; i>=0; i--){
                top--;
            }
        }
    }
    
    public boolean isFull(){
        if(top==data.length-1){
            return true;
        }
        return false;
    }
    
    public boolean isEmpty(){
        if(top>=0){
            return false;
        }
        return true;
    }
    
    public void print(){
        System.out.println("---------");
        for(int i=data.length-1; i>=0; i--){
            System.out.print("|");
            if(i<=top)
            System.out.print(" "+data[i]);
            System.out.println("\t|");
        }
        System.out.print("---------");
        System.out.println();
    }
    
    public void PrintWithIndex(){
        if(top!=-1){
            System.out.println("\t---------");
            for(int i=data.length-1; i>=0; i--){
                if(i<=top){
                    System.out.print(i+".\t|");
                    System.out.print(" "+data[i]);
                    System.out.println("\t|");
                }
            }
            System.out.print("\t---------");
            System.out.println();
        }
    }

    public void PrintAfterFind(int idx[]) {
        if (idx == null || idx.length == 0) {
          System.out.println("\n==============");
          System.out.println("Stack is empty.");
          System.out.println("==============");
          return;
        }

        System.out.println("---------");
        for (int i = data.length - 1; i >= 0; i--) {
          System.out.print("|");
          if (i <= top) {
            System.out.print(" " + data[i]);
          }
          System.out.print("\t|");
          for (int j = 0; j < idx.length; j++) {
            if (i==idx[j] && j>=0 && idx[j]>=1) {
                System.out.print(" <= Found data");
            }else if(i == idx[j] && j==0 && idx[j]==0){
                System.out.print(" <= Found data");
            }
          }
          System.out.println();
        }
        System.out.print("---------");
        System.out.println();
      }
      

    public void calculate(){
        int result=0, num1=0, num2=0;
        Scanner sc= new Scanner(System.in);
        System.out.println("\nWhere data?");
        System.out.println("1. From existing data in stack");
        System.out.println("2. Enter new data");
        System.out.print("Enter option: ");
        int whereData= sc.nextInt();

        switch (whereData) {
            case 1:
            if(!isEmpty()){
                print();
                System.out.print("\nEnter number1 to calculate: ");
                num1= sc.nextInt();
                System.out.print("Enter number2 to calculate: ");
                num2= sc.nextInt();
            }else{
                System.out.println("\n===================");
                System.out.println("The stack is empty.");
                System.out.println("===================");
                return;    
            }
                break;
            case 2:
            System.out.print("Enter number1 to calculate: ");
            num1= sc.nextInt();
            System.out.print("Enter number2 to calculate: ");
            num2= sc.nextInt();
            default:
                break;
        }
        
        System.out.println("\nWhat operation?");
        System.out.println("1. Add");
        System.out.println("2. Substract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.print("Enter option: ");
        int op= sc.nextInt();

        switch (op) {
            case 1:
                if(whereData==1)
                    result= data[findNum(num1)]+data[findNum(num2)];
                else if(whereData==2)
                    result= num1+num2;
            break;
            case 2:
                if(whereData==1)
                    result= data[findNum(num1)]-data[findNum(num2)];
                else if(whereData==2)
                    result= num1-num2;
            break;
            case 3:
                if(whereData==1)
                    result= data[findNum(num1)]*data[findNum(num2)];
                else if(whereData==2)
                    result= num1*num2;
            break;
            case 4:
                if(whereData==1)
                    result= data[findNum(num1)]/data[findNum(num2)];
                else if(whereData==2)
                    result= num1/num2;
            break;
        
            default:
                break;
        }

        if(whereData==1){
            System.out.println("\nWhere to put result?");
            System.out.println("1. Replace "+num1);
            System.out.println("2. Replace "+num2);
            System.out.println("3. Push to top");
            System.out.print("Enter option: ");
            int place= sc.nextInt();
    
            switch (place) {
                case 1:
                    data[findNum(num1)]= result;
                    System.out.println("\n============================");
                    System.out.println("Number has been calculated.");
                    System.out.println("============================");
                    break;
                case 2:
                    data[findNum(num2)]= result;
                    System.out.println("\n============================");
                    System.out.println("Number has been calculated.");
                    System.out.println("============================");
                    break;
                case 3:
                    if(isFull()){
                        System.out.println("\n==================");
                        System.out.println("The stack is full.");
                        System.out.println("==================");
                    }else{
                        push(result);
                        System.out.println("\n============================");
                        System.out.println("Number has been calculated.");
                        System.out.println("============================");
                    }
                break;
                default:
                    break;
            }
        }else if(whereData==2){
            push(result);
            System.out.println("\n=================================================");
            System.out.println("Result of calculation has been pushed to the top.");
            System.out.println("=================================================");
        }
        return;
    }

    public void findNums(int key){
        int results[]= new int[data.length];
        int idx=0;
        boolean isThere= false;
        for(int i=0; i<=top; i++){
            if(key==data[i]){
                results[idx]=i;
                idx++;
                isThere=true;
            }
        }
        if(!isThere){
            System.out.println("\n==============");
            System.out.println("Key not found.");
            System.out.println("==============");
        }else{
            PrintAfterFind(results);
        }
        return;
    }

    public int findNum(int key){
        for(int i=0; i<data.length; i++){
            if(data[i]==key){
                return i;
            }
        }
        return -1;
    }
}
