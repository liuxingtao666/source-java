package day07;
/**
 *f(n) = 1+2+3+...+n = n+f(n-1) ���� f(1)=1
  f(n) = n+f(n-1) ���� f(1)=1 ��Ϊ�ݹ鶨��
 */
public class Demo02 {
	public static void main(String[] args) {               
		int n = 50000;
		int y = f(n);
		System.out.println(y); 
	}
	public static int f(int n){
		if(n==1){//�ݹ��������
			return 1;
		}//     �ݹ����
		return n + f(n-1);
	}
}
