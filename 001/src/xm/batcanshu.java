package xm;

import java.io.InputStream;

/**

 */

public class batcanshu {

	public static void main(String[] args) {

		runbat("d:\\test.bat", "1.1.1.1", "111");

	}

	/**
	 * 文件路径一定不要写错了，比如没有空格之类的，因为不会报错，导致很难排查 执行批处理命令
	 */
	public static void runbat(String batPath, String... argStrings) {
		String cmd = "cmd /c start /b " + batPath + " ";
		if (argStrings != null && argStrings.length > 0) {
			for (String string : argStrings) {
				cmd += string + " ";
			}
		}
		try {
			Process ps = Runtime.getRuntime().exec(cmd);
			InputStream inputStream = ps.getInputStream();
			byte[] by = new byte[1024];
			// while (inputStream.read(by) != -1) {

			if (new String(by, "utf-8").contains("echo success")) {

				// 33333333333333
			}
			// System.out.println(new String(by,"utf-8"));
			// }
			inputStream.close();
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}
}