package caixirank.feature;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;

public class BufferedReaderHelper {
    public static Integer readInt(BufferedReader br) throws Exception {
        String line = br.readLine();
        return Integer.parseInt(line);
    }

    public static Integer[] readInts(BufferedReader br) throws Exception {
        return readInts(br, ' ');
    }

    public static Integer[] readInts(BufferedReader br, char separator) throws Exception {
        String[] line = StringUtils.split(br.readLine(), separator);
        Integer[] ints = new Integer[line.length];
        for (int i = 0; i < line.length; ++i) {
            ints[i] = Integer.parseInt(line[i]);
        }
        return ints;
    }

    public static Float[] readFloats(BufferedReader br) throws Exception {
        return readFloats(br, ' ');
    }

    public static Float[] readFloats(BufferedReader br, char separator) throws Exception {
        String[] line = StringUtils.split(br.readLine(), separator);
        Float[] floats = new Float[line.length];
        for (int i = 0; i < line.length; ++i) {
            floats[i] = Float.parseFloat(line[i]);
        }
        return floats;
    }

    public static String readAll(BufferedReader reader) throws Exception {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
