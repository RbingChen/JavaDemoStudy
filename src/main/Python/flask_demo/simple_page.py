# coding:utf-8
from flask import Blueprint

simple_page = Blueprint("simple_page",__name__)  #新建蓝图


@simple_page.route("show") # 将show函数注册到蓝图上。 ip:port/simple_page/show 可以访问函数
def show():

    return "show Blueprint page"