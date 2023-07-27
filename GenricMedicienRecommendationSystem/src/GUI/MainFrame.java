package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import DataBase.DataBaseConnection;
import java.awt.Color;
import java.awt.Font;

public class MainFrame
{
    public static MainFrame singleInstance;
    public static MainFrame getInstance()
    {
    	if(singleInstance==null)
    	{
    		singleInstance = new MainFrame();
    	}
    	return singleInstance;
    }
    private JFrame frame;
    public JPanel panel;
    public  MainFrame()
    {
    	 frame = new JFrame("GENRIC MEDICINE SYSTEM");
    	 frame.setBounds(200, 0, 457, 500);
    	 frame.setResizable(false);
    	 frame.getContentPane().setLayout(null);
    	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         panel = new JPanel();
         panel.setBounds(0, 0, 1310, 720);
         panel.setLayout(null);
         panel.setBackground(Color.darkGray);
    	 frame.getContentPane().add(panel);
    	 
    	 JLabel lblNewLabel = new JLabel("WELCOME TO GENRIC MEDICINE SYSTEM");
    	 lblNewLabel.setForeground(Color.WHITE);
    	 lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
    	 lblNewLabel.setBounds(22, 11, 414, 44);
    	 panel.add(lblNewLabel);
    }
    public void addManiPanel_1()
    {
    	panel.add(MainPanel.getInstance().getPanel());
    	frame.setVisible(true);
    }
    public void getConnection()
    {
    	DataBaseConnection.getInstance().getConnection();
    }
    public static void main(String[] args)
    {
    	MainFrame mf = MainFrame.getInstance();
    	mf.addManiPanel_1();
    	//mf.getConnection();
    
    }
}
