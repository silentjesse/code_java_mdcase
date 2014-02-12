package utils.dcase.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
 



import org.apache.log4j.Logger;

public class FileOperation {
	static Logger logInfo=Logger.getLogger("info");
	static Logger logError = Logger.getLogger("error");// ��¼������Ϣ
	static String pathSeparator  = java.io.File.separator;
	/**
	 * @param source  Դ
	 * @param dest   Ŀ��
	 * @param remark ��ע
	 * @return
	 * ����0��ʾ�ɹ�,����-1��ʾʧ��
	 */
	public static int  copy(String source, String dest, String remark){
		int isSuccessfull = 1 ;//�Ƿ�ɹ� 
		File inputFile = new File(source);
		boolean isSourceExist = false; //Դ�Ƿ����
		isSourceExist = inputFile.exists();
		if(isSourceExist){//�ļ�Դ����
			boolean isDirectory = false;//�Ƿ�ΪĿ¼
			isDirectory = inputFile.isDirectory();
			if(isDirectory){
				logError.error(remark+"]["+source+"][��һ��Ŀ¼,�����и��Ʋ���");				
			}else{
				try {
					FileInputStream fileInputStream = new FileInputStream(inputFile);
					saveFile(fileInputStream, dest);
					/*FileOutputStream fileOutputStream = new FileOutputStream(new File(dest));
					byte[] buffer = new byte[1024];
					int j = 0;
					while ((j = fileInputStream.read(buffer)) != -1) {
						fileOutputStream.write(buffer, 0, j);
					}*/
					fileInputStream.close();
					/*fileOutputStream.close();*/
				} catch (FileNotFoundException e) {
					logError.error("["+remark+"]["+e.getMessage()+"]");	
					isSuccessfull = -2;
				} catch (IOException e) {
					isSuccessfull = -2;
					logError.error("["+remark+"]["+e.getMessage()+"]");	
				}
				
			}
		}else{
			logError.error("["+remark+"]["+source+"][Դ�ļ�������");
		}
		
		return isSuccessfull;
	}
	
	/**
	 * @param dest
	 * @param newName
	 * @param remark
	 * @return
	 *  ����0��ʾ�ɹ�,����-1��ʾʧ��
	 */
	public static int rename(String dest, String newName, String remark){
		int isSuccessfull = -1 ;//�Ƿ�ɹ� 
		File oldFile = new File(dest);//ԭ�����ļ�
		boolean isOldFileExist = false;//ԭ�����ļ��Ƿ����
		isOldFileExist = oldFile.exists();
		if(isOldFileExist){
			//logError.error(remark+"]["+source+"][����������ļ�");
		}else{
			
		}
		return isSuccessfull;
	}

	
	/**
	 * @param inFile
	 * @param dest
	 * @return
	 * @throws IOException 
	 * 
	 */
	public static void saveFile(InputStream inFile, String dest) throws IOException {
		 
		File out = new File(dest);
		
		FileOutputStream outFile = null;
		try {
			if(!out.exists()){
				File parentFile = out.getParentFile();
				boolean isParentDirExist = parentFile.exists();
				if(!isParentDirExist){ 
					parentFile.mkdirs();
					 
				}
				
				out.createNewFile();
				
			}
			
			outFile = new FileOutputStream(out);
			byte[] buffer = new byte[1024];
			int j = 0;
			 
			while ((j = inFile.read(buffer)) != -1) {
				
				outFile.write(buffer, 0, j);
				
			}
			
			inFile.close();
			outFile.close();
		} catch (FileNotFoundException e) {
			 throw e;
		} catch (IOException e) {
			throw e;
		}finally{
			
		}
		 
	}
	/**
	 * @param inFile
	 * @param dest
	 * @return
	 * 1��ʾ�ɹ���-2��ʾio�쳣,-3��ʾ�Ҳ����ļ�
	 */
	public static int saveFile(String src, String dest){
		int issuccessful = 1;
		URL url = null;
		try {
			logInfo.info(src+"]��ʼ���Ƶ�["+dest);
			File out = new File(dest);
			if(!out.exists()){
				File parentFile = out.getParentFile();
				boolean isParentDirExist = parentFile.exists();
				if(!isParentDirExist){//��Ŀ¼������
					parentFile.mkdirs();
					logInfo.info("����Ŀ¼]["+""+parentFile.getPath());
				}
				out.createNewFile();
			}
			url = new URL(src);
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection(); 
			httpConnection.connect();
			BufferedInputStream bis = new BufferedInputStream(httpConnection.getInputStream());
			FileOutputStream fos = new FileOutputStream(out);
			int size = 0;
			byte buf[] = new byte[10240];
			while ( (size = bis.read(buf)) != -1){
				logInfo.info("...........");
				fos.write(buf, 0, size);
			}
			bis.close();
			fos.close();
			httpConnection.disconnect();
			logInfo.info(src+"]�����Ѿ���["+dest);
		} catch (MalformedURLException e) {
			issuccessful = -2;
			e.printStackTrace();
		} catch (IOException e) {
			issuccessful = -2;
			e.printStackTrace();
		}  
		if(issuccessful < 0){
			logInfo.info(src+"]���Ƶ�["+dest+"][����ʧ��");
		}
		return issuccessful;
	}
	

	
	
	public static String arrangePathSeparator(String srcPath){
		if(srcPath == null){
			return null;
		}
		if(srcPath.indexOf("\\")!= -1){
			srcPath = srcPath.replaceAll("\\\\", pathSeparator+pathSeparator);
		}
		if(srcPath.indexOf("/")!= -1){
			srcPath = srcPath.replaceAll("/", pathSeparator+pathSeparator);
		}
		return srcPath;
	}
	
	public static  int writeOutputStreamAppend(String chars, String dest){
		int issuccessful = 1;
		
		try {
			File file = new File(dest);
			if(!file.exists()){
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file,true);
			fileWriter.write(chars);
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			issuccessful = -2;
			logError.error(e.getMessage());
		}
		return issuccessful;
	}
	
	public static InputStream HttpInputStream(String urlStr){
		InputStream inputStream = null;
		try {
			URL  url = new URL(urlStr);
			
			inputStream = url.openStream(); 
		} catch (MalformedURLException e) {
			logError.error(e.getMessage());
		} catch (IOException e) {
			logError.error(e.getMessage());
		} 
		return inputStream;
	}
	
	public static boolean isFileExist(String pathPrefix, String pathtmp,
			String filename) {
		String path = pathPrefix + File.separator + pathtmp + File.separator + filename;
		File file = new File(path); 
		return file.exists();
	}
}
