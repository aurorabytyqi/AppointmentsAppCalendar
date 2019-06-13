public class Day{
   private AppointmentsDatabase events;
   private String key;
   
   public Day(AppointmentsDatabase events,String k){
      this.events=events;
      key=k;
   }
   
   public AppointmentsDatabase getEvents(){
      return events;
   }
   
   public String getKey(){
      return key;
   }
}