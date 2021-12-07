package test;
//수정테스트
//수정테스트
public class Test {

	public static void main(String[] args) {

//		String new_id = "...!@BaT#*..y.abcdefghijklm";
		String new_id = "a.-";

        String Id = new_id.toLowerCase();
		
		Id = Id.replaceAll("[^a-zA-Z0-9.-_]", "");

		for(int i = 0; i < Id.length(); i++) {
			if(Id.charAt(i) == '.') {
				int j = i+1;
				String dot = ".";

				while(j != Id.length() && Id.charAt(j) == '.') {
					dot += ".";
					j++;
				}

				if(dot.length() > 1)
					Id = Id.replace(dot, ".");
			}
		}

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
            
	}

}
