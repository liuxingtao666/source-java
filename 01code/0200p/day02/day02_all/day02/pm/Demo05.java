package day02.pm;


public class Demo05 {
	public static void main(String[] args) {
		Integer i = new Integer(5);
		Double d = new Double(5.5);
		Number n = i;
		// Integer x = n;//�������
		Integer x = (Integer) n;
		//Double y = (Double) n;// û�б�����������쳣
		test(i);
		test(d);
	}
	public static void test(Number n){
		//�ȼ���������ͣ���ת��
		//n instanceof Double n���õĶ����Ƿ���
		// Double ���͵ģ��Ƿ���true������false
		if(n instanceof Double){
			Double d = (Double)n;
			System.out.println("������"+d); 
		}else if(n instanceof Integer){
			Integer i = (Integer)n;
			System.out.println("����"+i);
		}
	}
}
