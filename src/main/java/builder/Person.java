package builder;


/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/11/6 14:38
 * @descrption
 */
public class Person {
    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;

    private Person() {
    }

    public static class PersonBuilder {
        Person p = new Person();

        public PersonBuilder basicInfo(int id,String name,int age){
            p.id=id;
            p.name=name;
            p.age=age;
            return this;
        }
        public PersonBuilder weight(double weight){
            p.weight=weight;
            return this;
        }
        public PersonBuilder score(int score){
            p.score=score;
            return this;
        }
        public PersonBuilder loc(String street,String roomNo){
            p.loc=new Location(street,roomNo);
            return this;
        }
        public Person builder(){
            return p;
        }
    }

}
class Location{
    String street;
    String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}