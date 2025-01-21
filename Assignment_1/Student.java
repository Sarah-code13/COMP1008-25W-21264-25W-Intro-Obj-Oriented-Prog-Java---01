package Assignment_1;
import java.util.Arrays;
import java.util.Scanner;
public class Student {
    static double[] averages;
    static String[] names;
    static double[] score;
    static char[] letterGrade; //declaring the three variables as a universal arrays to use

    public static class GradeBook {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in); //using a scanner to read the input from the user
            int n;
            do {
                System.out.println("Enter the number of students: ");
                n = sc.nextInt();
                if (n < 1 || n > 50) { //using an if statement to check if the number inserted is between 1 to 50
                    System.out.println("Out of range, enter between 1 to 50 students:");
                }
            } while (n < 1 || n > 50); //using a do while in case the if statement returns false it doesn't store the invalid value to 'n'
            sc.nextLine();
            names = new String[n];
            averages = new double[n];
            letterGrade = new char[n]; /* making the variables locally so they can update when going to the next student
     and don't overwrite the last data from the last student */
            for (int i = 0; i < n; i++) { //using a for loop to loop from student to another student
                System.out.println("Student Name: " + (i + 1) + ": ");
                names[i] = sc.nextLine();
                System.out.println("Enter the number of grades between 3 and 5: ");
                int gradesnumber = sc.nextInt();
                while (gradesnumber < 3 || gradesnumber > 5 ) { //checking if the value for the number of grades is between 3 and 5
                    System.out.println("Invalid grades!");
                    gradesnumber = sc.nextInt();
                }
                 score = new double[gradesnumber];
                double total = 0; //variable that updates the total of grades the current student has
                for (int h = 0; h < gradesnumber; h++) {
                    System.out.println("Enter the grade " + (h + 1) + " of student: " + names[i] + ": ");
                    score[h] = sc.nextDouble();
                    while (score[h] > 100 || score[h] < 0) { //another if statement that checks the correct inputs
                        System.out.println("Invalid grade, enter a grade between 0 to 100");
                        score[h] = sc.nextDouble();
                    }
                    total += score[h]; //it sums the total of grades
                }
                sc.nextLine();

                averages[i] = total / gradesnumber; //an array that stores the average of the current student
                System.out.printf("The average is %.2f\n", averages[i]);


                if (averages[i] >= 90 && averages[i] <= 100) {
                    letterGrade[i] = 'A';
                } else if (averages[i] >= 80 && averages[i] <= 89) {
                    letterGrade[i] = 'B';
                } else if (averages[i] >= 70 && averages[i] <= 79) {
                    letterGrade[i] = 'C';
                } else if (averages[i] >= 60 && averages[i] <= 69) {
                    letterGrade[i] = 'D';
                } else {
                    letterGrade[i] = 'F';
                } //if statements that checks the current value of averages and sees through where is true to store that char
                System.out.println("The student " + names[i] + " has a letter of grade: " + letterGrade[i] + ".");
            } //end of for loop it finishes storing all the data of the current and goes back again for the next student
            System.out.println("In summary: ");
            for (int i = 0; i < n; i++) {
                System.out.printf("Student Name: %s has a average of: %.2f and his grade is %c\n", names[i], averages[i], letterGrade[i]);

            }
        }
    }
}


