# Bar
杭州迈冲科技状态栏/导航栏实例

## 一、使用说明
该实例实现通过代码控制状态栏/导航栏的永久隐藏和显示。

### RK3288 Android 7.1
对于 Android 7.1 系统，该实例可以显示状态栏和导航栏分别隐藏/显示。
```java
ShellUtils.execCmd("settings put system systembar_hide 0", true); // 1: 隐藏导航栏，0: 显示导航栏
sendBroadcast(systemBarIntent);

ShellUtils.execCmd("settings put system systemstatusbar_hide 0", true); // 1: 隐藏状态栏，0: 显示状态栏
sendBroadcast(statusBarIntent);
```

### RK3288 Android 5.1
对于 Android 5.1 系统，该实例目前只能实现状态栏和导航栏同时隐藏/显示。
``` java
ShellUtils.execCmd("settings put system systembar_hide 0", true); // 1: 隐藏，0: 显示
sendBroadcast(systemBarIntent);
```



## 二、下载体验
[导航栏/状态栏 apk 下载](https://github.com/Hangzhou-Maichong-Technology/Bar/raw/master/apk/Bar.apk)