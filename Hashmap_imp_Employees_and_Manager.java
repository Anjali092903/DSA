import java.io.*;
import java.util.*;

class Solution {

    public void EmpUnderManager(Map<String, String> emp) {
        // Step 1: Create a map to store the direct reports for each manager
        Map<String, List<String>> managerToEmployeeMap = new HashMap<>();
        for (Map.Entry<String, String> entry : emp.entrySet()) {
            String employee = entry.getKey();
            String manager = entry.getValue();
            // Avoid self-references for employees reporting to themselves (CEO)
            if (!manager.equals(employee)) {
                managerToEmployeeMap.putIfAbsent(manager, new ArrayList<>());
                managerToEmployeeMap.get(manager).add(employee);
            }
        }

        // Step 2: Create a map to store the number of employees under each manager
        Map<String, Integer> result = new HashMap<>();

        // Step 3: Use recursion to calculate the number of employees under each manager
        for (String manager : emp.keySet()) {
            getEmployeeCount(manager, managerToEmployeeMap, result);
        }

        // Step 4: Print the result sorted by manager in lexical order
        List<String> managers = new ArrayList<>(result.keySet());
        Collections.sort(managers);
        for (String manager : managers) {
            System.out.println(manager + " " + result.get(manager));
        }
    }

    private int getEmployeeCount(String manager, Map<String, List<String>> managerToEmployeeMap, Map<String, Integer> result) {
        // If the result for this manager is already calculated, return it
        if (result.containsKey(manager)) {
            return result.get(manager);
        }

        // Get the list of employees reporting to this manager
        List<String> employees = managerToEmployeeMap.getOrDefault(manager, new ArrayList<>());

        // Recursively calculate the total number of employees (direct + indirect)
        int count = 0;
        for (String employee : employees) {
            count += 1 + getEmployeeCount(employee, managerToEmployeeMap, result);
        }

        // Store the result for this manager
        result.put(manager, count);
        return count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Map<String, String> emp = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            String employee = sc.next();
            String manager = sc.next();
            emp.put(employee, manager);
        }
        Solution Obj = new Solution();
        Obj.EmpUnderManager(emp);
        sc.close();
    }
}




Employees and Manager
Given a dictionary of employee:manager where they are represented by characters,

Print manager number_of employees_under_the_manager where managers sorted in lexical order

Number of employees also include indirect reports not only direct reports.

It may be assumed that an employee directly reports to only one manager.

In the above dictionary the root node/ceo is listed as reporting to himself.

Note You are given a dictionary named emp containing employee:manager as key:value so you only need to complete the function and print output

Input Format
First line of input denotes the number of pairs

followed by n space seperated pairs denoting employee and manager

Output Format
Print manager number_of_employees space seperated where each pair is in new line in lexically sorted order

Example
Input

6
A C
B C
C F
D E
E F
F F
Output

A 0  
B 0
C 2
D 0
E 1
F 5 
Explanation

Each denotes number of employees directly and indirectly under the manager. F is the CEO therefore all other employees are under him

Constraints
1<=Total number of employees<=100

Topics
Dynamic Programming
Hashing
