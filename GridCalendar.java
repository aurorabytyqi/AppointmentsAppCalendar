import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.border.LineBorder;
public class GridCalendar extends JFrame{
   
   Calendar calendar = new GregorianCalendar();
   Date trialTime = new Date();
   private DayDatabase model;
   private AppointmentsDatabase imfull;
   private Color color;
   private JButton button;
   private Calendar c = new GregorianCalendar();
   
   public GridCalendar(DayDatabase database){
      model=database;
      calendar.setTime(trialTime);
      /*int[] months={0,1,2,3,4,5,6,7,8,9,10,11};
      for(int i=0;i<months.length;i++){//GregorianCalendar bug
         if(Calendar.MONTH == months[i])
         {System.out.println(months[i]);
            c = new GregorianCalendar(Calendar.YEAR,months[i],1);}
      }*/
      Calendar c =Calendar.getInstance();// new GregorianCalendar(Calendar.YEAR,Calendar.MONTH,1);
      int dayOfWeek=calendar.get(Calendar.DAY_OF_WEEK);
      int currentDay=calendar.get(Calendar.DAY_OF_MONTH);
      int monthDays = c.getActualMaximum(Calendar.DAY_OF_MONTH);
      int count=currentDay;
      while(count!=1){
         dayOfWeek=(dayOfWeek-1)%7;
         count--;
         if(dayOfWeek==0)dayOfWeek=7;
      }
   
      Container cp=getContentPane();
      
      cp.setLayout(new BorderLayout());
      
      JLabel[] label={new JLabel("Mon"),new JLabel("Tue"),new JLabel("Wed"),
                      new JLabel("Thur"),new JLabel("Fri"),new JLabel("Sat"),new JLabel("Sun")};
      JPanel p=new JPanel(new GridLayout(1,7));
      for(int i=0;i<label.length;i++){
         p.add(label[i]);
      }
      cp.add(p,BorderLayout.NORTH);
      JPanel panel=new JPanel(new GridLayout(5,6,2,2));
   
      for(int i=0;i<monthDays;i++){
         while(dayOfWeek!=2){
            panel.add(new JLabel(""));
            dayOfWeek--;
         }
         
         
      
         if(model.getDay()[i]!=null  ){
            button=new MyButton(""+(i+1),model.getDay()[i].getEvents());
            panel.add(button);
         }
         if(currentDay==i+1){
            button.setBackground(new Color(98,186,235));
            panel.add(button);
         }
         else{
            panel.add(button);
         }
         
      }
      
      cp.add(panel,BorderLayout.CENTER);
      
     
      setSize(450,300);
      setTitle("Monthly Appointments app");
      setVisible(true);
   }
}