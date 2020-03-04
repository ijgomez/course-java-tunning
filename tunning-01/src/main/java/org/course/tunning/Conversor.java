package org.course.tunning;

public class Conversor {

	public static int convert(byte input[], int byteStart, int byteEnd, char output[], int charStart, int charEnd) throws Exception {
		int charOff = charStart;
		for (int byteOff = byteStart; byteOff < byteEnd;) {
			if (charOff >= charEnd)
				throw new Exception();
			
			int i1 = input[byteOff++];
			if (i1 >= 0)
				output[charOff++] = (char) i1;
			else
				output[charOff++] = (char) (256 + i1);
		}
		return charOff - charStart;
	}

}
