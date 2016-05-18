package meituan.commons;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.jsp.PageContext;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

public class FileUpload {
	private static final String ALLOWED="gif,png,jpg,jpeg";//允许上传的文件
	private static final String DENTED="html,jsp.exe,bat,com";//不允许上传的文件类型
	private static final int TOTALFILE=20*1024*1024;//文件总大小
	private static final int SINGLEFILESIZE=1024*1024;//单个文件大小
	private static final String PATH="upload/";//保存图片的路径
	
	public Map<String, String>  upload(PageContext  context) throws Exception{
		Map<String,String> map = new HashMap<String, String>();
		SmartUpload  upload = new SmartUpload();
		//初始化
		upload.initialize(context);
		//参数进行设置
		upload.setAllowedFilesList(ALLOWED);
		upload.setDeniedFilesList(DENTED);
		upload.setCharset("UTF-8");
		upload.setMaxFileSize(SINGLEFILESIZE);
		upload.setTotalMaxFileSize(TOTALFILE);
		upload.upload();//开始接收上传
		Request request =upload.getRequest();//功能等同于Jsp页面上的request
		//获取请求中的参数
		//String user_id=request.getParameter("user_id");
		//获取所有表单元素的name属性值
		Enumeration<String> enums =request.getParameterNames();
		String fieldName = null ;
		while(enums.hasMoreElements()){
			fieldName=enums.nextElement();
	//		System.out.println("filename:"+fieldName);
			map.put(fieldName, request.getParameter(fieldName));
		}
	//	System.out.println("内容："+request.getParameter(fieldName));
		Files files =upload.getFiles();
		if(null!=files&&files.getCount()>0){//文件存在
			Collection<File> fs =files.getCollection();
			String realPath="";
			StringBuffer  sb =new StringBuffer();
			for(File file:fs){
				if(!file.isMissing()){//文件数据是否丢失
					System.out.println(file.getFileName());
					realPath =PATH+System.currentTimeMillis()+new Random().nextInt(1000)+"."+file.getFileExt();
					System.out.println(realPath);
					//保存到服务器中
					file.saveAs(realPath,SmartUpload.SAVE_VIRTUAL);//另存   1.GIF ,  2.gif ,  
					sb.append(realPath).append(",");
			//		System.out.println(sb.toString());
				}
			}
			String image =sb.toString();
			if(null!=image&&!"".equals(image)){
			//	System.out.println("0--------------------------"+image);
				map.put("image", image);
			}
		}
		return map;
	}
	
	

}
