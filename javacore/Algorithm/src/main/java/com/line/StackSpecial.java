package com.line;

import java.util.Scanner;

class MyStack {
    private int size;
    private int[][] arrInt;
    private int branch;
    private int currentAction;

    public MyStack(int lSize, int lBranch){
        this.size = lSize + 1;
        currentAction = 0;
        this.branch = lBranch + 1;
        arrInt = new int[branch][size];
        arrInt[0][0] = 0;
    }

    public void push(int value) {
        if(arrInt[currentAction][0] < size) {
            arrInt[currentAction][0]++;
            int index = arrInt[currentAction][0];
            arrInt[currentAction][index] = value;
        }
    }

    public int top(int k) {
        int index = arrInt[currentAction][0];

        if(k >= index || k < 0)
            return 0;

        return arrInt[currentAction][index - k];
    }

    public void pop(int k) {
        if(k <= 0) return;
        if(k >= arrInt[currentAction][0]) {
            arrInt[currentAction][0] = 0;
        }
        else {
            arrInt[currentAction][0] -= k;
        }
    }

    public void newBranch(){
        //copy current state to new branch
        if(currentAction < branch) {
            for(int i = 0; i <= arrInt[currentAction][0]; i++) {
                arrInt[currentAction+1][i] = arrInt[currentAction][i];
            }
            currentAction++;
        }
    }

    public boolean commit() {
        //copy current state to previous branch
        if(currentAction < 1)
            return false;

        for(int i = 0; i <= arrInt[currentAction][0]; i++) {
            arrInt[currentAction-1][i] = arrInt[currentAction][i];
        }
        currentAction--;
        return true;
    }

    public boolean rollback() {
        if(currentAction < 1)
            return false;

        currentAction--;

        return true;
    }
}

public class StackSpecial {
    public static void main(String[] args) {
        final String BEGIN = "begin";
        final String ROLLBACK = "rollback";
        final String COMMIT = "commit";
        final String PUSH = "push";

        //System.out.println("input n: ");
        try {
            Scanner scanner = new Scanner(System.in);
            String numberStr = scanner.nextLine();
            int n = Integer.parseInt(numberStr);
            String[] arrInput = new String[n];

            //check input
            int maxBeginCount = 0;
            int currentBeginCount = 0;
            int pushCount = 0;

            for(int i = 0; i < n; i++) {
                String command = scanner.nextLine();
                arrInput[i] = command;
                if(command.contains(BEGIN)) {
                    currentBeginCount++;
                    if(maxBeginCount < currentBeginCount) {
                        maxBeginCount = currentBeginCount;
                    }
                }
                else if(command.contains(ROLLBACK) || command.contains(COMMIT)) {
                    if(currentBeginCount > 0) {
                        currentBeginCount--;
                    }
                }
                else if(command.contains(PUSH)) {
                    pushCount++;
                }
            }
            scanner.close();

            MyStack myStack = new MyStack(pushCount, maxBeginCount);
//        System.out.println("Mystack with: branch " +maxBeginCount + ", size " + pushCount);
            //end check input

//        MyStack myStack = new MyStack(n);
//        System.out.println("value n: " + n);
            for(int i = 0; i < n; i++) {
                String command = arrInput[i];
                String[] arrCommand = command.split(" ");
                if(arrCommand.length > 1) {
//                System.out.println("string: " + arrCommand[0] + " , number: " + arrCommand[1]);
                    int value = Integer.parseInt(arrCommand[1]);

                    switch (arrCommand[0]) {
                        case "push": {
                            myStack.push(value);
                            break;
                        }
                        case "pop": {
                            myStack.pop(value);
                            break;
                        }
                        case "top": {
                            int result = myStack.top(value);
                            System.out.println(result);
                            break;
                        }
                        default:
                            break;
                    }

                }
                else if(arrCommand.length == 1){
//                System.out.println("string: " + arrCommand[0]);
                    switch (arrCommand[0]) {
                        case "begin" : {
                            myStack.newBranch();
                            break;
                        }

                        case "rollback" : {
                            boolean result = myStack.rollback();
                            System.out.println(result);
                            break;
                        }

                        case "commit" : {
                            boolean result = myStack.commit();
                            System.out.println(result);
                            break;
                        }
                        default:
                            break;
                    }
                }
            }
        }
        catch (Exception ex) {

        }
    }
}
