# AspectRatioLayout [![Maven Central](https://maven-badges.herokuapp.com/maven-central/me.mattak/aspect-ratio-layout/badge.svg)](https://maven-badges.herokuapp.com/maven-central/me.mattak/aspect-ratio-layout) [![Build Status](https://travis-ci.org/mattak/AspectRatioLayout.svg)](https://travis-ci.org/mattak/AspectRatioLayout)

## Install

Write folloing lines into your build.gradle

    compile 'me.mattak:aspect-ratio-layout:0.1.3'

## Usage

Show FrameLayout (1:1 aspect, 50% of parent width size)

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:aspect="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <me.mattak.aspect_ratio_layout.FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@android:color/black"
        aspect:aspect_height="1"
        aspect:aspect_width="1"
        />

</LinearLayout>
```

![framelayout](./art/framelayout_square.png)

Show Image button (120:120 aspect, 50% of parent width size).

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:aspect="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">

    <me.mattak.aspect_ratio_layout.ImageButton
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@null"
        android:scaleType="fitCenter"
        android:src="@drawable/s120x120"
        aspect:aspect_height="120"
        aspect:aspect_width="120"
        aspect:relative_height="0.5"
        aspect:relative_width="0.5" />

</LinearLayout>
```

![framelayout](./art/imagebutton_half_square.png)

Also supports basic views.

- LinearLayout
- RelativeLayout
- FrameLayout
- ImageView
- ImageButton
- Button
- TextView
- View

More details please see the example project layouts.

# Contributors

See [contributors](./CONTRIBUTORS.md).
