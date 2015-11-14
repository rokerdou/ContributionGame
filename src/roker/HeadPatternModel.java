package roker;

public class HeadPatternModel extends PatternModel {

	public HeadPatternModel() {
		super(9, 7);
		int i=0;
		planPattern(5,0,1,3,true);
		planPattern(5,7,1,3,true);
		model[1][0]=3;
		model[6][0]=3;
		planPattern(4,2,1,3,false);
		planPattern(6,1,6,3,false);
		model[2][3]=3;model[5][3]=3;model[3][4]=3;model[4][4]=3;
		model[0][0]=1;
		model[0][6]=1;
		model[7][0]=1;
		model[7][6]=1;
		planPattern(4,2,0,1,false);
		planPattern(7,8,0,1,true);
		FillOhter(2);
		
		
		
		
	}
	private void planPattern(int CircleNum,int startX,int startY,int deep,boolean vertical)
	{
		if(vertical)
		{
			int i =startY;
			for(;i<startY+CircleNum;i++)
			{
				model[startX][i]=deep;
				
			}
		}else
		{
			int i =startX;
			for(;i<startX+CircleNum;i++)
			{
				model[i][startY]=deep;
				
			}
		}
	}
	@Override
	public void drawPattern() {
		int y=0;
		int x=0;
		for(y=0;y<HeightY;y++)
		{
			for(x=0;x<widthX;x++)
			{
				if(model[x][y]!=2)
				{
				System.out.print(model[x][y]);
				}else
				{
					System.out.print(" ");
		
				}
			}
			if(x==widthX)
			{
				x=0;
				System.out.print("\n");
			}
		}
		
	}

}
