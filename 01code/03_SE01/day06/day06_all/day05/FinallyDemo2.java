package day05;
/**
 * Finally≤‚ ‘
 * @author Administrator
 *
 */
public class FinallyDemo2 {
	public static void main(String[] args) {
		System.out.println(
			test(null) + "," +
			test("") + "," +
			test("0")
		);	
	}
	
	public static int test(String str){
		try {
			return '0'-str.charAt(0);
		} catch (NullPointerException e) {
			return 1;
		} catch (RuntimeException e){
			return 2;
		} catch (Exception e){
			return 3;
		} finally{
			return 4;
		}
	}
	
}



