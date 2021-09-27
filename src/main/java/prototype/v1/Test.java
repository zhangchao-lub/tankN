package prototype.v1;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/23 15:24
 * @descrption 浅克隆
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1=new Person();
        Person p2= (Person) p1.clone();
        System.out.println(p2.age+" "+p2.getSalary());
        System.out.println(p2.loc);

        System.out.println(p1.loc==p2.loc);
        p1.loc.street="sh";
        p1.age=27;
        System.out.println(p2.loc);
        System.out.println(p2.age);
    }

}

class Person implements Cloneable{
    int age=26;
    int salary=12000;

    Location loc=new Location("yhsx",1303);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }
}

class Location /*implements Cloneable*/{

     String street;
     int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}
