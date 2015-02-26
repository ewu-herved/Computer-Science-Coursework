package w15cs350.support;

import java.io.PrintWriter;
import java.io.StringWriter;

//=============================================================================================================================================================
/**
 * This abstract class supplies assertion functionality statically. Treat it as a singleton class.
 * 
 * @author Dan Tappan [14.09.12]
 */
public abstract class Assert
{
   /** whether an error is already being handled; this prevents cascading errors */
   private static boolean isHandlingError = false;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a boolean as being true with an assertion.
    * 
    * @param value - the value
    * @param message - the optional message to print if the assertion fails
    */
   public static void assert2(final boolean value, final double... message)
   {
      nonnull(value);

      if (!value)
      {
         Assert.throwAssertionError((message.length == 0) ? "" : ("" + message[0]));
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a boolean as being true with an assertion.
    * 
    * @param value - the value
    * @param message - the optional message to print if the assertion fails
    */
   public static void assert2(final boolean value, final String... message)
   {
      nonnull(value);
      optional(message);

      if (!value)
      {
         Assert.throwAssertionError((message.length == 0) ? "" : message[0]);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates two numerical values as being equal. Doubles should not compared.
    * 
    * @param value1 - the first value
    * @param value2 - the second value
    */
   public static void equal(final double value1, final double value2)
   {
      if (value1 != value2)
      {
         Assert.throwAssertionError(value1 + "!=" + value2);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Throws an unconditional assertion error.
    * 
    * @param exception - the exception
    * @param message - the message
    */
   public static void fail(final Exception exception, final String message)
   {
      nonnull(message);
      nonnullempty(message);

      Assert.throwAssertionError(message);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Throws an unconditional assertion error.
    * 
    * @param message - the message
    */
   public static void fail(final String message)
   {
      nonnullempty(message);

      Assert.throwAssertionError(message);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a numerical value as being above a limit.
    * 
    * @param value - the value
    * @param limit - the minimum legal value
    */
   public static void gt(final double value, final double limit)
   {
      if (value <= limit)
      {
         Assert.throwAssertionError(value + "<=" + limit);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a numerical value as being at or above a limit.
    * 
    * @param value - the value
    * @param limit - the minimum legal value
    */
   public static void gte(final double value, final double limit)
   {
      if (value < limit)
      {
         Assert.throwAssertionError(value + "<" + limit);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a list of booleans as being false with an assertion.
    * 
    * @param values - the values
    */
   public static void isFalse(final boolean... values)
   {
      nonnull(values);

      for (int iValue = 0; iValue < values.length; ++iValue)
      {
         boolean value = values[iValue];

         if (value)
         {
            Assert.throwAssertionError("argument " + (iValue + 1) + " of " + values.length + " true");
         }
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a list of booleans as being true with an assertion.
    * 
    * @param values - the values
    */
   public static void isTrue(final boolean... values)
   {
      nonnull(values);

      for (int iValue = 0; iValue < values.length; ++iValue)
      {
         boolean value = values[iValue];

         if (!value)
         {
            Assert.throwAssertionError("argument " + (iValue + 1) + " of " + values.length + " false");
         }
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validate a boolean as being true with an assertion.
    * 
    * @param value - the value
    * @param message - the message
    */
   public static void isTrue(final boolean value, final String message)
   {
      nonnull(value);
      nonnullempty(message);

      if (!value)
      {
         Assert.throwAssertionError(message);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a numerical value as being below a limit.
    * 
    * @param value - the value
    * @param limit - the maximum legal value
    */
   public static void lt(final double value, final double limit)
   {
      if (value >= limit)
      {
         Assert.throwAssertionError(value + ">=" + limit);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a numerical value as being at or below a limit.
    * 
    * @param value - the value
    * @param limit - the maximum legal value
    */
   public static void lte(final double value, final double limit)
   {
      if (value > limit)
      {
         Assert.throwAssertionError(value + ">" + limit);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a list of values as being non-negative with an assertion.
    * 
    * @param values - the values
    */
   public static void nonnegative(final double... values)
   {
      nonnull(values);

      for (int iValue = 0; iValue < values.length; ++iValue)
      {
         double value = values[iValue];

         if (value < 0)
         {
            Assert.throwAssertionError("argument " + (iValue + 1) + " of " + values.length + " value " + value);
         }
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a list of objects as being non-null with an assertion.
    * 
    * @param values - the values
    */
   @SuppressWarnings("null")
   public static void nonnull(final Object... values)
   {
      if (values == null)
      {
         Assert.throwAssertionError("null");
      }

      for (int iValue = 0; iValue < values.length; ++iValue)
      {
         Object value = values[iValue];

         if (value == null)
         {
            Assert.throwAssertionError("argument " + (iValue + 1) + " of " + values.length + " null");
         }
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a list of strings as being non-null and non-empty with an assertion.
    * 
    * @param values - the values
    */
   @SuppressWarnings("null")
   public static void nonnullempty(final String... values)
   {
      if (values == null)
      {
         Assert.throwAssertionError("null");
      }

      for (int iValue = 0; iValue < values.length; ++iValue)
      {
         String value = values[iValue];

         if (value == null)
         {
            Assert.throwAssertionError("argument " + (iValue + 1) + " of " + values.length + " null");
         }

         if (value.isEmpty())
         {
            Assert.throwAssertionError("argument " + (iValue + 1) + " of " + values.length + " empty");
         }
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates an optional argument as being absent with an assertion.
    * 
    * @param argument - the argument
    */
   public static void notallowed(final Object[] argument)
   {
      nonnull(argument);

      if (argument.length != 0)
      {
         Assert.throwAssertionError("zero arguments required, not " + argument.length);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a list of values as being one with an assertion.
    * 
    * @param values - the values
    */
   public static void one(final double... values)
   {
      nonnull(values);

      for (int iValue = 0; iValue < values.length; ++iValue)
      {
         double value = values[iValue];

         if (value == 1)
         {
            Assert.throwAssertionError("argument " + (iValue + 1) + " of " + values.length + " value " + value);
         }
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates an optional argument as being absent or present only once with an assertion.
    * 
    * @param argument - the argument
    */
   public static void optional(final Object[] argument)
   {
      nonnull(argument);

      if (argument.length > 1)
      {
         Assert.throwAssertionError("zero or one arguments allowed, not " + argument.length);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a list of values as being positive with an assertion.
    * 
    * @param values - the values
    */
   public static void positive(final double... values)
   {
      nonnull(values);

      for (int iValue = 0; iValue < values.length; ++iValue)
      {
         double value = values[iValue];

         if (value <= 0)
         {
            Assert.throwAssertionError("argument " + (iValue + 1) + " of " + values.length + " value " + value);
         }
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a numerical value as being on a range.
    * 
    * @param value - the value
    * @param min - the minimum legal value
    * @param max - the maximum legal value
    */
   public static void range(final double value, final double min, final double max)
   {
      if (value < min)
      {
         Assert.throwAssertionError(value + "<" + min);
      }
      if (value > max)
      {
         Assert.throwAssertionError(value + ">" + max);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates an optional argument as being present only once with an assertion.
    * 
    * @param argument - the argument
    */
   public static void required(final Object[] argument)
   {
      nonnull(argument);

      if (argument.length != 1)
      {
         Assert.throwAssertionError("one argument required, not " + argument.length);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Throws an unconditional assertion error.
    * 
    * @param exception - the exception
    */
   public static void throwAssertionError(final Exception exception)
   {
      throwAssertionError(exception.getMessage());
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Throws an unconditional assertion error.
    * 
    * @param message - the message
    */
   public static void throwAssertionError(final String message)
   {
      if (!isHandlingError)
      {
         isHandlingError = true;

         StringWriter buffer = new StringWriter();

         (new Throwable()).printStackTrace(new PrintWriter(buffer));

         String message2 = (message + "\n\n" + buffer.getBuffer());

         System.err.println(message2);

         throw new AssertionError(message2);
      }

      System.err.println("cascaded error: " + message);

      throw new AssertionError(message);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Validates a list of values as being zero with an assertion.
    * 
    * @param values - the values
    */
   public static void zero(final double... values)
   {
      nonnull(values);

      for (int iValue = 0; iValue < values.length; ++iValue)
      {
         double value = values[iValue];

         if (value != 0)
         {
            Assert.throwAssertionError("argument " + (iValue + 1) + " of " + values.length + " value " + value);
         }
      }
   }
}
