import javax.swing.*;
import java.awt.event.*;
import java.awt.*; 
public class DeleteButton extends JButton implements ActionListener{

   private AppointmentsDatabase events;
   private MyButton button;
    
   public  DeleteButton(String label,MyButton b){
      super(label);
      button=b; 
      addActionListener(this);
   }
   
   public void actionPerformed(ActionEvent e){
          
      if(!button.getSelected()){ 
         events =button.getApp();
         events.delete(button.getKey());
         if(events.getAppointment()[0]!=null){
            button.update(events);}
         else{
            button.update2(events);
         }
         button.getFrame().dispose();
         button.actionPerformed(e);
      }
   
   }
 
}