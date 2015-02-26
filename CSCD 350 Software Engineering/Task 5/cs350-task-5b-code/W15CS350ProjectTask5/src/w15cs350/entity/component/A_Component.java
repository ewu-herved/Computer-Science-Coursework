package w15cs350.entity.component;

import static w15cs350.support.Support.NEWLINE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import w15cs350.datatype.Attitude;
import w15cs350.datatype.Position;
import w15cs350.entity.connector.A_Span;
import w15cs350.entity.connector.LinkageBall;
import w15cs350.entity.connector.LinkageSocket;
import w15cs350.support.Assert;
import w15cs350.support.I_Identifiable;
import w15cs350.support.I_XMLable;

//=============================================================================================================================================================
/**
 * Defines the shared elements of a component, which is a formless three-dimensional entity with a position and attitude in space. It may contain any number of
 * sockets to link to other components via balls and spans to form a complex structure.
 * 
 * @author Dan Tappan [11.01.15]
 */
public abstract class A_Component implements I_Identifiable, I_XMLable
{
   /** the component identifier */
   private final String _id;

   /** the spatial configuration of the component */
   private final DescriptorSpatial _descriptor;

   /** the sockets associated with the component; they do not need to reside on or inside the component bounds */
   private final Map<String, LinkageSocket> _sockets = new HashMap<>();

   /** the position of the origin of the component at (0,0,0) */
   private Position _position;

   /** the absolute attitude of the component in the world based on its pivot */
   private Attitude _attitudeAbsolute;

   /**
    * the relative attitude of the component in the world based on its pivot. The relative attitude is the attitude of the component when it is committed.
    * Subsequent changes to the absolute attitude will always add the relative contribution
    */
   private Attitude _attitudeRelative;

   /** whether this component is a root component; one and only one is required for any structure of components */
   private final boolean _isRoot;

   /** whether the component is committed, which which prevents further structural changes to its configuration */
   private boolean _isCommitted = false;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a nonroot component.
    * 
    * @param id - the arbitrary, nonempty component identifier
    * @param descriptor - the spatial configuration of the component
    * @param sockets - the sockets associated with the component; they do not need to reside on or inside the component bounds
    */
   public A_Component(final String id, final DescriptorSpatial descriptor, final List<LinkageSocket> sockets)
   {
      this(id, descriptor, sockets, false);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a component.
    * 
    * @param id - the arbitrary, nonempty component identifier
    * @param descriptor - the spatial configuration of the component
    * @param sockets - the sockets associated with the component; they do not need to reside on or inside the component bounds
    * @param isRoot - whether this component is a root component; one and only one is required for any structure of components
    */
   public A_Component(final String id, final DescriptorSpatial descriptor, final List<LinkageSocket> sockets, final boolean isRoot)
   {
      Assert.nonnullempty(id);
      Assert.nonnull(descriptor, sockets);

      _id = id;

      _descriptor = descriptor;

      _isRoot = isRoot;

      for (LinkageSocket socket : sockets)
      {
         Assert.nonnull(socket);

         String idSocket = socket.getID_();

         boolean isDuplicate = _sockets.containsKey(idSocket);

         if (isDuplicate)
         {
            throw new RuntimeException("duplicate socket [" + id + "]");
         }

         socket.setHost(this);

         _sockets.put(idSocket, socket);
      }

      // do not call setPosition() or setAttitude() here because they contain an implicit update() call to an incomplete component
      _position = Position.CENTER;

      _attitudeRelative = Attitude.NEUTRAL;
      _attitudeAbsolute = Attitude.NEUTRAL;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Anchors the component in the world.
    * 
    * @param position - the position of the origin
    * @param attitude - the attitude of the component based on its pivot
    */
   protected void anchor(final Position position, final Attitude attitude)
   {
      Assert.nonnull(position, attitude);

      setPositionAndAttitude(position, attitude);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Idempotently commits the component, which prevents further structural changes to its configuration.
    */
   public void commit()
   {
      _isCommitted = true;

      _attitudeRelative = _attitudeAbsolute;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Returns whether two components are equal based on their identifiers.
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

      if (!_id.equals(((A_Component) object)._id))
      {
         return false;
      }

      return true;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the absolute attitude of the component in the world based on its pivot.
    * 
    * @return the attitude
    */
   public Attitude getAttitude()
   {
      return _attitudeAbsolute;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the relative attitude of the component in the world based on its pivot. The relative attitude is the attitude of the component when it is committed.
    * Subsequent changes to the absolute attitude will always add the relative contribution.
    * 
    * If the component has not been committed yet, this returns the absolute attitude.
    * 
    * @return the attitude
    */
   public Attitude getAttitudeRelative()
   {
      return _attitudeRelative;
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
    * Gets the world position of the origin of the component at (0,0,0).
    * 
    * @return the position
    */
   public Position getPosition()
   {
      return _position;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the world position of the pivot of the component at (0,0,0).
    * 
    * @return the position
    */
   public Position getPositionPivotAbsolute()
   {
      return _position.add(_descriptor.getPivot());
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets a socket.
    * 
    * @param id - the socket identifier
    * 
    * @return the socket
    */
   public LinkageSocket getSocket(final String id)
   {
      Assert.nonnullempty(id);

      if (!_sockets.containsKey(id))
      {
         throw new RuntimeException("unknown socket [" + id + "]");
      }

      return _sockets.get(id);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the sockets associated with the component.
    * 
    * @return the sockets as a safely mutable list
    */
   public List<LinkageSocket> getSockets()
   {
      List<LinkageSocket> sockets = new ArrayList<>();

      sockets.addAll(_sockets.values());

      return sockets;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the spatial configuration of the component.
    * 
    * @return the configuration
    */
   public DescriptorSpatial getSpatialDescriptor()
   {
      return _descriptor;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the target component attached to this component by a span.
    * 
    * @param span - the span
    * 
    * @return the target component
    */
   private A_Component getTargetComponent(final A_Span span)
   {
      Assert.nonnull(span);

      LinkageBall targetBall = span.getBallTarget();

      LinkageSocket targetSocket = targetBall.getBindingToSocket();

      A_Component targetComponent = targetSocket.getHost();

      return targetComponent;
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
    * Gets whether a socket is present in this component.
    * 
    * @param id - the socket identifier
    * 
    * @return the result
    */
   public boolean hasSocket(final String id)
   {
      Assert.nonnullempty(id);

      return _sockets.containsKey(id);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether the component is committed, which which prevents further structural changes to its configuration.
    * 
    * @return the result
    */
   public boolean isCommitted()
   {
      return _isCommitted;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether this component is a root component. One and only one is required for any structure of components.
    * 
    * @return the result
    */
   public boolean isRoot()
   {
      return _isRoot;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Recursively resets the flag that prevents cyclical revisitation of components during propagation of changes.
    */
   private void resetVisit()
   {
      for (LinkageSocket sourceSocket : _sockets.values())
      {
         if (sourceSocket.isBoundToBall())
         {
            LinkageBall sourceBall = sourceSocket.getBindingToBall();

            A_Span span = sourceBall.getHost();

            if (span.isVisited())
            {
               span.isVisited(false);

               A_Component targetComponent = getTargetComponent(span);

               targetComponent.resetVisit();
            }
         }
      }
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Sets the absolute attitude of the component in the world based on its pivot and recursively updates any components linked to this one.
    * 
    * This is valid only on a root component that has been committed.
    * 
    * @param attitude - the attitude
    */
   public void setAttitude(final Attitude attitude)
   {
      Assert.nonnull(attitude);

      if (_isCommitted && !_isRoot)
      {
         throw new RuntimeException("operation not valid on committed nonroot component");
      }

      _attitudeAbsolute = attitude;

      update();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Sets the world position of the origin of the component at (0,0,0) and recursively updates any components linked to this one.
    * 
    * This is valid only on a root component that has been committed.
    * 
    * @param position - the position
    */
   public void setPosition(final Position position)
   {
      Assert.nonnull(position);

      if (_isCommitted && !_isRoot)
      {
         throw new RuntimeException("operation not valid on committed nonroot component");
      }

      _position = position;

      update();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Sets the absolute attitude of the component in the world based on its pivot and the position of the origin at (0,0,0). It then recursively updates any
    * components linked to this one. Use this combined variant instead of {@link #setPosition(Position)} and {@link #setAttitude(Attitude)} separately to reduce
    * overhead.
    * 
    * @param position - the position
    * @param attitude - the attitude
    */
   public void setPositionAndAttitude(final Position position, final Attitude attitude)
   {
      Assert.nonnull(position, attitude);

      _position = position;
      _attitudeAbsolute = attitude;

      update();
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<component id=\"" + _id + "\">" + NEWLINE);

      stream.append(_descriptor.toXML_());
      stream.append(_position.toXML_());
      stream.append(_attitudeAbsolute.toXML_());

      stream.append("<sockets>" + NEWLINE);

      for (LinkageSocket socket : _sockets.values())
      {
         stream.append(socket.toXML_());
      }

      stream.append("</sockets>" + NEWLINE);

      stream.append("</component>" + NEWLINE);

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Recursively updates any components linked to this one based on its current state.
    */
   public void update()
   {
      for (LinkageSocket sourceSocket : _sockets.values())
      {
         if (sourceSocket.isBoundToBall())
         {
            LinkageBall sourceBall = sourceSocket.getBindingToBall();

            A_Span span = sourceBall.getHost();

            if (!span.isVisited())
            {
               span.isVisited(true);

               A_Component targetComponent = getTargetComponent(span);

               Position targetComponentPositionPlanned = span.resolveTargetComponent();
               Attitude targetComponentAttitudePlanned = targetComponent.getAttitudeRelative().add(_attitudeAbsolute);

               targetComponent.anchor(targetComponentPositionPlanned, targetComponentAttitudePlanned);
            }
         }
      }

      if (_isRoot)
      {
         resetVisit();
      }
   }
}
