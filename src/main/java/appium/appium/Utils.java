package appium.appium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Utils {
	
	
	public static class autoUtils{
		
		public static void copy(File source, String toPath) throws Exception {

			InputStream in = null;

			OutputStream out = null;

			try {
				in = new FileInputStream(source);

				out = new FileOutputStream(new File(toPath));

				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				in.close();
				out.close();
			}
		}
	}

}
