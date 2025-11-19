import java.util.*;

public class Codec {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        char separator = '`';

        for (String str : strs) {
            sb.append(str.length());
            sb.append(separator);
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;
        char separator = '`';

        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != separator) {
                j++;
            }
            int length = Integer.parseInt(s.substring(i, j));
            j++;
            String word = s.substring(j, j + length);
            result.add(word);
            i = j + length;
        }

        return result;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        List<String> list = Arrays.asList("hello", "world", "java");

        String encoded = codec.encode(list);
        System.out.println("Encoded: " + encoded);

        List<String> decoded = codec.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
