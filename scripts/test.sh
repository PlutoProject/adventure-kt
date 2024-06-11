#!/usr/bin bash

# because idea test console has no color, i can't see the result clearly, so i wrote this script to check the
# test result in local terminal

../gradlew shadowJar
java -cp ../test/build/libs/test-1.0-SNAPSHOT.jar ink/nostal/advkt/ComponenKtTestKt