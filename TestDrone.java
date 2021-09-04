//Author Name:  Caleb Beck
//Date:  8/25/21
//Program Name:  drone_beck
//Purpose:  Simulate the interface for controlling the movement of a drone.
import java.util.Scanner;

public class TestDrone{
    public static void main(String[] args) {
        Drone testDrone = new Drone();
        Scanner userInput = new Scanner(System.in);
        int userChoice = 0;

        while (userChoice != 8){
            testDrone.printMenu();
            userChoice =  userInput.nextInt();


            if (userChoice == 1) {
                testDrone.moveUp();
            } else if (userChoice == 2) {
                testDrone.moveDown();
            } else if (userChoice == 3) {
                testDrone.moveForward();
            } else if (userChoice == 4) {
                testDrone.moveBackward();
            } else if (userChoice == 5){
                testDrone.turnLeft();
            } else if (userChoice == 6) {
                testDrone.turnRight();
            } else if (userChoice == 7) {
                testDrone.printCurrentPosition();
            } else {
                System.out.println("Exiting");
            }
        }
        userInput.close();
    }
}
class Drone {
    private int posX, posY, posZ = 0;
    private String direction = "North";

    public void printMenu(){
        System.out.println("1 - Move Up");
        System.out.println("2 - Move Down");
        System.out.println("3 - Move Forward");
        System.out.println("4 - Move Backward");
        System.out.println("5 - Turn Left");
        System.out.println("6 - Turn Right");
        System.out.println("7 - Display Position");
        System.out.println("8 - Exit Navigation");    
    }

    //Assuming Up/Down is the Z axis, N/S is the Y axis, and E/W is the X axis.

    public void turnLeft(){
        if (this.direction == "North"){
            this.direction = "West";
        } else if (this.direction == "East") {
            this.direction = "North";
        } else if (this.direction == "South") {
            this.direction = "East";
        } else if (this.direction == "West") {
            this.direction = "South";
        }
    }

    public void turnRight(){
        if (this.direction == "North") {
            this.direction = "East";
        } else if (this.direction == "East") {
            this.direction = "South";
        } else if (this.direction == "South") {
            this.direction = "West";
        } else if (this.direction == "West"){
            this.direction = "North";
        }
    }

    //Because the drone's orienation does not matter for the vertical axis, just adjust the value of Z.
    public void moveUp(){
        this.posZ = this.posZ + 1;
    }

    public void moveDown(){
        this.posZ = this.posZ - 1;
    }

    public void moveForward(){
        if (this.direction == "North") {
            this.posY = this.posY + 1;
        } else if (this.direction == "East") {
            this.posX = this.posX + 1;
        } else if (this.direction == "South") {
            this.posY = this.posY - 1;
        } else if (this.direction == "West") {
            this.posX = this.posX - 1;
        }
    }

    public void moveBackward(){
        if (this.direction == "North") {
            this.posY = this.posY - 1;
        } else if (this.direction == "East") {
            this.posX = this.posX - 1;
        } else if (this.direction == "South") {
            this.posY = this.posY + 1;
        } else if (this.direction == "West") {
            this.posX = this.posX + 1;
        }   
    }

    public void printCurrentPosition() {
        System.out.println("X_Pos = " + this.posX + ", Y_Pos = " + this.posY + ", Z_Pos = " + this.posZ + ", direction = " + this.direction);
    }
}