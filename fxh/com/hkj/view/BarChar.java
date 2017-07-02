package fxh.com.hkj.view;

import java.awt.Font;
import java.nio.channels.Channel;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
//2.     3. 

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;



public class BarChar extends JPanel{
	ChartPanel frame1;       
	public  BarChar(){            
		CategoryDataset dataset = getDataSet(); 	      
		JFreeChart chart = ChartFactory.createBarChart3D("销售统计", 	// 图表标题    19.
			"月份", // 目录轴的显示标签   
             "数量", // 数值轴的显示标签   21.     
             dataset, // 数据集    22.                             
             PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
             false,           // 是否显示图例(对于简单的柱状图必 须是false)    24.                             
             false,          // 是否生成工具   25.                             
             false           // 是否生成URL链接   26.                             
         );   //27.             28.         //从这里开始    29.         
		CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象   30.         
		CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列 表    31.          
		domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水 平底部标题    32.          
		domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直 标题    33.          
		ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状   34.          
		rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));    //35.           
		//chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  // 36.           

		chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题 字体   37.               38.           
		//到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题   39.               40.          
		frame1=new ChartPanel(chart,true);        //这里也可以用chartFrame, 可以直接生成一个独立的Frame   41.             42.     
	}       //43. 
	
	private static CategoryDataset getDataSet() {    //44.            
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();   //45.            
		dataset.addValue(50, "销量", "1月份");  // 46.                       
		dataset.addValue(200, "库存", "1月份");   //48.           
		dataset.addValue(60, "销量", "2月份");   //49.               //50.            
		dataset.addValue(200, "库存", "2月份");   //51.            
		dataset.addValue(60, "销量", "3月份");   //52.                      
		dataset.addValue(300, "库存", "3月份");   //54.            
		dataset.addValue(330, "销量", "4月份");   //55.                      
		dataset.addValue(400, "库存", "4月份");   //57.            
		dataset.addValue(35, "销量", "5月份");              
	    dataset.addValue(400, "库存", "5月份");   //60.            
	    return dataset;  
	}   
	//单层  
	public ChartPanel getChartjPanel(){       
		 return frame1;            
	}   
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().add(new BarChar().getChartjPanel());
		f.setBounds(480, 330, 880, 480);
		f.setVisible(true);
		
	}	 
}
