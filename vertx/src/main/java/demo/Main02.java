package demo;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystem;

public class Main02 {
  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();

    FileSystem fs = vertx.fileSystem();
    Future<Void> f1 = Future.future(promise -> fs.createFile("/foo", promise));
    Future<Void> f = f1
            .compose(v -> Future.<Void>future(promise -> fs.writeFile("/foo", Buffer.buffer(), promise)))
            .compose(v -> Future.future(promise -> fs.move("/foo", "/bar", promise)));

  }
}
