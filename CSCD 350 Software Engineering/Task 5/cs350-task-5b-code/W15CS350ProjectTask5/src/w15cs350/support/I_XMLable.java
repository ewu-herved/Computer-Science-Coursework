package w15cs350.support;

//=============================================================================================================================================================
/**
 * Defines the contract to be able to output the internal state of an object in XML format.
 * 
 * @author Dan Tappan [11.01.15]
 */
public interface I_XMLable
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the XML representation of the internal state.
    * 
    * @return the representation
    */
   public StringBuilder toXML_();
}
