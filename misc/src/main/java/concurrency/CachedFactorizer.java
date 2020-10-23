package concurrency;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;

public class CachedFactorizer  implements Servlet {

  private BigInteger lastNumber;
  private BigInteger[] lastFactors;
  private long hits;
  private long cacheHits;

  public synchronized long getHits() {
    return hits;
  }

  public synchronized double getCacheHitRatio() {
    return (double) cacheHits / (double) hits;
  }

  @Override
  public void init(ServletConfig config) throws ServletException {

  }

  @Override
  public ServletConfig getServletConfig() {
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    BigInteger i = extractFromReq(req);
    BigInteger[] factors = null;

    synchronized (this) {
      ++hits;
      if (Objects.equals(i, lastNumber)){
        ++cacheHits;
        factors = lastFactors.clone();
      }
    }
    if (factors == null) {
      factors = factors(i);
      synchronized (this) {
        lastNumber = i;
        lastFactors = factors.clone();
      }
    }
    encodeIntoResp(res, factors);
  }

  private void encodeIntoResp(ServletResponse res, BigInteger[] factors) {

  }

  private BigInteger[] factors(BigInteger i) {
    return null;
  }

  private BigInteger extractFromReq(ServletRequest req) {
    return null;
  }

  @Override
  public String getServletInfo() {
    return null;
  }

  @Override
  public void destroy() {

  }
}
