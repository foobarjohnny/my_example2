package com.daragon.collector.jmxcollector.call;


/**
 * <p> Represents a problem that occurred as a result of
 * configuration.  </p>
 *
 * <p>$Author: chris $</p>
 *
 * @author Christopher Blunck
 * @version $Revision: 1.6 $
 */
public class ConfigurationException 
  extends Exception {

  /**
   * Creates a ConfigurationException based on a message and an
   * exception that caused the ConfigurationException.
   */
  public ConfigurationException(String message, Throwable t) {
    super(message, t);
  }


  /**
   * Creates a ConfigurationException given a message
   */
  public ConfigurationException(String message) {
    super(message);
  }
}
