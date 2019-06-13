import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 
public class AddButton extends JButton implements ActionListener{

   private JFrame frame;
   private MyButton button;
   private JTextField hour=new JTextField(); 
   private Appointments event;
   private JTextField title=new JTextField();
   private JTextArea desc=new JTextArea();
   
   public AddButton(String label,MyButton b){
      super(label);
      button=b; 
      addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e){
      button.getFrame().setVisible(false);
      frame=new JFrame("ADD NEW");
      Container cp=frame.getContentPane();
      cp.setLayout(new GridLayout(4,1));
      JPanel p1=new JPanel(new BorderLayout());
      JPanel p2=new JPanel(new BorderLayout());
      JPanel p3=new JPanel(new BorderLayout());
      JPanel p=new JPanel(new FlowLayout());
      JLabel h=new JLabel("Hour: ");
      JLabel t=new JLabel("Title: ");
      JLabel d=new JLabel("Description: ");
      JButton cancel=new JButton("Cancel");
      cancel.addActionListener(
         new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent a) {
               button.actionPerformed(a);
               frame.dispose();
            }
         });
      
      JButton save=new JButton("Save");
      save.addActionListener(
         new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent evt) {
               event=new Appointments(hour.getText()+" ",title.getText(),desc.getText());
               button.getApp().insert(event);
               button.update(button.getApp());
               button.actionPerformed(evt);
               frame.dispose();
            }
         });
      
      p1.add(h,BorderLayout.NORTH);
      p1.add(hour,BorderLayout.CENTER);
      cp.add(p1);
      p2.add(t,BorderLayout.NORTH);
      p2.add(title,BorderLayout.CENTER);
      cp.add(p2);
      p3.add(d,BorderLayout.NORTH);
      p3.add(desc,BorderLayout.CENTER);
      JSeparator sep=new JSeparator(SwingConstants.HORIZONTAL);
      p3.add(sep,BorderLayout.SOUTH);
      cp.add(p3);
      p.add(save);
      p.add(cancel);
      cp.add(p);
      frame.setSize(450,300);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
   
   public JFrame getFrame(){
      return frame;
   }
   
}