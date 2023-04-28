package tw.org.iii.myclasses;

public class taiwanId {
	//Every class contains constructor
	
	private String id;
	static String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO"; 
	//static: to be independent of the object
	
	public String getId() {
		return id;
	}
	// the first line in constructor is used to inherit
	// all your father, grandfather...etc
	
	// note that the first line must be "super" or "this"
	public taiwanId(){
		this((int)Math.random()*2 == 0); //this: the object we'll new in future
	}
	public taiwanId(boolean isMale) {
		this(isMale, (int)(Math.random()*26));
	}
	public taiwanId(int area){
		this((int)(Math.random()*2)==0, area);
	}
	public taiwanId(boolean isMale, int area){
		String s1 = letters.substring(area, area+1);
		StringBuilder sb = new StringBuilder(s1);
		//while String object being constructed, the content is unchangeable!!
		sb.append(isMale?"1":"2");
		for(int j=0;j<7;j++) {
			sb.append((int)(Math.random()*10));
		}
		String temp = sb.toString();
		for(int k=0;k<10;k++) {
			if(checkId(temp+k)) {
				id = temp + k;
			}
		}

	}
	private taiwanId(String id){
		this.id = id;
	}
	
	public static taiwanId createId(String id) {
		taiwanId twId = null;
		if(checkId(id)) {
			twId = new taiwanId(id);
		}
		return twId;
		
	}
	
	
	
	

	public static boolean checkId(String id) {	
		if(id.length() != 10) {
			return false;
		}
		if(id.matches("[A-Z][1,2]([0-9]){8}")) {
			
		} else {
			return false;
		}
		String region = id.substring(0,1);
		int num = Integer.parseInt(id.substring(1));
		String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
		int i = letters.indexOf(region)+10;

		int sum = i/10 + num%10 + (num%100)/10
				+ (i%10) *9
				+ num/(100000000) %10 *8
				+ num/(10000000) %10 *7
				+ num/(1000000) %10 *6
				+ num/(100000) %10 *5
				+ num/(10000) %10 *4
				+ num/(1000) %10 *3
				+ num/(100) %10 *2;

		if(sum%10==0) {
			return true;
		} else {
			return false;
		}

	}
}
