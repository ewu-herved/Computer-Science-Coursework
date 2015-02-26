package w15cs350.support;

//=============================================================================================================================================================
/**
 * Defines the contract to be able to output the internal state of an object in Gnuplot format.
 * 
 * @author Dan Tappan [01.02.15]
 */
public interface I_Gnuplotable
{
   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the Gnuplot representation of the internal state.
    * 
    * @return the representation
    */
   public StringBuilder toGnuplot_();
}
