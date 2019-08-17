import javax.swing.*;
import java.awt.*;
import javax.swing.SpringLayout;
import javax.swing.Spring;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner.DefaultEditor;
import java.text.ParseException;
public class AddButton extends JButton implements ActionListener{
   private GridCalendar model;
   private AppointmentsDatabase events;
   private JFrame frame;
   private MyButton button;
   private JTextField hour=new JTextField(); ;
   private Appointments event;
   private JTextField title=new JTextField();
   private JTextArea desc=new JTextArea();
   private SimpleDateFormat format;
   
   public AddButton(String label,MyButton b){
      super(label);
      button=b; 
        
       //hour.addActionListener(this);
      addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e){
      button.getFrame().setVisible(false);
      frame=new JFrame("Add Appointment");
      Container cp=frame.getContentPane();
      SpringLayout layout = new SpringLayout();
      cp.setLayout(new GridLayout(4,1));
      JPanel p1=new JPanel(new GridLayout(2,2));
      JPanel p2=new JPanel(new BorderLayout());
      JPanel p3=new JPanel(new BorderLayout());
      JPanel p=new JPanel(new FlowLayout());
      JLabel h=new JLabel("Hour: ");
      JLabel t=new JLabel("Title: ");
      JLabel d=new JLabel("Description: ");
      
      
      Date date=new Date();
      SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
      JSpinner jSpinner1=new javax.swing.JSpinner(sm);
      JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "HH:mm");
      de.getTextField().setEditable( false );
      jSpinner1.setEditor(de);
      jSpinner1.getEditor().getComponent(0).setBackground(new Color(200,200,220));
      JButton cancel=new JButton("Exit");
      cancel.addActionListener(
         new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent a) {
                    frame.dispose();
                    button.actionPerformed(a);
                }
          });
      
      JButton save=new JButton("Save");
      save.addActionListener(
         new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent evt) {
                    
               Object value1 = jSpinner1.getValue();
               String time2="";
               try{
                  if (value1 instanceof Date) {
                     Date date1 = (Date)value1;
                     format = new SimpleDateFormat("HH:mm");
                     String time = format.format(date1);
                     Date d=format.parse(time);
                     time2=format.format(d);
                  }
               }
               catch (ParseException pe) {
                  pe.printStackTrace();
               }   
                    //System.out.println(time2);
                    event=new Appointments(time2+" ",title.getText(),desc.getText());
                    button.getApp().insert(event);
                    button.update(button.getApp());
                    button.actionPerformed(evt);
                    frame.dispose();
                }
          });
      JLabel blank=new JLabel(" ");
      JLabel blank2=new JLabel("");
      p1.add(h); 
      p1.add(jSpinner1);
      p1.add(blank);p1.add(blank2);
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
