public class Appointments{
   private String hour="";
   private String event="";
   private String comment="";
   public Appointments(String hour,String event,String comment){
      this.hour=hour;
      this.event=event;
      this.comment=comment;
   }
  
   public String getHour(){
      return hour;
   }
  
   public String getEvent(){
      return event;
   }
  
   public String getComment(){
      return comment;
   }
  
   public void edit(String hour,String event,String comment){
      if(hour!=null || !hour.equals(""))this.hour=hour;
      if(event!=null || !event.equals(""))this.event=event;
      if(comment!=null || !comment.equals(""))this.comment=comment;
   }
}