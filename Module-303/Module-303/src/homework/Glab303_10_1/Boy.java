package homework.Glab303_10_1;

public class Boy extends Person {
    static double ageFactor = 1.1;
    public String talk(){
        return(super.talk() + "..... but I love Java classes");
    }
    public String walk(){
        return ("I am now walking");
    }
}
