import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

abstract class Test{
    private static final int a=0;
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        Test.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
    }

    public static void swap(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }
    static class Student{
        private String name;
        Student(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }
    }
}

