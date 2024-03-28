import sys
import socket
from loguru import logger as loguru_logger
from datetime import date
import json
logger = loguru_logger

error_path = "/Users/bing/Desktop/IDEA/JavaDemoStudy/src/main/Python/flask_demo/error.log"
info_path = "/Users/bing/Desktop/IDEA/JavaDemoStudy/src/main/Python/flask_demo/inf.log"

json_ = {"prompt_and_response":["\"dsdsd",121212,"为得"]}


def is_filter(x):
    print(x)
    if "prompt_and_response" in x["message"]:
        return True
    else: return False

logger.add(error_path, rotation="70MB", level="INFO",format="{message}",filter=lambda x: is_filter(x) )
logger.add(info_path, rotation="70MB", level="INFO")
logger.info(json.dumps(json_,ensure_ascii=False))
logger.info(json_)
logger.info("info ")