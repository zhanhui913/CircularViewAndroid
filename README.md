# CircularViewAndroid
A custom view for Circular view for android with possibility to add circle stroke and icons. <br/>
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-PMD-blue.svg?style=flat)](http://android-arsenal.com/details/1/443)

**Author**: Zhan Yap<br/>
**License** : MIT


## Usage

### Add as dependency

Gradle

```groovy
    dependencies {
      compile 'com.github.zhanhui913:circular-view:0.4.1'
    }
```
    

Maven

```groovy
<dependency>
  <groupId>com.github.zhanhui913</groupId>
  <artifactId>circular-view</artifactId>
  <version>0.4.1</version>
</dependency>

```


Define 'custom' namespace on root view in your layout

```
xmlns:custom="http://schemas.android.com/apk/res-auto"
```

Include 'com.zhan.library.CircularView' in your layout

```
<com.zhan.library.CircularView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    custom:cv_bgRadius="dimension"
    custom:cv_bgColor="color"
    custom:cv_strokeWidth="dimension"
    custom:cv_strokePadding="dimension"
    custom:cv_strokeColor="color"
    custom:cv_iconDrawable="int"
    custom:cv_iconColor="color"
    custom:cv_iconTopPadding="dimension"
    custom:cv_iconBottomPadding="dimension"
    custom:cv_iconLeftPadding="dimension"
    custom:cv_iconRightPadding="dimension"
    custom:cv_text="string"
    custom:cv_textColor="color"
    custom:cv_textSize="dimension"/>

```

## Public method on CircularView
```
void setCircleRadius(int value)
int getCircleRadius()
void setCircleColor(int color)
int getCircleColor()

void setStrokeWidth(int value)
int getStrokeWidth()
void setStrokePadding(int value)
int getStrokePadding()
void setStrokeColor(int color)
int getStrokeColor()

void setIconColor(int color)
int getIconColor()
void setIconResource(int ic)
Drawable getIconResource()

void setIconTopPadding(int value)
int getIconTopPadding()
void setIconBottomPadding(int value)
int getIconBottomPadding()
void setIconLeftPadding(int value)
int getIconLeftPadding()
void setIconRightPadding(int value)
int getIconRightPadding()

void setText(String value)
String getText()
void setTextColor(int color);
int getTextColor();
void setTextSize(int size);
int getTextSize();
```


# Contributing

I welcome pull requests, issues and feedback.

- Fork it
- Create your feature branch (git checkout -b my-new-feature)
- Commit your changes (git commit -am 'Added some feature')
- Push to the branch (git push origin my-new-feature)
- Create new Pull Request
