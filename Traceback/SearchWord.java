import java.util.Scanner;


/**
 * ����һ��ȫ�Ǵ�д��ĸ���ַ�������CCHNCHN���������ַ��������Ӵ�ΪCHN���Ӵ�����
 * ������� + ����
 * --û��֤--
 */
public class SearchWord {
    static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine().toUpperCase(); // ��������ַ���ת��Ϊ��д
        // �����ַ�������ÿ���ַ�Ϊ��ʼλ�ý��������������
        dfs(input, 0, 0); // ��ʼ�Ӵ�ƥ������Ϊ0


        System.out.println(count);
    }

    private static void dfs(String str, int index, int chnIndex) {
        if (chnIndex == 3) {
            count++;
            return;
        }

        // �ݹ���������������ַ�����Χ���Ѿ�����"CHN"�Ӵ�
        if (index >= str.length() || chnIndex > 3) {
            return;
        }

        // ѡ��ǰ�ַ������Ӵ�
        if (str.charAt(index) == "CHN".charAt(chnIndex)) {
            dfs(str, index + 1, chnIndex + 1); // ����ƶ�һ���ַ�������������һ���ַ�
        }

        // ��ѡ��ǰ�ַ�������������һ���ַ�
        used[index] = false;
        dfs(str, index + 1, chnIndex);
    }
}
