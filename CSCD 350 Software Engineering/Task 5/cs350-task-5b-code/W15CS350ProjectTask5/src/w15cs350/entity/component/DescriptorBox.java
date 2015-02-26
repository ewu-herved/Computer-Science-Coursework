package w15cs350.entity.component;

import static w15cs350.support.Support.NEWLINE;

import java.util.Collections;
import java.util.List;

import w15cs350.datatype.Attitude;
import w15cs350.datatype.Position;
import w15cs350.entity.connector.LinkageSocket;
import w15cs350.support.Assert;
import w15cs350.support.I_Gnuplotable;
import w15cs350.support.I_XMLable;

//=============================================================================================================================================================
/**
 * Defines a three-dimensional box as eight corners, along with its pivot point for attitude changes, and any sockets it contains.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class DescriptorBox implements I_XMLable, I_Gnuplotable
{
   /** the position of the pivot, which is the base for all attitude changes */
   private final Position _pivot;

   /** the position of the top-front-left corner */
   private final Position _cornerTopFrontLeft;

   /** the position of the top-front-right corner */
   private final Position _cornerTopFrontRight;

   /** the position of the top-back-right corner */
   private final Position _cornerTopBackRight;

   /** the position of the top-back-left corner */
   private final Position _cornerTopBackLeft;

   /** the position of the bottom-front-left corner */
   private final Position _cornerBottomFrontLeft;

   /** the position of the bottom-front-right corner */
   private final Position _cornerBottomFrontRight;

   /** the position of the bottom-back-right corner */
   private final Position _cornerBottomBackRight;

   /** the position of the bottom-back-left corner */
   private final Position _cornerBottomBackLeft;

   /** the sockets associated with the component */
   private final List<LinkageSocket> _sockets;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a new box descriptor.
    * 
    * @param pivot - the position of the pivot that is the base for all attitude changes
    * @param cornerTopFrontLeft - the position of the top-front-left corner
    * @param cornerTopFrontRight - the position of the top-front-right corner
    * @param cornerTopBackRight - the position of the top-back-right corner
    * @param cornerTopBackLeft - the position of the top-back-left corner
    * @param cornerBottomFrontLeft - the position of the bottom-front-left corner
    * @param cornerBottomFrontRight - the position of the bottom-front-right corner
    * @param cornerBottomBackRight - the position of the bottom-back-right corner
    * @param cornerBottomBackLeft - the position of the bottom-back-left corner
    * @param sockets - the sockets associated with the component
    */
   public DescriptorBox(final Position pivot,
                        final Position cornerTopFrontLeft,
                        final Position cornerTopFrontRight,
                        final Position cornerTopBackRight,
                        final Position cornerTopBackLeft,
                        final Position cornerBottomFrontLeft,
                        final Position cornerBottomFrontRight,
                        final Position cornerBottomBackRight,
                        final Position cornerBottomBackLeft,
                        final List<LinkageSocket> sockets)
   {
      Assert.nonnull(pivot,
                     cornerTopFrontLeft,
                     cornerTopFrontRight,
                     cornerTopBackRight,
                     cornerTopBackLeft,
                     cornerBottomFrontLeft,
                     cornerBottomFrontRight,
                     cornerBottomBackRight,
                     cornerBottomBackLeft,
                     sockets);

      _pivot = pivot;

      _cornerTopFrontLeft = cornerTopFrontLeft;
      _cornerTopFrontRight = cornerTopFrontRight;
      _cornerTopBackRight = cornerTopBackRight;
      _cornerTopBackLeft = cornerTopBackLeft;

      _cornerBottomFrontLeft = cornerBottomFrontLeft;
      _cornerBottomFrontRight = cornerBottomFrontRight;
      _cornerBottomBackRight = cornerBottomBackRight;
      _cornerBottomBackLeft = cornerBottomBackLeft;

      _sockets = Collections.unmodifiableList(sockets);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Builds the Gnuplot output string for a position.
    * 
    * @param stream - the stream, which is modified in place
    * @param position - the position to output
    * @param description - the position description to be output as a comment
    * @param newlineCount - the number of newlines to output after the data
    */
   private void buildString(final StringBuilder stream, final Position position, final String description, final int newlineCount)
   {
      Assert.nonnull(stream, position, description);
      Assert.nonnegative(newlineCount);

      stream.append(position.toGnuplot_() + "   # " + description);

      for (int iNewline = 0; iNewline < newlineCount; ++iNewline)
      {
         stream.append(NEWLINE);
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the bottom-back-left corner.
    * 
    * @return the position
    */
   public Position getCornerBottomBackLeft()
   {
      return _cornerBottomBackLeft;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the bottom-back-right corner.
    * 
    * @return the position
    */
   public Position getCornerBottomBackRight()
   {
      return _cornerBottomBackRight;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the bottom-front-left corner.
    * 
    * @return the position
    */
   public Position getCornerBottomFrontLeft()
   {
      return _cornerBottomFrontLeft;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the bottom-front-right corner.
    * 
    * @return the position
    */
   public Position getCornerBottomFrontRight()
   {
      return _cornerBottomFrontRight;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the corner positions as an array ordered as specified in the constructor.
    * 
    * @return the positions
    */
   public Position[] getCorners()
   {
      return new Position[]
      { _cornerTopFrontLeft, _cornerTopFrontRight, _cornerTopBackRight, _cornerTopBackLeft, _cornerBottomFrontLeft, _cornerBottomFrontRight,
            _cornerBottomBackRight, _cornerBottomBackLeft };
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the top-back-left corner.
    * 
    * @return the position
    */
   public Position getCornerTopBackLeft()
   {
      return _cornerTopBackLeft;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the top-back-right corner.
    * 
    * @return the position
    */
   public Position getCornerTopBackRight()
   {
      return _cornerTopBackRight;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the top-front-left corner.
    * 
    * @return the position
    */
   public Position getCornerTopFrontLeft()
   {
      return _cornerTopFrontLeft;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the top-front-right corner.
    * 
    * @return the position
    */
   public Position getCornerTopFrontRight()
   {
      return _cornerTopFrontRight;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of the pivot that is the base for all attitude changes.
    * 
    * @return the position
    */
   public Position getPivot()
   {
      return _pivot;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the sockets associated with the component.
    * 
    * @return an immutable list of the sockets
    */
   public List<LinkageSocket> getSockets()
   {
      return _sockets;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rotates this box around the default pivot and returns a new box.
    * 
    * @param attitude - the rotation attitude
    * 
    * @return the new box
    */
   public DescriptorBox rotate(final Attitude attitude)
   {
      return rotate(attitude, _pivot);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Rotates this box around a specified pivot and returns a new box.
    * 
    * @param attitude - the rotation attitude
    * @param pivot - the pivot
    * 
    * @return the new box
    */
   public DescriptorBox rotate(final Attitude attitude, final Position pivot)
   {
      Assert.nonnull(attitude, pivot);

      Position pivot2 = pivot.rotate(pivot, attitude);

      Position cornerTopFrontLeft = _cornerTopFrontLeft.rotate(pivot, attitude);
      Position cornerTopFrontRight = _cornerTopFrontRight.rotate(pivot, attitude);
      Position cornerTopBackRight = _cornerTopBackRight.rotate(pivot, attitude);
      Position cornerTopBackLeft = _cornerTopBackLeft.rotate(pivot, attitude);
      Position cornerBottomFrontLeft = _cornerBottomFrontLeft.rotate(pivot, attitude);
      Position cornerBottomFrontRight = _cornerBottomFrontRight.rotate(pivot, attitude);
      Position cornerBottomBackRight = _cornerBottomBackRight.rotate(pivot, attitude);
      Position cornerBottomBackLeft = _cornerBottomBackLeft.rotate(pivot, attitude);

      for (LinkageSocket socket : _sockets)
      {
         Position position = socket.getPositionRelative();

         Position positionRotated = position.rotate(pivot, attitude);

         socket.setPositionAbsolute(positionRotated);
      }

      return new DescriptorBox(pivot2,
                               cornerTopFrontLeft,
                               cornerTopFrontRight,
                               cornerTopBackRight,
                               cornerTopBackLeft,
                               cornerBottomFrontLeft,
                               cornerBottomFrontRight,
                               cornerBottomBackRight,
                               cornerBottomBackLeft,
                               _sockets);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toGnuplot_()
   {
      return new StringBuilder(toString());
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      StringBuilder stream = new StringBuilder();

      buildString(stream, _cornerTopFrontLeft, "corner, top front left", 1);
      buildString(stream, _cornerTopFrontRight, "corner, top front right", 1);
      buildString(stream, _cornerTopBackRight, "corner, top back right", 1);
      buildString(stream, _cornerTopBackLeft, "corner, top back left", 1);
      buildString(stream, _cornerTopFrontLeft, "corner, top front left (closure)", 2);

      buildString(stream, _cornerBottomFrontLeft, "corner, bottom front left", 1);
      buildString(stream, _cornerBottomFrontRight, "corner, bottom front right", 1);
      buildString(stream, _cornerBottomBackRight, "corner, bottom back right", 1);
      buildString(stream, _cornerBottomBackLeft, "corner, bottom back left", 1);
      buildString(stream, _cornerBottomFrontLeft, "corner, bottom front left (closure)", 3);

      for (LinkageSocket socket : _sockets)
      {
         Position position = (socket.hasPositionAbsolute() ? socket.getPositionAbsolute() : socket.getPositionRelative());

         String socketID = socket.getID_();

         buildString(stream, position, ("socket [" + socketID + "]"), 3);
      }

      buildString(stream, _pivot, "pivot", 3);

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

      stream.append("<box-descriptor>" + NEWLINE);

      stream.append("<pivot>" + NEWLINE);
      stream.append(_pivot.toXML_());
      stream.append("</pivot>" + NEWLINE);

      stream.append("<corners>" + NEWLINE);

      stream.append("<top-front-left>" + NEWLINE);
      stream.append(_cornerTopFrontLeft.toXML_());
      stream.append("</top-front-left>" + NEWLINE);

      stream.append("<top-front-right>" + NEWLINE);
      stream.append(_cornerTopFrontRight.toXML_());
      stream.append("</top-front-right>" + NEWLINE);

      stream.append("<top-back-right>" + NEWLINE);
      stream.append(_cornerTopBackRight.toXML_());
      stream.append("</top-back-right>" + NEWLINE);

      stream.append("<top-back-left>" + NEWLINE);
      stream.append(_cornerTopBackLeft.toXML_());
      stream.append("</top-back-left>" + NEWLINE);

      stream.append("<bottom-front-left>" + NEWLINE);
      stream.append(_cornerBottomFrontLeft.toXML_());
      stream.append("</bottom-front-left>" + NEWLINE);

      stream.append("<bottom-front-right>" + NEWLINE);
      stream.append(_cornerBottomFrontRight.toXML_());
      stream.append("</bottom-front-right>" + NEWLINE);

      stream.append("<bottom-back-right>" + NEWLINE);
      stream.append(_cornerBottomBackRight.toXML_());
      stream.append("</bottom-back-right>" + NEWLINE);

      stream.append("<bottom-back-left>" + NEWLINE);
      stream.append(_cornerBottomBackLeft.toXML_());
      stream.append("</bottom-back-left>" + NEWLINE);

      stream.append("</corners>" + NEWLINE);

      stream.append("<sockets>" + NEWLINE);

      for (LinkageSocket socket : _sockets)
      {
         Position position = socket.getPositionAbsolute();

         String socketID = socket.getID_();

         stream.append("<socket id=\"" + socketID + "\">" + NEWLINE);
         stream.append(position.toXML_());
         stream.append("</socket>" + NEWLINE);
      }

      stream.append("</sockets>" + NEWLINE);

      stream.append("</box-descriptor>" + NEWLINE);

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Translates this box by an offset and returns a new box.
    * 
    * @param offset - the offset
    * 
    * @return the new box
    */
   public DescriptorBox translate(final Position offset)
   {
      Assert.nonnull(offset);

      Position pivot = _pivot.add(offset);

      Position cornerTopFrontLeft = _cornerTopFrontLeft.add(offset);
      Position cornerTopFrontRight = _cornerTopFrontRight.add(offset);
      Position cornerTopBackRight = _cornerTopBackRight.add(offset);
      Position cornerTopBackLeft = _cornerTopBackLeft.add(offset);

      Position cornerBottomFrontLeft = _cornerBottomFrontLeft.add(offset);
      Position cornerBottomFrontRight = _cornerBottomFrontRight.add(offset);
      Position cornerBottomBackRight = _cornerBottomBackRight.add(offset);
      Position cornerBottomBackLeft = _cornerBottomBackLeft.add(offset);

      for (LinkageSocket socket : _sockets)
      {
         Position position = (socket.hasPositionAbsolute() ? socket.getPositionAbsolute() : socket.getPositionRelative());

         Position positionTranslated = position.add(offset);

         socket.setPositionAbsolute(positionTranslated);
      }

      return new DescriptorBox(pivot,
                               cornerTopFrontLeft,
                               cornerTopFrontRight,
                               cornerTopBackRight,
                               cornerTopBackLeft,
                               cornerBottomFrontLeft,
                               cornerBottomFrontRight,
                               cornerBottomBackRight,
                               cornerBottomBackLeft,
                               _sockets);
   }
}
