public class CoinChange_ii {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};

        System.out.println(change(5, arr));
    }

    /**
     * ����һ���������� coins ��ʾ��ͬ����Ӳ�ң����һ������ amount ��ʾ�ܽ�
     * ������㲢���ؿ��Դճ��ܽ���Ӳ�������������κ�Ӳ����϶��޷��ճ��ܽ����� 0 ��
     * ����ÿһ������Ӳ�������޸���
     * ��Ŀ���ݱ�֤������� 32 λ������������
     * leetcode ���ӣ�https://leetcode.cn/problems/coin-change-ii/description/
     */

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

}
