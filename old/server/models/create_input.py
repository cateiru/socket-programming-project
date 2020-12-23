import collections
import json

import fire


def flatten(l):
    for el in l:
        if isinstance(el, collections.abc.Iterable) and not isinstance(el, (str, bytes)):
            yield from flatten(el)
        else:
            yield el


def main(path: str):
    with open(path, mode='r') as contents:
        body = json.load(contents)

    for i in list(flatten(body)):
        print(i)


if __name__ == "__main__":
    fire.Fire(main)
