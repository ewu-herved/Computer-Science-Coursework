package w15cs350.entity.component;

import static w15cs350.support.Support.NEWLINE;

import java.util.List;

import w15cs350.datatype.Attitude;
import w15cs350.datatype.Dimensions;
import w15cs350.datatype.Position;
import w15cs350.entity.connector.LinkageSocket;
import w15cs350.support.Assert;

//=============================================================================================================================================================
/**
 * Defines a box component as a three-dimensional entity with a width, height, and depth, a position origin at (0,0,0), and an attitude pivot at any arbitrary
 * position.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class ComponentBox extends A_Component
{
   /** the base form of the box, which remains the same no matter how the position and attitude of the component are modified */
   private final DescriptorBox _boxBase;

   /** the current form of the box, which reflects how the position and attitude of the component have been modified */
   private DescriptorBox _boxCurrent;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a box component.
    * 
    * @param id - the arbitrary, nonempty component identifier
    * @param descriptor - the spatial configuration of the component
    * @param sockets - the sockets associated with the component; they do not need to reside on or inside the component bounds
    */
   public ComponentBox(final String id, final DescriptorSpatial descriptor, final List<LinkageSocket> sockets)
   {
      this(id, descriptor, sockets, false);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a box component.
    * 
    * @param id - the arbitrary, nonempty component identifier
    * @param descriptor - the spatial configuration of the component
    * @param sockets - the sockets associated with the component; they do not need to reside on or inside the component bounds
    * @param isRoot - whether this component is a root component; one and only one is required for any structure of components
    */
   public ComponentBox(final String id, final DescriptorSpatial descriptor, final List<LinkageSocket> sockets, final boolean isRoot)
   {
      super(id, descriptor, sockets, isRoot);

      Position pivot = descriptor.getPivot();

      _boxBase = generateBox(Position.CENTER, pivot);

      _boxCurrent = _boxBase;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Generates the corner and pivot points of the box, as well of its sockets.
    * 
    * @param base - the position to place the origin
    * @param pivot - the point by which to pivot the attitude of the box
    * 
    * @return the box
    */
   private DescriptorBox generateBox(final Position base, final Position pivot)
   {
      Assert.nonnull(base, pivot);

      DescriptorSpatial descriptor = getSpatialDescriptor();

      Dimensions dimensions = descriptor.getDimensions();

      Position origin = dimensions.getOrigin();

      double xM = -origin.getX();
      double xP = +origin.getX();

      double yM = -origin.getY();
      double yP = +origin.getY();

      double zM = -origin.getZ();
      double zP = +origin.getZ();

      Position cornerTopFrontLeft = new Position("top front left", xM, yM, zP);
      Position cornerTopFrontRight = new Position("top front right", xP, yM, zP);
      Position cornerTopBackRight = new Position("top back right", xP, yP, zP);
      Position cornerTopBackLeft = new Position("top back left", xM, yP, zP);

      Position cornerBottomFrontLeft = new Position("bottom from left", xM, yM, zM);
      Position cornerBottomFrontRight = new Position("bottom front right", xP, yM, zM);
      Position cornerBottomBackRight = new Position("bottom back right", xP, yP, zM);
      Position cornerBottomBackLeft = new Position("bottom back left", xM, yP, zM);

      List<LinkageSocket> sockets = getSockets();

      DescriptorBox box = new DescriptorBox(pivot,
                                            cornerTopFrontLeft,
                                            cornerTopFrontRight,
                                            cornerTopBackRight,
                                            cornerTopBackLeft,
                                            cornerBottomFrontLeft,
                                            cornerBottomFrontRight,
                                            cornerBottomBackRight,
                                            cornerBottomBackLeft,
                                            sockets);

      DescriptorBox boxAnchored = box.translate(base.negate());

      return boxAnchored;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the base form of the box, which remains the same no matter how the position and attitude of the component are modified.
    * 
    * @return the box
    */
   public DescriptorBox getBoxBase()
   {
      return _boxBase;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the current form of the box, which reflects how the position and attitude of the component have been modified.
    * 
    * @return the box
    */
   public DescriptorBox getBoxCurrent()
   {
      return _boxCurrent;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("# ----- [COMPONENT] " + getID_() + NEWLINE);

      stream.append(_boxCurrent.toString());

      return stream.toString();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<component-box>" + NEWLINE);

      stream.append(super.toXML_());

      stream.append("<base>" + NEWLINE);
      stream.append(_boxBase.toXML_());
      stream.append("</base>" + NEWLINE);

      stream.append("<current>" + NEWLINE);
      stream.append(_boxCurrent.toXML_());
      stream.append("</current>" + NEWLINE);

      stream.append("</component-box>" + NEWLINE);

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public void update()
   {
      super.update();

      Attitude attitude = getAttitude();

      _boxCurrent = _boxBase.rotate(attitude);

      Position position = getPosition();

      _boxCurrent = _boxCurrent.translate(position);
   }
}
