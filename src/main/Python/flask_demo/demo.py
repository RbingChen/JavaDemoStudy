# coding:utf-8

from flask import Flask
from flask import Blueprint, jsonify, request
from simple_page import simple_page

app = Flask(__name__)

app.register_blueprint(simple_page,url_prefix="/simple-page")  # 可以改变url映射路径,/必须有

@app.route("/")
def hello_world():
    return "hello world"


@app.route("/json")
def get_json():
    return """{"id",123}"""



@app.route("/login",methods=["POST"])
def login():
    print(request.data) ## 原始数据
    print(request.json) ## 原始数据是 字典格式会转为json
    return request.data


if __name__ == "__main__":
    app.run("127.0.0.1", "8080")