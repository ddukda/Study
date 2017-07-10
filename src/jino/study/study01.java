package jino.study;

import java.io.*;
import java.util.ArrayList;
import resource.Path;

public class study01 {
	
	
	
	public static void main(String[] args) {
//		String FileHeader = "";
//		Path path = new Path();
//		String[] filepath = {"test.gif",
//				"test.bmp",
//				"test.JPG",
//				"test.PNG",
//				"test.txt",
//				"test2.txt",
//				"Blip.wav",
//				"type.wav",
//				"online.wav",
//				"TestSnd.wav",
//				"bizringctn.xls"};
//		String key="";
//		 
//		
//		for(int i=0; i < filepath.length; i++){
//			System.out.print(i + " : " + filepath[i] + " -> ");
//			FileHeader = fileToByte(path.getPath() + filepath[i]);
//		}
		
		String rst = "a";
		try{
			throw new Exception();
		}catch(Exception e){
			System.err.println(e);
			rst = "b";
		}
		System.out.println("rst = " + rst);
	}
	
	public static String fileToByte(String szFilePath) {
		byte [] b = new byte[16];
		String szFileHeader = "";
		
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(szFilePath));
			
			in.read(b);

			for(int i=0;i<b.length;i++) {
				szFileHeader += byteToHex(b[i]);
			}
			
			System.out.println(szFileHeader);
		} catch(FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		
		return szFileHeader;
	}

	public static String byteToHex(byte in) {
		byte ch = 0x00;

        String pseudo[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        StringBuffer out = new StringBuffer();

        ch = (byte) (in & 0xF0);
        ch = (byte) (ch >>> 4);
        ch = (byte) (ch & 0x0F);
        
        out.append(pseudo[ (int) ch]);
        
        ch = (byte) (in & 0x0F);
        
        out.append(pseudo[ (int) ch]);

        String rslt = new String(out);
        
        return rslt;
	}
	
	public static boolean isImageFile(String szFilePath) {
		boolean isRst = false;
		
		String szFileHeader = "";
		
		String [] szArrImgHeader = {
				"47494638", "474946383761", "474946383761", "474946383761"	// GIF Header Check-sum
				, "89504E470D0A1A0A0000000D49484452"						// PNG Header Check-sum
				, "FFD8FF"													// JPG Header Check-sum
				, "424D"													// BMP Header Check-sum
		};
		
		if(szFilePath != null && !szFilePath.equals("")) {
			szFileHeader = fileToByte(szFilePath);
			
			if(szFileHeader != null && !szFileHeader.equals("")) {
				try {
					for(int i=0;i<szArrImgHeader.length;i++) {
						int len = szArrImgHeader[i].length();
						
						if(szArrImgHeader[i].equals(szFileHeader.substring(0, len))) {
							isRst = true;

							break;
						}
					}
				} catch(NullPointerException e) {
					
				} catch(StringIndexOutOfBoundsException e) {
					
				}
			}
		}
		
		return isRst;
		
	}

}
