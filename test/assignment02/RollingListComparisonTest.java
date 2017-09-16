package assignment02;

import org.junit.Before;
import org.junit.Test;

public class RollingListComparisonTest
{

    RollingList doubleListAbsolute;
    RollingList doubleListRelative;

    RollingListString stringListAbsolute;
    RollingListString stringListRelative;

    int numberOfTests = 50000;
    double testDouble = 1.0;
    String testString = "a";

    long start;
    long end;

    @Before
    public void setUp() throws Exception
    {
        doubleListRelative = new RollingList(2f,0);
        doubleListAbsolute = new RollingList(1f,10);

        stringListRelative = new RollingListString(2f,0);
        stringListAbsolute = new RollingListString(1f,10);
    }

    @Test
    public void testPrependDoubleAbsoluteGrowth01(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            doubleListAbsolute.prepend(testDouble);
        }
        end = System.currentTimeMillis();

        System.out.printf("(Double)\tAGR:\t%sms\tMods:\t%s%n", end - start, doubleListAbsolute.getModificationCounter());
    }

    @Test
    public void testPrependDoubleAbsoluteGrowth02(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            doubleListAbsolute.prepend(testDouble);
        }
        end = System.currentTimeMillis();

        System.out.printf("(Double)\tAGR:\t%sms\tMods:\t%s%n", end - start, doubleListAbsolute.getModificationCounter());
    }

    @Test
    public void testPrependDoubleAbsoluteGrowth03(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            doubleListAbsolute.prepend(testDouble);
        }
        end = System.currentTimeMillis();

        System.out.printf("(Double)\tAGR:\t%sms\tMods:\t%s%n", end - start, doubleListAbsolute.getModificationCounter());
    }

    @Test
    public void testPrependDoubleRelativeGrowth01(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            doubleListRelative.prepend(testDouble);
        }
        end = System.currentTimeMillis();

        System.out.printf("(Double)\tRGR:\t%sms\tMods:\t%s%n", end - start, doubleListRelative.getModificationCounter());
    }

    @Test
    public void testPrependDoubleRelativeGrowth02(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            doubleListRelative.prepend(testDouble);
        }
        end = System.currentTimeMillis();

        System.out.printf("(Double)\tRGR:\t%sms\tMods:\t%s%n", end - start, doubleListRelative.getModificationCounter());
    }

    @Test
    public void testPrependDoubleRelativeGrowth03(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            doubleListRelative.prepend(testDouble);
        }
        end = System.currentTimeMillis();

        System.out.printf("(Double)\tRGR:\t%sms\tMods:\t%s%n", end - start, doubleListRelative.getModificationCounter());
    }

    @Test
    public void testPrependStringAbsoluteGrowth01(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            stringListAbsolute.prepend(testString);
        }
        end = System.currentTimeMillis();

        System.out.printf("(String)\tAGR:\t%sms\tMods:\t%s%n", end - start, stringListAbsolute.getModificationCounter());
    }

    @Test
    public void testPrependStringAbsoluteGrowth02(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            stringListAbsolute.prepend(testString);
        }
        end = System.currentTimeMillis();

        System.out.printf("(String)\tAGR:\t%sms\tMods:\t%s%n", end - start, stringListAbsolute.getModificationCounter());
    }

    @Test
    public void testPrependStringAbsoluteGrowth03(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            stringListAbsolute.prepend(testString);
        }
        end = System.currentTimeMillis();

        System.out.printf("(String)\tAGR:\t%sms\tMods:\t%s%n", end - start, stringListAbsolute.getModificationCounter());
    }

    @Test
    public void testPrependStringRelativeGrowth01(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            stringListRelative.prepend(testString);
        }
        end = System.currentTimeMillis();

        System.out.printf("(String)\tRGR:\t%sms\tMods:\t%s%n", end - start, stringListRelative.getModificationCounter());
    }

    @Test
    public void testPrependStringRelativeGrowth02(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            stringListRelative.prepend(testString);
        }
        end = System.currentTimeMillis();

        System.out.printf("(String)\tRGR:\t%sms\tMods:\t%s%n", end - start, stringListRelative.getModificationCounter());
    }

    @Test
    public void testPrependStringRelativeGrowth03(){
        start = System.currentTimeMillis();
        for (int i = 0; i < numberOfTests; i++) {
            stringListRelative.prepend(testString);
        }
        end = System.currentTimeMillis();

        System.out.printf("(String)\tRGR:\t%sms\tMods:\t%s%n", end - start, stringListRelative.getModificationCounter());
    }

}


