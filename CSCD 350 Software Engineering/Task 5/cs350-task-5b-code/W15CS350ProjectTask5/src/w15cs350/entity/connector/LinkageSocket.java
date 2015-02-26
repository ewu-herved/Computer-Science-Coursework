package w15cs350.entity.connector;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.datatype.Position;
import w15cs350.entity.component.A_Component;
import w15cs350.support.Assert;

//=============================================================================================================================================================
/**
 * Defines a socket linkage, which is a female element that mates with a male ball linkage.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class LinkageSocket extends A_Linkage<A_Component>
{
   /** the position of this socket relative to the origin of the component it is bound to */
   private final Position _positionRelative;

   /** the absolute position of this socket in the world */
   private Position _positionAbsolute;

   /** the ball this socket mates with */
   private LinkageBall _ball;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a socket linkage.
    * 
    * @param id - the arbitrary, nonempty identifier
    * @param positionRelative - the position of this socket relative to the origin of the component it is bound to
    */
   public LinkageSocket(final String id, final Position positionRelative)
   {
      super(id);

      Assert.nonnull(positionRelative);

      _positionRelative = positionRelative;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Sets the ball this socket mates with. One and only one socket is required.
    * 
    * @param ball - the ball
    */
   protected void bindToBall(final LinkageBall ball)
   {
      Assert.nonnull(ball);

      if (isBoundToBall())
      {
         throw new RuntimeException("already bound to ball [" + _ball.getID_() + "]");
      }

      _ball = ball;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the ball this socket mates with. This is valid only after {@link #bindToBall(LinkageBall)} has been called.
    * 
    * @return the ball
    */
   public LinkageBall getBindingToBall()
   {
      if (!isBoundToBall())
      {
         throw new RuntimeException("not bound to any ball");

      }

      return _ball;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of this socket in the world. This is valid only after {@link #setPositionAbsolute(Position)} has been called.
    * 
    * @return the position
    */
   public Position getPositionAbsolute()
   {
      if (!hasPositionAbsolute())
      {
         throw new RuntimeException("no absolute position set on socket [" + getID_() + "]");
      }

      return _positionAbsolute;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the position of this socket relative to the origin of the component it is bound to.
    * 
    * @return the position
    */
   public Position getPositionRelative()
   {
      return _positionRelative;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether an absolute position of this socket in the world has been set with {@link #setPositionAbsolute(Position)}.
    * 
    * @return the result
    */
   public boolean hasPositionAbsolute()
   {
      return (_positionAbsolute != null);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether this socket is mated to a ball.
    * 
    * @return the result
    */
   public boolean isBoundToBall()
   {
      return (_ball != null);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public void setHost(final A_Component host)
   {
      super.setHost(host);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Sets the absolute position of this socket in the world.
    * 
    * @param position - the position
    */
   public void setPositionAbsolute(final Position position)
   {
      Assert.nonnull(position);

      _positionAbsolute = position;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("LinkageBall{positionRelative=" + _positionRelative + " positionAbsolute=" + _positionAbsolute + " _ball="
            + (isBoundToBall() ? _ball.getID_() : "<none>") + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<socket>" + NEWLINE);

      stream.append(super.toXML_());

      stream.append("<position-relative>" + NEWLINE);
      stream.append(_positionRelative.toXML_());
      stream.append("</position-relative>" + NEWLINE);

      if (hasPositionAbsolute())
      {
         stream.append("<position-absolute>" + NEWLINE);
         stream.append(_positionAbsolute.toXML_());
         stream.append("</position-absolute>" + NEWLINE);
      }

      if (isBoundToBall())
      {
         stream.append("<ball id=\"" + _ball.getID_() + "\"/>" + NEWLINE);
      }

      stream.append("</socket>" + NEWLINE);

      return stream;
   }
}
