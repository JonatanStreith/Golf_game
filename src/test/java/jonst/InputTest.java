package jonst;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputTest {

    @Test
    public void ConstructorTest()
    {
        Input test = new Input(45, 1000);

        double expectedDistance = 4443.32;  //Calculated result of those inputs

        assertEquals( expectedDistance, test.getDistance(), 0.01 );
    }

}
