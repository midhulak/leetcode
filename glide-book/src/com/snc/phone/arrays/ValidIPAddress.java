package com.snc.phone.arrays;

public class ValidIPAddress {
	
	// Time complexity: \mathcal{O}(N)O(N) because to count number of dots requires to parse the entire input string.

	// Space complexity: \mathcal{O}(1)O(1).

	
	public String validIPAddress(String IP) {
	    if(IP == null || IP.isEmpty())
	      return "Neither";

	    if(IP.indexOf(".") >= 0)
	      return validateIPv4(IP);

	    if(IP.indexOf(":") >= 0)
	      return validateIPv6(IP);

	    return "Neither";
	  }

	  private String validateIPv4(String ip) {
	     if(ip.charAt(0) == '.' || ip.charAt(ip.length()-1) == '.')
	      return "Neither";
	    String[] components = ip.split("\\.");

	    if(components.length != 4)
	      return "Neither";

	    for(String comp : components) {
	        //checking if each chunk in dots length is greater then 3 or if first digit 0 and length is greater than
	      if(comp.isEmpty() || comp.length() > 3 || (comp.charAt(0) == '0' && comp.length() > 1))
	        return "Neither";

	        //and each digit is in between  0 and 9
	      for(char ch : comp.toCharArray()) {
	        if(ch < '0' || ch > '9')
	          return "Neither";
	      }
	//once confirmed all are digits then converting and checking the num is in between 0 to 255
	      int num = Integer.parseInt(comp);
	      if(num < 0 || num > 255)
	        return "Neither";
	    }

	    return "IPv4";
	  }


	  private String validateIPv6(String ip) {
	    if(ip.charAt(0) == ':' || ip.charAt(ip.length()-1) == ':')
	      return "Neither";

	    String[] components = ip.split(":");
	    if(components.length != 8)
	      return "Neither";
	     
	     
	    for(String comp : components) {
	      if(comp.isEmpty() || comp.length() > 4)
	        return "Neither";

	      for(char ch : comp.toLowerCase().toCharArray()) {
	         // if the character is not 0 to 9 or not a , b , c , d , e or f we can return neither
	        if((ch < '0' || ch > '9') && ch != 'a' && ch != 'b' && ch != 'c' && ch != 'd' && ch != 'e' && ch != 'f')
	          return "Neither";
	      }
	    }

	    return "IPv6";
	  }

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
