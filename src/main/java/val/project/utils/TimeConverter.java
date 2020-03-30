package val.project.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class TimeConverter {

    public Date convertFromInternetTimeToDate(String toConvert){
        DateFormat format = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ssZ");
        try {
            Date date = format.parse(toConvert);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private long convertToTimeStemp(Date date){
        Timestamp ts=new Timestamp(date.getTime());
        System.out.println(ts.getTime());
        return ts.getTime();
    }

    public long getDateInTimestap(String time){
        Instant instant = Instant.parse( time );
        Date tmp=Date.from(instant);
       return convertToTimeStemp(tmp);
    }

    public Date getDateFromTimeStamp(long convertingDate){
        Timestamp timestamp=new Timestamp(convertingDate);
        return new Date(timestamp.getTime());
    }
}
