package day03;
/**
 * �����������˰ 
 */
public class Demo06 {
	public static void main(String[] args) {
		//���룺нˮ salary
		double s = 6500;
		//�����˰��˰������
		double tax, income;
		//�㷨
		double t = s-3500;//t����Ӧ˰н��
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





