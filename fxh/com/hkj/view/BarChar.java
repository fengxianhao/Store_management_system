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
		JFreeChart chart = ChartFactory.createBarChart3D("����ͳ��", 	// ͼ�����    19.
			"�·�", // Ŀ¼�����ʾ��ǩ   
             "����", // ��ֵ�����ʾ��ǩ   21.     
             dataset, // ���ݼ�    22.                             
             PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
             false,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ�� ����false)    24.                             
             false,          // �Ƿ����ɹ���   25.                             
             false           // �Ƿ�����URL����   26.                             
         );   //27.             28.         //�����￪ʼ    29.         
		CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������   30.         
		CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��� ��    31.          
		domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮ ƽ�ײ�����    32.          
		domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ ����    33.          
		ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״   34.          
		rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));    //35.           
		//chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  // 36.           

		chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ��� ����   37.               38.           
		//�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������   39.               40.          
		frame1=new ChartPanel(chart,true);        //����Ҳ������chartFrame, ����ֱ������һ��������Frame   41.             42.     
	}       //43. 
	
	private static CategoryDataset getDataSet() {    //44.            
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();   //45.            
		dataset.addValue(50, "����", "1�·�");  // 46.                       
		dataset.addValue(200, "���", "1�·�");   //48.           
		dataset.addValue(60, "����", "2�·�");   //49.               //50.            
		dataset.addValue(200, "���", "2�·�");   //51.            
		dataset.addValue(60, "����", "3�·�");   //52.                      
		dataset.addValue(300, "���", "3�·�");   //54.            
		dataset.addValue(330, "����", "4�·�");   //55.                      
		dataset.addValue(400, "���", "4�·�");   //57.            
		dataset.addValue(35, "����", "5�·�");              
	    dataset.addValue(400, "���", "5�·�");   //60.            
	    return dataset;  
	}   
	//����  
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
