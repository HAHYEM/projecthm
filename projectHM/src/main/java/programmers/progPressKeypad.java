package programmers;

public class progPressKeypad {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		int left = 10, right = 12;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
            	answer += "L";
            	left = numbers[i];
            } else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
            	answer += "R";
            	right = numbers[i];
            } else {
            	numbers[i] = numbers[i] == 0 ? 11 : numbers[i];
            	
            	int leftTo = findWay(numbers[i] - left);
            	int rightTo = findWay(numbers[i] - right);
            	
            	if(leftTo < rightTo) {
            		answer += "L";
            		left = numbers[i];
            	} else if(leftTo > rightTo) {
            		answer += "R";
            		right = numbers[i];
            	} else {
            		if(hand.equals("right")) {
            			answer += "R";
                		right = numbers[i];
            		} else {
            			answer += "L";
                		left = numbers[i];
            		}
            	}
            }
        }
        return answer;
    }
	
	public int findWay(int n) {
		n = Math.abs(n);
		
		if(n == 0) {
			return 0;
		}else if(n == 1 || n == 3) {
			return 1;
		}else if(n == 2 || n == 4 || n == 6) {
			return 2;
		}else if(n == 5 || n == 7 || n == 9) {
			return 3;
		}else {
			return 4;
		}
	}
}
