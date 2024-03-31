import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(compressArray(input));
    }

    public static String compressArray(String s) {
        StringBuilder output = new StringBuilder("[");
        int i = 0;
        while (i < s.length()) {
            // 找到数字的起始位置
            int digitStart = i;
            while (digitStart < s.length() && !Character.isDigit(s.charAt(digitStart))) {
                digitStart++;
            }
            // 找到数字的结束位置
            int digitEnd = digitStart;
            while (digitEnd < s.length() && Character.isDigit(s.charAt(digitEnd))) {
                digitEnd++;
            }
            // 获取数字子字符串，并解析为整数
            int value = Integer.parseInt(s.substring(digitStart, digitEnd));

            // 找到次数的起始位置
            int countStart = i;
            while (i < s.length() && !Character.isDigit(s.charAt(i))) {
                i++;
            }
            // 找到次数的结束位置
            int countEnd = i;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                i++;
            }
            // 获取次数子字符串，并解析为整数，跳过方括号
            int count = Integer.parseInt(s.substring(countStart + 1, countEnd - 1));

            if (output.length() > 1) {
                output.append(",");
            }
            output.append(value).append("(").append(count).append(")");
            i++; // 跳过逗号
        }
        output.append("]");
        return output.toString();
    }
}
