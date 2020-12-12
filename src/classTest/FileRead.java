package classTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FileRead {
	public static byte[] blank = new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 0, 100, 0, 0, 0, 100, 8, 6, 0, 0, 0, 112, -30, -107, 84, 0, 0, 0, 9, 112, 72, 89, 115, 0, 0, 11, 19, 0, 0, 11, 19, 1, 0, -102, -100, 24, 0, 0, 5, -47, 105, 84, 88, 116, 88, 77, 76, 58, 99, 111, 109, 46, 97, 100, 111, 98, 101, 46, 120, 109, 112, 0, 0, 0, 0, 0, 60, 63, 120, 112, 97, 99, 107, 101, 116, 32, 98, 101, 103, 105, 110, 61, 34, -17, -69, -65, 34, 32, 105, 100, 61, 34, 87, 53, 77, 48, 77, 112, 67, 101, 104, 105, 72, 122, 114, 101, 83, 122, 78, 84, 99, 122, 107, 99, 57, 100, 34, 63, 62, 32, 60, 120, 58, 120, 109, 112, 109, 101, 116, 97, 32, 120, 109, 108, 110, 115, 58, 120, 61, 34, 97, 100, 111, 98, 101, 58, 110, 115, 58, 109, 101, 116, 97, 47, 34, 32, 120, 58, 120, 109, 112, 116, 107, 61, 34, 65, 100, 111, 98, 101, 32, 88, 77, 80, 32, 67, 111, 114, 101, 32, 53, 46, 54, 45, 99, 49, 52, 53, 32, 55, 57, 46, 49, 54, 51, 52, 57, 57, 44, 32, 50, 48, 49, 56, 47, 48, 56, 47, 49, 51, 45, 49, 54, 58, 52, 48, 58, 50, 50, 32, 32, 32, 32, 32, 32, 32, 32, 34, 62, 32, 60, 114, 100, 102, 58, 82, 68, 70, 32, 120, 109, 108, 110, 115, 58, 114, 100, 102, 61, 34, 104, 116, 116, 112, 58, 47, 47, 119, 119, 119, 46, 119, 51, 46, 111, 114, 103, 47, 49, 57, 57, 57, 47, 48, 50, 47, 50, 50, 45, 114, 100, 102, 45, 115, 121, 110, 116, 97, 120, 45, 110, 115, 35, 34, 62, 32, 60, 114, 100, 102, 58, 68, 101, 115, 99, 114, 105, 112, 116, 105, 111, 110, 32, 114, 100, 102, 58, 97, 98, 111, 117, 116, 61, 34, 34, 32, 120, 109, 108, 110, 115, 58, 120, 109, 112, 61, 34, 104, 116, 116, 112, 58, 47, 47, 110, 115, 46, 97, 100, 111, 98, 101, 46, 99, 111, 109, 47, 120, 97, 112, 47, 49, 46, 48, 47, 34, 32, 120, 109, 108, 110, 115, 58, 120, 109, 112, 77, 77, 61, 34, 104, 116, 116, 112, 58, 47, 47, 110, 115, 46, 97, 100, 111, 98, 101, 46, 99, 111, 109, 47, 120, 97, 112, 47, 49, 46, 48, 47, 109, 109, 47, 34, 32, 120, 109, 108, 110, 115, 58, 115, 116, 69, 118, 116, 61, 34, 104, 116, 116, 112, 58, 47, 47, 110, 115, 46, 97, 100, 111, 98, 101, 46, 99, 111, 109, 47, 120, 97, 112, 47, 49, 46, 48, 47, 115, 84, 121, 112, 101, 47, 82, 101, 115, 111, 117, 114, 99, 101, 69, 118, 101, 110, 116, 35, 34, 32, 120, 109, 108, 110, 115, 58, 100, 99, 61, 34, 104, 116, 116, 112, 58, 47, 47, 112, 117, 114, 108, 46, 111, 114, 103, 47, 100, 99, 47, 101, 108, 101, 109, 101, 110, 116, 115, 47, 49, 46, 49, 47, 34, 32, 120, 109, 108, 110, 115, 58, 112, 104, 111, 116, 111, 115, 104, 111, 112, 61, 34, 104, 116, 116, 112, 58, 47, 47, 110, 115, 46, 97, 100, 111, 98, 101, 46, 99, 111, 109, 47, 112, 104, 111, 116, 111, 115, 104, 111, 112, 47, 49, 46, 48, 47, 34, 32, 120, 109, 112, 58, 67, 114, 101, 97, 116, 111, 114, 84, 111, 111, 108, 61, 34, 65, 100, 111, 98, 101, 32, 80, 104, 111, 116, 111, 115, 104, 111, 112, 32, 67, 67, 32, 50, 48, 49, 57, 32, 40, 87, 105, 110, 100, 111, 119, 115, 41, 34, 32, 120, 109, 112, 58, 67, 114, 101, 97, 116, 101, 68, 97, 116, 101, 61, 34, 50, 48, 50, 48, 45, 48, 57, 45, 48, 52, 84, 49, 55, 58, 53, 51, 58, 49, 55, 43, 48, 56, 58, 48, 48, 34, 32, 120, 109, 112, 58, 77, 101, 116, 97, 100, 97, 116, 97, 68, 97, 116, 101, 61, 34, 50, 48, 50, 48, 45, 48, 57, 45, 48, 52, 84, 49, 55, 58, 53, 51, 58, 49, 55, 43, 48, 56, 58, 48, 48, 34, 32, 120, 109, 112, 58, 77, 111, 100, 105, 102, 121, 68, 97, 116, 101, 61, 34, 50, 48, 50, 48, 45, 48, 57, 45, 48, 52, 84, 49, 55, 58, 53, 51, 58, 49, 55, 43, 48, 56, 58, 48, 48, 34, 32, 120, 109, 112, 77, 77, 58, 73, 110, 115, 116, 97, 110, 99, 101, 73, 68, 61, 34, 120, 109, 112, 46, 105, 105, 100, 58, 50, 51, 102, 52, 55, 101, 54, 102, 45, 48, 100, 55, 97, 45, 52, 99, 52, 57, 45, 98, 56, 53, 56, 45, 55, 57, 52, 100, 53, 99, 97, 56, 48, 98, 99, 49, 34, 32, 120, 109, 112, 77, 77, 58, 68, 111, 99, 117, 109, 101, 110, 116, 73, 68, 61, 34, 97, 100, 111, 98, 101, 58, 100, 111, 99, 105, 100, 58, 112, 104, 111, 116, 111, 115, 104, 111, 112, 58, 53, 56, 50, 99, 52, 100, 97, 55, 45, 56, 56, 98, 57, 45, 52, 54, 52, 57, 45, 98, 100, 101, 98, 45, 53, 52, 102, 48, 52, 56, 102, 56, 57, 97, 55, 97, 34, 32, 120, 109, 112, 77, 77, 58, 79, 114, 105, 103, 105, 110, 97, 108, 68, 111, 99, 117, 109, 101, 110, 116, 73, 68, 61, 34, 120, 109, 112, 46, 100, 105, 100, 58, 99, 102, 54, 48, 56, 56, 101, 52, 45, 99, 51, 102, 55, 45, 102, 53, 52, 51, 45, 98, 51, 48, 52, 45, 99, 55, 50, 56, 100, 100, 99, 56, 56, 49, 99, 50, 34, 32, 100, 99, 58, 102, 111, 114, 109, 97, 116, 61, 34, 105, 109, 97, 103, 101, 47, 112, 110, 103, 34, 32, 112, 104, 111, 116, 111, 115, 104, 111, 112, 58, 67, 111, 108, 111, 114, 77, 111, 100, 101, 61, 34, 51, 34, 62, 32, 60, 120, 109, 112, 77, 77, 58, 72, 105, 115, 116, 111, 114, 121, 62, 32, 60, 114, 100, 102, 58, 83, 101, 113, 62, 32, 60, 114, 100, 102, 58, 108, 105, 32, 115, 116, 69, 118, 116, 58, 97, 99, 116, 105, 111, 110, 61, 34, 99, 114, 101, 97, 116, 101, 100, 34, 32, 115, 116, 69, 118, 116, 58, 105, 110, 115, 116, 97, 110, 99, 101, 73, 68, 61, 34, 120, 109, 112, 46, 105, 105, 100, 58, 99, 102, 54, 48, 56, 56, 101, 52, 45, 99, 51, 102, 55, 45, 102, 53, 52, 51, 45, 98, 51, 48, 52, 45, 99, 55, 50, 56, 100, 100, 99, 56, 56, 49, 99, 50, 34, 32, 115, 116, 69, 118, 116, 58, 119, 104, 101, 110, 61, 34, 50, 48, 50, 48, 45, 48, 57, 45, 48, 52, 84, 49, 55, 58, 53, 51, 58, 49, 55, 43, 48, 56, 58, 48, 48, 34, 32, 115, 116, 69, 118, 116, 58, 115, 111, 102, 116, 119, 97, 114, 101, 65, 103, 101, 110, 116, 61, 34, 65, 100, 111, 98, 101, 32, 80, 104, 111, 116, 111, 115, 104, 111, 112, 32, 67, 67, 32, 50, 48, 49, 57, 32, 40, 87, 105, 110, 100, 111, 119, 115, 41, 34, 47, 62, 32, 60, 114, 100, 102, 58, 108, 105, 32, 115, 116, 69, 118, 116, 58, 97, 99, 116, 105, 111, 110, 61, 34, 115, 97, 118, 101, 100, 34, 32, 115, 116, 69, 118, 116, 58, 105, 110, 115, 116, 97, 110, 99, 101, 73, 68, 61, 34, 120, 109, 112, 46, 105, 105, 100, 58, 50, 51, 102, 52, 55, 101, 54, 102, 45, 48, 100, 55, 97, 45, 52, 99, 52, 57, 45, 98, 56, 53, 56, 45, 55, 57, 52, 100, 53, 99, 97, 56, 48, 98, 99, 49, 34, 32, 115, 116, 69, 118, 116, 58, 119, 104, 101, 110, 61, 34, 50, 48, 50, 48, 45, 48, 57, 45, 48, 52, 84, 49, 55, 58, 53, 51, 58, 49, 55, 43, 48, 56, 58, 48, 48, 34, 32, 115, 116, 69, 118, 116, 58, 115, 111, 102, 116, 119, 97, 114, 101, 65, 103, 101, 110, 116, 61, 34, 65, 100, 111, 98, 101, 32, 80, 104, 111, 116, 111, 115, 104, 111, 112, 32, 67, 67, 32, 50, 48, 49, 57, 32, 40, 87, 105, 110, 100, 111, 119, 115, 41, 34, 32, 115, 116, 69, 118, 116, 58, 99, 104, 97, 110, 103, 101, 100, 61, 34, 47, 34, 47, 62, 32, 60, 47, 114, 100, 102, 58, 83, 101, 113, 62, 32, 60, 47, 120, 109, 112, 77, 77, 58, 72, 105, 115, 116, 111, 114, 121, 62, 32, 60, 47, 114, 100, 102, 58, 68, 101, 115, 99, 114, 105, 112, 116, 105, 111, 110, 62, 32, 60, 47, 114, 100, 102, 58, 82, 68, 70, 62, 32, 60, 47, 120, 58, 120, 109, 112, 109, 101, 116, 97, 62, 32, 60, 63, 120, 112, 97, 99, 107, 101, 116, 32, 101, 110, 100, 61, 34, 114, 34, 63, 62, -72, 116, -125, -5, 0, 0, 0, -1, 73, 68, 65, 84, 120, -100, -19, -47, 65, 13, 0, 32, 16, -64, 48, -64, -65, -25, -29, -115, 2, -10, 104, 21, 44, -39, -98, -103, 69, -57, -7, 29, -64, -53, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 12, -119, 49, 36, -58, -112, 24, 67, 98, 46, -5, -51, 3, -59, 30, -70, -101, 18, 0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};
	public void read() {
		String path = "e:/ͼƬ/blank100.png";
		try {
			FileInputStream dis  = new FileInputStream(new File(path));
			byte[] bs = new byte[dis.available()];
			dis.read(bs);
			System.out.println(Arrays.toString(bs));
			dis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void test() {
		read();
	}
}
