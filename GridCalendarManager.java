public class GridCalendarManager  {
public static void main(String[] args){
      DayDatabase d=new DayDatabase(31);
      for(int i=0;i!=32;i++){
      Day day=new Day(new AppointmentsDatabase(100),i+"");
      d.insert(day);}
      new GridCalendar(d);
      }
}