import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileExtractor {
	private static final String line_separator="\n";
	//假定每个数据最长为7位，例如1918317
	private static final String SUMMARY_REGEX = "\u8d77\u59cb\u65f6\u95f4: (\\d{4}\u5e74\\d{3}\u65e5--\\d{2}\u65f6\\d{2}\u5206\\d{2}\u79d2)"+line_separator+"\u91c7\u6837\u957f\u5ea6: 512\\*1500"+line_separator+"\u91c7\u6837\u7387: 125 SPS"+line_separator+"(GX:)"+line_separator+"((-?\\d{1,7}\\s*){152})"+line_separator+"\u8d77\u59cb\u65f6\u95f4: \\d{4}\u5e74\\d{3}\u65e5--\\d{2}\u65f6\\d{2}\u5206\\d{2}\u79d2"+line_separator+"\u91c7\u6837\u957f\u5ea6: 512\\*1500"+line_separator+"\u91c7\u6837\u7387: 125 SPS"+line_separator+"(GY:)"+line_separator+"((-?\\d{1,7}\\s*){152})"+line_separator+"\u8d77\u59cb\u65f6\u95f4: \\d{4}\u5e74\\d{3}\u65e5--\\d{2}\u65f6\\d{2}\u5206\\d{2}\u79d2"+line_separator+"\u91c7\u6837\u957f\u5ea6: 512\\*1500"+line_separator+"\u91c7\u6837\u7387: 125 SPS"+line_separator+"(GZ:)"+line_separator+"((-?\\d{1,7}\\s*){152})"+line_separator+"\u8d77\u59cb\u65f6\u95f4: \\d{4}\u5e74\\d{3}\u65e5--\\d{2}\u65f6\\d{2}\u5206\\d{2}\u79d2"+line_separator+"\u91c7\u6837\u957f\u5ea6: 512\\*1500"+line_separator+"\u91c7\u6837\u7387: 125 SPS"+line_separator+"(HY:)"+line_separator+"((-?\\d{1,7}\\s*){0,152})";

	private static final Pattern SUMMARY_PATTERN = Pattern.compile(SUMMARY_REGEX,Pattern.DOTALL);

	public static void main(String[] args) throws IOException {
		// 读取文件
		FileInputStream input = new FileInputStream(
		        "/home/liujijun/workspace/miscellany/src/main/java/s.ssm");
		FileChannel channel = input.getChannel();
		ByteBuffer bbuf = channel.map(FileChannel.MapMode.READ_ONLY, 0, (int) channel.size());
		// 文件编码为utf-8
		CharBuffer cbuf = Charset.forName("utf-8").newDecoder().decode(bbuf);
		long start = System.currentTimeMillis();
		Matcher matcher1 = SUMMARY_PATTERN.matcher(cbuf);
		while (matcher1.find()) {
			String time = matcher1.group(1);
			String gxtype = matcher1.group(2);
			//替换掉空格，假定最多空格数为7
			String gxdata = matcher1.group(3).replaceAll("\\s{1,7}", ",");
			String gytype = matcher1.group(5);
			String gydata = matcher1.group(6).replaceAll("\\s{1,7}", ",");
			String gztype = matcher1.group(8);
			String gzdata = matcher1.group(9).replaceAll("\\s{1,7}", ",");
			String hytype = matcher1.group(11);
			String hydata = matcher1.group(12).replaceAll("\\s{1,7}", ",");
			System.out.println("时间:" + time + " " + gxtype + gxdata);
			System.out.println(gytype + gydata);
			System.out.println(gztype + gzdata);
			System.out.println(hytype + hydata);
		}
		long end = System.currentTimeMillis();
		System.out.println("耗时" + (end - start) + "ms");
	}
}
