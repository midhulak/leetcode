package com.snc.affirm;

public class StringCompression {
	
public int compress(char[] chars) {
        
        if(chars.length == 0)
            return 0;
        int count=1;
        char ch = chars[0];
        int result=0;
        
        for(int i=1 ; i<chars.length; i++){
            
            if(chars[i] == ch)
                count++;
            else
            {
              
                String str = count+"";
                result+= 1+str.length();
                
                ch=chars[i];
                count=1;
            }
            
        }
        
        result+=1+count;
        
        return result;
    }

public static String compress1(String s) {
    
    if(s.length() == 0)
        return "";
    int count=1;
    char ch = s.charAt(0);
    String result="";
    
    for(int i=1 ; i<s.length(); i++){
        
        if(s.charAt(i) == ch)
            count++;
        else
        {
          
           if(count == 1)
            result+= ch+"";
           else
        	   result+=ch+""+count;
            
            ch=s.charAt(i);
            count=1;
        }
        
    }
    
 
    if(count == 1)
        result+= ch+"";
       else
    	   result+=ch+""+count;
    
    return result;
}

public static String decompress(String s) {
	
	if(s.length() == 0)
		return "";
	
	int i=0;
	String result="";
	
	while(i < s.length()) {
	if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
		
		int num=0;
		int digit=1;
		char ch =s.charAt(i);
		i++;
		while(i < s.length() && s.charAt(i) > '0' && s.charAt(i) <= '9' ) {
			
			digit = num*10 + s.charAt(i) - '0';
			num+=s.charAt(i) - '0';
			
			i++;
		}
		
		for(int k=0 ; k<digit; k++) {
			result+=ch;
		}
		
	}
	
	
}
	return result;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(compress1("aaabbc"));
		System.out.println(decompress("a13b2c"));
	}

}
