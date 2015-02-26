package w15cs350.entity.connector;

import w15cs350.datatype.Attitude;
import w15cs350.datatype.Position;
import w15cs350.entity.component.A_Component;

//=============================================================================================================================================================
/**
 * Defines a static span, which never changes in length.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class SpanStatic extends A_Span
{
   /** the offset between the pivot of the source component and the origin of the target component */
   private Position _offsetPivotSourceToOriginTarget;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a static span.
    * 
    * @param id - the arbitrary, nonempty identifier
    * @param ballSource - the source ball; the freedom type of each ball must be the same
    * @param ballTarget - the target ball
    */
   public SpanStatic(final String id, final LinkageBall ballSource, final LinkageBall ballTarget)
   {
      super(id, ballSource, ballTarget);

      if ((ballSource.getFreedom() != LinkageBall.E_Freedom.FIXED) || (ballTarget.getFreedom() != LinkageBall.E_Freedom.FIXED))
      {
         throw new RuntimeException("both balls must be fixed in current version: " + ballSource.getFreedom() + " / " + ballTarget.getFreedom());
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   protected void calculateOffset(final LinkageSocket socketSource, final LinkageSocket socketTarget)
   {
      super.calculateOffset(socketSource, socketTarget);

      A_Component sourceComponent = socketSource.getHost();

      Position positionTarget = socketTarget.getHost().getPosition();

      Position sourcePivotAbsolute = sourceComponent.getPositionPivotAbsolute();

      _offsetPivotSourceToOriginTarget = positionTarget.subtract(sourcePivotAbsolute);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public Position resolveTargetComponent()
   {
      A_Component sourceComponent = getBallSource().getBindingToSocket().getHost();

      Attitude sourceAttitude = sourceComponent.getAttitude();

      Position sourcePositionPivotAbsolute = sourceComponent.getPositionPivotAbsolute();

      Position targetPositionTranslated = sourcePositionPivotAbsolute.add(_offsetPivotSourceToOriginTarget);

      Position targetPositionRotated = targetPositionTranslated.rotate(sourcePositionPivotAbsolute, sourceAttitude);

      return targetPositionRotated;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append(super.toXML_());

      // xxx

      return stream;
   }
}
