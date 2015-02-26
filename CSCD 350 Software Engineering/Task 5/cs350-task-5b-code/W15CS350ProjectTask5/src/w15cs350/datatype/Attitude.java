package w15cs350.datatype;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_XMLable;

//=============================================================================================================================================================
/**
 * Defines an attitude based on a yaw, pitch, and roll over the <i>z</i>, <i>x</i>, and <i>y</i> axes, respectively.
 * 
 * @author Dan Tappan [12.01.15]
 */
public class Attitude implements I_XMLable
{
   /** a neutral attitude of zero degrees yaw, pitch, and roll */
   public static final Attitude NEUTRAL = new Attitude(Yaw.NEUTRAL, Pitch.NEUTRAL, Roll.NEUTRAL);

   /** the yaw */
   private final Yaw _yaw;

   /** the pitch */
   private final Pitch _pitch;

   /** the roll */
   private final Roll _roll;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates an attitude with the default yaw, pitch, and roll.
    */
   public Attitude()
   {
      _yaw = new Yaw();
      _pitch = new Pitch();
      _roll = new Roll();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates an attitude with a pitch and the default yaw and roll.
    * 
    * @param pitch - the pitch
    */
   public Attitude(final Pitch pitch)
   {
      this(new Yaw(), pitch, new Roll());
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates an attitude with a pitch and roll and the default yaw.
    * 
    * @param pitch - the pitch
    * @param roll - the roll
    */
   public Attitude(final Pitch pitch, final Roll roll)
   {
      this(new Yaw(), pitch, roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates an attitude with a roll and the default yaw and pitch.
    * 
    * @param roll - the roll
    */
   public Attitude(final Roll roll)
   {
      this(new Yaw(), new Pitch(), roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates an attitude with a yaw and the default pitch and roll.
    * 
    * @param yaw - the yaw
    */
   public Attitude(final Yaw yaw)
   {
      this(yaw, new Pitch(), new Roll());
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates an attitude with a yaw and pitch and the default roll.
    * 
    * @param yaw - the yaw
    * @param pitch - the pitch
    */
   public Attitude(final Yaw yaw, final Pitch pitch)
   {
      this(yaw, pitch, new Roll());
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates an attitude.
    * 
    * @param yaw - the yaw
    * @param pitch - the pitch
    * @param roll - the roll
    */
   public Attitude(final Yaw yaw, final Pitch pitch, final Roll roll)
   {
      Assert.nonnull(yaw, pitch, roll);

      _yaw = yaw;
      _pitch = pitch;
      _roll = roll;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates an attitude with a yaw and roll and the default pitch.
    * 
    * @param yaw - the yaw
    * @param roll - the roll
    */
   public Attitude(final Yaw yaw, final Roll roll)
   {
      this(yaw, new Pitch(), roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Adds an attitude to this one and returns a new one with the sum.
    * 
    * @param attitude - the attitude to add
    * 
    * @return the new attitude
    */
   public Attitude add(final Attitude attitude)
   {
      Assert.nonnull(attitude);

      Yaw yaw = _yaw.add(attitude._yaw);

      Pitch pitch = _pitch.add(attitude._pitch);

      Roll roll = _roll.add(attitude._roll);

      return new Attitude(yaw, pitch, roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the pitch.
    * 
    * @return the pitch
    */
   public Pitch getPitch()
   {
      return _pitch;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the roll.
    * 
    * @return the roll
    */
   public Roll getRoll()
   {
      return _roll;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the yaw.
    * 
    * @return the yaw
    */
   public Yaw getYaw()
   {
      return _yaw;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new attitude with the given pitch and roll and the current yaw.
    * 
    * @param pitch - the pitch
    * @param roll - the roll
    * 
    * @return the new attitude
    */
   public Attitude setAttitude(final Pitch pitch, final Roll roll)
   {
      return new Attitude(_yaw, pitch, roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new attitude with the given yaw and pitch and the current roll.
    * 
    * @param yaw - the yaw
    * @param pitch - the pitch
    * 
    * @return the new attitude
    */
   public Attitude setAttitude(final Yaw yaw, final Pitch pitch)
   {
      return new Attitude(yaw, pitch, _roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new attitude with the given yaw and roll and the current pitch.
    * 
    * @param yaw - the yaw
    * @param roll - the roll
    * 
    * @return the new attitude
    */
   public Attitude setAttitude(final Yaw yaw, final Roll roll)
   {
      return new Attitude(yaw, _pitch, roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new attitude with the given pitch and the current yaw and roll.
    * 
    * @param pitch - the pitch
    * 
    * @return the new attitude
    */
   public Attitude setPitch(final Pitch pitch)
   {
      return new Attitude(_yaw, pitch, _roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new attitude with the given roll and the current yaw and pitch.
    * 
    * @param roll - the roll
    * 
    * @return the new attitude
    */
   public Attitude setRoll(final Roll roll)
   {
      return new Attitude(_yaw, _pitch, roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates a new attitude with the given yaw and the current pitch and roll.
    * 
    * @param yaw - the yaw
    * 
    * @return the new attitude
    */
   public Attitude setYaw(final Yaw yaw)
   {
      return new Attitude(yaw, _pitch, _roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts an attitude from this one and returns a new one with the difference.
    * 
    * @param attitude - the attitude to subtract
    * 
    * @return the new attitude
    */
   public Attitude subtract(final Attitude attitude)
   {
      Assert.nonnull(attitude);

      Yaw yaw = _yaw.subtract(attitude._yaw);

      Pitch pitch = _pitch.subtract(attitude._pitch);

      Roll roll = _roll.subtract(attitude._roll);

      return new Attitude(yaw, pitch, roll);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("Attitude{" + _yaw + " " + _pitch + " " + _roll + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<attitude>" + NEWLINE);

      stream.append(_yaw.toXML_());
      stream.append(_pitch.toXML_());
      stream.append(_roll.toXML_());

      stream.append("</attitude>" + NEWLINE);

      return stream;
   }
}
