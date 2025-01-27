#!/bin/sh

#/usr/lib/jvm/bin/java -jar server-sem.jar >/dev/null 2>&1 & echo $! > server-sem.pid
/usr/lib/jvm/bin/java -jar server-sem.jar & echo $! > server-sem.pid