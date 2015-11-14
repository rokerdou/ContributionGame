package roker;

import java.util.ArrayList;

import roker.Controller.CommitListener;

public class ListenerContainer {
	private static ArrayList<CommitListener> list =new ArrayList<CommitListener>();
	public static void succes()
	{
		int i=0;
		for(i=0;i<list.size();i++)
		{
			if(list.get(i)!=null)
			{
				list.get(i).succes();
			}
		}
		
	}
	public static void addCommitListener(CommitListener cl)
	{
		if(cl!=null)
		list.add(cl);
	}

}
