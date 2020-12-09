export DIRPATH=$(cd $(dirname $0); pwd)

export CLASSPATH=$DIRPATH/libs/onnxruntime-1.5.2.jar:.

java sample.ScoreMNIST
