package jino.study.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadUtil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String szFileName = "test.zip";
		File file = new File("C:\\App\\bizring\\data\\upload\\xls\\20170504\\20170504114458643.zip");
		
		
//		res.setContentType("application/octet-stream");
		res.setContentType("application/x-msdownload"); //상관없음
		res.setHeader("Content-Disposition", "attachment;filename=" + szFileName);
		res.setContentLength((int)file.length());
		res.setHeader("Content-Transfer-Encoding", "binary;");
		res.setHeader("Content-Length", "" + file.length());
		
		if(req.getParameter("flag").equals("0"))
			download_1(file,res);
		else if(req.getParameter("flag").equals("1"))
			download_2(file,res);
		else
			System.out.println("없저");
	}
	
	
	
	// ServletOutputStream
	public void download_1(File file, HttpServletResponse res) throws ServletException, IOException {
		FileInputStream fileIn = new FileInputStream(file);
		ServletOutputStream out = res.getOutputStream();
		
		byte[] outputByte = new byte[4096];
		
		while (fileIn.read(outputByte, 0, 4096) != -1)
			out.write(outputByte, 0, 4096);
		
		
		fileIn.close();
		out.flush();
		out.close();
	}
	

	// Buffer.....
	public void download_2(File file, HttpServletResponse res) throws ServletException, IOException {
		BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));  
		BufferedOutputStream outs = new BufferedOutputStream(res.getOutputStream());
		
		int read = 0; 
		byte b[] = new byte[1024];
		
		while ((read = fin.read(b)) != -1)
			outs.write(b,0,read);
		
		outs.flush();
		fin.close();
	}
}
