package T1k_101_200;

public class T1185 {

//	给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
//	可以用蔡勒公式
	
//	也可以根据19710101是周五，来推测日期
    public String dayOfTheWeek(int day, int month, int year) {
    	int[] m = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    	int[] m2 = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
    	String[] weekdays = new String[]{"Friday", "Saturday","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
    	int days=0;
        for(int i=1971;i<year;i++){
        	days+=365;
        	if(i%400==0 || (i%4==0 && i%100!=0))
        		days++;
        }

        int[] cm;
        if(year%400==0 || (year%4==0 && year%100!=0))  cm=m2;
        else  cm=m;
        
        for(int i=1;i<month;i++){
        	days+=cm[i-1];
        }
        
        for(int i=1;i<day;i++)
        	days++;
        
        return weekdays[days%7];
    }
    
}
