package level1;

public class NewID {
	class Solution {
	    public String solution(String new_id) {
	        String Id = new_id.toLowerCase();
			
			Id = Id.replaceAll("[^a-zA-Z0-9.-_", "");

			while(Id.indexOf("..") >= 0){
				Id = Id.replace("..", ".");
	        }
			System.out.println();
			if (Id.startsWith(".")) {
				Id = Id.substring(1);
			} else if(Id.endsWith(".")) {
				Id = Id.substring(0, Id.length()-1);
			}

			if(Id.equals("")) {
				Id = "a";
			}
			
			if(Id.length() >= 16) {
				Id = Id.substring(0, 15);
			}

			if(Id.endsWith(".")) {
				Id = Id.substring(0, Id.length()-1);
			}
	        
			if(Id.length()<=2){
	            while(Id.length()<3){
	                Id+=Id.charAt(Id.length()-1);
	            }
	        }
	            
		
	        String answer = Id;
	        return answer;
	    }
	}
}
