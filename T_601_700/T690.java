package T_601_700;

import java.util.HashMap;
import java.util.List;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};



public class T690 {

//	map+bfs
	int sum=0;
	HashMap<Integer,Employee> map=new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e:employees)
        	map.put(e.id, e);
        getitem(map.get(id));
        return sum;
    }
	private void getitem(Employee employee) {
		sum+=employee.importance;
		for(int i:employee.subordinates)
			getitem(map.get(i));
	}
    
}
