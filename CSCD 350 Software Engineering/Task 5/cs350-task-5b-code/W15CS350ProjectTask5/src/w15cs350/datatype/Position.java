package w15cs350.datatype;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_Gnuplotable;
import w15cs350.support.I_XMLable;
import w15cs350.support.Support;

//=============================================================================================================================================================
/**
 * Defines a three-dimensional position with arbitrary units on the coordinate system discussed in class.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class Position implements I_XMLable, I_Gnuplotable
{
   /** a neutral center position */
   public static final Position CENTER = new Position(0, 0, 0);

   /**
    * the optional arbitrary name, which may be null. It is advisory only, generally for clarifying output. It may not be retained consistently after subsequent
    * manipulation unless the client explicitly does so
    */
   private String _name;

   /** the x position */
   private final double _x;

   /** the y position */
   private final double _y;

   /** the z position */
   private final double _z;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a position.
    * 
    * @param x - the <i>x</i> position
    * @param y - the <i>y</i> position
    * @param z - the <i>z</i> position
    */
   public Position(final double x, final double y, final double z)
   {
      _name = null;

      _x = x;
      _y = y;
      _z = z;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a position descriptor with a name.
    * 
    * @param name - the optional arbitrary name, which may be null. It is advisory only, generally for clarifying output. It may not be retained consistently
    * after subsequent manipulation unless the client explicitly does so
    * @param x - the <i>x</i> coordinate
    * @param y - the <i>y</i> coordinate
    * @param z - the <i>z</i> coordinate
    */
   public Position(final String name, final double x, final double y, final double z)
   {
      _name = name;

      _x = x;
      _y = y;
      _z = z;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Adds a position to this one and returns a new position with the sum.
    * 
    * @param position - the position to add
    * 
    * @return the new position
    */
   public Position add(final Position position)
   {
      Assert.nonnull(position);

      double x = (_x + position._x);
      double y = (_y + position._y);
      double z = (_z + position._z);

      return new Position(_name, x, y, z);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates the attitude between this position and another.
    * 
    * @param position - the other position
    * 
    * @return the attitude
    */
   public Attitude calculateAttitude(final Position position)
   {
      Assert.nonnull(position);

      Yaw yaw = calculateYaw(position);

      Pitch pitch = calculatePitch(position);

      return new Attitude(yaw, pitch);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates the bearing between this position and another.
    * 
    * @param position - the other position
    * 
    * @return the bearing
    */
   public Bearing calculateBearing(final Position position)
   {
      Vector vector = calculateVector(position);

      return new Bearing(this, vector);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates the distance between this position and another.
    * 
    * @param position - the other position
    * 
    * @return the distance
    */
   public Distance calculateDistance(final Position position)
   {
      Assert.nonnull(position);

      Position delta = subtract(position);

      double deltaX = delta.getX();
      double deltaY = delta.getY();
      double deltaZ = delta.getZ();

      double distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));

      return new Distance(distance);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------\
   /**
    * Calculates the pitch between this position and another.
    * 
    * @param position - the other position
    * 
    * @return the pitch
    */
   public Pitch calculatePitch(final Position position)
   {
      Assert.nonnull(position);

      double deltaX = (_x - position._x);
      double deltaY = (_y - position._y);
      double deltaZ = (_z - position._z);

      double distance = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY) + (deltaZ * deltaZ));

      double angle = 0;

      if (distance != 0)
      {
         angle = (90 - Math.toDegrees(Math.acos(-deltaZ / distance)));
      }

      return new Pitch(angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates a position based on a vector from this position.
    * 
    * @param vector - the vector
    * 
    * @return the target position
    */
   public Position calculatePosition(final Vector vector)
   {
      Assert.nonnull(vector);

      return vector.resolveTarget(this);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates the vector between this position and another.
    * 
    * @param position - the other position
    * 
    * @return the vector
    */
   public Vector calculateVector(final Position position)
   {
      return new Vector(this, position);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates the yaw between this position and another.
    * 
    * @param position - the other position
    * 
    * @return the yaw
    */
   public Yaw calculateYaw(final Position position)
   {
      Assert.nonnull(position);

      double deltaX = (_x - position._x);
      double deltaY = (_y - position._y);

      double angle = (Math.toDegrees(Math.atan2(-deltaY, deltaX)) - 90);

      angle = Yaw.normalize(angle);

      return new Yaw(angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Returns whether two positions are equal based on their <i>x</i>, <i>y</i>, and <i>z</i> values, where comparison is defined as
    * {@link Support#isEqual(double,double)}
    * 
    * @param object - the other object
    * 
    * @return the result
    */
   @Override
   public boolean equals(final Object object)
   {
      if (this == object)
      {
         return true;
      }

      if (object == null)
      {
         return false;
      }

      if (getClass() != object.getClass())
      {
         return false;
      }

      Position position2 = (Position) object;

      return (Support.isEqual(_x, position2._x) && Support.isEqual(_y, position2._y) && Support.isEqual(_z, position2._z));
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the optional arbitrary name, which may be null. It is advisory only, generally for clarifying output. It may not be retained consistently after
    * subsequent manipulation unless the client explicitly does so
    * 
    * @return the name
    */
   public String getName()
   {
      if (!hasName())
      {
         throw new RuntimeException("no name set");
      }

      return _name;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the <i>x</i> coordinate.
    * 
    * @return the coordinate
    */
   public double getX()
   {
      return _x;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the <i>y</i> coordinate.
    * 
    * @return the coordinate
    */
   public double getY()
   {
      return _y;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the <i>z</i> coordinate.
    * 
    * @return the coordinate
    */
   public double getZ()
   {
      return _z;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public int hashCode()
   {
      return (int) (((_x + 11) * (_y * 37)) + (_z * 79));
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether a name is defined for this position.
    * 
    * @return the result
    */
   public boolean hasName()
   {
      return (_name != null);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Negates this position by flipping the sign of each component and returns a new position.
    * 
    * @return the new position
    */
   public Position negate()
   {
      return new Position(_name, (-_x), (-_y), (-_z));
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rotates this position about a pivot based on an attitude and returns a new position.
    * 
    * @param pivot - the pivot
    * @param attitude - the attitude
    * 
    * @return the new position
    */
   public Position rotate(final Position pivot, final Attitude attitude)
   {
      Assert.nonnull(pivot, attitude);

      Position pointRoll = rotate(pivot, attitude.getRoll());

      Position pointPitch = pointRoll.rotate(pivot, attitude.getPitch());

      Position pointYaw = pointPitch.rotate(pivot, attitude.getYaw());

      return pointYaw;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rotates this position about a pivot based on a pitch and returns a new position.
    * 
    * @param pivot - the pivot
    * @param pitch - the pitch
    * 
    * @return the new position
    */
   public Position rotate(final Position pivot, final Pitch pitch)
   {
      Assert.nonnull(pivot, pitch);

      Position pointTranslatedToOrigin = translate(pivot.negate());

      double pitch2 = -pitch.getAngleRadians();

      double sinPitch = Math.sin(pitch2);
      double cosPitch = Math.cos(pitch2);

      double y = ((pointTranslatedToOrigin._z * sinPitch) + (pointTranslatedToOrigin._y * cosPitch));
      double z = ((pointTranslatedToOrigin._z * cosPitch) - (pointTranslatedToOrigin._y * sinPitch));

      Position pointRotated = new Position(_name, pointTranslatedToOrigin._x, y, z);

      Position pointTranslatedFromOrigin = pointRotated.translate(pivot);

      return pointTranslatedFromOrigin;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rotates this position about a pivot based on a roll and returns a new position.
    * 
    * @param pivot - the pivot
    * @param roll - the roll
    * 
    * @return the new position
    */
   public Position rotate(final Position pivot, final Roll roll)
   {
      Assert.nonnull(pivot, roll);

      Position pointTranslatedToOrigin = translate(pivot.negate());

      double roll2 = roll.getAngleRadians();

      double sinRoll = Math.sin(roll2);
      double cosRoll = Math.cos(roll2);

      double x = ((pointTranslatedToOrigin._z * sinRoll) + (pointTranslatedToOrigin._x * cosRoll));
      double z = ((pointTranslatedToOrigin._z * cosRoll) - (pointTranslatedToOrigin._x * sinRoll));

      Position pointRotated = new Position(_name, x, pointTranslatedToOrigin._y, z);

      Position pointTranslatedFromOrigin = pointRotated.translate(pivot);

      return pointTranslatedFromOrigin;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rotates this position about a pivot based on a yaw and returns a new position.
    * 
    * @param pivot - the pivot
    * @param yaw - the yaw
    * 
    * @return the new position
    */
   public Position rotate(final Position pivot, final Yaw yaw)
   {
      Assert.nonnull(pivot, yaw);

      Position pointTranslatedToOrigin = translate(pivot.negate());

      double yaw2 = -yaw.getAngleRadians();

      double sinYaw = Math.sin(yaw2);
      double cosYaw = Math.cos(yaw2);

      double x = ((pointTranslatedToOrigin._x * cosYaw) - (pointTranslatedToOrigin._y * sinYaw));
      double y = ((pointTranslatedToOrigin._y * cosYaw) + (pointTranslatedToOrigin._x * sinYaw));

      Position pointRotated = new Position(_name, x, y, pointTranslatedToOrigin._z);

      Position pointTranslatedFromOrigin = pointRotated.translate(pivot);

      return pointTranslatedFromOrigin;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Sets the optional arbitrary name, which may be null. It is advisory only, generally for clarifying output. It may not be retained consistently after
    * subsequent manipulation unless the client explicitly does so. Multiple sets are valid.
    * 
    * @param name - the name
    */
   public void setName(final String name)
   {
      Assert.nonnullempty(name);

      _name = name;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts a position to this one and returns a new position with the difference.
    * 
    * @param position - the position to subtract
    * 
    * @return the new position
    */
   public Position subtract(final Position position)
   {
      Assert.nonnull(position);

      double x = (_x - position._x);
      double y = (_y - position._y);
      double z = (_z - position._z);

      return new Position(_name, x, y, z);
   }

   // ------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toGnuplot_()
   {
      return new StringBuilder(_x + " " + _y + " " + _z);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("Position{" + (hasName() ? ("name=[" + _name + "] ") : " ") + Support.format(_x) + " " + Support.format(_y) + " " + Support.format(_z) + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<position x=\"" + _x + "\" y=\"" + _y + "\" z=\"" + _z + "\"/>" + NEWLINE);

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Translates this position by an offset and returns a new position. This is equivalent to {@link #add(Position)}.
    * 
    * @param offset - the offset
    * 
    * @return the new position
    */
   public Position translate(final Position offset)
   {
      return add(offset);
   }
}
