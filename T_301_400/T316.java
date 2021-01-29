package T_301_400;

public class T316 {

	public String removeDuplicateLetters(String s) {
		int[] cnt = new int[26];
		for (char c : s.toCharArray())
			cnt[c - 'a']++;

		StringBuilder sb = new StringBuilder();
		boolean[] vis = new boolean[26];
		for (char c : s.toCharArray()) {
			if (vis[c - 'a']) {
				cnt[c - 'a']--;
				continue;
			}
			while (sb.length() > 0 && cnt[sb.charAt(sb.length() - 1) - 'a'] > 0 && sb.charAt(sb.length() - 1) > c) {
				vis[sb.charAt(sb.length() - 1) - 'a'] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
			vis[c - 'a'] = true;
			cnt[c - 'a']--;
			sb.append(c);
		}
		return sb.toString();

	}

}
