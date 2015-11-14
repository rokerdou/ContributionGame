package roker;
import Utils.*;
public class Controller {
	int map[]={0,0,1,2,3,4};
	private PatternModel pm;
	public void setPatternModel(PatternModel p)
	{
		pm=p;
	}
	public interface CommitListener
	{
		public abstract void succes();
		
	}
	private static Controller con=new Controller()
	{
		
	};
	private Controller()
	{
		
	};
	public static Controller getController()
	{
		return con;
	}
	private CommitListener cl;
	public void addCommitListener(CommitListener commitListener)
	{
	  ListenerContainer.addCommitListener(commitListener);
	}
	public CommitListener getCommitListener()
	{
		return cl;
	}
	public int getPosition()
	{
		return Utils.subTodayAndStartDay()+1;
	}
	public void start()
	{
		int position =Utils.subTodayAndStartDay()+1;
		System.out.println("Ïà²î"+position+"Ìì");
		String todayValue=Config.getKeyValue(Utils.getNowTime());
		int todayCountNow;
		if(todayValue!=null)
		{
		    todayCountNow=Integer.parseInt(todayValue);
			
		}
		else
		{
			todayCountNow=0;
			Config.writeProperties(Utils.getNowTime(), "0");
		}
		
		int todayCountNeeds=map[pm.getModelToday(position)];

		if(todayCountNeeds-todayCountNow>0)
		CommitTask(todayCountNeeds-todayCountNow);
		
	}
	private void CommitTask(int count)
	{
		int i=0;
		for(i=0;i<count;i++)
		{
			
			Utils.commitCodeToGithub();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean checkTodayTask()
	{
		int position =Utils.subTodayAndStartDay()+1;
		String todayValue=Config.getKeyValue(Utils.getNowTime());
		if(todayValue!=null)
		{
		   int todayCountNow=Integer.parseInt(todayValue);
		   int todayCountNeeds=map[pm.getModelToday(position)];
		   if(todayCountNow>=todayCountNeeds) return true;
		   
			
		}
		return false;
		
	}


}
