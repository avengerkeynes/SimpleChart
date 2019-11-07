package defaultchart;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Main_pie2d {
	public static void main(String[] args) 
	{
		createPieChart pie=new createPieChart();
		Map<String,String> data=new HashMap<String,String>();
		data.put("JAVA","1000");
		data.put("ORACLE","200");
		data.put("C语言","234.5");
		pie.setTitle("测试");
		pie.setUrls(false);
		pie.setData(data);
		JPanel jpanel=pie.createPanel(pie.createPieChart(pie.getPieDataset()));
		JFrame jFrame=new JFrame();
		jFrame.add(jpanel);
		jFrame.setTitle("饼图");
		jFrame.setBounds(0, 0, 600, 450);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jFrame.setVisible(true);
		
	}
}
