package day05;

import java.util.Arrays;

public class Demo09 {
	public static void main(String[] args) {
		String[] hotel = 
			{"Tom","Andy","Jerry","John","Wang"};
		int index =Arrays.binarySearch(
				hotel, "Jerry");
		System.out.println(index);//2
		index =Arrays.binarySearch(
				hotel, "Tom");
		System.out.println(index);//?
		//≈≈–Ú“‘∫Û≤È’“
		Arrays.sort(hotel);
		System.out.println(Arrays.toString(hotel));
		index=Arrays.binarySearch(hotel, "Tom");
		System.out.println(index);
		index=Arrays.binarySearch(hotel, "Andy");
		System.out.println(index);
		index=Arrays.binarySearch(hotel, "Lee");
		System.out.println(index);
		
		
		
	}

}
