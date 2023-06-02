package kh.lclass;

import java.util.Arrays;

public class TestArray {
	
	public static void main(String[] args) {
			String[] strArr = new String [3];
			strArr[0] = "apple";
			strArr[1] = "banana";
			strArr[2] = new String("mango");
			// strArr을 복사할 strCopyArr 생성
			String[] strCopyArr = new String[strArr.length] ;
			for(int i=0;i<strArr.length; i++) {
				strCopyArr[i] = strArr[i];
			}
			for(int i=0; i<strArr.length; i++) {
				System.out.println(strCopyArr[i]);
			}
			strArr[2] = "oragne";
			strCopyArr[1] = "딸기";
			for(int i=0; i<strArr.length; i++) {
				System.out.println(strArr[i] + " : " + strCopyArr[i]);
			}
			System.out.println("=========");
			
			int a =10;
			int[] arrA= new int[3];
			arrA[2] =20;
			int[] arrB = arrA.clone();
			System.out.println(arrB.length);
			System.out.println(arrB[2]);
			
			System.out.println("=====Array.copyOf=====");
			String[] strCopyArr2 = Arrays.copyOf(strArr, 2); //copyOf는 3 이상도 죽지 않고 보여줌
			for(int i=0; i<strCopyArr2.length; i++) {
				System.out.println(strCopyArr2[i]);
			}
			
			System.out.println("==========");
			String[] strCopyArr3 = new String[5];
			System.arraycopy(strArr, 1, strCopyArr3, 0, 2);
			for(int i=0; i<strCopyArr3.length; i++) {
				System.out.println(strCopyArr3[i]);
			}
			
			
			String[] strArr2 = {"apple", "banana", new String("mango")};
			String[] strArr3 = {new String("apple"), new String("banana"), new String("mango")};
			String[] strArr4 = new String[] {"apple", "banana", new String("mango")};
			String[] strArr5 = new String[] {new String("apple"), new String("banana"), new String("mango")};
			//위 네개의 방식으로 초기화 가능
			
			System.out.println("strArr의 0번째 과일은" + strArr[0]);
			System.out.println("strArr의 1번째 과일은" + strArr[1]);
			System.out.println("strArr의 2번째 과일은" + strArr[2]);
			System.out.println("strArr의 2번째 과일은" + strArr[strArr.length-1]); //바로 위와 같음
			
			for(int i=0; i<strArr.length; i++) { //범위 작성시 오류를 줄이기 위해 strArr.length를 사용 
			System.out.println("strArr의 " + i + "번째 과일은 " + strArr[i]);
			System.out.printf("strArr의 %d번째 과일은 %s\n", i , strArr[i]); //strArr의 방은 string형, i는 int형 그래서 오류남
			}
			

			
			
			//오류 IndexOutOfBoundsException
			//System.out.println(strArr[3]);
			
			int[] intArr = new int[3];
			System.out.println(intArr[1]);
			
			int[] intArr2 = new int[] {1,2,3}; //방 갯수를 적으면 안됨, JVM알아서 정해줌
			int[] intArr3 = {1,2,3}; //2차원 배열때문에 구조를 new int[]와 함께 사용해주는 것이 좋음
			
			
			// Student[] studentArr = new 
	}

}
