import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ResponseRecordTest {
    @Test
    public void TestingExamplesResponseRecord(){
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-05 00:45] falls asleep",
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-05 00:55] wakes up"
        ));

        ResponseRecord resRec = new ResponseRecord();
        resRec.readList(list);

        Assert.assertEquals(Integer.valueOf(10), resRec.getSleepyGuard());
        Assert.assertEquals(Integer.valueOf(24), resRec.getMostCommonMinute(resRec.getSleepyGuard()));
        Assert.assertEquals(Integer.valueOf(240), resRec.getSolution());
    }
}