package utils.dcase.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
	static final int BUFFER = 2048;

	public static void main(String argv[]) throws Exception {
		//ZipUtils.compress("D:\\dl\\sf\\wappush\\080306738\\gms.zip","D:\\dl\\sf\\wappush\\080306738\\gms");
		ZipUtils.compress("D:\\test\\gms.zip","D:\\test\\gms");
	}
	public static void compress(String s_zipPath,String s_filePath) throws Exception{
		try {
			BufferedInputStream origin = null;
			FileOutputStream dest = new FileOutputStream(s_zipPath);
			ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
					dest));
			out.setLevel(Deflater.BEST_SPEED);
			byte data[] = new byte[BUFFER];
			File f = new File(s_filePath);
			File files[] = f.listFiles();

			for (int i = 0; i < files.length; i++) {
				FileInputStream fi = new FileInputStream(files[i]);
				origin = new BufferedInputStream(fi, BUFFER);
				ZipEntry entry = new ZipEntry(files[i].getName());
				out.putNextEntry(entry);
				int count;
				while ((count = origin.read(data, 0, BUFFER)) != -1) {
					out.write(data, 0, count);
				}
				origin.close();
				Thread.sleep(10);
			}
			out.close();
		} catch (Exception e) {
			throw e;
		}
	}
}
