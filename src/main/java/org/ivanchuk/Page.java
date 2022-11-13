package org.ivanchuk;

/**
 * The Page.
 * <p>
 * The basic web-page.
 */
public interface Page {

  /**
   * With some input params.
   *
   * @param src The source
   */
  Page from(Source src);

  /**
   * The Page with parameter.
   *
   * @param param The parameter
   * @return Parameterized page
   */
  Page with(Param param);
}
