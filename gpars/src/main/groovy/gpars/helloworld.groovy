package gpars

import static groovyx.gpars.actor.Actors.actor

def decryptor = actor {
  loop {
    react { msg ->
      if (msg instanceof String) reply msg.reverse()
      else stop()
    }
  }
}

def console = actor {
  decryptor.send 'yvoorg olleh'
  react { msg ->
    println "decryptor msg: ${msg}"
    decryptor.send false
  }
}

[decryptor, console]*.join()