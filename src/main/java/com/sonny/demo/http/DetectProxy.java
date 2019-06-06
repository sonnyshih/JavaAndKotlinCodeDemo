package com.sonny.demo.http;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;


public class DetectProxy {

	public static void main(String[] args) {
		System.setProperty("java.net.useSystemProxies", "true");
		System.out.println("detecting proxies");
		List l = null;
		try {
		    l = ProxySelector.getDefault().select(new URI("http://10.16.10.150"));
		} 
		catch (URISyntaxException e) {
		    e.printStackTrace();
		}
		
		if (l != null) {
		    for (Iterator iter = l.iterator(); iter.hasNext();) {
		    	java.net.Proxy proxy = (java.net.Proxy) iter.next();
		    	System.out.println("proxy hostname type: " + proxy.type());

		    	InetSocketAddress addr = (InetSocketAddress) proxy.address();

		    	if (addr == null) {
		    		System.out.println("No Proxy");
		    	} else {
		    		System.out.println("proxy hostname : " + addr.getHostName());
		    		System.setProperty("http.proxyHost", addr.getHostName());
		    		System.out.println("prox host IP : "+ addr.getHostString());
		    		System.out.println("proxy port : " + addr.getPort());
		    		System.setProperty("http.proxyPort", Integer.toString(addr.getPort()));
		    	}
		    }
		}
	}

}
