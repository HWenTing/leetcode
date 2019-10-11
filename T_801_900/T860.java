package T_801_900;

public class T860 {

//	在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
//	顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
//	每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
//	注意，一开始你手头没有任何零钱。
//	如果你能给每位顾客正确找零，返回 true ，否则返回 false 。

//	讨论呗
    public boolean lemonadeChange(int[] bills) {
        int cnt5 = 0;
        int cnt10 = 0;
        
        for(int coin : bills){
        	switch(coin){
        	case 5:
        		cnt5++;
        		break;
        	case 10:
        		cnt10++;
        		if(cnt5==0)
        			return false;
        		cnt5--;
        		break;
        	default:
        		if(cnt5==0)
        			return false;
        		else{
        			if(cnt10==0){
        				if(cnt5<3)
        					return false;
        				else{
        					cnt5-=3;
        				}
        			}else{
        				cnt10--;
        				cnt5--;
        			}
        		}
        	}
        }
        return true;
    }
    
}
