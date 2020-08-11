package chapter01;

import java.util.Arrays;

//import utils.ArrayAsString;

public class Case08ArrayIntroduction {

	public static void main(String[] args) {
		
		// initialize array:
		int[] arr1 = {1, 3, 5, 7, 2, 8, 6, 4, 2};
		System.out.println(arr1);
		
		int[] arr2;
		arr2 = new int[]{10, 23, 30, -10, 96};
		System.out.println(arr2);
		
		// length of array:
		int[] arr3 = new int[] {3, 6, 8, 9};
		int length = arr3.length;
		System.out.println("数组的长度为：" + length);
		
		// access array through index:
		int[] arr4 = new int[] {4, 5, 6, 8};
		int temp = arr4[2];
		arr4[2] = arr4[3];
		arr4[3] = temp;
		System.out.println(arr4);
		
		// iterate elements from array:
		for (int i = 0; i < arr4.length; i++) {
			System.out.println(arr4[i]);
		}
		
		int[] arr5 = new int[] {10, 20, 30, 40, 50};
		for (int i = (arr5.length-1); i >= 0; i--) {
			System.out.println(arr5[i]);
		}
		
		// copy array:System.arraycopy(source, srcPos, destination, destPos, length);
		int[] arr6 = {10, 20, 30, 40, 50};
		for (int i = 0; i < arr6.length; i++) {
			if (i == 0) {
				System.out.print("[" + arr6[i] + ", ");
			} else if (i == (arr6.length - 1)) {
				System.out.print(arr6[i] + "]");
			} else {
				System.out.print(arr6[i] + ", ");
			}
		}
		System.out.print("\n");
		int[] arr7 = new int[6];
		for (int i = 0; i < arr7.length; i++) {
			if (i == 0) {
				System.out.print("[" + arr7[i] + ", ");
			} else if (i == (arr7.length - 1)) {
				System.out.print(arr7[i] + "]");
			} else {
				System.out.print(arr7[i] + ", ");
			}
		}
		System.out.print("\n");
		System.arraycopy(arr6, 1, arr7, 0, 4);
		for (int i = 0; i < arr7.length; i++) {
			if (i == 0) {
				System.out.print("[" + arr7[i] + ", ");
			} else if (i == (arr7.length - 1)) {
				System.out.print(arr7[i] + "]");
			} else {
				System.out.print(arr7[i] + ", ");
			}
		}
		
		// Arrays.copyOf
		int[] arr8 = {100, 200, 300, 400, 500};
		int[] arr9 = Arrays.copyOf(arr8, 6);
		System.out.print("\narr9: ");
		for (int i = 0; i < arr9.length; i++) {
			if (i == 0) {
				System.out.print("[" + arr9[i] + ", ");
			} else if (i == (arr9.length - 1)) {
				System.out.print(arr9[i] + "]");
			} else {
				System.out.print(arr9[i] + ", ");
			}
		}
		
		// array dilatation:
		int[] arr10 = {21, 23, 25, 27, 29};
		int[] arr11 = Arrays.copyOf(arr10, arr10.length + 2);
		System.out.print("\narr11: ");
		for (int i = 0; i < arr11.length; i++) {
			if (i == 0) {
				System.out.print("[" + arr11[i] + ", ");
			} else if (i == (arr11.length - 1)) {
				System.out.print(arr11[i] + "]");
			} else {
				System.out.print(arr11[i] + ", ");
			}
		}
		
		// sort array:
//		int[] arr12 = {10, 34, 55, 3, 89, 12, 51, 14, 37, 18, 9};
//		Arrays.sort(arr12);
//		System.out.print("\narr12: ");
//		ArrayAsString.printArray(arr12);
	}

}
