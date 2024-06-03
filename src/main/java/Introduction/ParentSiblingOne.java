package Introduction;

import org.testng.annotations.Test;

public class ParentSiblingOne extends ParentSibling {
    @Test
    public void doThis() {
        super.doThis();
        ParentSiblingTwo parentSiblingTwo = new ParentSiblingTwo(3);
        int a = 3;
        System.out.println(parentSiblingTwo.increment());
        System.out.println(parentSiblingTwo.decrement());

        System.out.println(parentSiblingTwo.multiplyThree());

    }
}
