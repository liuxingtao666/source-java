package day03;
/**
 * 计算个人所得税 
 */
public class Demo06 {
	public static void main(String[] args) {
		//输入：薪水 salary
		double s = 6500;
		//输出：税，税后所得
		double tax, income;
		//算法
		double t = s-3500;//t代表应税薪资
		if(t<=0){
			tax = 0;
		}else if(t<=1500){
			tax = t * 0.03;
		}else if(t<=4500){
			tax = t*0.1 - 105;
		}else if(t<=9000){
			tax = t*0.2 - 555;
		}else if(t<=35000){
			tax = t*0.25 - 1005;
		}else if(t<=55000){
			tax = t*0.30- 2755;
		}else if(t<=80000){
			tax = t*0.35- 5505;
		}else{
			tax = t*0.45 - 13505;
		}
		income = s - tax;
		System.out.println(income+","+tax); 
		
	}
}





