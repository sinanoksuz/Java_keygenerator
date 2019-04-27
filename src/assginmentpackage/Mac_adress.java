package assginmentpackage;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;

public class Mac_adress {
	StringBuilder sb;
	String str = null;
	
	public String  MacAdress() throws Exception {
		
		
		final Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
	    ArrayList <String> arrayList;
	    arrayList=new ArrayList<>();
		while (e.hasMoreElements()) {
	        final byte [] mac = e.nextElement().getHardwareAddress();
	        if (mac != null) {
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < mac.length; i++)
	                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
	            arrayList.add(sb.toString());
	        }
	        }
		return arrayList.get(1).toString();
			}
}
