import junit.framework.Assert;
import org.apache.tomcat.util.digester.ArrayStack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import userInput.Attempt;
import userInput.UserInputService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
public class UserInputServiceTest {

    UserInputService uis = new UserInputService();

    @Test
    public void TEST1() {
        List<List<Integer>> input = new ArrayList<>();
        Attempt attempt = uis.processInput(input);
        Assert.assertEquals(input, attempt.getInput());
        Assert.assertFalse(attempt.getStatus());
        Assert.assertEquals(Arrays.asList("please send atleast two arrays"), attempt.getMessages());
    }

    @Test
    public void TEST2() {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>());
        input.add(new ArrayList<>());
        input.add(new ArrayList<>());
        Attempt attempt = uis.processInput(input);
        Assert.assertEquals(input, attempt.getInput());
        Assert.assertEquals(false, attempt.getStatus());
        Assert.assertEquals(Arrays.asList("please send atleast two non empty arrays"), attempt.getMessages());
    }

    @Test
    public void Test3() {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2, 3));
        input.add(Arrays.asList(1, 3, 2));
        input.add(Arrays.asList(2, 3, 1));

        List<String> msgs = new ArrayList<>();
        msgs.add("Array 0 and Array 1 are equal");
        msgs.add("Array 0 and Array 2 are equal");
        msgs.add("Array 1 and Array 2 are equal");

        Attempt attempt = uis.processInput(input);
        Assert.assertEquals(input, attempt.getInput());
        Assert.assertEquals(true, attempt.getStatus());
        Assert.assertEquals(msgs, attempt.getMessages());
    }


    @Test
    public void Test4() {
        List<List<Integer>> input1 = new ArrayList<>();
        input1.add(Arrays.asList(1,2,3));
        input1.add(Arrays.asList(1,2,3,4));
        input1.add(Arrays.asList(2,1,3));

        List<String> msg = new ArrayList<>();
        msg.add("Array 0 and Array 2 are equal");

        Attempt attempt1 = uis.processInput(input1);
        Assert.assertEquals(input1, attempt1.getInput());
        Assert.assertEquals(true, attempt1.getStatus());
        Assert.assertEquals(msg, attempt1.getMessages());
    }

    @Test
    public void Test5() {
        List<List<Integer>> input2 = new ArrayList<>();
        input2.add(Arrays.asList(1,2,3));
        input2.add(Arrays.asList(1,3,4,5));
        input2.add(Arrays.asList(1,2,5));

        List<String> mesg = new ArrayList<>();
        mesg.add("none of the arrays matched");

        Attempt attempt1 = uis.processInput(input2);
        Assert.assertEquals(input2, attempt1.getInput());
        Assert.assertEquals(true, attempt1.getStatus());
        Assert.assertEquals(mesg, attempt1.getMessages());


    }
}
