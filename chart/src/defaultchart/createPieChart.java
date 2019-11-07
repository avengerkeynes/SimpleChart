package defaultchart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.ui.RectangleEdge;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class createPieChart {
	private Map<String,String> dataValue=new HashMap<String,String>();
	
	public void setData(Map<String, String> data) 
	{
		this.dataValue=data;
	}
	
	private String title=new String();
	public void setTitle(String title) 
	{
		this.title=title;
	}
	private boolean legend=true; 
	public void setLegend(boolean legend) 
	{
		this.legend=legend;
	}
	private boolean tooltips=true;
	public void setTooltips(boolean tooltips)
	{
		this.tooltips=tooltips;
	}
	private boolean urls=true;
	public void setUrls(boolean urls) 
	{
		this.urls=urls;
	}
	
	public JFreeChart createPieChart(PieDataset dataset) 
	{
		JFreeChart chart=ChartFactory.createPieChart(title,dataset,legend,tooltips,urls);
		PiePlot piePlot=(PiePlot)chart.getPlot();
		piePlot.setLabelFont(new Font("宋体",Font.PLAIN,14));
		TextTitle textTitle=chart.getTitle();
		textTitle.setFont(new Font("宋体",Font.PLAIN,20));
		
		/*图例*/
		LegendTitle legendTitle=chart.getLegend();
		legendTitle.setItemFont(new Font("宋体",Font.PLAIN,12));
		legendTitle.setBackgroundPaint(Color.LIGHT_GRAY);//图例底色
		legendTitle.setItemPaint(Color.RED);//图例字体颜色
		legendTitle.setPosition(RectangleEdge.BOTTOM);//图例位置
		
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}\n{1}"));//{0}默认值；{1}具体数值；{2}百分比；{3}和
		/*是否带图表边框*/
		piePlot.setOutlineVisible(false);
		/*分离饼图*/
		piePlot.setExplodePercent("ORACLE", 0.2);//饼图分离部分 0.2为分离距离
		/*是否椭圆*/
		piePlot.setCircular(true);
		/*阴影*/
		piePlot.setShadowXOffset(5);
		piePlot.setShadowYOffset(5);
		/*加粗分类边框*/
		piePlot.setSectionOutlineStroke("ORACLE",new BasicStroke(5f));
		/*饼颜色*/
		piePlot.setSectionPaint("JAVA", new Color(30,144,255));
		piePlot.setSectionPaint("ORACLE",new Color(70,130,180));
		piePlot.setSectionPaint("C语言",new Color(72,61,139));
		/*旋转角度*/
		piePlot.setStartAngle(0);
		/*逆时针*/
		piePlot.setDirection(Rotation.ANTICLOCKWISE);
		/*隐藏连接线*/
		piePlot.setSimpleLabels(true);
		/*是否抗锯齿*/
		chart.setAntiAlias(true);
		/*背景图片*/
		Image image=null;//设置背景图片
		try 
		{
			image=ImageIO.read(new FileInputStream(System.getProperty("user.dir")+"/source/pie_background.jpg"));
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		piePlot.setBackgroundImage(image);
		return chart;
	}
	
	public JFreeChart create3dPieChart(PieDataset dataset) 
	{
		JFreeChart chart=ChartFactory.createPieChart3D(title, dataset,legend,tooltips,urls);
		PiePlot piePlot=(PiePlot)chart.getPlot();
		piePlot.setLabelFont(new Font("宋体",Font.PLAIN,14));
		TextTitle textTitle=chart.getTitle();
		textTitle.setFont(new Font("宋体",Font.PLAIN,20));
		/*设置透明度*/
		piePlot.setForegroundAlpha(0.7f);
		/*z轴高度*/
		PiePlot3D pie3dplot=(PiePlot3D)chart.getPlot();
		pie3dplot.setDepthFactor(0.08f);
		return chart;
	}
	
	public PieDataset getPieDataset() 
	{
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Map.Entry<String,String> entry:dataValue.entrySet()) 
		{
			dataset.setValue(entry.getKey(), Double.parseDouble(entry.getValue()));
		}
		return dataset;
	}
	public JPanel createPanel(JFreeChart chart) 
	{
		return new ChartPanel(chart);
	}
	
}
