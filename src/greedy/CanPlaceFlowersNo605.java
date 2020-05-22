package greedy;

/**
 * @author wsh
 * @date 2020-02-27
 */
public class CanPlaceFlowersNo605 {

    public static void main(String[] args) {
        int[] flowerbed = new int[]{0,0,1,0,1,0,0};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n){
        if(flowerbed == null || flowerbed.length == 0){
            return false;
        }
        int canPlaceNum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1){
                continue;
            }
            int pre =  i - 1 >= 0 ? i - 1 : 0;
            int next = i + 1 < flowerbed.length ? i + 1 : flowerbed.length - 1;
            if(flowerbed[pre] == 0 && flowerbed[next] == 0){
                canPlaceNum++;
                flowerbed[i] = 1;
            }
        }
        return canPlaceNum >= n;
    }
}
