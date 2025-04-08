from flask import Flask, jsonify, render_template, url_for, request
import json
import random
import os
from pypinyin import pinyin, Style

app = Flask(__name__, static_url_path='/static')

class PoemError(Exception):
    """自定义诗句相关错误"""
    pass

def load_poems():
    """加载诗句，包含错误处理"""
    try:
        if not os.path.exists('poems.json'):
            raise PoemError("诗句文件不存在")
            
        with open('poems.json', 'r', encoding='utf-8') as f:
            data = json.load(f)
            
        if not data.get('poems'):
            raise PoemError("诗句数据格式错误")
            
        return data['poems']
    except json.JSONDecodeError:
        raise PoemError("诗句文件格式错误")
    except Exception as e:
        raise PoemError(f"加载诗句时发生错误: {str(e)}")

@app.route('/')
def index():
    """返回前端页面"""
    return render_template('index.html')

@app.route('/api/poem', methods=['GET'])
def get_random_poem():
    """获取随机诗句的接口"""
    try:
        poems = load_poems()
        random_poem = random.choice(poems)
        return jsonify({
            "status": "success",
            "data": random_poem
        })
    except PoemError as e:
        return jsonify({
            "status": "error",
            "message": str(e)
        }), 500
    except Exception as e:
        return jsonify({
            "status": "error",
            "message": "服务器内部错误"
        }), 500

@app.route('/heart')
def heart():
    """返回爱心页面"""
    return render_template('heart.html')

@app.route('/mytime')
def mytime():
    """返回时钟页面"""
    return render_template('mytime.html')

@app.route('/dance')
def dance():
    """返回Live2D页面"""
    return render_template('dance.html')

@app.route('/snake')
def snake():
    """返回贪吃蛇游戏页面"""
    return render_template('snake.html')

@app.route('/dict')
def dict_page():
    """返回字典页面"""
    return render_template('dict.html')

@app.route('/api/pinyin', methods=['POST'])
def get_pinyin():
    """获取汉字拼音"""
    data = request.get_json()
    text = data.get('text', '')
    if not text:
        return jsonify({"status": "error", "message": "文本不能为空"})
    
    # 获取拼音（带音调）
    pinyins = pinyin(text, style=Style.TONE)
    result = []
    for char, py in zip(text, pinyins):
        result.append({
            "char": char,
            "pinyin": py[0] if py else ''
        })
    
    return jsonify({
        "status": "success",
        "data": result
    })

@app.errorhandler(404)
def not_found(error):
    return jsonify({
        "status": "error",
        "message": "接口不存在"
    }), 404

if __name__ == '__main__':
    app.run(debug=True)
    