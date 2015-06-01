package cn.itcast.utils;

public class RandomUtils
{
	public static int Random1to10()
	{
		int number = (int)(Math.random()*10+1);
		return number;
	}
}
