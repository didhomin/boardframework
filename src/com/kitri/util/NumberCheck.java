package com.kitri.util;

public class NumberCheck {

	
	public static int nullToZero(String tmp) {
		int num = 0;
		if(isNumber(tmp))
			num= Integer.parseInt(tmp);
		return num;
	}
	public static int nullToOne(String tmp) {
		int num = 1;
		if(isNumber(tmp))
			num= Integer.parseInt(tmp);
		return num;
	}

	private static boolean isNumber(String tmp) {
			boolean flag = true;
//			if(tmp!=null) {
//				byte b[] = tmp.getBytes();
//				int len = b.length;
//				for (int i = 0; i < len; i++) {
//					if(b[i]<48 || b[i]>57) {
//					flag=false;
//					break;
//					}
//				}
//			} else {
//				flag = false;
//			}
			if(tmp!=null && !tmp.isEmpty()) {
				int len =tmp.length();
				for (int i = 0; i < len; i++) {
					int asc = tmp.charAt(i);
					if(asc<48 || asc> 57) {
						flag=false;
						break;
					}
				}
			}else {
				flag = false;
						//48보다작고 57보다큰
			}
		return flag;
	}

	
}