package com.snc.strings;

/**https://leetcode.com/problems/validate-ip-address/

Medium
**/
public class ValidateIPAddress {
	
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
		      //first index shud not start with dot and last index shud not end with dot
		     if(ip.charAt(0) == '.' || ip.charAt(ip.length()-1) == '.')
		      return "Neither";
		    String[] components = ip.split("\\.");
		//dotted array length shud not be exceed 4
		    if(components.length != 4)
		      return "Neither";
		//the value is either empty or length greater than 3 or starts with 0 or after 0 is there any number
		    for(String comp : components) {
		      if(comp.isEmpty() || comp.length() > 3 || (comp.charAt(0) == '0' && comp.length() > 1))
		        return "Neither";

		        //checking the numbers is in between 0 to 9 
		      for(char ch : comp.toCharArray()) {
		        if(ch < '0' || ch > '9')
		          return "Neither";
		      }
		//checking if it is numric it shud be between 0 to 255
		      int num = Integer.parseInt(comp);
		      if(num < 0 || num > 255)
		        return "Neither";
		    }

		    return "IPv4";
		  }


		  private String validateIPv6(String ip) {
		      
		      //first index shud not start with dot and last index shud not end with dot
		    if(ip.charAt(0) == ':' || ip.charAt(ip.length()-1) == ':')
		      return "Neither";

		      //length after split shud be greater tahn 8
		    String[] components = ip.split(":");
		    if(components.length != 8)
		      return "Neither";
		     
		      //length of each split shud not exceed more than 4
		     for(String comp : components) {
		      if(comp.isEmpty() || comp.length() > 4)
		        return "Neither";

		         //it shud contain 0 to 9 atof if not there return neither.
		         
		      for(char ch : comp.toLowerCase().toCharArray()) {
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
