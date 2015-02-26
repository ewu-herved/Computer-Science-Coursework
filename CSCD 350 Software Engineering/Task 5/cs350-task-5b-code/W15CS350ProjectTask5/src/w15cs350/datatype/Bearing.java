package w15cs350.datatype;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_XMLable;

//=============================================================================================================================================================
/**
 * Defines a bearing as a vector from a position.
 * 
 * @author Dan Tappan [12.01.15]
 */
public class Bearing implements I_XMLable
{
   /** the origin */
   private final Position _origin;

   /** the vector */
   private final Vector _vector;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a bearing.
    * 
    * @param origin - the origin
    * @param vector - the vector
    */
   public Bearing(final Position origin, final Vector vector)
   {
      Assert.nonnull(origin, vector);

      _origin = origin;
      _vector = vector;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Adds a bearing to this one and returns a new bearing with the sum.
    * 
    * @param bearing - the bearing to add
    * 
    * @return the new bearing
    */
   public Bearing add(final Bearing bearing)
   {
      Assert.nonnull(bearing);

      Position origin = _origin.add(bearing.getOrigin());

      Vector vector = _vector.add(bearing.getVector());

      return new Bearing(origin, vector);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the origin.
    * 
    * @return the origin
    */
   public Position getOrigin()
   {
      return _origin;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the vector.
    * 
    * @return - the vector
    */
   public Vector getVector()
   {
      return _vector;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates the target position by following the vector from the origin.
    * 
    * @return the position
    */
   public Position resolveTarget()
   {
      return _vector.resolveTarget(_origin);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts a bearing from this one and returns a new bearing with the difference.
    * 
    * @param bearing - the bearing to subtract
    * 
    * @return the new bearing
    */
   public Bearing subtract(final Bearing bearing)
   {
      Assert.nonnull(bearing);

      Position origin = _origin.subtract(bearing.getOrigin());

      Vector vector = _vector.subtract(bearing.getVector());

      return new Bearing(origin, vector);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("Bearing{" + _origin + " " + _vector + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<bearing>" + NEWLINE);

      stream.append(_origin.toXML_());
      stream.append(_vector.toXML_());

      stream.append("</bearing>" + NEWLINE);

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new bearing with the given attitude and the existing origin.
    * 
    * @param attitude - the attitude
    * 
    * @return the bearing
    */
   public Bearing updateVector(final Attitude attitude)
   {
      Vector vector = _vector.updateAttitude(attitude);

      return new Bearing(_origin, vector);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new bearing with the given vector and the existing origin.
    * 
    * @param vector - the vector
    * 
    * @return the bearing
    */
   public Bearing updateVector(final Vector vector)
   {
      return new Bearing(_origin, vector);
   }
}
