/**
 * Project Name:nbcqjym
 * File Name:Get.java
 * Package Name:com.micropower.common
 * Date:Jul 25, 20169:37:45 AM
 * Copyright (c) 2016, 1173499611@qq.com All Rights Reserved.
 *
*/

package com.micropower.manager.common.util;
import java.io.BufferedOutputStream;
/**
 * ClassName:Get <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     Jul 25, 2016 9:37:45 AM <br/>
 * @author   lihui
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
import java.io.ByteArrayOutputStream;  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;  
import java.net.URL;  
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/** 
 * @˵�� �������ȡͼƬ������ 
 * @author lihui
 * @version 1.0 
 * @since 
 */  
public class GetImage {  
    /** 
     * ���� 
     * @param args 
     */  
    public  static String upload(String url,HttpServletRequest  request) {
    	try {
    		byte[] btImg = getImageFromNetByUrl(url);  
            if(null != btImg && btImg.length > 0){  
                 
                String fileName = new Date().getTime()+""+((int)(Math.random())*100+1)+".jpg";  
                String path= request.getSession().getServletContext().getRealPath("app").replace("nbcqjym\\app", "NBhouse\\images\\upload\\");;
                writeImageToDisk(path,btImg, fileName);
                return fileName;
            }else{  
                System.out.println("û�дӸ����ӻ������"); 
                return null;
            } 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
         
    }  
    /** 
     * ��ͼƬд�뵽���� 
     * @param img ͼƬ����� 
     * @param fileName �ļ�����ʱ����� 
     */  
    public static void writeImageToDisk(String path,byte[] img, String fileName){  
        try {  
            File file = new File(path + fileName);  
            FileOutputStream fops = new FileOutputStream(file);  
            fops.write(img);  
            fops.flush();  
            fops.close();  
            System.out.println("ͼƬ�Ѿ�д�뵽C��");  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    /** 
     * ��ݵ�ַ�����ݵ��ֽ��� 
     * @param strUrl �������ӵ�ַ 
     * @return 
     */  
    public static byte[] getImageFromNetByUrl(String strUrl){  
        try {  
            URL url = new URL(strUrl);  
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
            conn.setRequestMethod("GET");  
            conn.setConnectTimeout(5 * 1000);  
            InputStream inStream = conn.getInputStream();//ͨ����������ȡͼƬ���  
            byte[] btImg = readInputStream(inStream);//�õ�ͼƬ�Ķ��������  
            return btImg;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    /** 
     * ���������л�ȡ��� 
     * @param inStream ������ 
     * @return 
     * @throws Exception 
     */  
    public static byte[] readInputStream(InputStream inStream) throws Exception{  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while( (len=inStream.read(buffer)) != -1 ){  
            outStream.write(buffer, 0, len);  
        }  
        inStream.close();  
        return outStream.toByteArray();  
    }  
    
    public static byte[] File2byte(String filePath)  
    {  
        byte[] buffer = null;  
        try  
        {  
            File file = new File(filePath);  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            byte[] b = new byte[1024];  
            int n;  
            while ((n = fis.read(b)) != -1)  
            {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        }  
        catch (FileNotFoundException e)  
        {  
            e.printStackTrace();  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
        return buffer;  
    }  
  
    public static void byte2File(byte[] buf, String filePath, String fileName)  
    {  
        BufferedOutputStream bos = null;  
        FileOutputStream fos = null;  
        File file = null;  
        try  
        {  
            File dir = new File(filePath);  
            if (!dir.exists() && dir.isDirectory())  
            {  
                dir.mkdirs();  
            }  
            file = new File(filePath + File.separator + fileName);  
            fos = new FileOutputStream(file);  
            bos = new BufferedOutputStream(fos);  
            bos.write(buf);  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
        finally  
        {  
            if (bos != null)  
            {  
                try  
                {  
                    bos.close();  
                }  
                catch (IOException e)  
                {  
                    e.printStackTrace();  
                }  
            }  
            if (fos != null)  
            {  
                try  
                {  
                    fos.close();  
                }  
                catch (IOException e)  
                {  
                    e.printStackTrace();  
                }  
            }  
        }  
    }  
    
    
    public static File byte2File(byte[] buf)  
    {  
    	File file = new File("");  
    	  
        OutputStream output;
		try {
			output = new FileOutputStream(file);
			 BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);  
		     bufferedOutput.write(buf);
		     return file;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
      
       
    }  
    
    
    public static void main(String[] args) {
    	byte2File(getImageFromNetByUrl("https://www.baidu.com/img/bd_logo1.png"),"d://","baidu.jpg");
	}
    
}  

