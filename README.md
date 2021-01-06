<h1 align="center">
Socket Programming Project
</h1>

## TL;DR

コマンド入力形式のマルコフ連鎖プログラム。

形態素解析→マルコフ連鎖でそれとなくいい感じの文章を返します。

## Build

- 形態素解析のパッケージ**Igo**を使用しています。以下リンクから0.4.5のバージョンをダウンロードして[server/libs](server/libs)に`.jar`のまま保存してください。

[Igo Download](https://ja.osdn.net/projects/igo/downloads/55029/igo-0.4.5.jar/)

### Serverのビルド

```bash
cd server
# build
sh build.sh
```

### Clientのビルド

```bash
cd client
# build
sh build.sh
```

## Run

- server

  ```bash
  cd server
  sh run.sh
  ```

- client

  ```bash
  cd client
  sh run.sh
  ```

### コマンドの説明

#### `/train [text]`

マルコフ連鎖に使用する文章を追加します。

### `/generate`

マルコフ連鎖を実行します。

### `/reset`

`/train`で追加した文章をすべて削除します。

### `/end`

サーバーおよびクライアントを終了します。バルスコマンドです。

## Package

- [Igo](http://igo.osdn.jp/)

## 参考文献

- [JavaでTwitterBotをつくってみたよ - 白猫のメモ帳](https://shironeko.hateblo.jp/entry/2016/11/14/201912)
- [【自動生成】入賞作品から作文を生成したら素晴らしい文章ができる説 - Youtube](https://www.youtube.com/watch?v=1OfCyavg_ZE)

## License

MIT
