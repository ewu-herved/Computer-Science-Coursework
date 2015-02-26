package w15cs350.entity.connector;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;

//=============================================================================================================================================================
/**
 * Defines a ball linkage, which is a male element that mates with a female socket linkage in several configurations.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class LinkageBall extends A_Linkage<A_Span>
{
   // =========================================================================================================================================================
   /**
    * Defines the support mating configurations from a ball to a socket.
    * 
    * @author Dan Tappan [29.01.15]
    */
   public enum E_Freedom
   {
      /** a ball is fused to a socket and can never be reoriented */
      FIXED,

      /** a ball can be reoriented about the x axis of a socket, but not about y or z */
      FREE_X,

      /** a ball can be reoriented about the y axis of a socket, but not about x or z */
      FREE_Y,

      /** a ball can be reoriented about the z axis of a socket, but not about x or y */
      FREE_Z
   }

   /** the mating configuration of the ball to the socket */
   private final E_Freedom _freedom;

   /** the socket this ball mates with */
   private LinkageSocket _socket;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a ball linkage.
    * 
    * @param id - the arbitrary, nonempty identifier
    * @param freedom - the mating configuration of the ball to the socket
    */
   public LinkageBall(final String id, final E_Freedom freedom)
   {
      super(id);

      _freedom = freedom;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Sets the socket this ball mates with. One and only one socket is required.
    * 
    * @param socket - the socket
    */
   protected void bindToSocket(final LinkageSocket socket)
   {
      Assert.nonnull(socket);

      if (isBoundToSocket())
      {
         throw new RuntimeException("already bound to socket [" + _socket.getID_() + "]");
      }

      _socket = socket;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the socket this ball mates with. This is valid only after {@link #bindToSocket(LinkageSocket)} has been called.
    * 
    * @return the socket
    */
   public LinkageSocket getBindingToSocket()
   {
      if (!isBoundToSocket())
      {
         throw new RuntimeException("no bound to any socket");

      }

      return _socket;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the mating configuration of the ball to the socket.
    * 
    * @return the configuration
    */
   public E_Freedom getFreedom()
   {
      return _freedom;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether this ball is mated to a socket.
    * 
    * @return the result
    */
   public boolean isBoundToSocket()
   {
      return (_socket != null);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("LinkageBall{freedom=" + _freedom + " socket=[" + (isBoundToSocket() ? _socket.getID_() : "<none>") + "]}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<ball freedom=\"" + _freedom.toString().toLowerCase() + "\">" + NEWLINE);

      stream.append(super.toXML_());

      if (isBoundToSocket())
      {
         stream.append("<socket>" + NEWLINE);
         stream.append(_socket.toXML_());
         stream.append("</socket>" + NEWLINE);
      }

      stream.append("</ball>" + NEWLINE);

      return stream;
   }
}
