/*---------------------------------------------------------------------------
Program Name: CSC320_CTA5_Option1.java
Author: Cole Miller
Date: 07/14/24
-----------------------------------------------------------------------------
Psuedocode:
    1. Start
    2. Import necessary libraries
    3. Declare ArrayLists to store days of the week and their corresponding temperatures.
    4. Create a method to prompt the user for input and store the data in the ArrayLists.
    5. Create a method to display the temperatures for each day.
    6. Create a method to calculate and display the weekly average temperature.
    7. In the main method, prompt the user for the day of the week or the keyword “week”.
    8. Based on the input, either display the temperature for the specific day or the weekly average.
    9. End

-----------------------------------------------------------------------------
Program Inputs: Daily temperature, What temperatures should be displayed
Program Outputs: Display temperature of chosen day or weekly average
-----------------------------------------------------------------------------
*/

import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperature {

    public static void main(String[] args) {
        // ArrayLists to store the days of the week and corresponding temperatures for each day
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Populate the days of the week
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");

        // Prompt the user to enter the temperature for each day
        for (String day : days) {
            System.out.print("Enter the average temperature for " + day + " in Fahrenheit: ");
            double temp = scanner.nextDouble();
            temperatures.add(temp);
        }

        // Loop to continuously prompt user for input until 'week' is entered
        while (true) {
            System.out.print("Enter a day of the week to see its temperature or 'week' to see the weekly average: ");
            String input = scanner.next();

            // If 'week' is entered, display the weekly average temperature and break the loop
            if (input.equalsIgnoreCase("week")) {
                displayWeeklyAverage(temperatures);
                break;
            } else {
                // Display temperature for the specified day
                displayDayTemperature(days, temperatures, input);
            }
        }

        // Close the scanner to free resources
        scanner.close();
    }

    // Method to display the temperature for a specific day
    public static void displayDayTemperature(ArrayList<String> days, ArrayList<Double> temperatures, String day) {
        // Convert the input day to proper case (example: monday to Monday)
        int index = days.indexOf(day.substring(0, 1).toUpperCase() + day.substring(1).toLowerCase());

        // Check if the day exists in the list
        if (index != -1) {
            // Print the day and its corresponding temperature
            System.out.println(day + ": " + temperatures.get(index) + "°F");
        } else {
            // Print an error message if the day is not valid
            System.out.println("Invalid day entered. Please try again.");
        }
    }

    // Method to display the weekly average temperature
    public static void displayWeeklyAverage(ArrayList<Double> temperatures) {
        // Calculate the sum of all temperatures
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }

        // Calculate and print the average temperature
        double average = sum / temperatures.size();
        System.out.printf("Weekly average temperature: %.2f°F%n", average);
    }
}
