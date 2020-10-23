package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogException {
  static final Logger logger = LoggerFactory.getLogger(LogException.class);
  public static void main(String[] args) {
  //  logger.error("error", new Exception("some error", new RuntimeException("wrapper", new ArithmeticException("div zero"))));
    logger.error("error :\n{}", new Exception("hahaha").getMessage());
  }
}
