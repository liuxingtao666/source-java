package day02;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Demo12 {
	public static void main(String[] args) {
		printCal(2014, 3);
	}
	public static void printCal(
			int year, int month){
		System.out.println(year+"��"+month+"��");
		System.out.println("�� һ �� �� �� �� ��");
		//��ȡ��ǰ��ʱ��
		Calendar cal = new GregorianCalendar();
		//�޸ĵ�ǰʱ�䵽���³��ĵ�һ��
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
	//�޸�ʱ�䵽���³��ĵ�һ�ܵĵ�һ�죬
		//����һ�ܵ�����Ϊ��ʼ
		cal.set(Calendar.WEEK_OF_MONTH, 1);
		cal.set(Calendar.DAY_OF_WEEK, 
				Calendar.SUNDAY);
		//SimpleDateFormat fmt = new SimpleDateFormat();
		//System.out.println(fmt.format(cal.getTime()));
		//ѭ����������Ǳ����·�Ϊֹ��
		//ע��: Calendar���·��Ǵ�0��ʼ������ 3��ֵ��2
		while(cal.get(Calendar.MONTH)<month){
			//�·�
			int mon = cal.get(Calendar.MONTH)+1;
			//����
			int day = cal.get(Calendar.DAY_OF_MONTH);
			//����
			int dayOfWeek = 
				cal.get(Calendar.DAY_OF_WEEK);
			if(mon!=month){
			//���Ǳ�������ո�
				System.out.print("   ");
			}else{
				if(day<10){
					//��λ�� �� һ���ո�
					System.out.print(" ");
				}
				//������µ�����
				System.out.print(day+" ");
			}
			//������������� ������س�
			if(dayOfWeek==Calendar.SATURDAY){
				System.out.println();
			}
			//����һ�죬�������
			cal.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
}



