export DIRPATH=$(cd $(dirname $0); pwd)

javac -cp .:$DIRPATH/libs/igo-0.4.5.jar sample.java