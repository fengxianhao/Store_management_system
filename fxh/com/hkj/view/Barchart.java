package fxh.com.hkj.view;

import java.awt.Font;
import java.nio.channels.Channel;

import javax.swing.JFrame;
import javax.swing.JPanel;
//2.     3. 
import org.jfree.chart.ChartFactory;   

import org.jfree.chart.ChartPanel;   //5. 
import org.jfree.chart.JFreeChart;   //6. 
import org.jfree.chart.axis.CategoryAxis;   
import org.jfree.chart.axis.ValueAxis;   
import org.jfree.chart.plot.CategoryPlot;   
import org.jfree.chart.plot.PlotOrientation;   
import org.jfree.data.category.CategoryDataset;   
import org.jfree.data.category.DefaultCategoryDataset;   

public class Barchart extends JPanel{
	ChartPanel frame1;       
	public  Barchart(){            
		CategoryDataset dataset = getDataSet(); 	      
		JFreeChart chart = ChartFactory.createBarChart3D("����ͳ��", 	// ͼ�����    19.
			"���", // Ŀ¼�����ʾ��ǩ   
             "����", // ��ֵ�����ʾ��ǩ   21.     
             dataset, // ���ݼ�    22.                             
             PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
//             true,  
             false,// �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ�� ����false)    24.                             
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
		frame1=new ChartPanel(chart,true); //����Ҳ������chartFrame, ����ֱ������һ��������Frame   41.             42.     
	}       //43. 
	
	private static CategoryDataset getDataSet() {    //44.            
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();   //45.                     
	         
		dataset.addValue(400, "����", "2013");   //55.                      
		dataset.addValue(600, "���", "2013");   //57.  
		dataset.addValue(820, "����", "2014");   //55.                      
		dataset.addValue(760, "���", "2014");   //57.
		dataset.addValue(1020, "����", "2015");   //55.                      
		dataset.addValue(1430, "���", "2015");   //57.
		dataset.addValue(1430, "����", "2016");   //52.                      
		dataset.addValue(1772, "���", "2016");   //54.   
	    return dataset;  
	}   
	//����  
	public ChartPanel getChartPanel(){       
		 return frame1;            
	}   
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.getContentPane().add(new Barchart().getChartPanel());
		f.setBounds(480, 330, 880, 480);
		f.setVisible(true);
		
	}	 

}
