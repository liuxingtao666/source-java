package day05;
import java.util.Arrays;
import java.util.Comparator;
/**
 * Comparator 比较器，是比较规则接口
 * 约定如何比较两个对象的大小 
 * 约定的方法叫：compare(o1, o2)
 * 返回0 表示 o1 与 o2 相等
 * 返回负数 表示 o1 小于 o2 
 * 返回正数 表示 o1 大于 o2
 */
public class Demo03 {
	public static void main(String[] args) {
		//按照字符串的长度比较大小
		// 长度一样 = 0     
		// o1 长 于 o2 = 正数
		// o1 短 于 o2 = 负数
		// 所以算法： o1.length() - o2.length()
		//<String> 泛型，这里表示被比较的类型
		Comparator<String> byLength = 
			new Comparator<String>(){
			public int compare(
					String o1, String o2) {
				//return o1.length()-o2.length();
				return o1.charAt(1)-o2.charAt(1);
			}
		};
		System.out.println(
				byLength.compare("A","BBB")); 
		String[] ary={"AAAA","BB","ax","abc"};
		//sort 方法按照byLength 规则排序
		Arrays.sort(ary, byLength);
		//将自定义比较大小的方法，委托给排序的算法
		//执行，就会得到自定义的排序结果
		System.out.println(Arrays.toString(ary)); 
	}

}



