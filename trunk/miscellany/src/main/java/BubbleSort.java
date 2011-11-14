public class BubbleSort {
	public static void main(String[] args) {

		int[] a = { 4, 5, 2, 11, 8, 9, 12, 7 };

		int len = a.length;

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len ; j++) {
				if (a[i] > a[j]) {
					int swap = a[i];
					a[i] = a[j];
					a[j] = swap;
				}
			}
		}
		for(int i=0;i<len;i++){
			System.out.println(a[i]);
			
		}
	}
}
