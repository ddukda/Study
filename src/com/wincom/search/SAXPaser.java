package com.wincom.search;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SAXPaser extends DefaultHandler {

	public SAXParserFactory parseFact;
	public SAXParser parser;

	public InputStream istream;
	public String startTagName;
	public boolean isEle;

	ArrayList<HashMap<String, String>> dataList = null;
	HashMap<String, String> colMap = null;

	private String sEleValues = "";
	private String sTotCnt = "0";
	private String sMaxCnt = "0";
	private String sOutCnt = "0";
	private String sPageNum = "0";

	public SAXPaser() {
	}

	public SAXPaser(InputStream istream) {
		super();
		try {
			isEle = false;
			dataList = new ArrayList<HashMap<String, String>>();
			parseFact = SAXParserFactory.newInstance();
			parser = parseFact.newSAXParser();

		} catch (Exception e) {
			System.out.println("Exception : " + e.toString());

		}

		this.istream = istream;
	}

	public void startElement(String uri, String IName, String ele,
			Attributes attributes) {

		isEle = false;
		startTagName = ele;
		sEleValues = "";

		try {
			if (startTagName.equals("att_list")) {
				colMap = new HashMap<String, String>();

			} else if (startTagName.equals("CONTNM")
					|| startTagName.equals("CNTID")
					|| startTagName.equals("TITLE")
					|| startTagName.equals("SINGER")
					|| startTagName.equals("ALBUM")
					|| startTagName.equals("ALBUM_IMG_URL")) {
				isEle = true;

			} else if (startTagName.equals("totcnt")
					|| startTagName.equals("maxcnt")
					|| startTagName.equals("outcnt")
					|| startTagName.equals("pagenum")) {
				isEle = true;

			}
		} catch (Exception e) {
			System.out.println("SAXPaser [startElement - Exception]"
					+ e.toString());
		}
	}

	public void characters(char[] ch, int start, int len) {
		try {
			if (isEle == true) {
				sEleValues = new String(ch, start, len);
			}
		} catch (Exception e) {
			System.out.println("SAXPaser [characters - Exception]"
					+ e.toString());
		}
	}

	public void endElement(String url, String localName, String qName) {
		try {
			if (isEle == true) {
				if (startTagName.equals("CONTNM")
						|| startTagName.equals("CNTID")
						|| startTagName.equals("TITLE")
						|| startTagName.equals("SINGER")
						|| startTagName.equals("ALBUM")
						|| startTagName.equals("ALBUM_IMG_URL")) {

					colMap.put(startTagName, sEleValues);

				} else if (startTagName.equals("totcnt")) {
					sTotCnt = sEleValues;
				} else if (startTagName.equals("maxcnt")) {
					sMaxCnt = sEleValues;
				} else if (startTagName.equals("outcnt")) {
					sOutCnt = sEleValues;
				} else if (startTagName.equals("pagenum")) {
					sPageNum = sEleValues;
				}
			}

			if (qName.equals("att_list")) {
				dataList.add(colMap);
			}
			isEle = false;
		} catch (Exception e) {
			System.out.println("SAXPaser [endElement - Exception]"
					+ e.toString());
		}
	}

	private int parseInt(String str) {
		if (str == null || str.trim().equals("") || str.equals("null")) {
			return 0;
		} else {
			return Integer.parseInt(str);
		}
	}

	public int getTotCnt() {
		return parseInt(sTotCnt);
	}

	public int getMaxCnt() {
		return parseInt(sMaxCnt);
	}

	public int getOutCnt() {
		return parseInt(sOutCnt);
	}

	public int getPageNum() {
		return parseInt(sPageNum);
	}

	public void parser() {
		try {
			parser.parse(istream, this);

		} catch (SAXException saxe) {
			System.out.println("SAXException : " + saxe.toString());
		} catch (Exception e) {
			System.out.println("Exception : " + e.toString());

		}
	}

	public String get(int row, String colName) {
		HashMap<String, String> map = dataList.get(row);
		Object v = map.get(colName);
		if (v == null)
			return "";
		else
			return v.toString();
	}

	public int getRowsize() {
		return dataList.size();
	}
}