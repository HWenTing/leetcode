package Tc_contest;

import java.util.Calendar;

public class W149_1154 {


//    public int dayOfYear(String date) {
//    	String[] time = date.split("-");
//    	Calendar cn = Calendar.getInstance();
//    	Calendar cf = Calendar.getInstance();
//    	cn.set(Integer.parseInt(time[0]), Integer.parseInt(time[1])-1, Integer.parseInt(time[2]),0,0,0);
//    	cf.set(Integer.parseInt(time[0])-1,11,31,0,0,0);
//    	return (int)((cn.getTime().getTime()-cf.getTime().getTime())/(3600000*24))+1;
//    }
    
    public int dayOfYear(String date) {
    	int y,m,d;
    	int ans=0;
    	int[] month = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    	String[] time = date.split("-");
    	y=Integer.parseInt(time[0]);
    	m=Integer.parseInt(time[1]);
    	d=Integer.parseInt(time[2]);
    	
    	
    	if(m>2 && check(y))//加润
    		ans++;
		while(--m>0)//加月
			ans+=month[m-1];
		ans+=d;//加天
    	return ans;
		
    }
    
    private boolean check(int year){//能被400整除或者（被4整除但100不整除）
    	if(year%400==0 || (year%4==0 && year%100!=0) )
    		return true;
    	return false;
    }
    
	public static void main(String[] args) {
		W149_1154 t = new W149_1154();
		System.out.println(t.dayOfYear("2004-03-01"));
	}

}
