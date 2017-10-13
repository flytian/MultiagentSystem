package ua.vasylenko.main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * ���������� ��������� ����������� Jsoup. 
 * @Created by Ҹ�� on 11.09.2017.
 * @version 1.0
 */
public interface UrlConnectable {
	
	/**
	 * ����� ����������� � �����.
	 * @param url ������� ������ �� �������� �����.
	 * @return �������� ��� ���������.
	 * @throws MalformedURLException ���� ����� ������ �������.
	 * @throws IOException ������ �����/������.
	 * @throws URISyntaxException ���� ������������ ������������ URI.
	 */
	static Document connectToUrl(String url) throws MalformedURLException, IOException, URISyntaxException {
		Document htmlDocument = Jsoup.connect(new URL(url).toURI().toASCIIString())
				.userAgent("Mozilla")
				.timeout(10 * 1000).get();
		
		return htmlDocument;
	}
	
}
