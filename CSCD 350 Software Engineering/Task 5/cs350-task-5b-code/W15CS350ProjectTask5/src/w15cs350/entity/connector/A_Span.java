package w15cs350.entity.connector;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.datatype.Attitude;
import w15cs350.datatype.Position;
import w15cs350.entity.component.A_Component;
import w15cs350.support.Assert;
import w15cs350.support.I_Gnuplotable;
import w15cs350.support.I_Identifiable;
import w15cs350.support.I_XMLable;

//=============================================================================================================================================================
/**
 * Defines the shared elements of a span, which is a linear connection between two sockets that are mated with a ball on each end of the span. The source ball
 * must be closer in line to the root component than the target ball.
 * 
 * @author Dan Tappan [11.01.15]
 */
public abstract class A_Span implements I_Identifiable, I_XMLable, I_Gnuplotable
{
   /** the arbitrary, nonempty identifier */
   private final String _id;

   /** the source ball */
   private final LinkageBall _ballSource;

   /** the target ball */
   private final LinkageBall _ballTarget;

   /** the offset between the pivot of the source component and the ball of the target component */
   private Position _offsetPivotSourceToBallTarget;

   /** whether this span has been visited during propagation of movement throughout a collection of connected components */
   private boolean _isVisited = false;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a span.
    * 
    * @param id - the arbitrary, nonempty identifier
    * @param ballSource - the source ball
    * @param ballTarget - the target ball
    */
   public A_Span(final String id, final LinkageBall ballSource, final LinkageBall ballTarget)
   {
      Assert.nonnullempty(id);
      Assert.nonnull(ballSource, ballTarget);

      _id = id;

      _ballSource = ballSource;
      _ballTarget = ballTarget;

      _ballSource.setHost(this);
      _ballTarget.setHost(this);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Binds a ball to a socket and vice versa.
    * 
    * @param ball - the ball
    * @param socket - the socket
    */
   private void bind(final LinkageBall ball, final LinkageSocket socket)
   {
      Assert.nonnull(ball, socket);

      ball.bindToSocket(socket);

      socket.bindToBall(ball);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Binds the source and target sockets to the source and target balls, respectively, and vice versa.
    * 
    * @param socketSource - the source socket
    * @param socketTarget - the target socket
    */
   public void bindToSockets(final LinkageSocket socketSource, final LinkageSocket socketTarget)
   {
      Assert.nonnull(socketSource, socketTarget);

      if (isBoundToSocket())
      {
         throw new RuntimeException("already bound from socket source [" + _ballSource.getBindingToSocket().getID_() + "] to target ["
               + _ballTarget.getBindingToSocket().getID_() + "]");
      }

      bind(_ballSource, socketSource);
      bind(_ballTarget, socketTarget);

      calculateOffset(socketSource, socketTarget);

      commit(socketSource, socketTarget);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates the position offset between the source and target sockets.
    * 
    * @param socketSource - the source socket
    * @param socketTarget - the target socket
    */
   protected void calculateOffset(final LinkageSocket socketSource, final LinkageSocket socketTarget)
   {
      Assert.nonnull(socketSource, socketTarget);

      Position positionSocketTarget = socketTarget.getPositionAbsolute();

      A_Component sourceComponent = socketSource.getHost();

      Position sourcePivotAbsolute = sourceComponent.getPositionPivotAbsolute();

      _offsetPivotSourceToBallTarget = positionSocketTarget.subtract(sourcePivotAbsolute);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Commits the components connected by this span.
    * 
    * @param socketSource - the source socket
    * @param socketTarget - the target socket
    */
   private void commit(final LinkageSocket socketSource, final LinkageSocket socketTarget)
   {
      Assert.nonnull(socketSource, socketTarget);

      A_Component componentSource = socketSource.getHost();
      A_Component componentTarget = socketTarget.getHost();

      componentSource.commit();
      componentTarget.commit();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Returns whether two spans are equal based on their identifiers.
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

      if (!_id.equals(((A_Span) object)._id))
      {
         return false;
      }

      return true;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the source ball.
    * 
    * @return the ball
    */
   public LinkageBall getBallSource()
   {
      return _ballSource;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the target ball.
    * 
    * @return the ball
    */
   public LinkageBall getBallTarget()
   {
      return _ballTarget;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String getID_()
   {
      return _id;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public int hashCode()
   {
      return (31 + ((_id == null) ? 0 : _id.hashCode()));
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether this span is bound to a socket. Actually, it is bound to either none or two, never just one.
    * 
    * @return the result
    */
   public boolean isBoundToSocket()
   {
      Assert.isTrue(_ballSource.isBoundToSocket() == _ballTarget.isBoundToSocket());

      return _ballSource.isBoundToSocket();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether this span has been visited during propagation of movement throughout a collection of connected components.
    * 
    * @return the result
    */
   public boolean isVisited()
   {
      return _isVisited;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Sets whether this span has been visited during propagation of movement throughout a collection of connected components.
    * 
    * @param isVisited - the state
    */
   public void isVisited(final boolean isVisited)
   {
      _isVisited = isVisited;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates where the target ball is based on the spatial state of the source component.
    * 
    * @return the position
    */
   private Position resolveTargetBall()
   {
      A_Component sourceComponent = getBallSource().getBindingToSocket().getHost();

      Attitude sourceAttitude = sourceComponent.getAttitude();

      Position sourcePositionPivotAbsolute = sourceComponent.getPositionPivotAbsolute();

      Position targetPositionTranslated = sourcePositionPivotAbsolute.add(_offsetPivotSourceToBallTarget);

      Position targetPositionRotated = targetPositionTranslated.rotate(sourcePositionPivotAbsolute, sourceAttitude);

      return targetPositionRotated;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Calculates where the target component is based on the spatial state of the source component.
    * 
    * @return the position
    */
   public abstract Position resolveTargetComponent();

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toGnuplot_()
   {
      StringBuilder stream = new StringBuilder();

      Position positionBallSource = _ballSource.getBindingToSocket().getPositionAbsolute();
      Position positionBallTarget = resolveTargetBall();

      stream.append(positionBallSource.toGnuplot_() + "  # ball source [" + _ballSource.getBindingToSocket().getID_() + "] known" + NEWLINE);
      stream.append(positionBallTarget.toGnuplot_() + "  # ball target [" + _ballTarget.getBindingToSocket().getID_() + "] derived" + NEWLINE + NEWLINE
            + NEWLINE);

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return (getClass().getSimpleName() + "{id=[" + _id + "] source=" + _ballSource + " target=" + _ballTarget);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<span id=\"" + _id + "\">" + NEWLINE);

      stream.append("<source>" + NEWLINE);
      stream.append(_ballSource.toXML_());
      stream.append("</source>" + NEWLINE);

      stream.append("<target>" + NEWLINE);
      stream.append(_ballTarget.toXML_());
      stream.append("</target>" + NEWLINE);

      stream.append("</span>" + NEWLINE);

      return stream;
   }
}
