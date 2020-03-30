package main;

import org.junit.Before;
import org.junit.Test;
import val.project.utils.TimeConverter;

import java.util.Date;


public class TimeConverterTest {
    private TimeConverter converter;
    private String convertingDate;
    @Before
    public void init(){
        converter=new TimeConverter();
        convertingDate="2020-01-31T13:40:13Z";
    }

    @Test
    public void doTest(){
        converter.getDateInTimestap(convertingDate);
    }
    @Test
    public void doTest2(){
        System.out.println(converter.getDateFromTimeStamp( converter.getDateInTimestap(convertingDate)).toString());  ;
    }
}
