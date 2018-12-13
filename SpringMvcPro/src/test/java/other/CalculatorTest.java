package other;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    @Before
    public void setUp() throws Exception {

        System.out.println("init");
    }

    @After
    public void tearDown() throws Exception {

        System.out.println("done");
    }

    @Test
    public void add() throws Exception {

        Calculator ca = new Calculator();
        int result = ca.add(5,8);
        Assert.assertEquals(13,result);
    }

    @Test
    public void subtract() throws Exception {

        Calculator ca = new Calculator();
        int result = ca.subtract(9,1);
        Assert.assertEquals(8,result);
    }

}