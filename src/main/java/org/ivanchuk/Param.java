package org.ivanchuk;

/**
 * The Parameter for {@link Page}
 */
public interface Param {

  /**
   * The includes new data.
   *
   * @param key The key
   * @param value The value
   * @return The updated param
   */
  Param include(String key, String value);

}
