package defaultchart;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main_bar {
	public static void main(String[] args) throws Exception 
	{
		createBarChart bar=new createBarChart();
		bar.setTitle("测试");
		bar.setXLabel("month");
		bar.setYLabel("sales");
		Map<String,String> data=new HashMap<String,String>();
		data.put("JAVA","500");
		data.put("ORACLE","200");
		data.put("C语言","234.5");
		bar.setData(data);
		bar.setHz("纵向");
		
		JPanel jpanel=bar.createPanel(bar.createBarChart(bar.getCategoryDataset()));
		JFrame jFrame=new JFrame();
		jFrame.add(jpanel);
		jFrame.setTitle("饼图");
		jFrame.setBounds(0, 0, 600, 450);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
	}
}
