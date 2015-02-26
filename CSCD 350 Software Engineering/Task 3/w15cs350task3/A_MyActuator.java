/**
 * Abstract superclass for actuator objects
 * 
 * @author Dan Herve
 */

package w15cs350task3;

public abstract class A_MyActuator implements I_Actuator {
   
   /**
    * The String identifier of the actuator.
    */
   protected final String id;
   
   /**
    * The state of the actuator as a double.
    */
   protected double state;
   
   /**
    * The starting state of the actuator. Also
    * represents the min value.
    */
   protected double stateStart;
   
   /**
    * The end state of the actuator. Also
    * represents the max value
    */
   protected double stateEnd;
   
   /**
    * The increment distance applied at each
    * update.
    */
   protected double step;
   
   /**
    * Boolean value signifying whether the actuator
    * is servicing update calls.
    */
   protected boolean isDead = false;
   
   /**
    * Boolean value signifying whether the actuator
    * is shutting down.
    */
   protected boolean isDying = false;
   
   /**
    * Counter for actuator shutdown.
    */
   protected int deathTimer = 3;
   
   /**
    * Counter for actuator shutdown.
    */
   protected boolean positiveStep = true;
   
   /**
    * @param id  the id of the actuator
    * @param stateStart  the beginning state of the actuator
    * @param stateEnd  the end state of the actuator
    * @param step  the increment to change state at update
    * @exception RuntimeException
    *             if the id is an empty string
    * @exception RuntimeException
    *             if the step is not a positive value
    */
   public A_MyActuator(String id, double stateStart, double stateEnd, double step) {
      
      if(id.compareTo("") == 0)
         throw new RuntimeException(this.getClass().getName() + "cannot take an empty string as an id.");
         
      if(step <= 0)
         throw new RuntimeException(this.getClass().getName() + "must have a positive value for the step attribute.");
      
      this.id = id;
      this.stateStart = stateStart;
      this.stateEnd = stateEnd;
      this.step = step;
      state = stateStart;
      if(stateEnd < stateStart)
         positiveStep = false;
   }
   
   /**
    * Gets the arbitrary nonempty identifier of this component.
    *
    * @return String
    */
   public String getID_() {
   
      return id;
   }
   
   /**
    * Gets the current state, which is always between 
    * the start and end states.
    *
    * @return double
    */
   public double getState_() {
   
      return state;
   }
   
   /**
    * Gets the initial state that this state assumes.
    *
    * @return double
    */
   public double getStateStart_() {
   
      return stateStart;
   }
   
   /**
    * Gets the final state that this state can assume.
    *
    * @return double
    */
   public double getStateEnd_() {
   
      return stateEnd;
   }
   
   /**
    * Gets the value of the transition step between the
    * start and end states. It is always positive.
    *
    * @return double
    */
   public double getStep_() {
   
      return step;
   }
   
   /**
    * Updates the state from its current state to its
    * next state based on the current step. If the next
    * state exceeds the end state, then the former is
    * clamped to the latter. This returns whether the 
    * end state has been reached.
    *
    * @return boolean
    */
   public abstract boolean updateState_();
   
   /**
    * Immediately stops the component from servicing
    * calls to updateState_().
    */
   public void cancel_() {
   
      if(isDead) {
         
         System.out.println(id + " cannot be cancelled since it is already dead.");
      }
      
      else {
         isDying = false;
         isDead = true;
      }
   }
   
   /**
    * Stops the component from servicing calls to
    * updateState_() with a notional gradual shutdown.
    * For linear components, reverse the step and cease
    * servicing three calls after receipt of this
    * terminate signal. For nonlinear components, also
    * reduce the step by half each time.
    */
   public void terminate_() {
      
      if(isDead) {
         
         System.out.println(id + " cannot be cancelled since it is already dead.");
      }
      
      else 
         isDying = true;
   }
    
   /**
    * Returns whether the component is being terminated.
    *
    * @return boolean
    */  
   public boolean isDying_() {
   
      return isDying;
   }
   
   /**
    * Returns whether the component has been terminated or canceled.
    *
    * @return boolean
    */  
   public boolean isDead_() {

      return isDead;
   }
   
   /**
    * Overrides the Object class toString method
    *
    * @return String
    */
   @Override
   public abstract String toString();
}