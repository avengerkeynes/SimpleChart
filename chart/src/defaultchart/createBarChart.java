package defaultchart;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtils;

public class createBarChart {
	private String title=new String();
	public void setTitle(String title) 
	{
		this.title=title;
	}
	private String xLabel=new String();
	public void setXLabel(String xLabel)
	{
		this.xLabel=xLabel;
	}
	private String yLabel=new String();
	public void setYLabel(String yLabel) 
	{
		this.yLabel=yLabel;	
	}
	private Map<String,String> dataValue=new HashMap<String,String>();
	public void setData(Map<String, String> data) 
	{
		this.dataValue=data;
	}
	/*是否使用图示*/
	private boolean legend=true;
	public void setLegend(boolean legend) 
	{
		this.legend=legend;
	}
	/*是否生成工具栏*/
	private boolean tooltips=true;
	public void setTooltips(boolean tooltips) 
	{
		this.tooltips=tooltips;
	}
	/*是否生成url*/
	private boolean urls=true;
	public void setUrls(boolean urls) 
	{
		this.urls=urls;
	}
	
	public CategoryDataset getCategoryDataset() 
	{
		DefaultKeyedValues values=new DefaultKeyedValues();
		for(Map.Entry<String,String> entry:dataValue.entrySet()) 
		{
			values.addValue(entry.getKey(), Double.parseDouble(entry.getValue()));
		}
		CategoryDataset dataset=DatasetUtils.createCategoryDataset("JAVABOOK", values);
		return dataset;
	}
	private PlotOrientation hz=PlotOrientation.HORIZONTAL;//横向纵向
	public void setHz(String direction) 
	{
		if(direction.equals("横向")) 
		{
			hz=PlotOrientation.HORIZONTAL;
		}
		else 
		{
			hz=PlotOrientation.VERTICAL;
		}
	}
	
	public JFreeChart createBarChart(CategoryDataset dataset) 
	{
		JFreeChart chart=ChartFactory.createBarChart(title,xLabel,yLabel,dataset,hz,legend,tooltips,urls);
		
		CategoryPlot categoryPlot=chart.getCategoryPlot();
		CategoryAxis axis=categoryPlot.getDomainAxis();
		
		/*设置X轴字体*/
		axis.setTickLabelFont(new Font("宋体",Font.PLAIN,14));
		/*设置X轴标签字体*/
		axis.setLabelFont(new Font("宋体",Font.PLAIN,14));
		/*设置X轴标签角度*/
		axis.setLabelAngle(1);
		
		/*X轴尺度线颜色*/
		axis.setAxisLinePaint(Color.GREEN);
		/*隐藏X轴尺度线*/
		axis.setAxisLineVisible(true);
		/*X轴分类之间距离*/
		axis.setCategoryMargin(0.3);
		/*X轴柱形与原点距离*/
		axis.setLowerMargin(0.3);
		/*X轴显示在图表上方*/
		categoryPlot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
		
		ValueAxis valueAxis=categoryPlot.getRangeAxis();
		/*设置Y轴字体*/
		valueAxis.setTickLabelFont(new Font("宋体",Font.PLAIN,14));
		/*设置Y轴标签字体*/
		valueAxis.setLabelFont(new Font("宋体",Font.PLAIN,14));
		/*Y轴尺度线颜色*/
		valueAxis.setAxisLinePaint(Color.GREEN);
		/*隐藏Y轴尺度线*/
		valueAxis.setAxisLineVisible(true);
		/*Y轴起始值*/
		valueAxis.setLowerBound(100);
		/*是否显示Y轴上的箭头*/
		valueAxis.setPositiveArrowVisible(true);
		/*Y轴刻度线是否显示*/
		valueAxis.setTickMarksVisible(true);
		/*Y轴内部刻度线*/
		valueAxis.setTickMarkInsideLength(20);
		/*Y轴外部刻度线*/
		valueAxis.setTickMarkOutsideLength(20);
		/*Y轴最大值*/
		valueAxis.setUpperBound(1500);
		/*Y轴数据范围*/
		valueAxis.setRangeAboutValue(0,3000);
		/*Y轴显示位置*/
		categoryPlot.setRangeAxisLocation(AxisLocation.TOP_OR_RIGHT);
		
		/*网格竖线*/
		categoryPlot.setDomainGridlinesVisible(true);
		/*网格竖线颜色*/
		categoryPlot.setDomainGridlinePaint(Color.blue);
		
		/*文本注解*/
		
		
		
		
		return chart;
	}
	
	
	public JPanel createPanel(JFreeChart chart) 
	{
		return new ChartPanel(chart);
	}

}
