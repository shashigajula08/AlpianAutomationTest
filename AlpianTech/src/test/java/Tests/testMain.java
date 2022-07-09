package Tests;

public class testMain {

	public static void main(String[] args) {
	
		
		String str = "123456";
		String sTemp="";
		
		for(int i=0; i<=str.length()-1;i++) {
			//System.out.println(str.substring(i, i+1));
			sTemp = str.substring(i, i+1)+sTemp ;
			
		}
		System.out.println(sTemp);

	}

}
