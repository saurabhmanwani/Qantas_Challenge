package au.com.qantas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * @author SM
 *
 * Test Class for {@link DateUtil}
 */
public class DateUtilTest {


    @Test(expected = RuntimeException.class)
    public void testValidateDateWithNullDate(){
        DateUtil.validateDate(null);
    }

    @Test
    public void testValidateDateWithInValidDate(){
        assertFalse(DateUtil.validateDate("20-11-2019"));
    }

    @Test
    public void testValidateDateWithValidDate() {
        assertTrue(DateUtil.validateDate("2020-11-20"));
    }

    @Test
    public void testGetYearFromDateString(){
        assertEquals(2009, DateUtil.getYearFromDateString("2009-12-01"));
    }

    @Test
    public void testGetMonthFromDateString(){
        assertEquals(12, DateUtil.getMonthFromDateString("2009-12-01"));
    }

    @Test
    public void testGetDayFromDateString(){
        assertEquals(01, DateUtil.getDaysFromDateString("2009-12-01"));
    }

    @Test
    public void testIsLeapYearWithInValidYear(){
        assertFalse(DateUtil.isLeapYear(2017));
    }

    @Test
    public void testIsLeapYearWithValidYear(){
        assertTrue(DateUtil.isLeapYear(2012));
    }

    @Test
    public void testGetDaysBetweenYearsWithLeapYear(){
        assertEquals(366,DateUtil.getDaysBetweenYears(2012, 2013));
    }

    @Test
    public void testGetDaysBetweenYearsCase1(){
        assertEquals(365,DateUtil.getDaysBetweenYears(2013, 2014));
    }

    @Test
    public void testGetDaysBetweenYearsCase2(){
        assertEquals(0,DateUtil.getDaysBetweenYears(2012, 2012));
    }

    @Test
    public void testGetDaysBetweenTwoDates1(){
        assertEquals(19,DateUtil.getDaysBetweenTwoDates("1983-06-02", "1983-06-22"));
    }

    @Test
    public void testGetDaysBetweenTwoDates2(){
        assertEquals(173,DateUtil.getDaysBetweenTwoDates("1984-07-04", "1984-12-25"));
    }

    @Test
    public void testGetDaysBetweenTwoDates3(){
        assertEquals(1979,DateUtil.getDaysBetweenTwoDates("1983-08-03", "1989-01-03"));
    }
}
