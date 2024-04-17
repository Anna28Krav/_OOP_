package ex06;

import java.util.concurrent.Callable;

public class Calculation {
    public int toDecimal(int binary) {
        return Integer.parseInt(String.valueOf(binary), 2);
    }

    public int calculatePerimeter(int length, int width) {
        return 2 * (length + width);
    }

    public int calculateArea(int length, int width) {
        return length * width;
    }

    public int calculateVolume(int length, int width, int height) {
        return length * width * height;
    }

    public static int countOnesInBinary(int length, int width, int height) {
        int perimeter = 2 * (length + width);
        int area = length * width;
        int volume = length * width * height;

        int sum = perimeter + area + volume;
        String binary = Integer.toBinaryString(sum);
        int countOnes = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                countOnes++;
            }
        }
        
        System.out.print("Двійковий вигляд: " + binary + "\n");
        System.out.print("Кількість одиниць: " + countOnes + "\n");

        return countOnes;
    }
}
