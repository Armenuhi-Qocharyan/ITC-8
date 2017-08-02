package actions;

public class Operations {
	public int[] sum(int[] arr1, int[] arr2) {
		int maxLength = arr1.length >= arr2.length ? arr1.length : arr2.length;
		int[] results = new int[maxLength];
		for(int i = 0; i < maxLength; ++i) {
			if(i < arr1.length && i < arr2.length) {
				results[i] = arr1[i] + arr2[i];
			} else if(i >= arr1.length) {
				results[i] = arr2[i];
			} else {
				results[i] = arr1[i];
			}
		}
		return results;
	}
//	public int[] mult(int[] arr1, int[] arr2) {
//		if(arr1.length != arr2)
//     		int[] result = new int[maxArr.length];
//		for(int i = 0; i < maxArr.length; ++i) {
//			if(i < minArr.length) {
//				result[i] = minArr[i] + maxArr[i];
//			} else {
//				result[i] = maxArr[i];
//			}
//		}
//		return result;
//	}
	
	
}
