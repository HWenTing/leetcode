package T_601_700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T638 {

//	在LeetCode商店中， 有许多在售的物品。
//	然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
//	现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
//	每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
//	任意大礼包可无限次购买。

//	记忆化搜索
	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>,Integer> map = new HashMap<>();
        return shopping(price, special, needs, map);
    }
    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>,Integer> map){
        if (map.containsKey(needs))
            return map.get(needs);
        int res = dot(needs, price);
        for (List<Integer> s: special) {//尝试每一种大礼包
        	int j=0;
            ArrayList<Integer> clone = new ArrayList<>(needs);
            for (; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0)
                    break;
                clone.set(j, diff);
            }
            if (j == needs.size())
                res = Math.min(res, s.get(j) + shopping(price, special, clone, map));
        }
        map.put(needs, res);
        return res;
    }
    
    
//    全部单买的价格
    public int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }
    
}
