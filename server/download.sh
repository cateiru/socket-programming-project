#!/bin/bash

# if [ ! -d ./libs/igo-0.4.2.jar ]; then
# wget https://ja.osdn.net/frs/redir.php?m=jaist&f=igo%2F55029%2Figo-0.4.5.jar -O ./libs/igo-0.4.5.jar
# fi

if [ ! -d ./libs/mecab-ipadic-2.7.0-20070801.tar.gz ]; then
wget https://sourceforge.net/projects/mecab/files/mecab-ipadic/2.7.0-20070801/mecab-ipadic-2.7.0-20070801.tar.gz/download -O ./libs/mecab-ipadic-2.7.0-20070801.tar.gz
tar -zxvf ./libs/mecab-ipadic-2.7.0-20070801.tar.gz
fi
