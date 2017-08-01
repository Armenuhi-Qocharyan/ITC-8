import java.util.Scanner;
import java.lang.Math;

public class Array {
    // Constructor
    public Array(int size) {
        mSize = (size > 0) ? size : 0;
        mArr = new int[mSize];
    }
    
    // Methods
    public void setArray() {
        Scanner reader = new Scanner(System.in);  
        for (int i = 0; i < mSize; ++i) {
            System.out.print("arr[" + i +"]= ");
            mArr[i] = reader.nextInt(); 
        }
    }

    public void print() {
        System.out.print("Array: ");
        for (int i = 0; i < mSize; ++i) {
            System.out.print(mArr[i] + "  ");
        }
        System.out.println();
    }

    public int getElement(int index) {
        return (index < mSize && index >= 0) ? mArr[index] : 0;
    }

    public Array add(Array other) {
        int len = Math.max(mSize, other.mSize);
        Array result = new Array(len);
        for (int i = 0; i < len; ++i) {
            result.mArr[i] = getElement(i) + other.getElement(i);
        }
        return result; 
    }

    public Array diff(Array other) {
        int len = Math.max(mSize, other.mSize);
        Array result = new Array(len);
        for (int i = 0; i < len; ++i) {
            result.mArr[i] = getElement(i) - other.getElement(i);
        }
        return result; 
    }

    public Array mult(Array other) {
        Array result = new Array(mSize);
        for (int i = 0; i < mSize; ++i) {
            result.mArr[i] = 0;
            for (int j = 0; j < other.mSize; ++j) {
                result.mArr[i] += mArr[i] * other.mArr[j];
            } 
        }
        return result;
    }
    
    // Fields
    private int[] mArr;
    private int mSize;
}
