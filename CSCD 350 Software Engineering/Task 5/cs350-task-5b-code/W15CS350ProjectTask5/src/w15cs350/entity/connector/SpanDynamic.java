package w15cs350.entity.connector;

import w15cs350.datatype.Position;
import w15cs350.support.Assert;

//=============================================================================================================================================================
/**
 * Defines a dynamic span, which can change in length.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class SpanDynamic extends A_Span
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a dynamic span.
    * 
    * @param id - the arbitrary, nonempty identifier
    * @param ballSource - the source ball; the freedom type of each ball must be the same
    * @param ballTarget - the target ball
    */
   public SpanDynamic(final String id, final LinkageBall ballSource, final LinkageBall ballTarget)
   {
      super(id, ballSource, ballTarget);

      if (ballSource.getFreedom() != ballTarget.getFreedom())
      {
         throw new RuntimeException("both balls must have same freedom in current version: " + ballSource.getFreedom() + " != " + ballTarget.getFreedom());
      }
   }

   // [xxx motion stuff]

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public Position resolveTargetComponent()
   {
      Assert.fail("xxx todo");

      return null;
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
