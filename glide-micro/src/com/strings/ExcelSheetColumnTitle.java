package com.strings;

public class ExcelSheetColumnTitle {
	
	public String convertToTitle(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while(columnNumber > 0){
            columnNumber--;
            char ch = (char)((columnNumber%26) + 65);
            sb.insert(0,ch);
            columnNumber = columnNumber / 26;
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
