package roker;

import java.text.SimpleDateFormat;
import java.util.Date;

import roker.Controller.CommitListener;

public abstract  class PatternModel {
	protected int[][] model;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh");
	int days;
	int nowPosition=0;//现在在图片的位置，该位置已经绘制过了；
	int widthX;
	int HeightY;
	int [][] PositionMap;


	public PatternModel(int x,int y )
	{
		
		days=x*y;
		model =new int[x][y];
		PositionMap=new int[x][y];
		widthX=x;
		HeightY=y;
		int X=0;int Y=0;
		int d=1;
		for(;X<widthX;X++)
		{
			for(;Y<HeightY;Y++)
			{
				PositionMap[X][Y]=d++;
				model[X][Y]=-1;
				
			}
			if(Y==HeightY) Y=0;
		}

		
	}
	protected void FillOhter(int deep)
	{
		int X=0;int Y=0;
		int d=1;
		for(;X<widthX;X++)
		{
			for(;Y<HeightY;Y++)
			{
				if(model[X][Y]==-1)
				model[X][Y]=deep;
				
			}
			if(Y==HeightY) Y=0;
		}
		
	}
	

	private int getXY(int x,int y)
	{
		return model[x][y];
	}
	private  int getX(int Position)
	{
		int X=0;int Y=0;

		for(;X<widthX;X++)
		{
			for(;Y<HeightY;Y++)
			{
				if(PositionMap[X][Y]==Position)
				{
					return X;
				}
			}
			if(Y==HeightY) Y=0;
		}
		return -1;
	}
	private int getY(int Position)
	{		
		int X=0;int Y=0;

		for(;X<widthX;X++)
		{
			for(;Y<HeightY;Y++)
			{
				if(PositionMap[X][Y]==Position)
				{
					return Y;
				}
			}
			if(Y==HeightY) Y=0;
		}
		return -1;
	}

	public void addCommitListener(CommitListener ls)
	{
		ListenerContainer.addCommitListener(ls);
	}
	public int getModelToday(int nowsPosition)
	{
		
//		int i=1;
//		for(i=1;i<nowsPosition;i++)
//		{
//			 getNext();
//			
//			Refresh();
//		}
	int relativePosition = nowsPosition%(days);
	
	if(relativePosition==0)relativePosition=days;
//	System.out.println("相对位置X:"+getX(relativePosition)+"Y:"+getY(relativePosition));
	int days=model[getX(relativePosition)][getY(relativePosition)];
//		Refresh();
	//System.out.println("第"+nowsPosition+"天:"+days);
		return days;

	}

	abstract public void drawPattern();
	public void drawPattern(int Position)
	{
		int relativePosition = Position%(days);
		
		if(relativePosition==0)relativePosition=days;
		System.out.println("相对位置X:"+getX(relativePosition)+"Y:"+getY(relativePosition));
		int days=model[getX(relativePosition)][getY(relativePosition)];
//			Refresh();
		System.out.println("第"+Position+"天:"+days);
		
	}


}
