package com.tecyin.basiclassify.utils;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间戳和日期转换
 */
public class FormatTime {
    /**
     * 时间戳转日期
     *
     * @param ms
     * @return
     */
    public static Date transForDate(Integer ms) {
        if (ms == null) {
            ms = 0;
        }
        long msl = (long) ms * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date temp = null;
        if (ms != null) {
            try {
                String str = sdf.format(msl);
                temp = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * 获取晚上9点半的时间戳
     *
     * @return
     */
    public static int getTimes(int day, int hour, int minute) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }

    /**
     * 获取当前时间往上的整点时间
     *
     * @return
     */
    public static int getIntegralTime() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, 1);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }
    /**
     * 获取当前时间往下的整点时间
     *
     * @return
     */
    public static int getIntegralTimeEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() / 1000);
    }


    /**
     * 时间戳转日期
     *
     * @param "yyyy-MM-dd HH:mm"
     * @return
     */
    public static Date transForDate3(Integer ms) {
        if (ms == null) {
            ms = 0;
        }
        long msl = (long) ms * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date temp = null;
        if (ms != null) {
            try {
                String str = sdf.format(msl);
                temp = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * 时间戳转日期
     *
     * @param "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static Date transForDate(Long ms) {
        if (ms == null) {
            ms = (long) 0;
        }
        long msl = (long) ms * 1000;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date temp = null;
        if (ms != null) {
            try {
                String str = sdf.format(msl);
                temp = sdf.parse(str);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * 时间戳转字符串 “yyyy-MM-dd HH:mm:ss”
     * @param ms
     * @return
     */
    public static String transForDate1(Integer ms) {
        String str = "";
        if (ms != null) {
            long msl = (long) ms * 1000;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if (ms != null) {
                try {
                    str = sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    /**
     * 时间戳转字符串 “yyyy-MM-dd”
     * @param ms
     * @return
     */
    public static String transForDate2(Integer ms) {
        String str = "";
        if (ms != null) {
            long msl = (long) ms * 1000;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            if (ms != null) {
                try {
                    str = sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    /**
     * 时间戳转字符串 “yyyy.MM.dd”
     * @param ms
     * @return
     */
    public static String transForDate4(Integer ms) {
        String str = "";
        if (ms != null) {
            long msl = (long) ms * 1000;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

            if (ms != null) {
                try {
                    str = sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    /**
     * 时间戳转字符串"yyyy/MM/dd HH:mm:ss"
     * @param ms
     * @return
     */
    public static String transForDate5(Integer ms) {
        String str = "";
        if (ms != null) {
            long msl = (long) ms * 1000;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

            if (ms != null) {
                try {
                    str = sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    /**
     * 时间戳转字符串"yyyy年MM月dd日 HH:mm:ss"
     * @param ms
     * @return
     */
    public static String transForDateInChinese(Integer ms) {
        String str = "";
        if (ms != null) {
            long msl = (long) ms * 1000;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");

            if (ms != null) {
                try {
                    str = sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    /**
     * 日期转时间戳
     *
     * @param date
     * @return
     */
    public static Integer transForMilliSecond(Date date) {
        if (date == null) return null;
        return (int) (date.getTime() / 1000);
    }

    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static int currentTimeStamp() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /**
     * 日期字符串转时间戳
     *
     * @param dateStr
     * @return
     */
    public static int transForMilliSecond(String dateStr) {
        Date date = FormatTime.formatDate(dateStr);
        return date == null ? null : FormatTime.transForMilliSecond(date);
    }

    /**
     * 日期字符串转时间戳
     *
     * @param dateStr
     * @return
     */
    public static int transForMilliSecond(String dateStr, String format) {
        Date date = FormatTime.formatDate(dateStr, format);
        return date == null ? null : FormatTime.transForMilliSecond(date);
    }

    /**
     * 日期字符串转时间戳
     *
     * @param dateStr
     * @param 格式      如"yyyy-mm-dd"
     * @return
     */
    public static int transForMilliSecondByTim(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date == null ? null : FormatTime.transForMilliSecond(date);
    }

    /**
     * 字符串转日期，格式为："yyyy-MM-dd HH:mm:ss"
     *
     * @param dateStr
     * @return
     */
    public static Date formatDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date result = null;
        try {
            result = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 字符串转日期，格式为："yyyy-MM-dd HH:mm:ss"
     *
     * @param dateStr
     * @return
     */
    public static Date formatDate(String dateStr, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date result = null;
        try {
            result = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = null;
        result = sdf.format(date);
        return result;
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String result = null;
        result = sdf.format(date);
        return result;
    }

    /**
     * 时间戳格式化输出（httl模版用）
     *
     * @param ms     时间戳
     * @param format 格式化
     * @return
     */
    public static String transForDate(Integer ms, String format) {
        String str = "";
        if (ms != null) {
            long msl = (long) ms * 1000;
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            if (!ms.equals(0)) {
                try {
                    str = sdf.format(msl);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }



    /**
     * 计算两个日期之间差的天数（httl模版用）
     *
     * @param ts1 时间戳1
     * @param ts2 时间戳2
     * @return
     */
    public static int caculate2Days(Integer ts1, Integer ts2) {
        Date firstDate = FormatTime.transForDate(ts1);
        Date secondDate = FormatTime.transForDate(ts2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        int dayNum1 = calendar.get(Calendar.DAY_OF_YEAR);
        calendar.setTime(secondDate);
        int dayNum2 = calendar.get(Calendar.DAY_OF_YEAR);
        return Math.abs(dayNum1 - dayNum2);
    }

    /**
     * 获取传入时间和当前时间的时间差
     *
     * @return
     */
    public static Long getTimediff(int timeStamp) {
        Date d1 = FormatTime.transForDate(timeStamp);
        Date today = new Date();
        if (d1.getTime() < today.getTime()) {
            return null;
        }
        return (d1.getTime() - today.getTime()) / 1000;
    }

    /**
     * 获取某周的第一天日期
     *
     * @param week 0 当周 1 上一周 -1 下一周
     * @return
     */
    public static String weekFirstDay(int week) {
        Calendar c1 = Calendar.getInstance();
        int dow = c1.get(Calendar.DAY_OF_WEEK);
        c1.add(Calendar.DATE, -dow - 7 * (week - 1) - 5);
        String d1 = new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime());
        return d1 + " 00:00:00";
    }

    /**
     * 当前时间加一年
     */
    public static String addYear(int startTime) {
        Date firstDate = FormatTime.transForDate(startTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDate);
        calendar.add(Calendar.YEAR, 1);
        String d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
        return d1;
    }

    /**
     * 获取某周的最后一天日期
     *
     * @param week
     * @return
     */
    public static String weekLastDay(int week) {
        Calendar c1 = Calendar.getInstance();
        int dow = c1.get(Calendar.DAY_OF_WEEK);
        c1.add(Calendar.DATE, -dow - 7 * (week - 1) + 1);
        String d1 = new SimpleDateFormat("yyyy-MM-dd").format(c1.getTime());
        return d1 + " 23:59:59";
    }

    /**
     * 和当前时间比对
     *
     * @return
     */
    public static boolean greaterThanNow(int timeStamp) {
        Date d1 = FormatTime.transForDate(timeStamp);
        Date today = new Date();
        if (d1.getTime() >= today.getTime()) {
            return true;
        }
        return false;
    }


    /**
     * HH:mm:ss格式时间转换为1970-01-01日的时间戳（也就是只有时间没有日期的情况要求使用时间戳表示时间）
     *
     * @author DingJiaCheng
     */
    public static int transFromTime(String time) {
        return transForMilliSecond("1970-01-01 " + time, "yyyy-mm-dd HH:mm:ss");
    }

    /**
     * 时间戳转换为HH：mm：ss格式时间(日期去除)
     *
     * @author DingJiaCheng
     */
    public static String transToTime(int time) {
        String s = new String(transForDate1(time));
        String ss[] = s.split(" ");
        return ss[1];
    }

    public static int transToChuo(String dateString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int res = 0;
        try {
            Date date = simpleDateFormat.parse(dateString);
            res = (int) date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

   /* public static void main(String[] args) {

        //System.out.println(getIntegralTimeEnd());
        System.out.println(transForDate2(transForMilliSecond("2015-02-25 00:00:00")));
        //System.out.println(transForMilliSecond("2016-01-25","yyyy-mm-dd"));
        //System.out.println(transForDate1(transForMilliSecond("1970-01-01 00:00:00","yyyy-mm-dd HH:mm:ss")));
        //System.out.println(currentTimeStamp());
        //System.out.println(transForDate(currentTimeStamp()));
        //System.out.println(new Date());
        //System.out.println(DateUtils.getDate());
        System.out.println(transFromTime("00:00:01"));
        System.out.println(transToTime(transFromTime("15:01:13")));
    }*/
}
