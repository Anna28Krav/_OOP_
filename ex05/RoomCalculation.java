package ex05;


import java.io.*;

public class RoomCalculation {
    public int calculatePerimeter(int length, int width) {
        return 2 * (length + width);
    }

    public int calculateArea(int length, int width) {
        return length * width;
    }

    public int calculateVolume(int length, int width, int height) {
        return length * width * height;
    }
}

