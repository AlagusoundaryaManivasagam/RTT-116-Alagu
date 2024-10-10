package homework.Glab303_9_1;

public class HumanBeing303_9_1 {
    private float weight;
    private float height;
    private float bmi;

    public HumanBeing303_9_1(float weight, float height, float bmi) {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }
    public HumanBeing303_9_1() {

    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getBmi() {
        return bmi;
    }

    public void setBmi(float bmi) {
        this.bmi = bmi;
    }
}
