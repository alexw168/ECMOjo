package edu.hawaii.jabsom.tri.ecmo.app.control.action;

import king.lib.out.Error;
import edu.hawaii.jabsom.tri.ecmo.app.control.Action;
import edu.hawaii.jabsom.tri.ecmo.app.model.Game;
import edu.hawaii.jabsom.tri.ecmo.app.model.comp.TubeComponent;

/**
 * The tubing action. 
 *
 * @author   king
 * @since    September 5, 2008
 */
public class TubeAction extends Action {

  /** The location. B=patient-side/left. A=pump-side/right. */
  public enum Location { ARTERIAL_A, ARTERIAL_B, VENOUS_A, VENOUS_B, BRIDGE };
  
  /** True for open. */
  private boolean open;
  /** The location. */
  private Location location;
  
  
  /**
   * Returns the location.
   *
   * @return  The location.
   */
  public Location getLocation() {
    return location;
  }

  /**
   * Sets the location.
   *
   * @param location  The location to set.
   */
  public void setLocation(Location location) {
    this.location = location;
  }

  /**
   * Returns true if open.
   *
   * @return  True if open.
   */
  public boolean isOpen() {
    return open;
  }

  /**
   * Set if open.
   *
   * @param open  True for open.
   */
  public void setOpen(boolean open) {
    this.open = open;
  }

  /**
   * Executes the action on the game.
   * 
   * @param game  The game.
   */
  @Override
  public void execute(Game game) {
    // and add the lab request
    TubeComponent component = (TubeComponent)game.getEquipment().getComponent(TubeComponent.class);
    if (location == Location.ARTERIAL_A) {
      component.setArterialAOpen(open);
    }
    else if (location == Location.ARTERIAL_B) {
      component.setArterialBOpen(open);
    }
    else if (location == Location.VENOUS_A) {
      component.setVenousAOpen(open);
    }
    else if (location == Location.VENOUS_B) {
      component.setVenousBOpen(open);
    }
    else if (location == Location.BRIDGE) {
      component.setBridgeOpen(open);
    }
    else {
      Error.out("Location not mapped: " + location);
    }
  }
  
  /**
   * Returns the string representation.
   * 
   * @return  The string representation.
   */
  @Override
  public String toString() {
    return "Action:Tube:{" + open + ", " + location + "}";
  }
}
