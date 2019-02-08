## This is a fork of the StandOut library from 2012-2013
### With this library, you can create android apps with floating windows (eg: similar to [FloatingCalculator](https://play.google.com/store/apps/details?id=com.aptapps.floatingcalculator) or Facebook Messenger's "chat heads")

What I've modified:

1. converted Eclipse ADT project to Android Studio Gradle project
2. Replaced vanilla Notification code with AppCompat Notification code in the library module
3. Android >= Marshmallow permission asking compatibility
4. Android >= Oreo foreground services compatibility
5. Published to jitpack

Tested on Android Marshmallow. Works just fine! :)

Kind of buggy on Android Pie :|

For more info, please study the ``sample``.

### Import

```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
```
dependencies {
    implementation ('com.github.andob:StandOut:1.0.3') {
        exclude group: 'com.android.support'
    }
}
```

#### [Demo Video](http://www.youtube.com/watch?v=S3vHjxonOeg)

#### [Original repo](https://github.com/pingpongboss/StandOut)

#### [Join the conversation on XDA forum](http://forum.xda-developers.com/showthread.php?t=1688531)

### Licence (MIT)

```
Copyright (C) 2012 Mark Wei

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
