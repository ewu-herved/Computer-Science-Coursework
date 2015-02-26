package w15cs350.datatype;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_XMLable;
import w15cs350.support.Support;

//=============================================================================================================================================================
/**
 * Defines the dimensions in three-dimensional space with arbitrary units.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class Dimensions implements I_XMLable
{
   /** the origin, always (0,0,0) */
   public static final Position ORIGIN = new Position(0, 0, 0);

   /** the positive width */
   private final double _width;

   /** the positive depth */
   private final double _depth;

   /** the positive height */
   private final double _height;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a dimensions descriptor that defines a box in three-dimensional space with arbitrary units in an arbitrary coordinate system.
    * 
    * @param height - the positive height
    * @param width - the positive width
    * @param depth - the positive depth
    */
   public Dimensions(final double width, final double depth, final double height)
   {
      if (width <= 0)
      {
         throw new IllegalArgumentException("illegal width: " + width);
      }

      if (depth <= 0)
      {
         throw new IllegalArgumentException("illegal depth: " + depth);
      }

      if (height <= 0)
      {
         throw new IllegalArgumentException("illegal height: " + height);
      }

      _width = width;
      _depth = depth;
      _height = height;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------\
   /**
    * Adds dimensions to this one and returns a new dimension with the sum.
    * 
    * @param dimensions - the dimensions to add
    * 
    * @return the new dimensions
    */
   public Dimensions add(final Dimensions dimensions)
   {
      Assert.nonnull(dimensions);

      double height = (_height + dimensions._height);
      double width = (_width + dimensions._width);
      double depth = (_depth + dimensions._depth);

      return new Dimensions(width, depth, height);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the depth.
    * 
    * @return the depth
    */
   public double getDepth()
   {
      return _depth;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the height.
    * 
    * @return the height
    */
   public double getHeight()
   {
      return _height;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the origin, which is halfway between each dimension.
    * 
    * @return the position
    */
   public Position getOrigin()
   {
      double x = (_width / 2);
      double y = (_depth / 2);
      double z = (_height / 2);

      return new Position(x, y, z);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the width.
    * 
    * @return the width
    */
   public double getWidth()
   {
      return _width;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether a position is within the limits of the frame defined by these dimensions.
    * 
    * @param position - the position
    * 
    * @return the result
    */
   public boolean isWithinFrame(final Position position)
   {
      Assert.nonnull(position);

      double shiftedWidth = (_width / 2);
      double shiftedDepth = (_depth / 2);
      double shiftedHeight = (_height / 2);

      double x = position.getX();
      double y = position.getY();
      double z = position.getZ();

      return ((x < -shiftedWidth) || (x > +shiftedWidth) || (y < -shiftedDepth) || (y > +shiftedDepth) || (z < -shiftedHeight) || (z > +shiftedHeight));
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts dimensions from this one and returns a new dimension with the difference.
    * 
    * @param dimensions - the dimensions to subtract
    * 
    * @return the new dimensions, which must be positive
    */
   public Dimensions subtract(final Dimensions dimensions)
   {
      Assert.nonnull(dimensions);

      double width = (_width - dimensions._width);
      double depth = (_depth - dimensions._depth);
      double height = (_height - dimensions._height);

      return new Dimensions(width, depth, height);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("Dimensions{" + Support.format(_width) + " " + Support.format(_depth) + " " + Support.format(_height) + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<dimensions width=\"" + _width + "\" depth=\"" + _depth + "\" height=\"" + _height + "\"/>" + NEWLINE);

      return stream;
   }
}
