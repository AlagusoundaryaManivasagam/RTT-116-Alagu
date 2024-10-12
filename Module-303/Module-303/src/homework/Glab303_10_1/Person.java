package homework.Glab303_10_1;

public class Person {
    String name;
    static int lifeSpan = 60;
    static double ageFactor =1.0;
    public Person(){
        name = "";
    }
    public Person(String aname){
        name = aname;
    }

    public String getName() {
        return name;
    }

    public void setName(String aname) {
        name = aname;
    }
    public String toString(){
        return ("hello, my name is "+ name);
    }
    public String talk(){
        return ("I have nothing to say");
    }
    public String walk(){
        return ("I have nowhere to go");
    }
    public static double lifeSpan(){
        return(ageFactor*lifeSpan);
    }
}
