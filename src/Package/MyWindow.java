import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.security.MessageDigest;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
public class MyWindow extends JFrame implements ActionListener{
    //Global components
		JLabel jl = new JLabel();
		JPanel jp = new JPanel();
		JLabel img = new JLabel();
		JTextField Type;
		JButton text2, picture;
 
    //constructor
    MyWindow(String title){
 
        super(title);
 
        this.setSize(400, 650);
        this.init();
        this.setVisible(true);
        
         
    }//end constructor
 
    void init(){
 
        JLabel text = new JLabel("Md5 Hash Map Generator");
        JLabel text1 = new JLabel("By Ryandw11"); //Name changed for the public.
        text2 = new JButton("Generate!");
        picture = new JButton("Picture ");
        Type = new JTextField(20);
        
        text2.addActionListener(this);
        //jl.setIcon(new ImageIcon("C:\\Ryandw11.png"));
        //img.setIcon(new ImageIcon("C:\\img.png"));
 
        JPanel panel = new JPanel();
        panel.add(text);
        panel.add(text1);
        panel.add(Type);
        panel.add(text2);

       
        //panel.add(img);
 
        this.add(panel);
        validate();

          
        }//End void
    
    @Override
    public void actionPerformed(ActionEvent event) {
    	if(event.getSource() == text2){
    		
    		String Types = Type.getText();
    		
    		try {
				fun(Types);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Oh no! An error has accored! Make sure that the file path is right! Ex: C:\\Example.png", "Hashmap - Error!", JOptionPane.ERROR_MESSAGE) ;
			}
    		
    	
    
    		
    	}
    }
    
    public void fun (String file)throws Exception{
    	 MessageDigest md = MessageDigest.getInstance("MD5");
         FileInputStream fis = new FileInputStream(file);
         
         byte[] dataBytes = new byte[1024];
      
         int nread = 0; 
         while ((nread = fis.read(dataBytes)) != -1) {
           md.update(dataBytes, 0, nread);
         };
         byte[] mdbytes = md.digest();
      
         //convert the byte to hex format method 1
         StringBuffer sbf = new StringBuffer();
         for (int i = 0; i < mdbytes.length; i++) {
           sbf.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
         }        
         String feedback = sbf.toString();
         JOptionPane.showMessageDialog(null, "That files hashmap code is:  " + feedback, "Hashmap - Complete!", JOptionPane.INFORMATION_MESSAGE) ;
    }
 
          
        //End class
}//End class
