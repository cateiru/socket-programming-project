export DIRPATH=$(cd $(dirname $0); pwd)

# export CLASSPATH=$DIRPATH/libs/onnxruntime-1.5.2.jar

javac -cp .:$DIRPATH/libs/onnxruntime-1.5.2.jar sample/ScoreMNIST.java
