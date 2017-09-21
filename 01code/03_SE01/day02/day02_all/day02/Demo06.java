package day02;
/**
 * StringBuilder
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		StringBuilder buf = new StringBuilder();
		//append 追加，向StringBuilder对象追加字符数据
		buf.append("李敖先生是一个牛x的人");
		//          0 1 2 3 4 5 6 7 89 10
		buf.replace(2, 4, "大师");//替换字符
		System.out.println(buf);//默认调用toString
	}
}


