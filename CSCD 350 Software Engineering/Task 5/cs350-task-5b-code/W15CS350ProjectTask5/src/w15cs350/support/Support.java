package w15cs350.support;

//=============================================================================================================================================================
/**
 * This abstract class supplies support functionality statically. Treat it as a singleton class.
 * 
 * @author Dan Tappan [10.09.13]
 */
public abstract class Support
{
   /** the system-independent newline character */
   public static final String NEWLINE = System.lineSeparator();

   /** whether to disable locked functionality */
   private static final boolean FAIL_LOCKED = true;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Returns a string minus a suffix if it is present, or the original string if it is not.
    * 
    * @param string - the string
    * @param suffix - the suffix
    * 
    * @return the chomped string
    */
   public static String chomp(final String string, final String suffix)
   {
      Assert.nonnull(string, suffix);
      Assert.nonnullempty(suffix);

      if (string.endsWith(suffix))
      {
         return string.substring(0, (string.length() - suffix.length()));
      }

      return string;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Returns a string minus a suffix if it is present, or the original string if it is not.
    * 
    * @param stream - the string, which is an in/out parameter
    * @param suffix - the suffix
    * 
    * @return the chomped string
    */
   public static StringBuilder chomp(final StringBuilder stream, final String suffix)
   {
      Assert.nonnull(stream);
      Assert.nonnullempty(suffix);

      int index = (stream.length() - suffix.length());

      if (stream.substring(index).equals(suffix))
      {
         return stream.delete(index, stream.length());
      }

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Throws an exception indicating the caller is not available to be executed.
    * 
    * @throws RuntimeException the exception
    */
   public static void failLocked()
   {
      if (FAIL_LOCKED)
      {
         throw new RuntimeException("this feature is locked; execution is disabled");
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Formats a double value as #.#.
    * 
    * @param value - the value
    * 
    * @return the formatted value
    */
   public static String format(final double value)
   {
      return String.format("%1.1f", value);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Determines whether two doubles are within 0.00001 of each other.
    * 
    * @param value1 - the first value
    * @param value2 - the second value
    * 
    * @return the result
    */
   public static boolean isEqual(final double value1, final double value2)
   {
      final double EPSILON = 0.00001;

      return (Math.abs(value1 - value2) < EPSILON);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether to disable locked functionality.
    * 
    * @return the result
    */
   public static boolean isLocked()
   {
      return FAIL_LOCKED;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rounds a real value to an integer.
    * 
    * @param value - the value
    * 
    * @return the integer
    */
   public static int round(final double value)
   {
      return (int) Math.round(value);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rounds a real value to an integer not less than 1.
    * 
    * @param value - the value
    * 
    * @return the integer
    */
   public static int roundFloor(final double value)
   {
      int roundedValue = (int) Math.round(value);

      return ((roundedValue >= 1) ? roundedValue : 1);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rounds a real value to an integer not less than a floor.
    * 
    * @param value - the value
    * @param floor - the floor
    * 
    * @return the integer
    */
   public static int roundFloor(final double value, final int floor)
   {
      int roundedValue = (int) Math.round(value);

      return ((roundedValue >= floor) ? roundedValue : floor);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rounds a real value to a tenth.
    * 
    * @param value - the value
    * 
    * @return the result
    */
   public static double roundTenth(final double value)
   {
      return (Math.round(value * 10) / 10.0);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rounds up an integer.
    * 
    * @param value - the value
    * 
    * @return the result
    */
   public static int roundUp(final double value)
   {
      return (int) Math.round(value + 0.5);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates that the caller of this method was called by an instance of a given class.
    * 
    * @param clazz - the expected class of the caller's caller
    * @param isSubclassValid - whether a subclass is valid, or only the explicitly stated class
    */
   public static void validateCaller(final Class<?> clazz, final boolean isSubclassValid)
   {
      Assert.nonnull(clazz);

      (new Exception()).getStackTrace();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Prevents subclassing and inadvertent instantiation.
    */
   private Support()
   {
      assert false : "singleton";
   }
}
