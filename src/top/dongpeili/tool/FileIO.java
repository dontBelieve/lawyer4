package top.dongpeili.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @summary 文件读写, 文件夹增删改查工具类
 * @date 2017年11月27日
 * @author dpl
 */
public class FileIO {

	/**
	 * @summary 程序输出到文件
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void outputFile(String url, String content) {
		try {
			// 1. 如果有原文件, 原文件将被覆盖. 2. 如果没有该目录会报错
			OutputStream os = new FileOutputStream(url);
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			osw.write(content);
			osw.close();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @summary 程序输入从文件
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void inputFile(String url) {
		InputStream is;
		InputStreamReader isr;
		try {
			is = new FileInputStream(url);
			isr = new InputStreamReader(is, "utf-8");
			StringBuffer sb = new StringBuffer();
			while (isr.ready()) {
				sb.append((char) isr.read());
			}
			System.out.println(sb.toString());
			isr.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @summary 创建目录
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void mkdir(String dirname) {
		File d = new File(dirname);
		// 现在创建目录
		d.mkdirs();
	}

	/**
	 * @summary 测试目录和文件阅读
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void dirList(String dirname) {
		File f1 = new File(dirname);
		if (f1.isDirectory()) {
			System.out.println("目录 " + dirname);
			String s[] = f1.list();
			for (int i = 0; i < s.length; i++) {
				File f = new File(dirname + "/" + s[i]);
				if (f.isDirectory()) {
					System.out.println(s[i] + " 是一个目录");
				} else {
					System.out.println(s[i] + " 是一个文件");
				}
			}
		} else {
			System.out.println(dirname + " 不是一个目录");
		}
	}

	/**
	 * @summary 删除文件夹
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void deleteDir(File file) {
		File[] files = file.listFiles();
		if(files!=null) { 
            for(File f: files) {
                if(f.isDirectory()) {
                    deleteDir(f);
                } else {
                    f.delete();
                }
            }
        }
		// 只能删除空文件夹
		file.delete();
	}
	
	/**
	 * @summary 删除文件夹
	 * @date 2017年11月27日
	 * @return void
	 * @author dpl
	 */
	public void deleteDir(String dirname) {
		File file = new File(dirname);
		this.deleteDir(file);
	}

	public static void main(String[] args) {
		FileIO fileIO = new FileIO();

		// String url = "D:/workspace/git/lawyer4/src/top/dongpeili/tool/test.txt";
		String dirname = "D:/nofile";
		// String content = "十年春，齐师伐我。公将战。";
		// new FileIO().outputFile(url, content);
		// new FileIO().inputFile(url);
		// fileIO.dirList(dirname);
		
		fileIO.deleteDir(dirname);
	}
}
