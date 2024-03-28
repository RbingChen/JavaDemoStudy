# coding:utf-8

import json
import requests

url  = "http://127.0.0.1:8080/login"


data = """{"id":123}"""
headers = {
    "Content-Type": "application/json;charset=utf-8"
}

#print(data)

response = requests.post(url, data=data, headers=headers)
print(response.text)
r = json.loads(response.text)
print(r)