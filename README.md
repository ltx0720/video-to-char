<p align="center"><img src="https://note.youdao.com/yws/public/resource/e8d523f15fc70dbd2971e2dd6efa5aaf/xmlnote/C8F8FE2E24184C71A62A87DF1A8FB1FA/6484" alt="Java 视频字符化显示" width="100" height="100"></p>
<h1 align="center">Java 视频字符化</h1>

## 思路
? 视频切帧放入文件夹<br>
? 图片转为灰度图<br>
? 对像素点的灰度的阶数用不同的字符代替<br>
? 把不同的字符显示在界面上<br>

## 注意点
- 由于不可能显示每一个像素，可以根据尺寸来调整间隔数
```java
Config.java: 
public static final int COLUMNGAP = 5;
public static final int ROWGAP = 17;
```
- 调整间隔之后，处理的像素点变化，需要设置界面的大小(可以不设置，但不美观)
- Swing 字体必须是等宽字体

## 问题
用 Swing 显示，字符行间距稍大，不太美观。但是使用控制台输出的话，需要清屏会造成闪烁。
## 截图
![1](https://note.youdao.com/yws/public/resource/e8d523f15fc70dbd2971e2dd6efa5aaf/xmlnote/C40AB382E2F147539E0A6CEE805F577A/6488)
![2](https://note.youdao.com/yws/public/resource/e8d523f15fc70dbd2971e2dd6efa5aaf/xmlnote/8CC6CF8B06A84F04975AB9D4483A1B0F/6491)




