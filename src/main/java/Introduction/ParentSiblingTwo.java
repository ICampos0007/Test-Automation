package Introduction;

public class ParentSiblingTwo extends ParentSiblingThree {

    int a;
    public ParentSiblingTwo(int a) {
        super(a);
        this.a = a;

    }
    public int increment() {
        a+=1;
        return a;
    }

    public int decrement() {
        a-=1;
        return a;
    }
}
