package bfs;

import entity.Employee;

import java.util.*;

/**
 * @author wsh
 * @date 2021-04-21
 */
public class GetImportanceNo690 {

    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) {
            return 0;
        }
        HashMap<Integer, Employee> employeeHashMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeHashMap.put(employee.id, employee);
        }
        Queue queue = new LinkedList<>();
        Set set = new HashSet<>();

        //初始化
        queue.add(id);
        set.add(id);

        int importance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Employee e = employeeHashMap.get(queue.poll());
                importance += e.importance;
                List<Integer> sub = e.subordinates;
                for (int s : sub) {
                    if(!set.contains(s)) {
                        queue.add(s);
                        set.add(s);
                    }
                }
            }
        }
        return importance;
    }


    public static void main(String[] args) {
        GetImportanceNo690 s = new GetImportanceNo690();
        List<Employee> employees = new ArrayList<>();

    }
}
