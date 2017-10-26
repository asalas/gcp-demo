package com.cirrocode.support;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils implements Serializable
{
    private static final long serialVersionUID = 1L;

    public static final Locale LOCALE_MX = new Locale("es", "MX");
    
    public static final TimeZone TIMEZONE_MX = TimeZone.getTimeZone("America/Mexico_City");
    
    public static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");

    /**
     * Pattern 'dd/MM/yyyy'
     */
    public static final String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
    /**
     * Pattern 'ddMMyyyyHHmmss'
     */
    public static final String FORMAT_DDMMYYYYHHMMSS = "ddMMyyyyHHmmss";
    /**
     * Pattern 'dd/MM/yyyy HH:mm:ss'
     */
    public static final String FORMAT_DDMMYYYY_HHMMSS = "dd/MM/yyyy HH:mm:ss";
    /**
     * Pattern 'yyyy-MM-dd'
     */
    public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd";
    /**
     * Pattern 'yyyy-MM-dd HH:mm:ss'
     */
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    /**
     * Pattern 'yyyyMMdd_HHmmss'
     */
    public static final String FORMAT_YYYYMMDD_HHMMSS = "yyyyMMdd_HHmmss";
    /**
     * Pattern 'ddMMyyHHmmss'
     */
    public static final String FORMAT_DDMMYYHHMMSS = "ddMMyyHHmmss";
    
    public static final String FORMAT_BIG_QUERY_TIMESTAMP = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /**
     * Formatear una fecha con el patrón especificado
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern)
    {
        final SimpleDateFormat sdf = new SimpleDateFormat(pattern, LOCALE_MX);
        sdf.setTimeZone(TIMEZONE_MX);
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    /**
     * Analiza una cadena de fecha con el patrón especificado
     *
     * @param date
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parse(String date, String pattern) throws ParseException
    {
        final SimpleDateFormat sdf = new SimpleDateFormat(pattern, LOCALE_MX);
        sdf.setTimeZone(TIMEZONE_MX);
        sdf.applyPattern(pattern);
        return sdf.parse(date);
    }

    public static List<Date> getDaysBetweenDates(Date startDate, Date endDate)
    {
        List<Date> result = new ArrayList<>();
        Calendar start = GregorianCalendar.getInstance(TIMEZONE_MX, LOCALE_MX);
        start.setTime(startDate);
        start.set(Calendar.HOUR_OF_DAY, 0);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND, 0);

        Calendar end = GregorianCalendar.getInstance(TIMEZONE_MX, LOCALE_MX);
        end.setTime(endDate);
        end.set(Calendar.HOUR_OF_DAY, 0);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND, 0);

        // Add 1 day to endDate to make sure
        // endDate is included into the
        // final list
        end.add(Calendar.DAY_OF_YEAR, 1);

        while (start.before(end))
        {
            result.add(start.getTime());
            start.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    public static Calendar getCurrentCalendar()
    {
        return GregorianCalendar.getInstance(TIMEZONE_MX, LOCALE_MX);
    }
    
    public static Calendar getCurrentCaledarUTC()
    {
        return GregorianCalendar.getInstance(TIMEZONE_UTC);
    }

    public static Date getCurrentDate()
    {
        return getCurrentCalendar().getTime();
    }
    
    public static Date getCurrentDateUTC()
    {
        return getCurrentCaledarUTC().getTime();
    }

    public static Date addOneYearToDate(Date date)
    {
        Calendar calendar = getCurrentCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 1);

        return calendar.getTime();
    }

    public static String timestampBigQueryToDateString(String timestamp)
    {
        Date date = new Date(Double.valueOf(timestamp).longValue() * 1000);
        // format of the date
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(date);
    }
    
    public static String timestampToDateString(String timestamp)
    {
        Date date = new Date(Double.valueOf(timestamp).longValue());
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);
        sdf.setTimeZone(TIMEZONE_UTC);
        return sdf.format(date);
    }
    
    public static String timestampBigQueryToDateMXString(String timestamp)
    {
        Date date = new Date(Double.valueOf(timestamp).longValue() * 1000);
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYYMMDDHHMMSS);
        sdf.setTimeZone(TIMEZONE_MX);
        return sdf.format(date);
    }
}
