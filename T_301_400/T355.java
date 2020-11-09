package T_301_400;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class T355 {

//	设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。
//	你的设计需要支持以下的几个功能：
//	postTweet(userId, tweetId): 创建一条新的推文
//	getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
//	follow(followerId, followeeId): 关注一个用户
//	unfollow(followerId, followeeId): 取消关注一个用户
	
	
	class Tweet{
		int id;
		int time;
		Tweet next;
		public Tweet(int id,int time){
			this.id = id;
			this.time = time;
			next = null;
		}
	}
	class User{
		int userid;
		Tweet tweet;//该用户的推文链表
		Set<Integer> following = new HashSet<>();//该用户关注的用户
		
		public User(int userid){
			this.userid = userid;
		}
		
		public void addTweet(int tweetId,int time){//头插法
			Tweet cur = new Tweet(tweetId,time);
			cur.next = tweet;
			tweet = cur;
		}
		
		public boolean follow(int uid){
			if(uid==userid || following.contains(uid)) return false;
			following.add(uid);
			return true;
		}
		
		public boolean unfollow(int uid){
			if(uid==userid || !following.contains(uid)) return false;
			following.remove(uid);
			return true;
		}
	}
	class Twitter {
		int num;
		int time;
		Map<Integer,User> map;
		
	    /** Initialize your data structure here. */
	    public Twitter() {
	    	map = new HashMap<>();
	    	time = 0;
	    	num = 10;
	    }
	    
	    /** Compose a new tweet. */
	    public void postTweet(int userId, int tweetId) {
	    	if(!map.containsKey(userId)){
	    		User u = new User(userId);
	    		u.addTweet(tweetId, time++);
	    		map.put(userId, u);
	    	}else{
	    		map.get(userId).addTweet(tweetId, time++);
	    	}
	    }
	    
	    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
	    public List<Integer> getNewsFeed(int userId) {
	    	List<Integer> ans = new LinkedList<>();
	    	if(!map.containsKey(userId)) return ans;
	    	
	    	User u = map.get(userId);
	    	PriorityQueue<Tweet> pq = new PriorityQueue<>(num,new Comparator<Tweet>(){
				@Override
				public int compare(Tweet o1, Tweet o2) {
					return o1.time-o2.time;
				}
	    	});
	    	
	    	Tweet t = u.tweet;
	    	while(t!=null){
	    		if(pq.size()<num)
	    			pq.add(t);
	    		else if(t.time>pq.peek().time){
	    			pq.poll();
	    			pq.add(t);
	    		}
	    		t = t.next;
	    	}
	    	
	    	for(int follower:u.following){
		    	t = map.get(follower).tweet;
		    	while(t!=null){
		    		if(pq.size()<num)
		    			pq.add(t);
		    		else if(t.time>pq.peek().time){
		    			pq.poll();
		    			pq.add(t);
		    		}
		    		t = t.next;
		    	}
	    	}
	    	
	    	while(!pq.isEmpty()){
	    		ans.add(0,pq.poll().id);
	    	}
	    	return ans;
	    }
	    
	    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
	    public void follow(int followerId, int followeeId) {
	    	
	    	if(!map.containsKey(followerId))
	    		map.put(followerId, new User(followerId));
	    	if(!map.containsKey(followeeId))
	    		map.put(followeeId, new User(followeeId));

	    	map.get(followerId).follow(followeeId);
	    	
	    }
	    
	    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
	    public void unfollow(int followerId, int followeeId) {
	    	if(!map.containsKey(followerId))
	    		map.put(followerId, new User(followerId));
	    	if(!map.containsKey(followeeId))
	    		map.put(followeeId, new User(followeeId));

	    	map.get(followerId).unfollow(followeeId);
	    }
	}
	
}
