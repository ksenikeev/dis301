#!/bin/sh

#/usr/lib/jvm/bin/java -jar server-sem.jar >/dev/null 2>&1 & echo $! > server-sem.pid
python telegram_bot_1 & echo $! > telegram_bot_1.pid

# kill -9 id