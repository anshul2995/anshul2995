package Questions;

public class Q5SPGlobal {

    class Employee{
        int a;
        Employee(int a){
            this.a = a;
        }
    }

    public static void main(String[] args) {
        Q5SPGlobal o = new Q5SPGlobal();
        o.fn();
    }

    public void fn(){
        Employee e1 = new Employee(10);
        Employee e2 = e1;
        e1 = null;
        System.out.println(e2.a);

    }
}
