import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 
import java.awt.Font;
import java.text.AttributedString;
import java.awt.font.TextAttribute; 
public class ViewButton extends JButton implements ActionListener{
   private AppointmentsDatabase events;
   private Appointments appointment;
   private MyButton button;
   private JFrame frame;
   
   public ViewButton(String label, MyButton b){
      super(label);
      button=b;
      addActionListener(this);
   }
    
   public void actionPerformed(ActionEvent e){
   
      if(!button.getSelected()){  
         button.getFrame().setVisible(false);
         frame=new JFrame("Appointment");
         Container cp=frame.getContentPane();
         cp.setLayout(new FlowLayout());
         JPanel p=new JPanel(new BorderLayout());
      
         events=button.getApp();
         appointment=events.find(button.getKey());
      
         JButton exit=new JButton("Back");
         exit.addActionListener(
            new ActionListener() {
               @Override
                public void actionPerformed(ActionEvent a) {
                  frame.dispose();
                  button.actionPerformed(a);
               }
            });
         Font f1 = new Font("Serif", Font.BOLD, 15);
         Font f2 = new Font("Arial", Font.ITALIC, 12);
      
         JTextArea title=new JTextArea(appointment.getEvent().toUpperCase());
         JTextArea hour=new JTextArea("At: "+appointment.getHour());
         JTextArea desc=new JTextArea("\n"+appointment.getComment(),15,20);
         title.setFont(f1);
         desc.setFont(f2);
         title.setBackground(Color.white);
         title.setEditable(false);
         hour.setEditable(false);
         desc.setEditable(false);
         p.add(title,BorderLayout.NORTH);
         p.add(hour,BorderLayout.WEST);
         p.add(desc);
         p.add(exit,BorderLayout.SOUTH);
         cp.add(p);
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);
      }
   }
}