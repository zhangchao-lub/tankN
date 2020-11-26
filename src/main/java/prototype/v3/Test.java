package prototype.v3;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/23 15:24
 * @descrption 深克隆
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1=new Person();
        Person p2= (Person) p1.clone();
        System.out.println("p1.loc == p2.loc? "+(p1.loc==p2.loc));

        p1.loc.street.reverse();
        System.out.println(p2.loc.street);
    }

}

class Person implements Cloneable{
    int age=26;
    int salary=7000;

    Location loc=new Location(new StringBuilder("yhsx"),1303);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p= (Person) super.clone();
        p.loc= (Location) loc.clone();
        return p;
    }

}

class Location implements Cloneable{

     StringBuilder street;
     int roomNo;

    public Location(StringBuilder street, int roomNo) {
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
