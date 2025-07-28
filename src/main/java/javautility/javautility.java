package javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class javautility 
{
public int getrandomnumber() 
{
Random ran = new Random();
int rancount = ran.nextInt(10000);
return rancount;
}

public String getcurrentdata()
{
Date da = new Date();
SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
String currentdate = sim.format(da);
return currentdate;
}
public String togetrequaired(int days)
{
Date dat = new Date();
SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
sim.format(dat);
Calendar cal = sim.getCalendar();
cal.add(Calendar.DAY_OF_MONTH,days);
String datereq = sim.format(cal.getTime());
return datereq;
}
}
