package T1k_201_300;

public class TLCP1 {

//	似乎是最弱智的题。。
    public int game(int[] guess, int[] answer) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }
    
}
