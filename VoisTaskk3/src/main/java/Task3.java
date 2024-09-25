import java.io.*;
import java.util.*;

public class Task3 {

        private static final double USD_TO_EGP_CONVERSION_RATE = 30.0; // Conversion rate

        public static void main(String[] args) {
            // Read data from CSV
            List<String[]> employees = readCSV("C:\\Users\\BaraaRihan\\Desktop\\Employees.csv");

            // Remove duplicates using HashSet with a custom comparator
            List<String[]> uniqueEmployees = removeDuplicates(employees);

            // Process data (remove decimals in age, convert salary to EGP)
            List<String[]> processedEmployees = processEmployees(uniqueEmployees);

            // Perform statistical calculations
            printStatistics(processedEmployees);

            // Write cleaned data to new CSV
            writeCSV("cleaned_data.csv", processedEmployees);
        }

        // Function to read CSV file
        private static List<String[]> readCSV(String filePath) {
            List<String[]> employees = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                // Skip the header line
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    employees.add(fields);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return employees;
        }

        // Function to remove duplicates based on all fields (Name, Gender, Age, Salary)
        private static List<String[]> removeDuplicates(List<String[]> employees) {
            Set<String> uniqueRecords = new HashSet<>();
            List<String[]> uniqueEmployees = new ArrayList<>();

            for (String[] employee : employees) {
                String uniqueKey = String.join(",", employee); // Combine all fields as a unique key
                if (!uniqueRecords.contains(uniqueKey)) {
                    uniqueRecords.add(uniqueKey);
                    uniqueEmployees.add(employee);
                }
            }
            return uniqueEmployees;
        }

        // Function to process the data (remove decimals in age, convert salary to EGP)
        private static List<String[]> processEmployees(List<String[]> employees) {
            List<String[]> processedEmployees = new ArrayList<>();

            for (String[] employee : employees) {
                String name = employee[0];
                String gender = employee[1];
                int age = (int) Double.parseDouble(employee[2]); // Remove decimal places in age
                double salaryEGP = Double.parseDouble(employee[3]) * USD_TO_EGP_CONVERSION_RATE; // Convert salary to EGP

                processedEmployees.add(new String[]{name, gender, String.valueOf(age), String.format("%.2f", salaryEGP)});
            }

            return processedEmployees;
        }

        // Function to write processed data to a CSV file
        private static void writeCSV(String filePath, List<String[]> employees) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                // Write the header
                bw.write("Name,Gender,Age,Salary(EGP)");
                bw.newLine();
                // Write each employee's data
                for (String[] employee : employees) {
                    bw.write(String.join(",", employee));
                    bw.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Function to calculate and print statistics
        private static void printStatistics(List<String[]> employees) {
            double totalAge = 0;
            int count = 0;
            List<Double> salaries = new ArrayList<>();
            int maleCount = 0, femaleCount = 0;

            // Iterate through each employee's data
            for (String[] employee : employees) {
                int age = Integer.parseInt(employee[2]);
                double salary = Double.parseDouble(employee[3]);
                String gender = employee[1];

                // Aggregate data for statistics
                totalAge += age;
                salaries.add(salary);
                count++;

                // Count males and females
                if (gender.equalsIgnoreCase("M")) maleCount++;
                else if (gender.equalsIgnoreCase("F")) femaleCount++;
            }

            // Calculate average age
            double averageAge = totalAge / count;

            // Calculate median salary
            Collections.sort(salaries);
            double medianSalary;
            if (salaries.size() % 2 == 0) {
                medianSalary = (salaries.get(salaries.size() / 2 - 1) + salaries.get(salaries.size() / 2)) / 2;
            } else {
                medianSalary = salaries.get(salaries.size() / 2);
            }

            // Calculate male-to-female ratio
            String genderRatio = femaleCount == 0 ? "No female employees" : String.format("%.2f:1", (double) maleCount / femaleCount);

            // Print statistics
            System.out.println("Average Age: " + averageAge);
            System.out.println("Median Salary (EGP): " + medianSalary);
            System.out.println("Male-to-Female Ratio: " + genderRatio);
        }
    }


