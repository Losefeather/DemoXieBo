package com.tablaoutviewpagerdemo.a1111.demoxiebo.Common.GetPhoneMac;

import android.util.Log;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by a1111 on 17/11/1.
 */

public class GetPhoneMac {
    /**
     * 获取手机的MAC地址
     *
     * @return
     * @throws SocketException
     */
    public static String getMac()  {
        String str = "";
        String macSerial = "";
        try {
            Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str;) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            macSerial = null;
        }
//		if (macSerial == null || "".equals(macSerial)) {
//			try {
//				return loadFileAsString("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
        if(macSerial ==null|| "".equals(macSerial)){
            Enumeration<NetworkInterface> interfaces;
            try
            {
                interfaces = NetworkInterface.getNetworkInterfaces();

                while (interfaces.hasMoreElements()) {
                    NetworkInterface iF = interfaces.nextElement();
                    byte[] addr = iF.getHardwareAddress();
                    if (addr == null || addr.length == 0) {
                        continue;
                    }
                    StringBuilder buf = new StringBuilder();
                    for (byte b : addr) {
                        buf.append(String.format("%02X:", b));
                    }
                    if (buf.length() > 0) {
                        buf.deleteCharAt(buf.length() - 1);
                    }
                    String mac = buf.toString();
                    Log.d("mac", "interfaceName="+iF.getName()+", mac="+mac);
                    if(iF.getName().equalsIgnoreCase("wlan0")){
                        macSerial=mac;
                    }
                }
            } catch (SocketException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return macSerial;
    }

    public static String loadFileAsString(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        String text = loadReaderAsString(reader);
        reader.close();
        return text;
    }

    public static String loadReaderAsString(Reader reader) throws Exception {
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[4096];
        int readLength = reader.read(buffer);
        while (readLength >= 0) {
            builder.append(buffer, 0, readLength);
            readLength = reader.read(buffer);
        }
        return builder.toString();
    }

    public static byte[] getMacInBytes()  {
        String macSerial = getMac();
        byte[] macBytes = macSerial.getBytes();
        if(macSerial.length()==17){//带有间隔符的mac地址的长度
//        		if (macSerial.contains(":")) {
//        			macSerial.replaceAll(":", "");
//        		}
//        		if (macSerial.contains("-")) {
//        			macSerial.replaceAll("-", "");
//        		}
//        		if (macSerial.contains(" ")) {
//        			macSerial.replaceAll(" ", "");
//        		}
            macSerial=macSerial.substring(0, 2)+macSerial.substring(3, 5)+macSerial.substring(6, 8)+macSerial.substring(9, 11)+macSerial.substring(12, 14)+macSerial.substring(15, 17);
            int mac1=Integer.valueOf(macSerial.substring(0, 2), 16);
            int mac2=Integer.valueOf(macSerial.substring(2, 4), 16);
            int mac3=Integer.valueOf(macSerial.substring(4, 6), 16);
            int mac4=Integer.valueOf(macSerial.substring(6, 8), 16);
            int mac5=Integer.valueOf(macSerial.substring(8, 10), 16);
            int mac6=Integer.valueOf(macSerial.substring(10, 12), 16);
            macBytes = new byte[]{(byte)mac1,(byte)mac2,(byte)mac3,(byte)mac4,(byte)mac5,(byte)mac6};
            return macBytes;
        }else if(macSerial.length()==12){//不带有间隔符的mac地址的长度
            int mac1=Integer.valueOf(macSerial.substring(0, 2), 16);
            int mac2=Integer.valueOf(macSerial.substring(2, 4), 16);
            int mac3=Integer.valueOf(macSerial.substring(4, 6), 16);
            int mac4=Integer.valueOf(macSerial.substring(6, 8), 16);
            int mac5=Integer.valueOf(macSerial.substring(8, 10), 16);
            int mac6=Integer.valueOf(macSerial.substring(10, 12), 16);
            macBytes = new byte[]{(byte)mac1,(byte)mac2,(byte)mac3,(byte)mac4,(byte)mac5,(byte)mac6};
            return macSerial.getBytes();
        }else{//错误的mac地址的长度
            Log.e("GetPhoneMac", "getPhoneMACiswrong!");
            return new byte[]{(byte)0x02,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00};
        }
    }
}
