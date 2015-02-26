package w15cs350.datatype;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_XMLable;
import w15cs350.support.Support;

//=============================================================================================================================================================
/**
 * Defines a measure of nonnegative distance in arbitrary units.
 * 
 * @author Dan Tappan [12.01.15]
 */
public class Distance implements I_XMLable, Comparable<Distance>
{
   /** the nonnegative distance */
   private final double _distance;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a distance.
    * 
    * @param distance - the nonnegative distance
    */
   public Distance(final double distance)
   {
      if (distance < 0)
      {
         throw new IllegalArgumentException("invalid distance: " + distance);

      }
      _distance = distance;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Adds a distance to this one and returns a new distance with the sum.
    * 
    * @param distance - the distance to add
    * 
    * @return the new distance
    */
   public Distance add(final Distance distance)
   {
      Assert.nonnull(distance);

      return new Distance(_distance + distance.getValue());
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public int compareTo(final Distance distance)
   {
      Assert.nonnull(distance);

      return Double.compare(_distance, distance._distance);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the underlying value of the distance.
    * 
    * @return the value
    */
   public double getValue()
   {
      return _distance;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts a distance from this one and returns a new distance with the difference.
    * 
    * @param distance - the distance to subtract
    * 
    * @return the new distance, which cannot be negative
    */
   public Distance subtract(final Distance distance)
   {
      Assert.nonnull(distance);

      return new Distance(_distance - distance.getValue());
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("Distance{" + Support.format(_distance) + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<distance value=\"" + _distance + "\"/>" + NEWLINE);

      return stream;
   }
}
