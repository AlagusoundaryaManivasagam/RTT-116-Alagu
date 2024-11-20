package M303_11;

public class GenericValueObject <T,K extends Number>{
    // basically T can be anything int, char or string
    private T typeT;
    private K typeK;

    public K getTypeK() {
        return typeK;
    }

    public void setTypeK(K typeK) {
        this.typeK = typeK;
    }

    public T getT(){
        return typeT;
    }
    public void setT(T typeT){
        this.typeT = typeT;
    }
    public static void main(String[] args){
        GenericValueObject<String, Integer> string = new GenericValueObject<>();
        string.setT("String");
        string.getT();
    }
}
