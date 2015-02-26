package w15cs350.datatype;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_XMLable;

//=============================================================================================================================================================
/**
 * Defines a vector as an attitude and a distance.
 * 
 * @author Dan Tappan [12.01.15]
 */
public class Vector implements I_XMLable
{
   /** the attitude */
   private final Attitude _attitude;

   /** the distance */
   private final Distance _distance;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a vector.
    * 
    * @param attitude - the attitude
    * @param distance - the distance
    */
   public Vector(final Attitude attitude, final Distance distance)
   {
      Assert.nonnull(attitude, distance);

      _attitude = attitude;
      _distance = distance;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a vector from two positions.
    * 
    * @param position1 - the source position
    * @param position2 - the target position
    */
   public Vector(final Position position1, final Position position2)
   {
      Assert.nonnull(position1, position2);

      _attitude = position1.calculateAttitude(position2);
      _distance = position1.calculateDistance(position2);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Adds an attitude to this one and returns a new vector with the sum and the original distance.
    * 
    * @param attitude - the attitude to add
    * 
    * @return the new vector
    */
   public Vector add(final Attitude attitude)
   {
      Assert.nonnull(attitude);

      Attitude attitudeNew = _attitude.add(attitude);

      return new Vector(attitudeNew, _distance);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Adds a vector to this one and returns a new vector with the sum.
    * 
    * @param vector - the vector to add
    * 
    * @return the new vector
    */
   public Vector add(final Vector vector)
   {
      Assert.nonnull(vector);

      Attitude attitude = _attitude.add(vector.getAttitude());

      Distance distance = _distance.add(vector.getDistance());

      return new Vector(attitude, distance);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the attitude.
    * 
    * @return the attitude
    */
   public Attitude getAttitude()
   {
      return _attitude;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the distance.
    * 
    * @return the distance
    */
   public Distance getDistance()
   {
      return _distance;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new vector with the attitude of this one negated.
    * 
    * @return the new vector
    */
   public Vector negate()
   {
      Yaw yawNew = _attitude.getYaw().negate();

      Pitch pitchNew = _attitude.getPitch().negate();

      Attitude attitudeNew = new Attitude(yawNew, pitchNew);

      return new Vector(attitudeNew, _distance);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates a position applied to a position from this vector.
    * 
    * @param source - the source position
    * 
    * @return the target position
    */
   public Position resolveTarget(final Position source)
   {
      Assert.nonnull(source);

      double sourceX = source.getX();
      double sourceY = source.getY();
      double sourceZ = source.getZ();

      double yaw = Math.toRadians(-_attitude.getYaw().getAngleDegrees() + 90);
      double pitch = Math.toRadians(90 - _attitude.getPitch().getAngleDegrees());

      double distance = _distance.getValue();

      double targetX = (sourceX + (distance * Math.sin(pitch) * Math.cos(yaw)));
      double targetY = (sourceY + (distance * Math.sin(pitch) * Math.sin(yaw)));
      double targetZ = (sourceZ + (distance * Math.cos(pitch)));

      return new Position(targetX, targetY, targetZ);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts an attitude from this one and returns a new vector with the difference and the original distance.
    * 
    * @param attitude - the attitude to subtract
    * 
    * @return the new vector
    */
   public Vector subtract(final Attitude attitude)
   {
      Assert.nonnull(attitude);

      Attitude attitudeNew = _attitude.subtract(attitude);

      return new Vector(attitudeNew, _distance);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts a vector from this one and returns a new vector with the difference.
    * 
    * @param vector - the vector to subtract
    * 
    * @return the new vector
    */
   public Vector subtract(final Vector vector)
   {
      Assert.nonnull(vector);

      Attitude attitude = _attitude.subtract(vector.getAttitude());

      Distance distance = _distance.subtract(vector.getDistance());

      return new Vector(attitude, distance);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("Vector{" + _attitude + " " + _distance + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<vector>" + NEWLINE);

      stream.append(_attitude.toXML_());
      stream.append(_distance.toXML_());

      stream.append("</vector>" + NEWLINE);

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new vector with the given attitude and the existing distance.
    * 
    * @param attitude - the attitude
    * 
    * @return the vector
    */
   public Vector updateAttitude(final Attitude attitude)
   {
      Attitude attitudeNew = _attitude.add(attitude);

      return new Vector(attitudeNew, _distance);
   }
}
