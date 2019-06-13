public class AppointmentsDatabase{ 
   private Appointments[] base;   
   private int NOT_FOUND = -1; 

   public AppointmentsDatabase(int initial_size)
   { 
      if ( initial_size > 0 )
      { base = new Appointments[initial_size]; }
      else { base = new Appointments[1]; }
   }

   private int findLocation(String k)
   { int result = NOT_FOUND;
      String s="";
      boolean found = false;
      int i = 0;
      while ( !found  &&  i != base.length )
      { 
         if(base[i] != null ){
            s= base[i].getHour()+" "+base[i].getEvent();}
         if ( base[i] != null  &&  s.equals(k) )
         { found = true;
            result = i;
         }
         else { i = i + 1; }
      }
      return result;
   }

   public Appointments find(String k)
   { Appointments answer = null;
      int index = findLocation(k);
      if ( index != NOT_FOUND )
      { answer = base[index]; }
      return answer;
   }

   public boolean insert(Appointments r)
   { boolean success = false;
      if ( findLocation(r.getHour()+" "+r.getEvent()) == NOT_FOUND )   {
         boolean found_empty_place = false;
         int i = 0;
         while ( !found_empty_place  &&  i != base.length )
         { 
            if ( base[i] == null )  
            { found_empty_place = true; }
            else { i = i + 1; }
         }
         if ( found_empty_place )
         { base[i] = r; }
         else { 
            Appointments[] temp = new Appointments[base.length * 2];
            for ( int j = 0;  j != base.length;  j = j + 1 )
            { temp[j] = base[j]; } 
            temp[base.length] = r;  
            base = temp;  
         }
         success = true;
      }
      return success;
   }

 
   public boolean delete(String k)
   { boolean result = false;
      int index = findLocation(k);
      if ( index != NOT_FOUND )
      { base[index] = null;
         result = true;
      }
      return result;
   }
  
   public Appointments[] getAppointment(){
      return base;
   }
  
  
}