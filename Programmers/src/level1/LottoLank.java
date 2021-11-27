package level1;
//lottos, win_nums 배열은 프로그래머스에서 테스트값을 설정해준 상태임
public class LottoLank {
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int matchCount = 0;
        int zeroCount = 0;
        
        for(int i=0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zeroCount++;
            }
            for(int j=0; j< win_nums.length; j++){
                if(win_nums[j] == lottos[i]){
                    matchCount++;
                }
            }
        }
        answer[0] = getLank(matchCount + zeroCount);
        answer[1] = getLank(matchCount);
        return answer;
    }
    public int getLank(int n){
            switch(n){
                case 0: 
                case 1:
                    return 6;
                case 2:
                    return 5;
                case 3:
                    return 4;
                case 4:
                    return 3;
                case 5:
                    return 2;
                default:
                    return 1;
            }
    }
}
