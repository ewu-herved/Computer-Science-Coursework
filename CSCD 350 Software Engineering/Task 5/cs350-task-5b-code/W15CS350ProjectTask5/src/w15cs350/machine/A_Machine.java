package w15cs350.machine;

import static w15cs350.support.Support.NEWLINE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import w15cs350.datatype.Attitude;
import w15cs350.datatype.Position;
import w15cs350.entity.component.A_Component;
import w15cs350.support.Assert;
import w15cs350.support.I_Gnuplotable;
import w15cs350.support.I_Identifiable;
import w15cs350.support.I_XMLable;

//=============================================================================================================================================================
/**
 * Defines the shared elements of any machine consisting of components.
 * 
 * @author Dan Tappan [11.01.15]
 */
public abstract class A_Machine implements I_Identifiable, I_XMLable, I_Gnuplotable
{
   /** the machine identifier */
   private final String _id;

   /** the components the machine consists of */
   private final Map<String, A_Component> _components = new HashMap<>();

   /** the root component */
   private final A_Component _componentRoot;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a machine.
    * 
    * @param id - the arbitrary, nonempty machine identifier
    * @param components - the components the machine consists of; one and only one must be designated as a root component
    */
   public A_Machine(final String id, final List<A_Component> components)
   {
      Assert.nonnullempty(id);
      Assert.nonnull(components);

      _id = id;

      A_Component componentRoot = null;

      for (A_Component component : components)
      {
         String idComponent = component.getID_();

         boolean isDuplicate = _components.containsKey(idComponent);

         if (isDuplicate)
         {
            throw new RuntimeException("duplicate component [" + id + "]");
         }

         if (component.isRoot())
         {
            if (componentRoot != null)
            {
               throw new RuntimeException("multiple root components in machine [" + id + "]: " + idComponent + " " + componentRoot.getID_());
            }

            componentRoot = component;
         }

         component.commit();

         _components.put(idComponent, component);
      }

      if (componentRoot == null)
      {
         throw new RuntimeException("no root component in machine [" + id + "]");
      }

      _componentRoot = componentRoot;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Returns whether two machines are equal based on their identifiers.
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

      if (!_id.equals(((A_Machine) object)._id))
      {
         return false;
      }

      return true;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets a component of this machine.
    * 
    * @param id - the component identifier
    * 
    * @return the component
    */
   public A_Component getComponent(final String id)
   {
      Assert.nonnullempty(id);

      if (!_components.containsKey(id))
      {
         throw new RuntimeException("unknown component [" + id + "]");
      }

      return _components.get(id);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the root component of this machine.
    * 
    * @return the component
    */
   public A_Component getComponentRoot()
   {
      return _componentRoot;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets all the components of this machine in undefined order.
    * 
    * @return the components as a safely mutable list
    */
   public List<A_Component> getComponents()
   {
      List<A_Component> components = new ArrayList<>();

      components.addAll(_components.values());

      return components;
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
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toGnuplot_()
   {
      StringBuilder stream = new StringBuilder();

      // xxx

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<machine id=\"" + _id + "\">" + NEWLINE);

      stream.append("<components>" + NEWLINE);

      for (A_Component component : _components.values())
      {
         stream.append(component.toXML_());
      }

      stream.append("</components>" + NEWLINE);

      stream.append("</machine>" + NEWLINE);

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Updates the attitude of the root component of this machine at its pivot, and recursively any connected components.
    * 
    * @param attitude - the attitude
    */
   public void update(final Attitude attitude)
   {
      _componentRoot.setAttitude(attitude);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Updates the position of the root component of this machine at its origin, and recursively any connected components.
    * 
    * @param position - the position
    */
   public void update(final Position position)
   {
      _componentRoot.setPosition(position);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Updates the attitude and position of the root component of this machine at its pivot and origin, respectively, and recursively any connected components.
    * Use this combined variant instead of {@link #update(Attitude)} and {@link #update(Position)} separately to reduce overhead.
    * 
    * @param position - the position
    * @param attitude - the attitude
    */
   public void update(final Position position, final Attitude attitude)
   {
      _componentRoot.setPositionAndAttitude(position, attitude);
   }
}
