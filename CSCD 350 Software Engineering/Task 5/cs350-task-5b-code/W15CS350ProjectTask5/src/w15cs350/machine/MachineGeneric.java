package w15cs350.machine;

import static w15cs350.support.Support.NEWLINE;

import java.util.List;

import w15cs350.entity.component.A_Component;

//=============================================================================================================================================================
/**
 * Defines a generic machine. For the purposes of CS 350, this can be anything we have discussed.
 * 
 * @author Dan Tappan [11.01.15]
 */
public class MachineGeneric extends A_Machine
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a generic machine.
    * 
    * @param id - the arbitrary, nonempty machine identifier
    * @param components - the components the machine consists of; one and only one must be designated as a root component
    */
   public MachineGeneric(final String id, final List<A_Component> components)
   {
      super(id, components);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<machine-generic>" + NEWLINE);

      stream.append(super.toXML_());

      // xxx

      stream.append("</machine-generic>" + NEWLINE);

      return stream;
   }
}
