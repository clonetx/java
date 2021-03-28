package com.neuedu.demo.controller;

import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;


public class HttpGetTest {
	// Httpget传递参数
	public static void psvm() {
		// TODO Auto-generated method stub
		try {
			URIBuilder builder = new URIBuilder(
					"http://192.168.1.102:8090/api/test/first");
			builder.setParameter("idNumber", "220422199311000000");
			builder.setParameter("name", "twodogs");
			HttpGet hget = new HttpGet(builder.build());
			hget.addHeader("content-Type", "application/json;charset=UTF-8");
			HttpClient hClient = HttpClients.createDefault();
			HttpResponse hResponse = hClient.execute(hget);
			String res = EntityUtils.toString(hResponse.getEntity());
			System.out.println(res);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		HttpGetTest.psvm();
		HttpGetTest.psvm1();
		HttpGetTest.testPost();
		;

	}

	// Httpget不涉及参数
	public static void psvm1() {
		try {
			HttpGet hGet = new HttpGet("http://192.168.1.102:8090/api/test");
			hGet.addHeader("contest-Type", "Application/json;charset=UTF-8");
			HttpClient hClient = HttpClients.createDefault();
			HttpResponse response = hClient.execute(hGet);
			String resString = EntityUtils.toString(response.getEntity());
			System.out.println(resString);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void testPost() {
		try {
			HttpPost hPost = new HttpPost(
					"http://192.168.1.102:8090/api/test/second");
			JSONObject object = new JSONObject();
				object.put("sign", "12312");
				JSONObject params = new JSONObject();
				
				params.put("idNumber", "220422199312121212");
				params.put("name", "wrewtr");
				object.put("params", params);
			StringEntity sEntity = new StringEntity(object.toString());
			// String
			// datajson={sign:12,params:{idNumber:220422199312121212,name:12}};
			sEntity.setContentType("application/json");
			hPost.setEntity(sEntity);
			CloseableHttpClient cHttpClient = HttpClients.createDefault();
			CloseableHttpResponse cResponse = cHttpClient.execute(hPost);
			String re = EntityUtils.toString(cResponse.getEntity());
			System.out.println(re);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}