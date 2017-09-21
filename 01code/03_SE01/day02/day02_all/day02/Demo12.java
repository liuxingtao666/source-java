package day02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Demo12 {
	public static void main(String[] args) {
		printCal(2014, 3);
	}
	public static void printCal(
			int year, int month){
		System.out.println(year+"年"+month+"月");
		System.out.println("日 一 二 三 四 五 六");
		//获取当前的时间
		Calendar cal = new GregorianCalendar();
		//修改当前时间到本月初的第一天
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
	//修改时间到本月初的第一周的第一天，
		//是上一周的周日为开始
		cal.set(Calendar.WEEK_OF_MONTH, 1);
		cal.set(Calendar.DAY_OF_WEEK, 
				Calendar.SUNDAY);
		//SimpleDateFormat fmt = new SimpleDateFormat();
		//System.out.println(fmt.format(cal.getTime()));
		//循环输出到不是本月月份为止，
		//注意: Calendar的月份是从0开始计数的 3月值是2
		while(cal.get(Calendar.MONTH)<month){
			//月份
			int mon = cal.get(Calendar.MONTH)+1;
			//日期
			int day = cal.get(Calendar.DAY_OF_MONTH);
			//星期
			int dayOfWeek = 
				cal.get(Calendar.DAY_OF_WEEK);
			if(mon!=month){
			//不是本月输出空格
				System.out.print("   ");
			}else{
				if(day<10){
					//单位数 补 一个空格
					System.out.print(" ");
				}
				//输出本月的日期
				System.out.print(day+" ");
			}
			//如果星期是周六 就输出回车
			if(dayOfWeek==Calendar.SATURDAY){
				System.out.println();
			}
			//增加一天，继续输出
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}



