package homework.Glab303_9_1;

public class EncapsulationExample303_9_1 {
    public static void main(String[] args) {
        HumanBeing303_9_1 h1 = new HumanBeing303_9_1();
        h1.setHeight(1.65f);
        h1.setWeight(68);
        h1.setBmi(calculateBmi(h1));
        System.out.println("Person has" + h1.getWeight() + " kgs and is " + h1.getHeight() +
                " meters in height, which results in BMIof" + h1.getBmi());
    }
    public static float calculateBmi(HumanBeing303_9_1 h1) {
        return h1.getWeight() / (h1.getHeight() * h1.getHeight());
    }
}
