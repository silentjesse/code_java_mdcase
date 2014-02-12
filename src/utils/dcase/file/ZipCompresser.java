package utils.dcase.file;

/**   
 *   Title:                 compress   Files   and   directory   to   a   ZIP   File   
 *   Description:   
 *   Copyright:         Copyright   (c)   2002   
 *   Company:             Personal   
 *   @author   hrexiyang   
 *   @version   1.0   
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompresser {
	private String basePath = null;

	private File dir = null;

	private ZipOutputStream zipoutputstream = null;

	 
	public ZipCompresser() {
	}

	public void initionalZip(String s_filePath, String s_zipName)

	{
		try {
			FileOutputStream zipFilename = new FileOutputStream(s_filePath
					+ "/" + s_zipName);
			zipoutputstream = new ZipOutputStream(zipFilename);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void compress(String s_filePath, String s_fileName) throws Exception {
		try {
			dir = new File(s_filePath, s_fileName);
			if (dir.isFile())
				basePath = dir.getPath().substring(0,
						dir.getPath().lastIndexOf("/"));
			else
				basePath = s_filePath;
			// System.out.println(basePath+"\n");
			CompressDir(dir, zipoutputstream);
			zipoutputstream.setMethod(ZipOutputStream.DEFLATED);

		} catch (Exception e) {
			throw new Exception("Something   wrong   in   compresser:   " + e);
		}
	}

	// ʹ�õݹ�ķ������˱����Ŀ¼�µ��ļ�
	private void CompressDir(File f, ZipOutputStream zipoutputstream) {
		if (f.isDirectory()) {
			File[] files = f.listFiles();
			if (files.length == 0) {
				// ����ѹ����Ŀ¼�ķ���������÷�����δʵ��
				addOneEmptyDirectory(f, zipoutputstream);

			} else {
				for (int i = 0; i < 20; ++i) {
					if (files[i].isDirectory()) {
						CompressDir(files[i], zipoutputstream);
					}
					if (files[i].isFile()) {
						addOneFile(files[i], zipoutputstream);
					}
				}
			}
		} else if (f.isFile()) {
			addOneFile(f, zipoutputstream);
		}
	}

	// ѹ��һ���ļ�
	private void addOneFile(File file, ZipOutputStream zipoutputstream) {
		ZipEntry zipentry = new ZipEntry(file.getPath().substring(
				basePath.length() + 1));
		FileInputStream fileinputstream;
		CRC32 crc32 = new CRC32();

		byte[] rgb = new byte[1024];
		int n;

		// Compute CRC of input stream

		try {
			fileinputstream = new FileInputStream(file);
			while ((n = fileinputstream.read(rgb)) > -1) {
				crc32.update(rgb, 0, n);
			}
			fileinputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Set Up Zip Entry
		zipentry.setSize(file.length());
		zipentry.setTime(file.lastModified());
		zipentry.setCrc(crc32.getValue());

		// Write Data
		try {
			zipoutputstream.putNextEntry(zipentry);
			fileinputstream = new FileInputStream(file);

			int c;
			while ((c = fileinputstream.read()) != -1)
				zipoutputstream.write(c);
			fileinputstream.close();
			zipoutputstream.closeEntry();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ѹ��һ����Ŀ¼
	private void addOneEmptyDirectory(File file, ZipOutputStream zipoutputstream) {
		ZipEntry zipentry = new ZipEntry(file.getPath().substring(
				basePath.length() + 1)
				+ "/");
		try {
			zipoutputstream.putNextEntry(zipentry);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void ZipClose() throws Exception {
		zipoutputstream.close();
	}
	public static void main(String[]args){
		ZipCompresser zip=new ZipCompresser();
		zip.initionalZip("D:\\dl\\sf\\wappush\\080306738\\","080306738.zip");
		try{
			zip.compress("D:\\dl\\sf\\wappush\\080306738\\gms","D:\\dl\\sf\\wappush\\080306738\\gms\\4220.tif");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
