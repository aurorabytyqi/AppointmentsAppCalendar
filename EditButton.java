import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

public class EditButton extends JButton implements ActionListener{
   private AppointmentsDatabase events;
   private Appointments appointment;
   private JFrame frame;
   private MyButton button;
   private JTextField hour;
   private Appointments event;
   private JTextField title;
   private JTextArea desc;
   private SimpleDateFormat format;
   
   public EditButton(String label,MyButton b){
      super(label);
      button=b; 
      addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e){
      if(!button.getSelected()){  
      button.getFrame().setVisible(false);
      frame=new JFrame("Change Appointment");
      Container cp=frame.getContentPane();
      cp.setLayout(new GridLayout(4,1));
      
      
      events=button.getApp();
      appointment=events.find(button.getKey());
      hour=new JTextField(appointment.getHour()+" ");
      title=new JTextField(appointment.getEvent());
      desc=new JTextArea(appointment.getComment());
      
      String hr=appointment.getHour().substring(0,2);
      String m=appointment.getHour().substring(3,5);
      int hh = Integer.parseInt(hr);
      int mm = Integer.parseInt(m);
      
      //System.out.println(mm);
      
      JPanel p1=new JPanel(new GridLayout(2,6));
      JPanel p2=new JPanel(new BorderLayout());
      JPanel p3=new JPanel(new BorderLayout());
      JPanel p=new JPanel(new FlowLayout());
      
      //Spin  "1 Jun 2019 "+appointment.getHour()+" GMT"
      Date date=new Date(2019,5,1,hh,mm);
      SpinnerDateModel sm=new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
      JSpinner jSpinner1=new javax.swing.JSpinner(sm);
      JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner1, "HH:mm");
      de.getTextField().setEditable( false );
      jSpinner1.setEditor(de);
      jSpinner1.getEditor().getComponent(0).setBackground(new Color(200,200,220));
      

      JLabel h=new JLabel("Time: ");
      JLabel t=new JLabel("Title: ");
      JLabel d=new JLabel("Description: ");
      JButton cancel=new JButton("Back");
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
                    button.getApp().find(button.getKey()).edit(time2,title.getText(),desc.getText());
                    button.update(button.getApp());
                    button.actionPerformed(evt);
                    frame.dispose();
                }
          });
      
      JLabel blank=new JLabel(" ");
      JLabel blank2=new JLabel("");
      JLabel blank3=new JLabel("");
      JLabel blank4=new JLabel("");
      JLabel blank5=new JLabel("");
      JLabel blank6=new JLabel("");
      JLabel blank7=new JLabel("");
      JLabel blank8=new JLabel("");
      JLabel blank9=new JLabel("");
      JLabel blank10=new JLabel("");
      p1.add(h);
      p1.add(jSpinner1);
      p1.add(blank);p1.add(blank2);p1.add(blank3);p1.add(blank4);p1.add(blank5);
      p1.add(blank6);p1.add(blank7);p1.add(blank8);p1.add(blank9);p1.add(blank10);
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
   }
   
   public JFrame getFrame(){
     return frame;
   }
   
}
