//class to create and manipulate the time on a clock
public class Clock 
{
	private int hr;
	private int min;
	private int sec;
	//constructors for the clock class
	public Clock()
	{
		setTime(0,0,0);
	}
	public Clock(int hours, int minutes, int seconds)
	{
		setTime(hours, minutes, seconds);
	}
	//method to set the hours, minutes, and seconds for the clock class
	public void setTime(int hours, int minutes, int seconds)
	{
		if(0 <= hours && hours < 24)
			hr = hours;
		else
			hr = 0;
		if(0 <= minutes && minutes < 60)
			min = minutes;
		else
			min = 0;
		if(0 <= seconds && seconds < 60)
			sec = seconds;
		else
			sec = 0;
	}
	//get methods for the clock class
	public int getHours()
	{
		return hr;
	}
	public int getMinutes()
	{
		return min;
	}
	public int getSeconds()
	{
		return sec;
	}
	//method to print the time in format 00:00:00
	public void printTime()
	{
		if(hr < 10)
			System.out.print("0");
		System.out.print(hr + ":");
		if(min < 10)
			System.out.print("0");
		System.out.print(min + ":");
		if(sec < 10)
			System.out.print("0");
		System.out.print(sec);
	}
	//methods to increment seconds, minutes, and hours
	public void incrementSeconds()
	{
		sec++;
		if(sec > 59)
		{
			sec = 0;
			incrementMinutes();
		}
	}
	public void incrementMinutes()
	{
		min++;
		if(min > 59)
		{
			min = 0;
			incrementHours();
		}
	}
	public void incrementHours()
	{
		hr++;
		if(hr > 23)
			hr = 0;
	}
	//methods to decrement seconds, minutes, and hours
	public void decrementSeconds()
	{
		sec--;
		if(sec < 0)
		{
			sec = 59;
			decrementMinutes();
		}
	}
	public void decrementMinutes()
	{
		min--;
		if(min < 0)
		{
			min = 59;
			decrementHours();
		}
	}
	public void decrementHours()
	{
		hr--;
		if(hr < 0)
			hr = 23;
	}
	//method to compare clock objects
	public boolean equals(Clock otherClock)
	{
		return(hr == otherClock.hr && min == otherClock.min && sec == otherClock.sec);
	}
	//method that copies another clocks hours, minutes, and seconds into this clocks
	public void makeCopy(Clock otherClock)
	{
		hr = otherClock.hr;
		min = otherClock.min;
		sec = otherClock.sec;
	}
	//method to create another clock with this clocks hours, minutes, and seconds
	public Clock getCopy()
	{
		Clock temp = new Clock();
		temp.hr = hr;
		temp.min = min;
		temp.sec = sec;
		return temp;
	}
}
