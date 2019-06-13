public class DayDatabase{ 
   private Day[] base;   
   private int NOT_FOUND = -1; 
  
   public DayDatabase(int initial_size)
   { 
      if ( initial_size > 0 )
      { base = new Day[initial_size]; }
      else { base = new Day[1]; }
   }

  
   private int findLocation(String k)
   { int result = NOT_FOUND;
      boolean found = false;
      int i = 0;
      while ( !found  &&  i != base.length )
      { 
         if ( base[i] != null  &&  base[i].getKey().equals(k) )
         { found = true;
            result = i;
         }
         else { i = i + 1; }
      }
      return result;
   }


   public Day find(String k)
   { Day answer = null;
      int index = findLocation(k);
      if ( index != NOT_FOUND )
      { answer = base[index]; }
      return answer;
   }
 
   public boolean insert(Day r)
   { boolean success = false;
      if ( findLocation(r.getKey()) == NOT_FOUND ) 
      { 
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
            Day[] temp = new Day[base.length * 2];
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
  
   public Day[] getDay(){
      return base;
   }
  
  
}