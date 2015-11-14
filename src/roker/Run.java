package roker;

import java.text.SimpleDateFormat;
import java.util.Date;

import roker.Controller.CommitListener;
import Utils.Config;
public class Run {

	public static void main(String[] args) {
	final PatternModel pm =new HeadPatternModel();
	pm.drawPattern();
	int x=0;
	//pm.getModelToday(1);
	//System.out.print(Utils.subTodayAndStartDay());
	final Controller cl =Controller.getController();

	cl.setPatternModel(pm);
	pm.addCommitListener(new CommitListener() {
		
		@Override
		public void succes() {
		  pm.drawPattern(cl.getPosition());
			
		}
	});
	cl.addCommitListener(new CommitListener() {
		
		@Override
		public void succes() {
			String todayValue=Config.getKeyValue(Utils.getNowTime());
			Integer i =Integer.parseInt(todayValue);
			Integer now=i+1;
			
			Config.writeProperties(Utils.getNowTime(), now.toString());
			System.out.println("第"+cl.getPosition()+"天"+"第"+Config.getKeyValue(Utils.getNowTime())+"次提交");
			
		}
	});
	
    while(true)
    {
    	cl.start();
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	while(cl.checkTodayTask())
    	{
    		Utils.changetime();
    		
    	}
    }

	}

}