export DIRPATH=$(cd $(dirname $0); pwd)

export CLASSPATH=$DIRPATH/libs/igo-0.4.5.jar:.

java  sample.java
