package searchstudents;

import java.util.HashMap;
import java.util.Scanner;

public class MainThread {
    public static Scanner scanner = new Scanner(System.in);
    public static Students students;
    public static HashMap<String, Students> mapStudent = new HashMap<String, Students>();
    public static void main(String[] args) {
        while (true) {
            try{
                System.out.println("----------------------------------------------");
                System.out.println("|       1.Add new students                   |");
                System.out.println("|       2.Search information by student code |");
                System.out.println("|       3.Exit                               |");
                System.out.println("----------------------------------------------");
                System.out.print("Choice = ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        createStudent();
                        break;
                    case 2:
                        searching();
                        break;
                    case 3:
                        System.out.println("Goodbye");
                        break;
                    default:
                        System.out.println("Please enter it again");
                        break;
                }
                if (choice == 3) {
                    break;
                }
            }catch (Exception e){
                System.out.println("Error!!");
                e.printStackTrace();
                break;
            }

        }
    }


    public static void createStudent(){
        System.out.println("Enter Information Student");
        System.out.println("-------------------------");
        System.out.print("Enter RollNumber : ");
        String rollNumber = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine();
        students = new Students(rollNumber, name, phone);
        mapStudent.put(rollNumber, students);
        System.out.println("Save success!!");
    }

    public static void searching(){
        System.out.print("Search information by student code: ");
        String searching = scanner.nextLine();
        students = mapStudent.get(searching);
        if (students == null) {

            System.out.println("Not fount!!");

        } else {
            System.out.println("Name: " + students.getName() + "\nPhone number: " + students.getPhone());
        }
    }
}
