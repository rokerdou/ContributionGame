package roker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Utils.Config;


public class Utils {

	public static String getNowTime()
	{
	        
	        Date dt = new Date();
	        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        return sdf.format(dt);
	}
	public static void changetime()
	{
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			Date dt=sdf.parse(getNowTime());
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(dt);
			rightNow.add(Calendar.DAY_OF_YEAR, 1);
			System.out.println("时间更改为:"+sdf.format(rightNow.getTime()));
			String cmd ="cmd /c date "+sdf.format(rightNow.getTime());
			Runtime.getRuntime().exec(cmd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void commitCodeToGithub()
	{
		BufferedReader br = null;

			
		Process pr;

	     Process p=null;  
	     Runtime r=Runtime.getRuntime();  
	        try{  
	        	Date nowTime=new Date(); 
	        	System.out.println(nowTime); 
	        	SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss"); 
	        	System.out.println(time.format(nowTime)); 
	            String path =Config.getKeyValue("path")+" "+time.format(new Date())+"自动提交";  
	     p = r.exec("cmd.exe /c  "+path);  
	 
	     StreamGobbler errorGobbler = new StreamGobbler(p.getErrorStream(), "ERROR");           
	            errorGobbler.start();  
	            StreamGobbler outGobbler = new StreamGobbler(p.getInputStream(), "STDOUT");  
	            outGobbler.start();  
	     p.waitFor();  
	    }catch(Exception e){   
	            System.out.println("运行错误:"+e.getMessage());  
	            e.printStackTrace();   
	   }  
	        
    }  
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
    public static int subTodayAndStartDay() 
    {
    	String startday=Config.getKeyValue("startDate");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Date d1;
		try {
			d1 = sdf.parse(startday);
 
        Date d2=new Date();
        
		return daysBetween(d1,d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1; 
    }
/** 
*字符串的日期格式的计算 
 * @throws ParseException 
*/  
    public static int daysBetween(String smdate,String bdate) throws ParseException {  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }  
}
