import java.util.Scanner;


/**
 * 输入一个全是大写字母的字符串：如CCHNCHN，输出这个字符串所有子串为CHN的子串个数
 * 深度搜索 + 回溯
 * --没验证--
 */
public class SearchWord {
    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toUpperCase(); // 将输入的字符串转换为大写
        // 遍历字符串，以每个字符为起始位置进行深度优先搜索
        dfs(input, 0, 0); // 初始子串匹配索引为0


        System.out.println(count);
    }

    private static void dfs(String str, int index, int chnIndex) {
        if (chnIndex == 3) {
            count++;
            return;
        }

        // 递归结束条件：超出字符串范围或已经包含"CHN"子串
        if (index >= str.length() || chnIndex > 3) {
            return;
        }

        // 选择当前字符加入子串
        if (str.charAt(index) == "CHN".charAt(chnIndex)) {
            dfs(str, index + 1, chnIndex + 1); // 向后移动一个字符，继续搜索下一个字符
        }

        // 不选择当前字符，继续搜索下一个字符
        used[index] = false;
        dfs(str, index + 1, chnIndex);
    }
}
