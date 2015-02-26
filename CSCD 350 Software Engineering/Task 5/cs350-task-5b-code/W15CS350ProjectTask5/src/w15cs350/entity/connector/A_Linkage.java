package w15cs350.entity.connector;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_Identifiable;
import w15cs350.support.I_XMLable;

//=============================================================================================================================================================
/**
 * Defines the shared elements of a linkage, which is
 * 
 * @author Dan Tappan [11.01.15]
 * 
 * @param <_HOST_> - the type of the host that this linkage connects to
 */
public abstract class A_Linkage<_HOST_ extends I_Identifiable> implements I_Identifiable, I_XMLable
{
   /** the arbitrary, nonempty identifier */
   private final String _id;

   /** the host that this linkage is connected to after setHost() is called */
   private _HOST_ _host;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a linkage.
    * 
    * @param id - the arbitrary, nonempty identifier
    */
   public A_Linkage(final String id)
   {
      Assert.nonnullempty(id);

      _id = id;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Returns whether two linkages are equal based on their identifiers.
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

      if (!_id.equals(((A_Linkage<?>) object)._id))
      {
         return false;
      }

      return true;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the host that this linkage is connected to. This is valid only after {@link #setHost(I_Identifiable)} is called.
    * 
    * @return the result
    */
   public _HOST_ getHost()
   {
      if (!hasHost())
      {
         throw new RuntimeException("not bound to any host");
      }

      return _host;
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
    * Gets whether this linkage has been connected to a host.
    * 
    * @return the result
    */
   public boolean hasHost()
   {
      return (_host != null);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Sets the host that this linkage is connected to. One and only one host is required.
    * 
    * @param host - the host
    */
   public void setHost(final _HOST_ host)
   {
      Assert.nonnull(host);

      if (hasHost())
      {
         throw new RuntimeException("already bound to host [" + host.getID_() + "]");
      }

      _host = host;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<linkage id=\"" + _id + "\"");

      if (hasHost())
      {
         stream.append(" host-id=\"" + _host.getID_() + "\"");
      }

      stream.append("/>" + NEWLINE);

      return stream;
   }
}
