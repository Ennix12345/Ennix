package uz.ennix;

public class Tester{
    public static void main(String[] args) throws CloneNotSupportedException {
        Doll doll = new Doll("Barbi", 200);
        Doll doll2 = (Doll) doll.clone();
        System.out.println(doll2);
    }
}
class Doll implements Cloneable{
    private String name;
    private int weight;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Doll doll = (Doll) super.clone();
        doll.name = name.replace('a', 'e');
        return doll;
    }
    public Doll(String name, int weight) {
        this.name = name;
        this.weight = weight;
        }

    @Override
    public String toString() {
        return "Doll: " +
                "name = " + name+
                ", weight = " + weight;
    }
}
