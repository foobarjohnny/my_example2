/**
 * 16G
 * @author liujijun
 *
 */
public class ChinauUnicomCalc {
    static int[] consume = { 66, 96, 126, 156, 186, 226, 386, 586, 886 };
    static int[] iphoneProce = { 4199, 3899, 3599, 2799, 2399, 1799, 0, 0, 0 };
    static int[] prepay = { 1681, 1981, 2281, 3081, 3481, 4081, 5880, 5880, 5880 };

    static int[] back = { 70, 82, 95, 128, 145, 170, 245, 245, 245 };

    public static void main(String[] args) {

        for (int i = 0; i < 9; i++) {
            System.out.println("方案" + (i + 1) + "花费:"
                    + (( consume[i] - back[i]) * 24 + iphoneProce[i] + prepay[i]));

        }

    }
}
