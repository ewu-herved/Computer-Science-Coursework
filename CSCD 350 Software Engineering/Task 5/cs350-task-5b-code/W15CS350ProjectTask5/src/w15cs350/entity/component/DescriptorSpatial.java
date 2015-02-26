package w15cs350.entity.component;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.datatype.Dimensions;
import w15cs350.datatype.Position;
import w15cs350.support.Assert;
import w15cs350.support.I_XMLable;

//=============================================================================================================================================================
/**
 * Defines a descriptor that contains the minimal spatial data needed to define a box component in three-dimensional space. The origin is always (0,0,0).
 * 
 * @author Dan Tappan [11.01.15]
 */
public class DescriptorSpatial implements I_XMLable
{
   /** the position of the pivot, which is the base for all attitude changes */
   private final Position _pivot;

   /** the box dimensions */
   private final Dimensions _dimensions;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a spatial descriptor.
    * 
    * @param dimensions - the box dimensions
    * @param pivot - the position of the pivot, which is the base for all attitude changes
    */
   public DescriptorSpatial(final Dimensions dimensions, final Position pivot)
   {
      Assert.nonnull(dimensions, pivot);

      _dimensions = dimensions;
      _pivot = pivot;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the box dimensions.
    * 
    * @return the dimensions
    */
   public Dimensions getDimensions()
   {
      return _dimensions;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the pivot, which is the base for all attitude changes.
    * 
    * @return the pivot
    */
   public Position getPivot()
   {
      return _pivot;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<spatial-descriptor>" + NEWLINE);

      stream.append("<pivot>" + NEWLINE);
      stream.append(_pivot.toXML_());
      stream.append("</pivot>" + NEWLINE);

      stream.append(_dimensions.toXML_());

      stream.append("</spatial-descriptor>" + NEWLINE);

      return stream;
   }
}
